package javawizards.surveywzrd.results;

public abstract class SurveyFeedbackReceive {
    private String timestamp;
    private String identifierID;

    public SurveyFeedbackReceive(String timestamp, String identifierID) {
        this.timestamp = timestamp;
        this.identifierID = identifierID;
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
