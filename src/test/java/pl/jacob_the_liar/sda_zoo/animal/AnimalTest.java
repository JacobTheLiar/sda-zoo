package pl.jacob_the_liar.sda_zoo.animal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.jacob_the_liar.sda_zoo.helpers.IDateProvider;
import pl.jacob_the_liar.sda_zoo.animal.bear.BrownBear;
import pl.jacob_the_liar.sda_zoo.animal.bear.IBear;
import pl.jacob_the_liar.sda_zoo.animal.bear.ILivingBear;
import pl.jacob_the_liar.sda_zoo.animal.bear.PolarBear;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static pl.jacob_the_liar.sda_zoo.animal.bear.Bear.KILL_FOR_FOOD;
import static pl.jacob_the_liar.sda_zoo.animal.bear.PolarBear.POLAR_BEAR_WEIGHT;

public class AnimalTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream orginalOut = System.out;
    private final IDateProvider dateProvider = mock(IDateProvider.class);

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));

        final IBear bear = mock(IBear.class);
        Mockito.when(bear.getWeight()).thenReturn(37.0);
    }


    @Test
    public void getWight_forPolarBear_returns200_Test() {
        IBear bear = new PolarBear(dateProvider);
        double expected = POLAR_BEAR_WEIGHT;

        double actual = bear.getWeight();

        assertTrue(expected==actual);
    }


    @Test
    public void animal_is_alive_if_he_has_eaten_less_then_10_days_ago_test() {
        LocalDateTime date = LocalDateTime.now().minusDays(9);

        Mockito.when(dateProvider.getDateTime()).thenReturn(date);


        IAnimal bear = new BrownBear(dateProvider);

        boolean isAlive =   bear.isAlive();

        assertTrue(isAlive);
    }

    @Test
    public void animal_is_dead_if_he_has_eaten_greater_then_10_days_ago_test() {
        LocalDateTime date = LocalDateTime.now().minusDays(10);
        Mockito.when(dateProvider.getDateTime()).thenReturn(date);

        IAnimal bear = new BrownBear(dateProvider);

        boolean isAlive =   bear.isAlive();

        assertFalse(isAlive);
    }

    @Test
    public void animal_is_dead_after_last_eat_14_days_ago_test(){

        LocalDateTime date = LocalDateTime.now();
        IAnimal bear = new BrownBear(dateProvider);
        Mockito.when(dateProvider.getDateTime()).thenReturn(date);


        date = date.plusDays(2);
        Mockito.when(dateProvider.getDateTime()).thenReturn(date);
        bear.eat();

        date = date.plusDays(14);
        Mockito.when(dateProvider.getDateTime()).thenReturn(date);
        boolean isAlive =   bear.isAlive();

        assertFalse(isAlive);

    }


    @Test
    public void attack_forPolarBear_returns_correct_message_on_consoleOutput_Test() {

        ILivingBear bear = new PolarBear(dateProvider);
        String expected = KILL_FOR_FOOD;

        bear.attack();
        String actual = outContent.toString().trim();

        assertEquals(expected, actual);
    }

    @After
    public void tearDown(){
        System.setOut(orginalOut);
    }
}