package koeln.uni.idh.java1.session11.zoo.animals;

public class Turtle extends WalkingMammal {

	public Turtle() {
		System.out.println("A new turtle has been born.");
		this.stepsize = 1;
	}

	@Override
	public char getSymbol() {
		return 'u';
	}

	public void hide() {
		System.out.println("The turtle hides in its shell.");
	}
}
