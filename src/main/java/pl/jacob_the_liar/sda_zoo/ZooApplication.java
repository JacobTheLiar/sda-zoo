package pl.jacob_the_liar.sda_zoo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.jacob_the_liar.sda_zoo.db.IZooDatabase;
import pl.jacob_the_liar.sda_zoo.db.ZooListDatabase;
import pl.jacob_the_liar.sda_zoo.zoo.IZoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class ZooApplication {

    private static final Logger log
            = LoggerFactory.getLogger(ZooApplication.class);

    private IZoo zoo;


    public void start() {

        log.debug("start()");
        initializeZoo();


        log.info("application lunched");
        String choose;
        do {
            writeLn("welcome in ZOO!");
            writeLn(String.format("we have %d animals", zoo.getNumberOfAllAnimals()));

            printAnimalDetails();

            writeLn("\n");
            writeLn("type 'exit' or 'quit' to exit");
            write("type your choice: ");
            choose = readLine();
            if (isValidChoice(choose))
                log.warn("invalid choice: "+choose);
        } while (isExitChoice(choose));

        log.info("application finish");

    }

    private boolean isValidChoice(String choose) {
        return isExitChoice(choose);
    }

    private boolean isExitChoice(String choose) {
        return !choose.equals("exit") && !choose.equals("quit");
    }

    private void printAnimalDetails() {
        log.debug("printAnimalDetails()");
        zoo.getAnimalsCount()
                .forEach((name, cnt) -> printAnimalDetailItem(name, cnt));
    }

    private void printAnimalDetailItem(String name, Integer count) {
        log.debug(String.format("printAnimalDetailItem(%s: %d);", name, count));
        writeLn(String.format("\t%s: %d", name, count));
    }

    private void initializeZoo() {
        log.debug("initializeZoo()");
        IZooDatabase zooDatabase = new ZooListDatabase();
        zoo = zooDatabase.getZooDatabase();
    }

    private void writeLn(String s) {
        System.out.println(s);
    }

    private void write(String s) {
        System.out.print(s);
    }

    private String readLine(){
        log.debug("readLine()");
        String inputText = "";
        try {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            inputText = inputReader.readLine().trim();
            log.info("user input: '"+inputText+"'");
        } catch (Exception e){
            log.error("input error", e);
        }
        return inputText;
    }

}
