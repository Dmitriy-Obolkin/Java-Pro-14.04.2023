package main.java.ua.ithillel.testRunner;

import org.junit.platform.console.ConsoleLauncher;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ProjectTestRunner {

    private PrintWriter printWriter;
    private PrintWriter printErrWriter;
    private OutputType outputType;

    public ProjectTestRunner(OutputType outputType) {
        changeOutputType(outputType);
    }

    public void changeOutputType(OutputType outputType){
        switch (outputType) {
            case FILE:
                try {
                    printWriter = new PrintWriter(new FileWriter("src/test/resources/testResults/results.txt"));
                    printErrWriter = new PrintWriter(new FileWriter("src/test/resources/testResults/errors.txt"));
                } catch (IOException e) {
                    throw new RuntimeException("Error opening a file for writing ", e);
                }
                break;
            case CONSOLE:
            default:
                printWriter = new PrintWriter(new OutputStreamWriter(System.out));
                printErrWriter = new PrintWriter(new OutputStreamWriter(System.err));
                break;
        }
        this.outputType = outputType;
    }

    public void runTestByName(String className){
        String[] args = {"execute", "--select-class", className};
        run(args);
    }

    public void runTestByClass(Class<?> classToTest){
        String[] args = {"execute", "--select-class", classToTest.getName()};
        run(args);
    }

    public void runTestByNames(String ... classNames){
        String[] args = new String[classNames.length + 2];
        args[0] = "execute";
        args[1] = "--select-class";
        System.arraycopy(classNames, 0, args, 2, classNames.length);
        run(args);
    }

    public void runTestByClasses(Class<?> ... classesToTest){
        String[] args = new String[classesToTest.length + 2];
        args[0] = "execute";
        args[1] = "--select-class";
        for (int i = 0; i < classesToTest.length; i++) {
            args[i + 2] = classesToTest[i].getName();
        }
        run(args);
    }

    public void runTestByPackage(String packageName){
        String[] args = {"execute", "--select-package", packageName};
        run(args);
    }

    private void run(String[] args){
        ConsoleLauncher.run(printWriter, printErrWriter, args);

        if (outputType == OutputType.FILE) {
            printWriter.close();
            printErrWriter.close();
        }
    }

}
