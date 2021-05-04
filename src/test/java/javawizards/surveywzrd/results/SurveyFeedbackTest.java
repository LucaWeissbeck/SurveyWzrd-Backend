package javawizards.surveywzrd.results;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
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
    void getTimestamp() throws NoSuchFieldException, IllegalAccessException, ParseException {
        //given
        final SurveyFeedback pojo = new SurveyFeedback();
        final Field field = pojo.getClass().getDeclaredField("timestamp");
        field.setAccessible(true);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        field.set(pojo, sdf.parse("2021-04-15 09:54:31"));

        //when
        final Date result = pojo.getTimestamp();

        //then
        assertEquals(sdf.parse("2021-04-15 09:54:31"), result, "magic_values");
    }

    @Test
    void setTimestamp() throws NoSuchFieldException, IllegalAccessException, ParseException {
        final SurveyFeedback pojo = new SurveyFeedback();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        //when
        pojo.setTimestamp(sdf.parse("2021-04-15 09:54:31"));

        //then
        final Field field = pojo.getClass().getDeclaredField("timestamp");
        field.setAccessible(true);
        assertEquals(sdf.parse("2021-04-15 09:54:31"), field.get(pojo), "foo");
    }

    /*@Test
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
    }*/
}