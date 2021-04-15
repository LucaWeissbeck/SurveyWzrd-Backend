package javawizards.surveywzrd.analysis;

public class RawSurveyFeedbackData {
    private Long id;
    private String timestamp;
    private Long answerOptionID;
    private String valueName;

    public RawSurveyFeedbackData(Long id, String timestamp, Long answerOptionID, String valueName) {
        this.id = id;
        this.timestamp = timestamp;
        this.answerOptionID = answerOptionID;
        this.valueName = valueName;

    }

    public RawSurveyFeedbackData() {
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Long getAnswerOptionID() {
        return answerOptionID;
    }

    public void setAnswerOptionID(Long answerOptionID) {
        this.answerOptionID = answerOptionID;
    }
}
