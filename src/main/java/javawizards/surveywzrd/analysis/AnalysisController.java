package javawizards.surveywzrd.analysis;

import javawizards.surveywzrd.results.SurveyFeedback;
import javawizards.surveywzrd.results.SurveyFeedbackRepository;
import javawizards.surveywzrd.surveys.AnswerOptionRepository;
import javawizards.surveywzrd.surveys.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/analysis")
public class AnalysisController {

    AnswerOptionRepository answerOptionRepository;
    SurveyFeedbackRepository surveyFeedbackRepository;

    @Autowired
    public AnalysisController(AnswerOptionRepository answerOptionRepository, SurveyFeedbackRepository surveyFeedbackRepository){
        this.answerOptionRepository = answerOptionRepository;
        this.surveyFeedbackRepository = surveyFeedbackRepository;
    }


    @RequestMapping(value = "/public/{surveyID}", method = RequestMethod.GET)
    public List<SurveyResultPerOption> getPublicSurveyResults(@PathVariable Long surveyID) {
        return AnalysisUtils.getPublicAnalysis1(surveyID, answerOptionRepository, surveyFeedbackRepository);

    }
    @RequestMapping(value = "/public/minimizedrawdata/{surveyID}", method = RequestMethod.GET)
    public List<RawSurveyFeedbackData> getMinimizedSurveyRawResults(@PathVariable Long surveyID) {
        return AnalysisUtils.getRawAnalysisDataMinimized(surveyFeedbackRepository.findAllBySurvey_Id(surveyID));

    }
}
