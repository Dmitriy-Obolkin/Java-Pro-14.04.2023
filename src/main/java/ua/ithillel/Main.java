package main.java.ua.ithillel;

import test.java.ua.ithillel.SimpleMathLibraryTest;

public class Main {
    public static void main(String[] args) {
        ProjectTestRunner projectTestRunner = new ProjectTestRunner();

        //projectTestRunner.runTestByName(SimpleMathLibraryTest.class.getName());
        //projectTestRunner.runTestByClass(SimpleMathLibraryTest.class);
        //projectTestRunner.runTestByNames(SimpleMathLibraryTest.class.getName());
        //projectTestRunner.runTestByClasses(SimpleMathLibraryTest.class);
        projectTestRunner.runTestByPackage("test.java.ua.ithillel");
    }
}