package javawizards.surveywzrd;

import javawizards.surveywzrd.results.SurveyFeedback;
import javawizards.surveywzrd.results.SurveyFeedbackRepository;
import javawizards.surveywzrd.surveys.AnswerOption;
import javawizards.surveywzrd.surveys.AnswerOptionRepository;
import javawizards.surveywzrd.surveys.Survey;
import javawizards.surveywzrd.surveys.SurveyRepository;
import javawizards.surveywzrd.users.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

@SpringBootTest
@ActiveProfiles("test")
class SurveywzrdTestUtils {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private AuthTokenRepository authTokenRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private AnswerOptionRepository answerOptionRepository;

    @Autowired
    private SurveyFeedbackRepository surveyFeedbackRepository;

    public void createAdministratorAndAuthToken() {
        Administrator administrator = new Administrator("test@test.de", "test", true);
        administrator.setId(1L);
        administratorRepository.save(administrator);
        authTokenRepository.save(new AuthToken("testkey", administratorRepository.findById(1L)));
    }

    public void createSurveyAnd3AnswerOptions() {
        Survey survey = new Survey("name", "description", new Date(), "question", true, "companyName");
        survey.setId(1L);
        survey.setAdministrator(administratorRepository.findById(1L));
        surveyRepository.save(survey);
        AnswerOption answerOption1 = new AnswerOption(1L, "value 1");
        AnswerOption answerOption2 = new AnswerOption(2L, "value 2");
        AnswerOption answerOption3 = new AnswerOption(3L, "value 3");
        answerOption1.setSurvey(surveyRepository.findById(1L));
        answerOption2.setSurvey(surveyRepository.findById(1L));
        answerOption3.setSurvey(surveyRepository.findById(1L));
        answerOptionRepository.save(answerOption1);
        answerOptionRepository.save(answerOption2);
        answerOptionRepository.save(answerOption3);
    }

    public void vote() {
        participantRepository.save(new Participant(1L, "cookieId", "platform", "platformVersion", "deviceType", "browser",
                "browserType", "browserLanguage", "locationCountry", "locationCity"));
        participantRepository.save(new Participant(2L, "cookieId", "platform", "platformVersion", "deviceType", "browser",
                "browserType", "browserLanguage", "locationCountry", "locationCity"));
        participantRepository.save(new Participant(3L, "cookieId", "platform", "platformVersion", "deviceType", "browser",
                "browserType", "browserLanguage", "locationCountry", "locationCity"));
        surveyFeedbackRepository.save(new SurveyFeedback(1L, new Date(), answerOptionRepository.findById(1L), surveyRepository.findById(1L), participantRepository.findById(1L)));
        surveyFeedbackRepository.save(new SurveyFeedback(2L, new Date(), answerOptionRepository.findById(2L), surveyRepository.findById(1L), participantRepository.findById(1L)));
        surveyFeedbackRepository.save(new SurveyFeedback(3L, new Date(), answerOptionRepository.findById(3L), surveyRepository.findById(1L), participantRepository.findById(1L)));
        surveyFeedbackRepository.save(new SurveyFeedback(4L, new Date(), answerOptionRepository.findById(1L), surveyRepository.findById(1L), participantRepository.findById(2L)));
        surveyFeedbackRepository.save(new SurveyFeedback(5L, new Date(), answerOptionRepository.findById(2L), surveyRepository.findById(1L), participantRepository.findById(2L)));
        surveyFeedbackRepository.save(new SurveyFeedback(6L, new Date(), answerOptionRepository.findById(3L), surveyRepository.findById(1L), participantRepository.findById(3L)));
    }

}
