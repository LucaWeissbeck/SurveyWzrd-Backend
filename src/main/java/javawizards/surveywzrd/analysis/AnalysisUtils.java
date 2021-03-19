package javawizards.surveywzrd.analysis;

import javawizards.surveywzrd.SurveywzrdApplication;
import javawizards.surveywzrd.results.SurveyFeedback;
import javawizards.surveywzrd.results.SurveyFeedbackRepository;
import javawizards.surveywzrd.surveys.AnswerOption;
import javawizards.surveywzrd.surveys.AnswerOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnalysisUtils {


    public static List<SurveyResultPerOption> getPublicAnalysis1(Long surveyID, AnswerOptionRepository answerOptionRepository, SurveyFeedbackRepository surveyFeedbackRepository) {
        List<AnswerOption> answerOptions = new ArrayList<>();
        List<SurveyResultPerOption> answerCounts = new ArrayList<>();
        answerOptions.addAll(answerOptionRepository.findAllBySurvey_id(surveyID));
        for (AnswerOption answer : answerOptions) {
            int count = surveyFeedbackRepository.findAllByAnswerOption_Id(answer.getId()).size();
                answerCounts.add(new SurveyResultPerOption(answer, count));
        }
        return answerCounts;
    }

    public static List<RawSurveyFeedbackData> getRawAnalysisDataMinimized(List<SurveyFeedback> rawFeedback){
        List<RawSurveyFeedbackData> returned = new ArrayList<>();
        for (SurveyFeedback feedback: rawFeedback){
            SimpleDateFormat formatter = new SimpleDateFormat(SurveywzrdApplication.dateformat);
            returned.add(new RawSurveyFeedbackData(feedback.getId(), formatter.format(feedback.getTimestamp()),feedback.getAnswerOption().getId(), feedback.getAnswerOption().getValue()));
        }
        return returned;
    }

    /*public HashMap<Long, Integer> getPublicAnalysis2(Long surveyID) {
        List<Long> answerOptionIds = null;
        HashMap<Long, Integer> answerCounts = null;
        for (AnswerOption answerOption : answerOptionRepository.findAllBySurvey_id(surveyID)) {
            answerOptionIds.add(answerOption.getId());
        }
        for (Long answerId : answerOptionIds) {
            int count = surveyFeedbackRepository.findAllByAnswerOption_Id(answerId).size();
            answerCounts.put(answerId, count);

        }

        return answerCounts;
    }*/
}
