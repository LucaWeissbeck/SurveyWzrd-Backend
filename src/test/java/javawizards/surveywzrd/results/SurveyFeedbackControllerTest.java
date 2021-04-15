package javawizards.surveywzrd.results;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class SurveyFeedbackControllerTest {

    private SurveyFeedbackController surveyfeedbackcontroller;


    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void getAllSurveyFeedbacks() {
    }

    @Test
    void getSurveyFeedback() {
    }

    @Test
    void addSurveyFeedback() {
    }

    @Test
    void updateSurveyFeedback() {
    }

    @Test
    void deleteSurveyFeedback() {
    }

    @Test
    void deleteAll() {
    }
}