package javawizards.surveywzrd.surveys;

import com.fasterxml.jackson.databind.ObjectMapper;
import javawizards.surveywzrd.SurveywzrdTestUtils;
import javawizards.surveywzrd.users.Administrator;
import javawizards.surveywzrd.users.AdministratorRepository;
import javawizards.surveywzrd.users.AuthToken;
import javawizards.surveywzrd.users.AuthTokenRepository;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SurveyWorkflowTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private AnswerOptionRepository answerOptionRepository;

    @Autowired
    private AuthTokenRepository authTokenRepository;

    @Autowired
    private SurveywzrdTestUtils surveywzrdTestUtils;

    @BeforeEach
    void setUp() {
        surveywzrdTestUtils.createAdministratorAndAuthToken();

    }


    @Test
    void createSurveyWorksCompletely() throws Exception {
        Survey surveyToInsert = new Survey("name", "description", new Date(), "question", true, "companyName");

        mockMvc.perform(post("/api/survey/")
                .contentType("application/json")
                .header("x-api-key",authTokenRepository.findByAdminId(1L).get().getAuthKey())
                .content(objectMapper.writeValueAsString(surveyToInsert)))
                .andExpect(status().isOk());

        Survey surveyToCheck = surveyRepository.findById(1L);
        assertEquals(surveyToInsert.getDescription(), surveyToCheck.getDescription());

    }

    @Test
    void testSurveyAnswerOptions() throws Exception {
        Survey surveyToInsert = new Survey("name", "description", new Date(), "question", true, "companyName");
        surveyToInsert.setAdministrator(administratorRepository.findById(1L));
        surveyRepository.save(surveyToInsert);

        AnswerOption answerOptionToInsert1 = new AnswerOption("Schokolade");

        mockMvc.perform(post("/api/survey/answeroptions/1")
                .contentType("application/json")
                .header("x-api-key",authTokenRepository.findByAdminId(1L).get().getAuthKey())
                .content(objectMapper.writeValueAsString(answerOptionToInsert1)))
                .andExpect(status().isOk());

        AnswerOption answerOptionToInsert2 = new AnswerOption("Vanille");
        mockMvc.perform(post("/api/survey/answeroptions/1")
                .contentType("application/json")
                .header("x-api-key",authTokenRepository.findByAdminId(1L).get().getAuthKey())
                .content(objectMapper.writeValueAsString(answerOptionToInsert2)))
                .andExpect(status().isOk());

        AnswerOption answerOptionToInsert3 = new AnswerOption("Stracciatella");
        mockMvc.perform(post("/api/survey/answeroptions/1")
                .contentType("application/json")
                .header("x-api-key",authTokenRepository.findByAdminId(1L).get().getAuthKey())
                .content(objectMapper.writeValueAsString(answerOptionToInsert3)))
                .andExpect(status().isOk());

        assertEquals(answerOptionRepository.findById(1L).get().getValue(), answerOptionToInsert1.getValue());
        assertEquals(answerOptionRepository.findById(2L).get().getValue(), answerOptionToInsert2.getValue());
        assertEquals(answerOptionRepository.findById(3L).get().getValue(), answerOptionToInsert3.getValue());

    }

}