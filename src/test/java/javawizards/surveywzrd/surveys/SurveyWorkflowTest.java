package javawizards.surveywzrd.surveys;

import com.fasterxml.jackson.databind.ObjectMapper;
import javawizards.surveywzrd.users.Administrator;
import javawizards.surveywzrd.users.AdministratorRepository;
import javawizards.surveywzrd.users.AuthToken;
import javawizards.surveywzrd.users.AuthTokenRepository;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
    private AuthTokenRepository authTokenRepository;


    @BeforeEach
    void setUp() {
       /* administratorRepository.save(new Administrator("test@test.de", "test", true));
        authTokenRepository.save(new AuthToken("testkey", administratorRepository.findById(1L)));*/
    }


    @Test
    void createSurveyWorksCompleteley() throws Exception {
        administratorRepository.save(new Administrator("test@test.de", "test", true));
        authTokenRepository.save(new AuthToken("testkey", administratorRepository.findById(1L)));



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