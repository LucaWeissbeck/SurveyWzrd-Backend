package javawizards.surveywzrd.results;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javawizards.surveywzrd.surveys.AnswerOption;
import javawizards.surveywzrd.surveys.Survey;
import javawizards.surveywzrd.users.Participant;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "survey_feedback")
public class SurveyFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "timestamp")
    private String timestamp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "answer_option_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AnswerOption answerOption;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Participant participant;

    public SurveyFeedback() {
    }

    public SurveyFeedback(Long id, String timestamp, AnswerOption answerOption, Participant participant) {
        this.id = id;
        this.timestamp = timestamp;
        this.answerOption = answerOption;
        this.participant = participant;
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

    public AnswerOption getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(AnswerOption answerOption) {
        this.answerOption = answerOption;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    @Override
    public String toString() {
        return "SurveyFeedback{" +
                "id=" + id +
                ", timestamp='" + timestamp + '\'' +
                ", answerOption=" + answerOption +
                ", participant=" + participant +
                '}';
    }
}
