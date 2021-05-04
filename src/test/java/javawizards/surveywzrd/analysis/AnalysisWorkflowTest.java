package javawizards.surveywzrd.analysis;

import com.fasterxml.jackson.databind.ObjectMapper;
import javawizards.surveywzrd.surveys.AnswerOptionRepository;
import javawizards.surveywzrd.surveys.Survey;
import javawizards.surveywzrd.surveys.SurveyRepository;
import javawizards.surveywzrd.users.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AnalysisWorkflowTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

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


    @BeforeEach
    void setUp() {
        Administrator toinsert = new Administrator("test@test.de", "test", true);
        toinsert.setId(1L);
        administratorRepository.save(toinsert);
        authTokenRepository.save(new AuthToken("testkey", administratorRepository.findById(1L)));
    }


    @Test
    void createSurveyWorksCompleteley() throws Exception {
        Survey surveyToInsert = new Survey("name", "description", new Date(), "question", true, "companyName");

        mockMvc.perform(post("/api/survey/", 42L)
                .contentType("application/json")
                .header("x-api-key",authTokenRepository.findByAdminId(1L).get().getAuthKey())
                //.param("sendWelcomeMail", "true")
                .content(objectMapper.writeValueAsString(surveyToInsert)))
                .andExpect(status().isOk());

        Survey surveyToCheck = surveyRepository.findById(1L);
        assertEquals(surveyToInsert.getDescription(), surveyToCheck.getDescription());

    }

    @Test
    void testSurveyAnswerOptions() throws Exception {

    }

}