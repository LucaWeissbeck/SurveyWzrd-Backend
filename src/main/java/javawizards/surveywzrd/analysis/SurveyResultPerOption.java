package javawizards.surveywzrd.analysis;

import javawizards.surveywzrd.surveys.AnswerOption;

public class SurveyResultPerOption {

    private AnswerOption answerOption;
    private int count;

    public SurveyResultPerOption(AnswerOption answerOption, int count) {
        this.answerOption = answerOption;
        this.count = count;
    }

    public SurveyResultPerOption() {
    }

    public AnswerOption getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(AnswerOption answerOption) {
        this.answerOption = answerOption;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
