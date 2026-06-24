package koeln.uni.idh.java1.session11.zoo;

import koeln.uni.idh.java1.session11.zoo.animals.Alpaca;
import koeln.uni.idh.java1.session11.zoo.animals.Cat;
import koeln.uni.idh.java1.session11.zoo.animals.Dog;
import koeln.uni.idh.java1.session11.zoo.animals.Turtle;
import koeln.uni.idh.java1.session11.zoo.animals.WalkingMammal;
import koeln.uni.idh.java1.session11.zoo.ui.AsciiImage;

public class Main {

	public static void main(String[] args) {
		WalkingMammal wm = new Alpaca();
		WalkingMammal cat = new Cat();
		WalkingMammal dog = new Dog("Buddy", "Golden Retriever");
		WalkingMammal turtle = new Turtle();

		AsciiImage ai = new AsciiImage(10, 10);

		ai.dot(5, 5, wm);
		ai.dot(2, 3, cat);
		ai.dot(7, 4, dog);
		ai.dot(4, 7, turtle);

		System.out.println(ai.toString());
	}

}
