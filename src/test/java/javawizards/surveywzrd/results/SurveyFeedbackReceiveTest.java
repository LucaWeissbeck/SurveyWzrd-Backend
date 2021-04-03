package javawizards.surveywzrd.results;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class SurveyFeedbackReceiveTest {

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void getBrowserLanguage() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyFeedbackReceive pojo = new SurveyFeedbackReceive();
        final Field field = pojo.getClass().getDeclaredField("browserLanguage");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getBrowserLanguage();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setBrowserLanguage() throws NoSuchFieldException, IllegalAccessException {
        final SurveyFeedbackReceive pojo = new SurveyFeedbackReceive();

        //when
        pojo.setBrowserLanguage("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("browserLanguage");
        field.setAccessible(true);
        assertEquals(123l, field.get(pojo), "foo");
    }

    @Test
    void getTimestamp() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyFeedbackReceive pojo = new SurveyFeedbackReceive();
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
        final SurveyFeedbackReceive pojo = new SurveyFeedbackReceive();

        //when
        pojo.setTimestamp("15-02-1999");

        //then
        final Field field = pojo.getClass().getDeclaredField("timestamp");
        field.setAccessible(true);
        assertEquals("15-02-1999", field.get(pojo), "foo");
    }

    @Test
    void getIdentifierID() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyFeedbackReceive pojo = new SurveyFeedbackReceive();
        final Field field = pojo.getClass().getDeclaredField("identifierID");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getIdentifierID();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setIdentifierID() throws NoSuchFieldException, IllegalAccessException {
        final SurveyFeedbackReceive pojo = new SurveyFeedbackReceive();

        //when
        pojo.setIdentifierID("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("identifierID");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }
}