package javawizards.surveywzrd.analysis;

import com.fasterxml.jackson.databind.ObjectMapper;
import javawizards.surveywzrd.SurveywzrdTestUtils;
import javawizards.surveywzrd.surveys.AnswerOptionRepository;
import javawizards.surveywzrd.surveys.SurveyRepository;
import javawizards.surveywzrd.users.AdministratorRepository;
import javawizards.surveywzrd.users.AuthTokenRepository;
import javawizards.surveywzrd.users.ParticipantRepository;
import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AnalysisWorkflowTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SurveywzrdTestUtils surveywzrdTestUtils;


    @BeforeEach
    void setUp() {
        surveywzrdTestUtils.createAdministratorAndAuthToken(1L, "String email");
        surveywzrdTestUtils.createSurveyAnd3AnswerOptions(1L, 1L);
        surveywzrdTestUtils.vote();
    }


    @Test
    void getResultsForAdmin() throws Exception {

        mockMvc.perform(get("/api/analysis/public/rawdata/{surveyID}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(6)));
    }

    @Test
    void getResultsForParticipant() throws Exception {
        mockMvc.perform(get("/api/analysis/public/minimizedrawdata/{surveyID}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getResultsForSurvey() throws Exception {
        mockMvc.perform(get("/api/analysis/public/{surveyID}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}