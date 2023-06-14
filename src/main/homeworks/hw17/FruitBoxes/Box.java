package src.main.homeworks.hw17.FruitBoxes;

import java.util.ArrayList;
import java.util.Comparator;

public class Box <T extends Fruit> {
    private ArrayList<T> box = new ArrayList<>();


    public void addFruit(T fruit) {
/*        if (!box.isEmpty()) {
            if (!fruit.getClass().equals(box.get(0).getClass())) {
                throw new IllegalArgumentException("The box can contain only one type of fruit");
            }
        }*/
        box.add(fruit);
    }

    public void addFruit(T fruit, int quantity) {
        for(int i=0; i<quantity; i++){
            box.add(fruit);
        }
    }

    public float getWeight() {
        float totalWeight = 0.0F;

        if(!box.isEmpty())
            totalWeight = box.size() * box.get(0).getWeight();

        return totalWeight;
    }


    public <T extends Fruit> boolean compare(Box<T> anotherBox) {
        float epsilon = 0.05F;
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < epsilon;
    }


    public void merge(Box<T> anotherBox) {
        if (!box.isEmpty() && !anotherBox.box.isEmpty()) {
            if (!box.get(0).getClass().equals(anotherBox.box.get(0).getClass())) {
                throw new IllegalArgumentException("Cannot merge boxes with different types of fruits");
            }
        }
        box.addAll(anotherBox.box);

        anotherBox.box.clear();
    }

}
