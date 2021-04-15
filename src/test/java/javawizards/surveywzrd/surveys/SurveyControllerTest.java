package javawizards.surveywzrd.surveys;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class SurveyControllerTest {

    private SurveyController surveycontroller;



    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void getAllSurveys() {
    }

    @Test
    void getSurvey() {
    }

    @Test
    void addSurvey() {
    }

    @Test
    void updateSurvey() {
    }

    @Test
    void deleteSurvey() {
    }

    @Test
    void deleteAll() {
    }
}