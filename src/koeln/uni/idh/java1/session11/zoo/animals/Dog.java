package koeln.uni.idh.java1.session11.zoo.animals;

public class Dog extends WalkingMammal {
	static int numberOfDogs = 0;

	// Inherit stepsize and name from WalkingMammal; no duplicate fields needed.
	String breed;

	public Dog(String name, String breed) {
		numberOfDogs++;
		this.name = name;
		this.breed = breed;
		System.out.println("Dog " + name + " (a " + breed + ") has been born. There are now " + numberOfDogs + " dogs in the world.");
	}

	public Dog mate(Dog partner) {
		Dog ret = new Dog("Child of " + this.name + " and " + partner.name, this.breed + "-" + partner.breed);
		System.out.println("Dog " + ret.name + " has been born.");
		return ret;
	}

	@Override
	public char getSymbol() {
		return 'D';
	}

	public void bark() {
		System.out.println("Woof! The dog barks.");
	}
}
