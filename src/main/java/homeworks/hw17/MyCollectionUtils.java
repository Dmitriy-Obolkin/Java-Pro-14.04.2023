package homeworks.hw17;

import java.util.ArrayList;
import java.util.List;

public class MyCollectionUtils {
    public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        //or
        //Collections.addAll(list, array);

        return list;
    }
}
