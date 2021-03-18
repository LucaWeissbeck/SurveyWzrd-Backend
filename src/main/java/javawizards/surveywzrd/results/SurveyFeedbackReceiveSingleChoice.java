package javawizards.surveywzrd.results;

import javawizards.surveywzrd.surveys.AnswerOption;
import javawizards.surveywzrd.users.Participant;

public class SurveyFeedbackReceiveSingleChoice extends SurveyFeedbackReceive{
    private Long answerOptionID;

    public SurveyFeedbackReceiveSingleChoice(String timestamp, Long answerOptionID, String identifierID) {
        super(timestamp, identifierID);
        this.answerOptionID = answerOptionID;
    }

    public Long getAnswerOptionID() {
        return answerOptionID;
    }

    public void setAnswerOptionID(Long answerOptionID) {
        this.answerOptionID = answerOptionID;
    }

}
