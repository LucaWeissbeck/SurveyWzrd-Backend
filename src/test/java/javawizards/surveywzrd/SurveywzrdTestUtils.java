package javawizards.surveywzrd;

import javawizards.surveywzrd.results.SurveyFeedback;
import javawizards.surveywzrd.results.SurveyFeedbackRepository;
import javawizards.surveywzrd.surveys.AnswerOption;
import javawizards.surveywzrd.surveys.AnswerOptionRepository;
import javawizards.surveywzrd.surveys.Survey;
import javawizards.surveywzrd.surveys.SurveyRepository;
import javawizards.surveywzrd.users.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ActiveProfiles("test")
@Service
public class SurveywzrdTestUtils {

    private SurveyRepository surveyRepository;

    private AdministratorRepository administratorRepository;

    private AuthTokenRepository authTokenRepository;

    private ParticipantRepository participantRepository;

    private AnswerOptionRepository answerOptionRepository;

    private SurveyFeedbackRepository surveyFeedbackRepository;

    @Autowired
    public SurveywzrdTestUtils(SurveyRepository surveyRepository, AdministratorRepository administratorRepository, AuthTokenRepository authTokenRepository, ParticipantRepository participantRepository, AnswerOptionRepository answerOptionRepository, SurveyFeedbackRepository surveyFeedbackRepository) {
        this.surveyRepository = surveyRepository;
        this.administratorRepository = administratorRepository;
        this.authTokenRepository = authTokenRepository;
        this.participantRepository = participantRepository;
        this.answerOptionRepository = answerOptionRepository;
        this.surveyFeedbackRepository = surveyFeedbackRepository;
    }

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
        surveyFeedbackRepository.save(new SurveyFeedback(1L, new Date(), answerOptionRepository.findById(1L).get(), surveyRepository.findById(1L), participantRepository.findById(1L)));
        surveyFeedbackRepository.save(new SurveyFeedback(2L, new Date(), answerOptionRepository.findById(2L).get(), surveyRepository.findById(1L), participantRepository.findById(1L)));
        surveyFeedbackRepository.save(new SurveyFeedback(3L, new Date(), answerOptionRepository.findById(3L).get(), surveyRepository.findById(1L), participantRepository.findById(1L)));
        surveyFeedbackRepository.save(new SurveyFeedback(4L, new Date(), answerOptionRepository.findById(1L).get(), surveyRepository.findById(1L), participantRepository.findById(2L)));
        surveyFeedbackRepository.save(new SurveyFeedback(5L, new Date(), answerOptionRepository.findById(2L).get(), surveyRepository.findById(1L), participantRepository.findById(2L)));
        surveyFeedbackRepository.save(new SurveyFeedback(6L, new Date(), answerOptionRepository.findById(3L).get(), surveyRepository.findById(1L), participantRepository.findById(3L)));
    }

}
