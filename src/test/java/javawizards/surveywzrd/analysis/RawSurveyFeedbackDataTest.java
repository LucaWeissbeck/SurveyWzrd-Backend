package javawizards.surveywzrd.analysis;

import javawizards.surveywzrd.users.Participant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class RawSurveyFeedbackDataTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getValueName() throws NoSuchFieldException, IllegalAccessException {
        //given
        final RawSurveyFeedbackData pojo = new RawSurveyFeedbackData();
        final Field field = pojo.getClass().getDeclaredField("valueName");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getValueName();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setValueName() throws NoSuchFieldException, IllegalAccessException {
        final RawSurveyFeedbackData pojo = new RawSurveyFeedbackData();

        //when
        pojo.setValueName("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("valueName");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }

    @Test
    void getId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final RawSurveyFeedbackData pojo = new RawSurveyFeedbackData();
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(pojo, 123l);

        //when
        final Long result = pojo.getId();

        //then
        assertEquals(123l, result, "magic_values");
    }

    @Test
    void setId() throws NoSuchFieldException, IllegalAccessException {
        final RawSurveyFeedbackData pojo = new RawSurveyFeedbackData();

        //when
        pojo.setId(123l);

        //then
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals(123l, field.get(pojo), "foo");
    }

    @Test
    void getTimestamp() throws NoSuchFieldException, IllegalAccessException {
        //given
        final RawSurveyFeedbackData pojo = new RawSurveyFeedbackData();
        final Field field = pojo.getClass().getDeclaredField("timestamp");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getTimestamp();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setTimestamp() throws NoSuchFieldException, IllegalAccessException {
        final RawSurveyFeedbackData pojo = new RawSurveyFeedbackData();

        //when
        pojo.setTimestamp("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("timestamp");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }

    @Test
    void getAnswerOptionID() throws NoSuchFieldException, IllegalAccessException {
        //given
        final RawSurveyFeedbackData pojo = new RawSurveyFeedbackData();
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
        final RawSurveyFeedbackData pojo = new RawSurveyFeedbackData();

        //when
        pojo.setTimestamp(123l);

        //then
        final Field field = pojo.getClass().getDeclaredField("answerOptionID");
        field.setAccessible(true);
        assertEquals(123l, field.get(pojo), "foo");
    }
}