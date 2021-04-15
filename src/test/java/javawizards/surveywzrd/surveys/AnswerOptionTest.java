package javawizards.surveywzrd.surveys;

import javawizards.surveywzrd.users.Participant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class AnswerOptionTest {

    private AnswerOption answeroption;

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
        final AnswerOption pojo = new AnswerOption();
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
        final AnswerOption pojo = new AnswerOption();

        //when
        pojo.setId(123l);

        //then
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals(123l, field.get(pojo), "foo");
    }

    @Test
    void getValue() throws NoSuchFieldException, IllegalAccessException {
        //given
        final AnswerOption pojo = new AnswerOption();
        final Field field = pojo.getClass().getDeclaredField("value");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getValue();

        //then
        assertEquals("test", result, "magic_values");
    }
 /*
    @Test
    void setValue() throws NoSuchFieldException, IllegalAccessException {
        final AnswerOption pojo = new AnswerOption();

        //when
        pojo.setId(123l);

        //then
        final Field field = pojo.getClass().getDeclaredField("value");
        field.setAccessible(true);
        assertEquals(123l, field.get(pojo), "foo");
    }

   @Test
    void getSurvey() throws NoSuchFieldException, IllegalAccessException {
        //given
        final AnswerOption pojo = new AnswerOption();
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
        final AnswerOption pojo = new AnswerOption();

        //when
        pojo.setSurvey(new Survey());

        //then
        final Field field = pojo.getClass().getDeclaredField("survey");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }*/
}