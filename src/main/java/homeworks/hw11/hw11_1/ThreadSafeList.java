package homeworks.hw11.hw11_1;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList<T> {
    private List<T> list;

    public ThreadSafeList(){
        this.list = new ArrayList<>();
    }

    public synchronized void add(T value){
        list.add(value);
    }

    public synchronized boolean remove(T value) throws IllegalArgumentException{
        if(!list.remove(value)){
            throw new IllegalArgumentException("Failed to remove the item. Item not found.");
        }
        return true;
    }

    public synchronized T get(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= list.size()){
            throw new IndexOutOfBoundsException("Index out of bounds for list.");
        }
        return list.get(index);
    }

}
