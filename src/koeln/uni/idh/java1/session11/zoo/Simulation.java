package koeln.uni.idh.java1.session11.zoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import koeln.uni.idh.java1.session11.zoo.animals.WalkingMammal;
import koeln.uni.idh.java1.session11.zoo.ui.AsciiImage;

/**
 * A simulation in which animals move around on a grid and produce offspring
 * whenever two animals of the same kind meet on the same cell. The simulation
 * runs until 50% of the grid slots are occupied by animals.
 */
public class Simulation {

	private final int width;
	private final int height;
	private final List<WalkingMammal> animals;
	private final Random random;

	public Simulation(int width, int height) {
		this.width = width;
		this.height = height;
		this.animals = new ArrayList<>();
		this.random = new Random();
	}

	/**
	 * Adds an animal to the simulation at a random free position.
	 *
	 * @param animal The animal to add
	 */
	public void addAnimal(WalkingMammal animal) {
		Set<Integer> occupied = occupiedCells();
		int[] pos = freePosition(occupied);
		animal.setX(pos[0]);
		animal.setY(pos[1]);
		animals.add(animal);
	}

	/**
	 * Builds the set of currently occupied cell indices (y * width + x).
	 */
	private Set<Integer> occupiedCells() {
		Set<Integer> occupied = new HashSet<>();
		for (WalkingMammal a : animals) {
			occupied.add(a.getY() * width + a.getX());
		}
		return occupied;
	}

	/**
	 * Returns the coordinates of a randomly chosen free cell given a pre-built set
	 * of occupied cell indices. The set is updated in place when a free cell is
	 * found, so subsequent calls in the same step reflect already-claimed cells.
	 * Falls back to an exhaustive scan when few free cells remain.
	 *
	 * @param occupied mutable set of occupied cell indices (y * width + x)
	 * @return int[] with [x, y]
	 */
	private int[] freePosition(Set<Integer> occupied) {
		// Try a small number of random candidates first
		for (int attempt = 0; attempt < 20; attempt++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int idx = y * width + x;
			if (!occupied.contains(idx)) {
				occupied.add(idx);
				return new int[]{x, y};
			}
		}
		// Exhaustive fallback (only reached when grid is nearly full)
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int idx = y * width + x;
				if (!occupied.contains(idx)) {
					occupied.add(idx);
					return new int[]{x, y};
				}
			}
		}
		// Grid is completely full – place at random (shouldn't happen due to 50% cap)
		return new int[]{random.nextInt(width), random.nextInt(height)};
	}

	/**
	 * Performs a single simulation step: each animal moves in a random direction,
	 * stays within the grid boundaries, and same-kind animals that land on the
	 * same cell produce one offspring (as long as the grid is not yet half full).
	 */
	private void step() {
		// Move every animal one step in a random direction
		for (WalkingMammal animal : animals) {
			animal.setDirection(random.nextInt(4) * 90);
			animal.walk();
			// Clamp to grid boundaries
			animal.setX(Math.max(0, Math.min(width - 1, animal.getX())));
			animal.setY(Math.max(0, Math.min(height - 1, animal.getY())));
		}

		// Collect offspring from meetings of same-kind animals (at most one
		// offspring per cell per species per step)
		List<WalkingMammal> offspring = new ArrayList<>();
		// Track which (cell, species) pairs have already bred this step
		Map<Class<?>, Set<Integer>> mated = new HashMap<>();
		// Build occupied set once and reuse/update across all offspring placements
		Set<Integer> occupied = occupiedCells();
		List<WalkingMammal> snapshot = new ArrayList<>(animals);
		outer:
		for (int i = 0; i < snapshot.size(); i++) {
			for (int j = i + 1; j < snapshot.size(); j++) {
				WalkingMammal a = snapshot.get(i);
				WalkingMammal b = snapshot.get(j);
				int cellIndex = a.getY() * width + a.getX();
				Set<Integer> matedCells = mated.computeIfAbsent(a.getClass(), k -> new HashSet<>());
				if (a.getX() == b.getX() && a.getY() == b.getY()
						&& a.getClass() == b.getClass()
						&& !matedCells.contains(cellIndex)) {
					matedCells.add(cellIndex);
					WalkingMammal child = a.mate(b);
					int[] pos = freePosition(occupied);
					child.setX(pos[0]);
					child.setY(pos[1]);
					offspring.add(child);
					if (isHalfFull(offspring.size())) {
						break outer;
					}
				}
			}
		}
		animals.addAll(offspring);
	}

	/**
	 * Returns true when the current number of animals plus any pending offspring
	 * has reached or exceeded 50% of the total grid slots.
	 */
	private boolean isHalfFull(int pendingOffspring) {
		return animals.size() + pendingOffspring >= target();
	}

	/**
	 * The minimum number of animals required to reach 50% grid occupancy
	 * (rounded up for odd-sized grids).
	 */
	private int target() {
		return (width * height + 1) / 2;
	}

	/**
	 * Runs the simulation until at least 50% of the grid slots are occupied,
	 * printing the grid after every step.
	 */
	public void run() {
		int targetCount = target();
		System.out.println("Starting simulation on a " + width + "x" + height
				+ " grid (" + (width * height) + " slots, target: " + targetCount + " animals).");
		System.out.println("Initial animals: " + animals.size());
		System.out.println();
		display(0);

		int step = 0;
		while (animals.size() < targetCount) {
			step();
			step++;
			display(step);
		}

		System.out.println("Simulation finished after " + step + " steps with "
				+ animals.size() + " animals (" + animals.size() + "/" + (width * height)
				+ " slots = " + (animals.size() * 100 / (width * height)) + "%).");
	}

	/**
	 * Renders the current state of the grid as ASCII art.
	 */
	private void display(int step) {
		AsciiImage image = new AsciiImage(width, height);
		for (WalkingMammal animal : animals) {
			image.dot(animal.getX(), animal.getY(), animal);
		}
		System.out.println("Step " + step + " | Animals: " + animals.size());
		System.out.print(image.toString());
	}
}
