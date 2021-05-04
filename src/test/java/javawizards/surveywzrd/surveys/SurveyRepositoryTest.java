package javawizards.surveywzrd.surveys;

import com.fasterxml.jackson.databind.ObjectMapper;
import javawizards.surveywzrd.users.Administrator;
import javawizards.surveywzrd.users.AdministratorRepository;
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


@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class SurveyRepositoryTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @BeforeEach
    void setUp() {
        Administrator toinsert = new Administrator("test@test.de", "test", true);
        toinsert.setId(1L);
        administratorRepository.save(toinsert);
        Survey surveyToInsert = new Survey("name", "description", new Date(), "question", true, "companyName");
        surveyToInsert.setAdministrator(administratorRepository.findById(1L));
        surveyRepository.save(surveyToInsert);
    }

    @Test
    void findAllByAdministrator_Id() {
        assertEquals(surveyRepository.findAllByAdministrator_Id(1L).get(0).getName(), "name");
    }

    @Test
    void findById() {
        assertEquals(surveyRepository.findById(1).getName(), "name");

    }
}