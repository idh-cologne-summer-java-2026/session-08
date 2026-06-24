package koeln.uni.idh.java1.session11.zoo.animals;

public class Zebra extends WalkingMammal {

	public Zebra() {
		System.out.println("A new turtle has been born.");
		this.stepsize = 1;
	}

	@Override
	public char getSymbol() {
		return 'Z';
	}

	public void hide() {
		System.out.println("The zebra hides in its shell.");
	}
}
