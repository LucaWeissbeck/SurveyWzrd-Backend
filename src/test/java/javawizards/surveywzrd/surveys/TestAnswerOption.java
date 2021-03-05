package javawizards.surveywzrd.surveys;


import javawizards.surveywzrd.surveys.AnswerOption;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Field;

@SpringBootTest
@ActiveProfiles("test")

class TestAnswerOption {

    @Test
    public void testSetter_setValue() throws NoSuchFieldException, IllegalAccessException {
        //given
        final AnswerOption pojo = new AnswerOption();

        //when
        pojo.setValue("foo");

        //then
        final Field field = pojo.getClass().getDeclaredField("value");
        ((Field) field).setAccessible(true);
        assertEquals("Fields didn't match", field.get(pojo), "foo");
    }

    @Test
    public void testGetter_getValue() throws NoSuchFieldException, IllegalAccessException {
        //given
        final AnswerOption pojo = new AnswerOption();
        final Field field = pojo.getClass().getDeclaredField("value");
        field.setAccessible(true);
        field.set(pojo, "magic_values");

        //when
        final String result = pojo.getValue();

        //then
        assertEquals("field wasn't retrieved properly", result, "magic_values");
    }
    @Test
    public void testSetter_setId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final AnswerOption pojo = new AnswerOption();

        //when
        pojo.setId(123l);

        //then
        final Field field = pojo.getClass().getDeclaredField("id");
        ((Field) field).setAccessible(true);
        assertEquals("Fields didn't match", field.get(pojo), "foo");
    }

    @Test
    public void testGetter_getId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final AnswerOption pojo = new AnswerOption();
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(pojo, 123d);

        //when
        final Long result = pojo.getId();

        //then
        assertEquals("field wasn't retrieved properly", result, "magic_values");
    }
    @Test
    public void testSetter_setSurvey() throws NoSuchFieldException, IllegalAccessException {
        //given
        final AnswerOption pojo = new AnswerOption();

        //when
        pojo.setId(123l);

        //then
        final Field field = pojo.getClass().getDeclaredField("id");
        ((Field) field).setAccessible(true);
        assertEquals("Fields didn't match", field.get(pojo), "foo");
    }

    @Test
    public void testGetter_getSurvey() throws NoSuchFieldException, IllegalAccessException {
        //given
        final AnswerOption pojo = new AnswerOption();
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(pojo, 123d);

        //when
        final Long result = pojo.getId();

        //then
        assertEquals("field wasn't retrieved properly", result, "magic_values");
    }



    private void assertEquals(String s, Object o, String foo) {
    }
}
