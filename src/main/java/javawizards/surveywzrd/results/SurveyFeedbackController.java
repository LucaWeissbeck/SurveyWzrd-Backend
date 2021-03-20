package javawizards.surveywzrd.results;

import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.ParseException;
import com.blueconic.browscap.UserAgentParser;
import com.blueconic.browscap.UserAgentService;
import javawizards.surveywzrd.SurveywzrdApplication;
import javawizards.surveywzrd.surveys.AnswerOptionRepository;
import javawizards.surveywzrd.surveys.SurveyRepository;
import javawizards.surveywzrd.users.Participant;
import javawizards.surveywzrd.users.ParticipantRepository;
import javawizards.surveywzrd.users.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/surveyfeedback")
public class SurveyFeedbackController {
    private final SurveyFeedbackRepository surveyFeedbackRepository;
    private final AnswerOptionRepository answerOptionRepository;
    private final SurveyRepository surveyRepository;
    private final ParticipantService participantService;

    @Autowired
    public SurveyFeedbackController(SurveyFeedbackRepository surveyFeedbackRepository, AnswerOptionRepository answerOptionRepository, SurveyRepository surveyRepository, ParticipantService participantService) {
        this.surveyFeedbackRepository = surveyFeedbackRepository;
        this.answerOptionRepository = answerOptionRepository;
        this.surveyRepository = surveyRepository;
        this.participantService = participantService;
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

    @RequestMapping(value = "/public/single/{surveyID}", method = RequestMethod.POST)
    public SurveyFeedbackReceiveSingleChoice addSurveyFeedbackSingleChoice(HttpServletRequest req, @RequestBody SurveyFeedbackReceiveSingleChoice surveyFeedbackReceiveSingleChoice, @PathVariable Long surveyID) {
        SurveyFeedback toInsert = new SurveyFeedback();
        Participant participantPrepare = new Participant();
        participantPrepare = participantService.addHeaderInformationToParticipant(participantPrepare, req);
        participantPrepare.setCookieId(surveyFeedbackReceiveSingleChoice.getIdentifierID());
        participantPrepare.setBrowser_language(surveyFeedbackReceiveSingleChoice.getBrowserLanguage());
        toInsert.setAnswerOption(answerOptionRepository.findById(surveyFeedbackReceiveSingleChoice.getAnswerOptionID()).get());
        toInsert.setSurvey(surveyRepository.findById(surveyID).get());
        toInsert.setParticipant(participantService.existsOrCreate(participantPrepare));
        toInsert.setTimestamp(new Date());
        surveyFeedbackRepository.save(toInsert);

        return new SurveyFeedbackReceiveSingleChoice(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(toInsert.getTimestamp()),toInsert.getAnswerOption().getId(),participantPrepare.getCookieId(),participantPrepare.getBrowser_language());

    }



    @RequestMapping(value = "/public/multiple/{surveyID}", method = RequestMethod.POST)
    public SurveyFeedbackReceiveMultipleChoice addSurveyFeedbackMultipleChoice(HttpServletRequest req, @RequestBody SurveyFeedbackReceiveMultipleChoice surveyFeedbackReceiveMultipleChoice, @PathVariable Long surveyID) {
        List<SurveyFeedback> surveyFeedbacks = new ArrayList<>();
        Participant participantPrepare = new Participant();
        participantPrepare = participantService.addHeaderInformationToParticipant(participantPrepare, req);
        participantPrepare.setCookieId(surveyFeedbackReceiveMultipleChoice.getIdentifierID());
        participantPrepare.setBrowser_language(surveyFeedbackReceiveMultipleChoice.getBrowserLanguage());
        Participant participant = participantService.existsOrCreate(participantPrepare);
        for (Long answerOptionID : surveyFeedbackReceiveMultipleChoice.getAnswerOptionIDs()) {
            SurveyFeedback toInsert = new SurveyFeedback();
            toInsert.setAnswerOption(answerOptionRepository.findById(answerOptionID).get());
            toInsert.setSurvey(surveyRepository.findById(surveyID).get());
            toInsert.setParticipant(participant);
            toInsert.setTimestamp(new Date());
            surveyFeedbacks.add(surveyFeedbackRepository.save(toInsert));
        }

        return new SurveyFeedbackReceiveMultipleChoice(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()),surveyFeedbackReceiveMultipleChoice.getAnswerOptionIDs(),participant.getCookieId(),participant.getBrowser_language());

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
