package pl.jacob_the_liar.sda_zoo.animal.bear;

import pl.jacob_the_liar.sda_zoo.toys.Toy;

public class TeddyBear extends Toy implements IToyBear{


    @Override
    public double getWeight() {
        return 0.25;
    }

    @Override
    public void display() {
        System.out.println("Toy: TeddyBear");
    }
}
