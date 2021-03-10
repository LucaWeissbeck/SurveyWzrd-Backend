package javawizards.surveywzrd.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/survey_feedback")
public class SurveyFeedbackController {
    private final SurveyFeedbackRepository surveyFeedbackRepository;

    @Autowired
    public SurveyFeedbackController(SurveyFeedbackRepository surveyFeedbackRepository) {
        this.surveyFeedbackRepository = surveyFeedbackRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<SurveyFeedback>> getAllSurveyFeedbacks() {
        return new ResponseEntity<>((List<SurveyFeedback>) surveyFeedbackRepository.findAll(), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SurveyFeedback getSurveyFeedback(@PathVariable Long id) {
        return surveyFeedbackRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(id.toString())); //SurveyNotFoundException(id));

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public SurveyFeedback addSurveyFeedback(@RequestBody SurveyFeedback surveyFeedback) {
        return surveyFeedbackRepository.save(surveyFeedback);

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
