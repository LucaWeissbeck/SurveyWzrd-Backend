package javawizards.surveywzrd.analysis;

import javawizards.surveywzrd.surveys.AnswerOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class SurveyResultPerOptionTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAnswerOption() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyResultPerOption pojo = new SurveyResultPerOption();
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
        final SurveyResultPerOption pojo = new SurveyResultPerOption();

        //when
        pojo.setAnswerOption("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("answerOption");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }

    @Test
    void getCount() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyResultPerOption pojo = new SurveyResultPerOption();
        final Field field = pojo.getClass().getDeclaredField("count");
        field.setAccessible(true);
        field.set(pojo, 123);

        //when
        final Integer result = pojo.getCount();

        //then
        assertEquals(123, result, "magic_values");
    }

    @Test
    void setCount() throws NoSuchFieldException, IllegalAccessException {
        final SurveyResultPerOption pojo = new SurveyResultPerOption();

        //when
        pojo.setCount(123);

        //then
        final Field field = pojo.getClass().getDeclaredField("count");
        field.setAccessible(true);
        assertEquals(123, field.get(pojo), "foo");
    }
}