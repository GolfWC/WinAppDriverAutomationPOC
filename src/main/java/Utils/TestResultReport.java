package Utils;

public class TestResultReport {
    private String scenarioName;
    private boolean isFailed;
    private String reportLink;

    public TestResultReport(String scenarioName, boolean isFailed, String reportLink) {
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