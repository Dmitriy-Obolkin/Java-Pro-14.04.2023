package main.java.ua.ithillel;

import org.junit.platform.console.ConsoleLauncher;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.stream.Stream;

import static org.junit.platform.engine.discovery.DiscoverySelectors.*;

public class ProjectTestRunner {

    private PrintWriter printWriter;
    private PrintWriter printErrWriter;

    public ProjectTestRunner() {
        printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        printErrWriter = new PrintWriter(new OutputStreamWriter(System.err));
    }

    public void runTestByName(String className){
        String[] args = {"execute", "--select-class", className};
        ConsoleLauncher.run(printWriter, printErrWriter, args);
    }

    public void runTestByClass(Class<?> classToTest){
        String[] args = {"execute", "--select-class", classToTest.getName()};
        ConsoleLauncher.run(printWriter, printErrWriter, args);
    }

    public void runTestByNames(String ... classNames){
        String[] args = new String[classNames.length + 2];
        args[0] = "execute";
        args[1] = "--select-class";
        System.arraycopy(classNames, 0, args, 2, classNames.length);
        ConsoleLauncher.run(printWriter, printErrWriter, args);
    }

    public void runTestByClasses(Class<?> ... classesToTest){
        String[] args = new String[classesToTest.length + 2];
        args[0] = "execute";
        args[1] = "--select-class";
        for (int i = 0; i < classesToTest.length; i++) {
            args[i + 2] = classesToTest[i].getName();
        }
        ConsoleLauncher.run(printWriter, printErrWriter, args);
    }

    public void runTestByPackage(String packageName){
        String[] args = {"execute", "--select-package", packageName};
        ConsoleLauncher.run(printWriter, printErrWriter, args);
    }

}
