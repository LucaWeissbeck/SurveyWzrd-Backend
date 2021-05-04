package javawizards.surveywzrd.results;

public class SurveyFeedbackReceiveSingleChoice extends SurveyFeedbackReceive {
    private Long answerOptionID;

    public SurveyFeedbackReceiveSingleChoice(String timestamp, Long answerOptionID, String identifierID, String browserLanguage) {
        super(timestamp, identifierID, browserLanguage);
        this.answerOptionID = answerOptionID;
    }

    public Long getAnswerOptionID() {
        return answerOptionID;
    }

    public void setAnswerOptionID(Long answerOptionID) {
        this.answerOptionID = answerOptionID;
    }

}
