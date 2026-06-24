package koeln.uni.idh.java1.session11.zoo;

import koeln.uni.idh.java1.session11.zoo.animals.Alpaca;
import koeln.uni.idh.java1.session11.zoo.animals.Elephant;
import koeln.uni.idh.java1.session11.zoo.animals.Horse;

public class Main {

	public static void main(String[] args) {
		Simulation sim = new Simulation(10, 10);

		// Add initial animals – two of each kind so they can meet and breed
		sim.addAnimal(new Horse("Spirit", "brown"));
		sim.addAnimal(new Horse("Shadow", "black"));
		sim.addAnimal(new Alpaca());
		sim.addAnimal(new Alpaca());
		sim.addAnimal(new Elephant());
		sim.addAnimal(new Elephant());

		sim.run();
	}

}
