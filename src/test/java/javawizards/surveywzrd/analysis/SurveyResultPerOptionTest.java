package javawizards.surveywzrd.analysis;

import javawizards.surveywzrd.surveys.AnswerOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
class SurveyResultPerOptionTest {

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void getAnswerOption() throws NoSuchFieldException, IllegalAccessException {
        //given
        final SurveyResultPerOption pojo = new SurveyResultPerOption();
        final Field field = pojo.getClass().getDeclaredField("answerOption");
        field.setAccessible(true);
        AnswerOption tocompare = new AnswerOption();
        field.set(pojo, tocompare);

        //when
        final AnswerOption result = pojo.getAnswerOption();

        //then
        assertEquals(tocompare, result, "magic_values");
    }

    @Test
    void setAnswerOption() throws NoSuchFieldException, IllegalAccessException {
        final SurveyResultPerOption pojo = new SurveyResultPerOption();

        //when
        AnswerOption tocompare = new AnswerOption();

        pojo.setAnswerOption(tocompare);

        //then
        final Field field = pojo.getClass().getDeclaredField("answerOption");
        field.setAccessible(true);
        assertEquals(tocompare, field.get(pojo), "foo");
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