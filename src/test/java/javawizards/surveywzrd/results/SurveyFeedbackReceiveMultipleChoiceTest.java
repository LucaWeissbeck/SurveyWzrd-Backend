package javawizards.surveywzrd.results;

import javawizards.surveywzrd.users.Participant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SurveyFeedbackReceiveMultipleChoiceTest {

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void getAnswerOptionIDs() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyFeedbackReceiveMultipleChoice pojo = new SurveyFeedbackReceiveMultipleChoice();
        final Field field = pojo.getClass().getDeclaredField("answerOptionIDs");
        field.setAccessible(true);
        field.set(pojo, 123l);

        //when
        final List<Long> result = pojo.getAnswerOptionIDs();

        //then
        assertEquals(123l, result, "magic_values");
    }

    @Test
    void setAnswerOptionIDs() throws NoSuchFieldException, IllegalAccessException {
        final SurveyFeedbackReceiveMultipleChoice pojo = new SurveyFeedbackReceiveMultipleChoice();

        //when
        pojo.setAnswerOptionIDs(123l);

        //then
        final Field field = pojo.getClass().getDeclaredField("answerOptionIDs");
        field.setAccessible(true);
        assertEquals(123l, field.get(pojo), "foo");
    }
}