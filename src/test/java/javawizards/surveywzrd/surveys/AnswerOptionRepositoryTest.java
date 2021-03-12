package javawizards.surveywzrd.surveys;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerOptionRepositoryTest {

    private AnswerOptionController answeroptioncontroller;
    @BeforeEach
    void setUp() throws Exception{
        answeroptioncontroller = new AnswerOptionController();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findBySurvey_id() {
    }

    @Test
    void findByIdAndSurveyId() {
    }
}