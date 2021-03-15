package javawizards.surveywzrd.analysis;

import javawizards.surveywzrd.results.SurveyFeedback;
import javawizards.surveywzrd.results.SurveyFeedbackRepository;
import javawizards.surveywzrd.surveys.AnswerOption;
import javawizards.surveywzrd.surveys.AnswerOptionRepository;

import java.util.HashMap;
import java.util.List;

public class AnalysisUtils {
    AnswerOptionRepository aor;
    SurveyFeedbackRepository sfr;

    public List<SurveyResultPerOption> getPublicAnalysis1(Long surveyID) {
        List<AnswerOption> answerOptions = null;
        List<SurveyResultPerOption> answerCounts = null;
        answerOptions.addAll(aor.findAllBySurvey_id(surveyID));
        for (AnswerOption answer : answerOptions) {
            int count = 0;
            for (SurveyFeedback surveyFeedback : sfr.findAllByAnswerOption_Id(answer.getId())) {
                count++;
                answerCounts.add(new SurveyResultPerOption(answer, count));
            }
        }
        return answerCounts;
    }

    public HashMap<Long, Integer> getPublicAnalysis2(Long surveyID) {
        List<Long> answerOptionIds = null;
        HashMap<Long, Integer> answerCounts = null;
        for (AnswerOption answerOption : aor.findAllBySurvey_id(surveyID)) {
            answerOptionIds.add(answerOption.getId());
        }
        for (Long answerId : answerOptionIds) {
            int count = 0;
            for (SurveyFeedback surveyFeedback : sfr.findAllByAnswerOption_Id(answerId)) {
                count++;
                answerCounts.put(answerId, count);
            }
        }
        return answerCounts;
    }
}
