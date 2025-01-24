package Utils;

public class SuiteResult {
    private int totalTests;
    private int passes;
    private int failures;
    private int skips;

    public SuiteResult(int totalTests, int passes, int failures, int skips) {
        this.totalTests = totalTests;
        this.passes = passes;
        this.failures = failures;
        this.skips = skips;
    }

    public int getTotalTests() {
        return totalTests;
    }

    public int getPasses() {
        return passes;
    }

    public int getFailures() {
        return failures;
    }

    public int getSkips() {
        return skips;
    }
}