package javawizards.surveywzrd.surveys;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void setSurvey() throws NoSuchFieldException, IllegalAccessException {
        final AnswerOption pojo = new AnswerOption();

        Survey tocompare = new Survey();
        //when
        pojo.setSurvey(tocompare);

        //then
        final Field field = pojo.getClass().getDeclaredField("survey");
        field.setAccessible(true);
        assertEquals(tocompare, field.get(pojo), "foo");
    }
}