package pl.jacob_the_liar.sda_zoo.animal;


import pl.jacob_the_liar.sda_zoo.helpers.IDateProvider;

import java.time.LocalDateTime;

public abstract class Animal implements IAnimal{

    private static final int DAYS_TO_FEED = 10;
    private final IDateProvider dateProvider;

    private LocalDateTime lastEatTime;
    private double bearWeight = 0.0;
    private String animalName = "no name";


    public Animal(IDateProvider dateProvider) {
        this.dateProvider = dateProvider;
        this.lastEatTime = dateProvider.getDateTime();
    }

    public boolean isAlive(){
        return lastEatTime
                .plusDays(DAYS_TO_FEED)
                .isAfter(dateProvider.getDateTime());
    }


    public double getWeight(){
        return bearWeight;
    }


    public void eat(){
        if (isAlive())
            lastEatTime = dateProvider.getDateTime();
    }

    protected void setWeight(double weight){
        bearWeight = weight;
    }

    protected void setName(String newAnimalName){
        animalName = newAnimalName;
    }

    public String getName(){
        return animalName;
    }

    public void display(){
        System.out.println("Animal: "+animalName);
    }

    public abstract void inspect();

}
