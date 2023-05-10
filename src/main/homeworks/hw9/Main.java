package src.main.homeworks.hw9;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        try {
            FileLoggerConfiguration configuration = loader.load("logConfigs/hw9/FileConfig.txt");
            FileLogger logger = new FileLogger(configuration);

            Scanner sc = new Scanner(System.in);
            int i = 1;
            while(i < 50){
                logger.info("Informational message " + i);
                logger.debug(String.format("Debug message %s\n", i));
                System.out.println("Iteration of the log entry: " + i);
                i++;
                sc.nextLine();
            }

        } catch (IOException | FileMaxSizeReachedException e) {
            e.printStackTrace();
        }

    }
}
