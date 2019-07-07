package pl.jacob_the_liar.sda_zoo.zoo;

import pl.jacob_the_liar.sda_zoo.animal.IAnimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoo implements IZoo {

    private List<IAnimal> animalList;

    public Zoo() {
        animalList = new ArrayList<>();
    }


    public void addAnimal(IAnimal animal){
        animalList.add(animal);
    }

    @Override
    public int getNumberOfAllAnimals() {
        return animalList.size();
    }

    @Override
    public Map<String, Integer> getAnimalsCount() {

        Map<String, Integer> list = new HashMap<>();

        animalList.forEach(iAnimal -> incCount(list, iAnimal));

        return list;
    }


    private void incCount(Map<String, Integer> map, IAnimal animal){

        if (map.containsKey(animal.getName())){
            int cnt = map.get(animal.getName());
            map.replace(animal.getName(), ++cnt);
        } else {
            map.put(animal.getName(), 1);
        }

    }
}
