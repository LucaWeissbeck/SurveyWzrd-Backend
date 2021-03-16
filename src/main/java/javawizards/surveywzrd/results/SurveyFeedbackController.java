package javawizards.surveywzrd.results;

import javawizards.surveywzrd.surveys.AnswerOptionRepository;
import javawizards.surveywzrd.surveys.SurveyRepository;
import javawizards.surveywzrd.users.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/surveyfeedback")
public class SurveyFeedbackController {
    private final SurveyFeedbackRepository surveyFeedbackRepository;
    private AnswerOptionRepository answerOptionRepository;
    private SurveyRepository surveyRepository;
    private ParticipantRepository participantRepository;

    @Autowired
    public SurveyFeedbackController(SurveyFeedbackRepository surveyFeedbackRepository, AnswerOptionRepository answerOptionRepository, SurveyRepository surveyRepository, ParticipantRepository participantRepository) {
        this.surveyFeedbackRepository = surveyFeedbackRepository;
        this.answerOptionRepository = answerOptionRepository;
        this.surveyRepository = surveyRepository;
        this.participantRepository = participantRepository;
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

    @RequestMapping(value = "/public/{surveyID}", method = RequestMethod.POST)
    public SurveyFeedback addSurveyFeedback(@RequestBody SurveyFeedbackReceive surveyFeedbackReceive, @PathVariable Long surveyID) {
        SurveyFeedback toinsert = new SurveyFeedback();
        toinsert.setAnswerOption(answerOptionRepository.findById(surveyFeedbackReceive.getAnswerOptionID()).get());
        toinsert.setSurvey(surveyRepository.findById(surveyID).get());
        toinsert.setParticipant(participantRepository.findById(surveyFeedbackReceive.getParticipantID()).get());
        toinsert.setTimestamp(new Date());

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
