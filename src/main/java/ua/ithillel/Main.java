package main.java.ua.ithillel;

import main.java.ua.ithillel.testRunner.OutputType;
import main.java.ua.ithillel.testRunner.ProjectTestRunner;
import main.java.ua.ithillel.testRunner.TestResultParser;
import test.java.ua.ithillel.ArrayUtilsTest;
import test.java.ua.ithillel.SimpleMathLibraryTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ProjectTestRunner projectTestRunner = new ProjectTestRunner(OutputType.CONSOLE);

        //projectTestRunner.runTestByName(SimpleMathLibraryTest.class.getName());
        //projectTestRunner.runTestByClass(SimpleMathLibraryTest.class);
        //projectTestRunner.runTestByNames(SimpleMathLibraryTest.class.getName());
        //projectTestRunner.runTestByClasses(SimpleMathLibraryTest.class);
        //projectTestRunner.runTestByPackage("test.java.ua.ithillel");

        projectTestRunner.changeOutputType(OutputType.FILE);
        projectTestRunner.runTestByName(SimpleMathLibraryTest.class.getName());



        System.out.println();
        TestResultParser testResultParser = new TestResultParser();
        String filePath = "src/test/resources/testResults/results.txt";

        File file = new File(filePath);
        Path path = Paths.get(filePath);

        try {
            //System.out.println(testResultParser.parse(filePath));
            //System.out.println(testResultParser.parse(file));
            System.out.println(testResultParser.parse(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        System.out.println();
        projectTestRunner.changeOutputType(OutputType.CONSOLE);
        projectTestRunner.runTestByClass(ArrayUtilsTest.class);

    }
}