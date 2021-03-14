package javawizards.surveywzrd.results;

import com.fasterxml.jackson.annotation.JsonProperty;
import javawizards.surveywzrd.surveys.AnswerOptionRepository;
import javawizards.surveywzrd.surveys.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/survey_feedback")
public class SurveyFeedbackController {
    private final SurveyFeedbackRepository surveyFeedbackRepository;
    private AnswerOptionRepository answerOptionRepository;

    @Autowired
    public SurveyFeedbackController(SurveyFeedbackRepository surveyFeedbackRepository, AnswerOptionRepository answerOptionRepository) {
        this.surveyFeedbackRepository = surveyFeedbackRepository;
        this.answerOptionRepository = answerOptionRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<SurveyFeedback>> getAllSurveyFeedbacks() {
        return new ResponseEntity<>((List<SurveyFeedback>) surveyFeedbackRepository.findAll(), HttpStatus.OK);

    }

    @RequestMapping(value = "/{survey_id}", method = RequestMethod.GET)
    public ResponseEntity<List<SurveyFeedback>> getSurveyFeedbacksForSurvey(@PathVariable Long survey_id) {
        return new ResponseEntity<>(surveyFeedbackRepository.findAllBySurvey_Id(survey_id), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SurveyFeedback getSurveyFeedback(@PathVariable Long id) {
        return surveyFeedbackRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(id.toString())); //SurveyNotFoundException(id));

    }

    @RequestMapping(value = "/{survey_id}", method = RequestMethod.POST)
    public SurveyFeedback addSurveyFeedback(@RequestBody SurveyFeedbackReceive surveyFeedbackReceive) {
        SurveyFeedback toinsert = new SurveyFeedback();
        toinsert.setAnswerOption(answerOptionRepository.findById(surveyFeedbackReceive.getAnswerOptionID()).get());
        return surveyFeedbackRepository.save(toinsert);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public SurveyFeedback updateSurveyFeedback(@RequestBody SurveyFeedback surveyFeedback, @PathVariable Long id) {
        return surveyFeedbackRepository.findById(id)
                .map(surveyFeedback1 -> {
                    surveyFeedback1.setAnswerOption(surveyFeedback.getAnswerOption());
                    surveyFeedback1.setParticipant(surveyFeedback.getParticipant());
                    surveyFeedback1.setTimestamp(surveyFeedback.getTimestamp());
                    return surveyFeedbackRepository.save(surveyFeedback1);
                })
                .orElseGet(() -> {
                    surveyFeedback.setId(id);
                    return surveyFeedbackRepository.save(surveyFeedback);
                });

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSurveyFeedback(@PathVariable Long id) {
        surveyFeedbackRepository.deleteById(id);

    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAll() {
        surveyFeedbackRepository.deleteAll();

    }
}
