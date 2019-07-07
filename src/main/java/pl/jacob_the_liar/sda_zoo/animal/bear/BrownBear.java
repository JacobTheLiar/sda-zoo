package pl.jacob_the_liar.sda_zoo.animal.bear;

import pl.jacob_the_liar.sda_zoo.helpers.IDateProvider;

public class BrownBear extends Bear {

    private static final double BROWN_BEAR_WEIGHT = 100.0;
    private static final String BROWN_BEAR_NAME = "Brown Bear";

    public BrownBear(IDateProvider dateProvider) {
        super(dateProvider);
        setWeight(BROWN_BEAR_WEIGHT);
        setName(BROWN_BEAR_NAME);
        setAttackMessage(HURT_FOR_FOOD);

        setLeftPawRaise(true);
        setJumpHeight(0.75f);
    }
}
