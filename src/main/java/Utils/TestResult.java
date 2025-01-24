package Utils;

public class TestResult {
    private String scenarioName;
    private boolean isFailed;
    private String reportLink;

    public TestResult(String scenarioName, boolean isFailed, String reportLink) {
        this.scenarioName = scenarioName;
        this.isFailed = isFailed;
        this.reportLink = reportLink;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public boolean isFailed() {
        return isFailed;
    }

    public String getReportLink() {
        return reportLink;
    }
}