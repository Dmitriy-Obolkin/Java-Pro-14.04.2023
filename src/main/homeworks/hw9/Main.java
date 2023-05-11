package src.main.homeworks.hw9;

import src.main.homeworks.hw9.logging.Logger;
import src.main.homeworks.hw9.logging.LoggerConfiguration;
import src.main.homeworks.hw9.logging.LoggerConfigurationLoader;
import src.main.homeworks.hw9.logging.file.FileLogger;
import src.main.homeworks.hw9.logging.file.FileLoggerConfiguration;
import src.main.homeworks.hw9.logging.file.FileLoggerConfigurationLoader;
import src.main.homeworks.hw9.logging.file.FileMaxSizeReachedException;
import src.main.homeworks.hw9.logging.stdout.StdoutLogger;
import src.main.homeworks.hw9.logging.stdout.StdoutLoggerConfiguration;
import src.main.homeworks.hw9.logging.stdout.StdoutLoggerConfigurationLoader;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //FileLogger
        LoggerConfigurationLoader fileConfigLoader = new FileLoggerConfigurationLoader();
        try {
            LoggerConfiguration fileConfiguration =
                    fileConfigLoader.load("logConfigs/hw9/FileConfig.txt");
            Logger fileLogger = new FileLogger((FileLoggerConfiguration)fileConfiguration);

            Scanner sc = new Scanner(System.in);
            int i = 1;
            while(i < 25){
                fileLogger.info("Informational message " + i);
                fileLogger.debug(String.format("Debug message %s\n", i));
                System.out.println("Iteration of the log entry: " + i);
                i++;
                //sc.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FileMaxSizeReachedException e) {
            throw new RuntimeException(e);
        }

        //StdoutLogger
        LoggerConfigurationLoader stdoutConfigLoader = new StdoutLoggerConfigurationLoader();
        try{
            LoggerConfiguration stdoutConfiguration =
                    stdoutConfigLoader.load("logConfigs/hw9/StdoutConfig.txt");
            Logger stdoutLogger = new StdoutLogger((StdoutLoggerConfiguration) stdoutConfiguration);

            int i = 1;
            while(i < 10){
                stdoutLogger.info("Informational message " + i);
                stdoutLogger.debug(String.format("Debug message %s\n", i));
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FileMaxSizeReachedException e) {
            throw new RuntimeException(e);
        }

    }
}
