package koeln.uni.idh.java1.session11.zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	 * Adds an animal to the simulation at a random position.
	 *
	 * @param animal The animal to add
	 */
	public void addAnimal(WalkingMammal animal) {
		animal.setX(random.nextInt(width));
		animal.setY(random.nextInt(height));
		animals.add(animal);
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

		// Collect offspring from meetings of same-kind animals
		List<WalkingMammal> offspring = new ArrayList<>();
		List<WalkingMammal> snapshot = new ArrayList<>(animals);
		for (int i = 0; i < snapshot.size() && !isHalfFull(offspring.size()); i++) {
			for (int j = i + 1; j < snapshot.size() && !isHalfFull(offspring.size()); j++) {
				WalkingMammal a = snapshot.get(i);
				WalkingMammal b = snapshot.get(j);
				if (a.getX() == b.getX() && a.getY() == b.getY()
						&& a.getClass() == b.getClass()) {
					WalkingMammal child = a.mate(b);
					child.setX(a.getX());
					child.setY(a.getY());
					offspring.add(child);
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
		int target = target();
		System.out.println("Starting simulation on a " + width + "x" + height
				+ " grid (" + (width * height) + " slots, target: " + target + " animals).");
		System.out.println("Initial animals: " + animals.size());
		System.out.println();
		display(0);

		int step = 0;
		while (animals.size() < target) {
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
