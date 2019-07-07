package pl.jacob_the_liar.sda_zoo.animal.bear;

import pl.jacob_the_liar.sda_zoo.helpers.IDateProvider;

public class PolarBear extends Bear{

    public static final double POLAR_BEAR_WEIGHT = 200.0;
    private static final String POLAR_BEAR_NAME = "Polar Bear";

    public PolarBear(IDateProvider dateProvider) {
        super(dateProvider);
        setWeight(POLAR_BEAR_WEIGHT);
        setName(POLAR_BEAR_NAME);
        setAttackMessage(KILL_FOR_FOOD);

        setJumpHeight(0.5f);
    }


}
