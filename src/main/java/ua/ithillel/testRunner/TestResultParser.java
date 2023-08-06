package main.java.ua.ithillel.testRunner;

import java.io.*;
import java.nio.file.Path;

public class TestResultParser {

    public TestResult parse(String filePath) throws IOException {
        return parse(new File(filePath));
    }

    public TestResult parse(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + file.getPath());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return parse(reader);
        }
    }

    public TestResult parse(Path path) throws IOException {
        return parse(path.toFile());
    }

    private TestResult parse(BufferedReader reader) throws IOException {
        String line;
        int totalTests = 0;
        int passedTests = 0;
        int failedTests = 0;
        long testRunTimeMs = 0;

        boolean parsingResults = false;

        while ((line = reader.readLine()) != null) {
            if (line.contains("Test run finished after")) {
                testRunTimeMs = Long.parseLong(line.split(" ")[4]);
                parsingResults = true;
            } else if (parsingResults) {
                if (line.contains("tests found")) {
                    totalTests = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                } else if (line.contains("tests successful")) {
                    passedTests = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                } else if (line.contains("tests failed")) {
                    failedTests = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                    break;
                }
            }
        }

        return new TestResult(totalTests, passedTests, failedTests, testRunTimeMs);
    }
}
