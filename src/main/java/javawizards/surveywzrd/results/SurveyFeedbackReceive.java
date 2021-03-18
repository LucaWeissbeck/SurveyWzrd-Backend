package javawizards.surveywzrd.results;

public abstract class SurveyFeedbackReceive {
    private String timestamp;
    private String identifierID;
    private String browserLanguage;

    public SurveyFeedbackReceive(String timestamp, String identifierID, String browserLanguage) {
        this.timestamp = timestamp;
        this.identifierID = identifierID;
        this.browserLanguage = browserLanguage;
    }

    public String getBrowserLanguage() {
        return browserLanguage;
    }

    public void setBrowserLanguage(String browserLanguage) {
        this.browserLanguage = browserLanguage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getIdentifierID() {
        return identifierID;
    }

    public void setIdentifierID(String identifierID) {
        this.identifierID = identifierID;
    }

}
