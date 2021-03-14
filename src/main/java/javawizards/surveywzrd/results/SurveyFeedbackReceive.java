package javawizards.surveywzrd.results;

import javawizards.surveywzrd.surveys.AnswerOption;
import javawizards.surveywzrd.users.Participant;

public class SurveyFeedbackReceive {
    private String timestamp;
    private Long answerOptionID;
    private Long participantID;

    public SurveyFeedbackReceive(String timestamp, Long answerOptionID, Long participantID) {
        this.timestamp = timestamp;
        this.answerOptionID = answerOptionID;
        this.participantID = participantID;
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

    public Long getParticipantID() {
        return participantID;
    }

    public void setParticipantID(Long participantID) {
        this.participantID = participantID;
    }
}
