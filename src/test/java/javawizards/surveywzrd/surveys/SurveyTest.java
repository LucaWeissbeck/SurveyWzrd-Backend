package javawizards.surveywzrd.surveys;

import javawizards.surveywzrd.users.Administrator;
import javawizards.surveywzrd.users.Participant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class SurveyTest {

    private SurveyTest surveytest;

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void getAdministrator() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Survey pojo = new Survey();
        final Field field = pojo.getClass().getDeclaredField("administrator");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final Administrator result = pojo.getAdministrator();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setAdministrator() throws NoSuchFieldException, IllegalAccessException {
        final Survey pojo = new Survey();

        //when
        pojo.setAdministrator(new Administrator());

        //then
        final Field field = pojo.getClass().getDeclaredField("administrator");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }

    @Test
    void getId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Survey pojo = new Survey();
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
        final Survey pojo = new Survey();

        //when
        pojo.setId(123l);

        //then
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals(123l, field.get(pojo), "foo");
    }

    @Test
    void getName() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Survey pojo = new Survey();
        final Field field = pojo.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getName();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setName() throws NoSuchFieldException, IllegalAccessException {
        final Survey pojo = new Survey();

        //when
        pojo.setName("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }

    @Test
    void getDescription() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Survey pojo = new Survey();
        final Field field = pojo.getClass().getDeclaredField("description");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getDescription();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setDescription() throws NoSuchFieldException, IllegalAccessException {
        final Survey pojo = new Survey();

        //when
        pojo.setDescription("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("description");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }

    @Test
    void getExpiryDate() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Survey pojo = new Survey();
        final Field field = pojo.getClass().getDeclaredField("expiryDate");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getExpiryDate();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setExpiryDate() throws NoSuchFieldException, IllegalAccessException {
        final Survey pojo = new Survey();

        //when
        pojo.setExpiryDate("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("expiryDate");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }

    @Test
    void getQuestion() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Survey pojo = new Survey();
        final Field field = pojo.getClass().getDeclaredField("question");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getQuestion();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setQuestion() throws NoSuchFieldException, IllegalAccessException {
        final Survey pojo = new Survey();

        //when
        pojo.setQuestion("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("question");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }

    @Test
    void isMultiSelect() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Survey pojo = new Survey();
        final Field field = pojo.getClass().getDeclaredField("multiSelect");
        field.setAccessible(true);
        field.set(pojo, true);

        //when
        final Boolean result = pojo.isMultiSelect();

        //then
        assertEquals(true, result, "magic_values");
    }

    @Test
    void setMultiSelect() throws NoSuchFieldException, IllegalAccessException {
        final Survey pojo = new Survey();

        //when
        pojo.setMultiSelect(true);

        //then
        final Field field = pojo.getClass().getDeclaredField("multiSelect");
        field.setAccessible(true);
        assertEquals(true, field.get(pojo), "foo");
    }
}