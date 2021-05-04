package javawizards.surveywzrd.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import javawizards.surveywzrd.SurveywzrdTestUtils;
import javawizards.surveywzrd.results.SurveyFeedbackReceiveMultipleChoice;
import javawizards.surveywzrd.results.SurveyFeedbackRepository;
import javawizards.surveywzrd.surveys.AnswerOptionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ParticipantControllerTest {

    private ParticipantController participantcontroller;


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    SurveywzrdTestUtils surveywzrdTestUtils;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    SurveyFeedbackRepository surveyFeedbackRepository;

    @Autowired
    AnswerOptionRepository answerOptionRepository;

    @Test
    void giveSurveyFeedbackWorksThroughAllLayers() throws Exception {
        surveywzrdTestUtils.createAdministratorAndAuthToken(1L, null);
        surveywzrdTestUtils.createSurveyAnd3AnswerOptions(1L, 1L);
        Participant user = new Participant(123L, "cookieId", "Windows", "platformVersion",
                "deviceType", "browser", "browserType", "browserLanguage"
                , "Stuttgart", "Germany");

        SurveyFeedbackReceiveMultipleChoice totest = new SurveyFeedbackReceiveMultipleChoice(null, Arrays.asList(1L, 2L), null, "de");
        mockMvc.perform(post("/api/surveyfeedback/public/multiple/1")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:88.0) Gecko/20100101 Firefox/88.0")
                .header("X-Forwarded-For", "141.72.229.175")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(totest)))
                .andExpect(status().isOk());

        assertEquals(answerOptionRepository.findById(surveyFeedbackRepository.findById(1L).getAnswerOption().getId()).get().getValue(), "value 1");
        assertEquals(participantRepository.findById(1L).getLocationCity(), "Stuttgart");


    }
}