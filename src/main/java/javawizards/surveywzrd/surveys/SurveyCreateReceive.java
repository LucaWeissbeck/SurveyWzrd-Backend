package javawizards.surveywzrd.surveys;

import java.util.List;

public class SurveyCreateReceive {
    private Survey survey;
    private List<AnswerOption> answerOptions;

    public SurveyCreateReceive(Survey survey, List<AnswerOption> answerOptions) {
        this.survey = survey;
        this.answerOptions = answerOptions;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<AnswerOption> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<AnswerOption> answerOptions) {
        this.answerOptions = answerOptions;
    }
}
