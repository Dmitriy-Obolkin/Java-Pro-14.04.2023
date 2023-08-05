package main.java.ua.ithillel.testRunner;

import java.util.Date;

public class TestResult {
    private final int totalTests;
    private final int passedTests;
    private final int failedTests;
    private final long testRunTimeMillis;

    public TestResult(int totalTests, int passedTests, int failedTests, long testRunTimeMillis) {
        this.totalTests = totalTests;
        this.passedTests = passedTests;
        this.failedTests = failedTests;
        this.testRunTimeMillis = testRunTimeMillis;
    }

    public int getTotalTests() {
        return totalTests;
    }

    public int getPassedTests() {
        return passedTests;
    }

    public int getFailedTests() {
        return failedTests;
    }

    public long getTestRunTimeMillis() {
        return testRunTimeMillis;
    }

    public double getTestRunTimeSeconds() {
        return testRunTimeMillis / 1000.0;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "totalTests=" + totalTests +
                ", passedTests=" + passedTests +
                ", failedTests=" + failedTests +
                ", testRunTimeMillis=" + testRunTimeMillis +
                '}';
    }
}
