package javawizards.surveywzrd.analysis;

import javawizards.surveywzrd.results.SurveyFeedback;
import javawizards.surveywzrd.results.SurveyFeedbackRepository;
import javawizards.surveywzrd.surveys.AnswerOption;
import javawizards.surveywzrd.surveys.AnswerOptionRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public static List<RawSurveyFeedbackData> getRawAnalysisDataMinimized(List<SurveyFeedback> rawFeedback) {
        List<RawSurveyFeedbackData> returned = new ArrayList<>();
        for (SurveyFeedback feedback : rawFeedback) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            returned.add(new RawSurveyFeedbackData(feedback.getId(), formatter.format(feedback.getTimestamp()), feedback.getAnswerOption().getId(), feedback.getAnswerOption().getValue()));
        }
        return returned;
    }

    public static List<RawSurveyFeedbackDataAdmin> getRawAnalysisDataMinimizedForAdmin(List<SurveyFeedback> rawFeedback) {
        List<RawSurveyFeedbackDataAdmin> returned = new ArrayList<>();
        for (SurveyFeedback feedback : rawFeedback) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            returned.add(new RawSurveyFeedbackDataAdmin(feedback.getId(),
                    formatter.format(feedback.getTimestamp()), feedback.getAnswerOption().getId(),
                    feedback.getAnswerOption().getValue(), feedback.getParticipant().getLocationCity(), feedback.getParticipant().getLocationCountry(), feedback.getParticipant().getId()));
        }
        return returned;
    }
}
