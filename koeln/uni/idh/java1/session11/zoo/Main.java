package koeln.uni.idh.java1.session11.zoo;

import koeln.uni.idh.java1.session11.zoo.animals.Alpaca;
import koeln.uni.idh.java1.session11.zoo.animals.Elephant;
import koeln.uni.idh.java1.session11.zoo.animals.Horse;
import koeln.uni.idh.java1.session11.zoo.animals.WalkingMammal;
import koeln.uni.idh.java1.session11.zoo.ui.AsciiImage;

public class Main {

	public static void main(String[] args) {
		WalkingMammal alpaca = new Alpaca();
		WalkingMammal elephant = new Elephant();
		WalkingMammal horse = new Horse("Berta", "brown");
		WalkingMammal secondAlpaca = new Alpaca();
		AsciiImage ai = new AsciiImage(10, 10);
		
		ai.dot(2, 2, alpaca);
		ai.dot(5, 5, elephant);
		ai.dot(7, 3, horse);
		ai.dot(3, 7, secondAlpaca);
		
		System.out.println(ai.toString());
	}

}
