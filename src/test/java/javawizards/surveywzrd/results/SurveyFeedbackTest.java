package javawizards.surveywzrd.results;

import javawizards.surveywzrd.surveys.AnswerOption;
import javawizards.surveywzrd.surveys.Survey;
import javawizards.surveywzrd.users.Participant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SurveyFeedbackTest {

    private SurveyFeedback surveyfeedback;
    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void getId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyFeedback pojo = new SurveyFeedback();
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
        final SurveyFeedback pojo = new SurveyFeedback();

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
        final SurveyFeedback pojo = new SurveyFeedback();
        final Field field = pojo.getClass().getDeclaredField("timestamp");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final Date result = pojo.getTimestamp();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setTimestamp() throws NoSuchFieldException, IllegalAccessException {
        final SurveyFeedback pojo = new SurveyFeedback();

        //when
        pojo.setTimestamp(15-02-1999);

        //then
        final Field field = pojo.getClass().getDeclaredField("timestamp");
        field.setAccessible(true);
        assertEquals(15-02-1999, field.get(pojo), "foo");
    }

    @Test
    void getSurvey() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyFeedback pojo = new SurveyFeedback();
        final Field field = pojo.getClass().getDeclaredField("survey");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final Survey result = pojo.getSurvey();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setSurvey() throws NoSuchFieldException, IllegalAccessException {
        final SurveyFeedback pojo = new SurveyFeedback();

        //when
        pojo.setSurvey(FFFFFF);

        //then
        final Field field = pojo.getClass().getDeclaredField("timestamp");
        field.setAccessible(true);
        assertEquals(FFFFFF, field.get(pojo), "foo");
    }

    @Test
    void getAnswerOption() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyFeedback pojo = new SurveyFeedback();
        final Field field = pojo.getClass().getDeclaredField("answerOption");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final AnswerOption result = pojo.getAnswerOption();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setAnswerOption() throws NoSuchFieldException, IllegalAccessException {
        final SurveyFeedback pojo = new SurveyFeedback();

        //when
        pojo.setAnswerOption(FFFFFF);

        //then
        final Field field = pojo.getClass().getDeclaredField("answerOption");
        field.setAccessible(true);
        assertEquals(FFFFFF, field.get(pojo), "foo");
    }

    @Test
    void getParticipant() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyFeedback pojo = new SurveyFeedback();
        final Field field = pojo.getClass().getDeclaredField("participant");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final Participant result = pojo.getParticipant();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setParticipant() throws NoSuchFieldException, IllegalAccessException {
        final SurveyFeedback pojo = new SurveyFeedback();

        //when
        pojo.setParticipant(FFFFFF);

        //then
        final Field field = pojo.getClass().getDeclaredField("participant");
        field.setAccessible(true);
        assertEquals(FFFFFF, field.get(pojo), "foo");
    }

    @Test
    void testToString() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyFeedback pojo = new SurveyFeedback();
        final Field field = pojo.getClass().getDeclaredField("id, timestamp, answerOption, survey, participant");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.toString();

        //then
        assertEquals("test", result, "magic_values");
    }
}