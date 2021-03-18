package javawizards.surveywzrd.results;

import java.util.List;

public class SurveyFeedbackReceiveMultipleChoice extends SurveyFeedbackReceive{
    private List<Long> answerOptionIDs;

    public SurveyFeedbackReceiveMultipleChoice(String timestamp, List<Long> answerOptionIDs, String identifierID) {
        super(timestamp, identifierID);
        this.answerOptionIDs = answerOptionIDs;
    }

    public List<Long> getAnswerOptionIDs() {
        return answerOptionIDs;
    }

    public void setAnswerOptionIDs(List<Long> answerOptionIDs) {
        this.answerOptionIDs = answerOptionIDs;
    }

}
