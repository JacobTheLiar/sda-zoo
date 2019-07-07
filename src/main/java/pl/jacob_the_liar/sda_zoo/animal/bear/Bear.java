package pl.jacob_the_liar.sda_zoo.animal.bear;

import pl.jacob_the_liar.sda_zoo.helpers.IDateProvider;
import pl.jacob_the_liar.sda_zoo.animal.Animal;

public abstract class Bear extends Animal implements ILivingBear {


    public static final String KILL_FOR_FOOD = "I'll kill for food!!!";
    protected static final String HURT_FOR_FOOD = "I'll hurt for food!";
    private static final String OPEN_JAWS = "open jaws!";
    private static final String RAISE_LEFT_PAW = "Raise left paw";
    private static final String RAISE_RIGHT_PAW = "Raise right paw";
    private static final String DONT_SWIM = "don't swim";
    private static final String SWIM = "swim";
    private static final String JUMP_HEIGHT = "jump %s m. height";


    private String attackmessage;
    private boolean leftPaw = false;
    private float jumpHeight = 0.0f;
    private boolean afraidWater = false;

    public Bear(IDateProvider dateProvider) {
        super(dateProvider);
    }


    protected void setAttackMessage(String newAttackMessage){
        attackmessage = newAttackMessage;
    }


    public void attack(){
        System.out.println(attackmessage);
    }


    public void inspect(){
        raisePaw();
        openMouth();
        jump();
        swim();
    }

    protected void openMouth() {
        System.out.println(OPEN_JAWS);
    }

    protected void setLeftPawRaise(boolean leftPawRaise){
        leftPaw = leftPawRaise;
    }

    protected void raisePaw() {

        if (leftPaw)
            System.out.println(RAISE_LEFT_PAW);
        else
            System.out.println(RAISE_RIGHT_PAW);
    }


    protected void setJumpHeight(float aJumpHeight){
        jumpHeight = aJumpHeight;
    }

    protected void jump() {
        System.out.println(String.format(JUMP_HEIGHT, jumpHeight));
    }

    protected void setAfraidWater(boolean isAfraidWater){
        afraidWater = isAfraidWater;
    }

    protected void swim() {
        if (afraidWater)
            System.out.println(DONT_SWIM);
        else
            System.out.println(SWIM);
    }

}
