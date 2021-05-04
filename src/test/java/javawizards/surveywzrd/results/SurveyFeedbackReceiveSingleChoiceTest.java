package javawizards.surveywzrd.results;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
class SurveyFeedbackReceiveSingleChoiceTest {

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void getAnswerOptionID() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyFeedbackReceiveSingleChoice pojo = new SurveyFeedbackReceiveSingleChoice("", 1L, "1", "de");
        final Field field = pojo.getClass().getDeclaredField("answerOptionID");
        field.setAccessible(true);
        field.set(pojo, 123l);

        //when
        final Long result = pojo.getAnswerOptionID();

        //then
        assertEquals(123l, result, "magic_values");
    }

    @Test
    void setAnswerOptionID() throws NoSuchFieldException, IllegalAccessException {
        final SurveyFeedbackReceiveSingleChoice pojo = new SurveyFeedbackReceiveSingleChoice("", 1L, "1", "de");

        //when
        pojo.setAnswerOptionID(123l);

        //then
        final Field field = pojo.getClass().getDeclaredField("answerOptionID");
        field.setAccessible(true);
        assertEquals(123l, field.get(pojo), "foo");
    }
}