package src.main.homeworks.hw19.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class TestRunner {
    public static void start(Class<?> testClass){
        Method beforeMethod = null;
        Method afterMethod = null;
        SortedMap<Integer, List<Method>> tests = new TreeMap<>();

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod != null) throw new RuntimeException("More than one @BeforeSuite method found");
                beforeMethod = method;
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod != null) throw new RuntimeException("More than one @AfterSuite method found");
                afterMethod = method;
            } else if (method.isAnnotationPresent(Test.class)) {
                int priority = method.getAnnotation(Test.class).priority();
                tests.computeIfAbsent(priority, k -> new ArrayList<>()).add(method);
            }
        }

        try {
            Object instance = testClass.getDeclaredConstructor().newInstance();
            if (beforeMethod != null) {
                beforeMethod.invoke(instance);
            }

            for (List<Method> methods : tests.values()) {
                for (Method method : methods) {
                    method.invoke(instance);
                }
            }

            if (afterMethod != null) {
                afterMethod.invoke(instance);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
