package pl.jacob_the_liar.sda_zoo.db;

import pl.jacob_the_liar.sda_zoo.animal.IAnimal;
import pl.jacob_the_liar.sda_zoo.animal.bear.BlackBear;
import pl.jacob_the_liar.sda_zoo.animal.bear.BrownBear;
import pl.jacob_the_liar.sda_zoo.animal.bear.PolarBear;
import pl.jacob_the_liar.sda_zoo.helpers.DateProvider;
import pl.jacob_the_liar.sda_zoo.zoo.IZoo;
import pl.jacob_the_liar.sda_zoo.zoo.Zoo;

import java.util.Random;

public class ZooListDatabase implements IZooDatabase {
    @Override
    public IZoo getZooDatabase() {

        Zoo zoo = new Zoo();


        for (int i=0; i<14; i++){
            zoo.addAnimal(randomAnimal());
        }


        return zoo;
    }

    private IAnimal randomAnimal() {

        Random rnd = new Random();

        switch (rnd.nextInt(3)){
            case 1: return new BlackBear(new DateProvider());
            case 2: return new BrownBear(new DateProvider());
            default:
                return new PolarBear(new DateProvider());
        }
    }
}
