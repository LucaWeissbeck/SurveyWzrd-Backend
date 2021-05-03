package javawizards.surveywzrd.surveys;

import com.fasterxml.jackson.databind.ObjectMapper;
import javawizards.surveywzrd.users.Administrator;
import javawizards.surveywzrd.users.AdministratorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DataJpaTest
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
        administratorRepository.save(new Administrator("test@test.de", "test", true));
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