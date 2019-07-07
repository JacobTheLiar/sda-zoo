package pl.jacob_the_liar.sda_zoo.animal.bear;

import pl.jacob_the_liar.sda_zoo.helpers.IDateProvider;

public class BlackBear extends Bear{

    private static final double BLACK_BEAR_WEIGHT = 50.0;
    private static final String BLACK_BEAR_NAME = "Black Bear";

    public BlackBear(IDateProvider dateProvider) {
        super(dateProvider);
        setWeight(BLACK_BEAR_WEIGHT);
        setName(BLACK_BEAR_NAME);
        setAttackMessage(HURT_FOR_FOOD);

        setLeftPawRaise(true);
        setJumpHeight(1f);
        setAfraidWater(true);
    }
}
