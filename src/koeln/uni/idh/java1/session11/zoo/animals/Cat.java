package koeln.uni.idh.java1.session11.zoo.animals;

public class Cat extends WalkingMammal {

	public Cat() {
		System.out.println("A new cat has been born.");
	}

	@Override
	public char getSymbol() {
		return 'C';
	}

	public void purr() {
		System.out.println("The cat is purring.");
	}
}
