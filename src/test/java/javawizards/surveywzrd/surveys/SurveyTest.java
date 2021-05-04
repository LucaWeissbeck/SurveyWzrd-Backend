package javawizards.surveywzrd.surveys;

import javawizards.surveywzrd.users.Administrator;
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
        Administrator tocompare = new Administrator();
        field.set(pojo, tocompare);

        //when
        final Administrator result = pojo.getAdministrator();

        //then
        assertEquals(tocompare, result, "magic_values");
    }

    @Test
    void setAdministrator() throws NoSuchFieldException, IllegalAccessException {
        final Survey pojo = new Survey();
        Administrator tocompare = new Administrator();
        //when
        pojo.setAdministrator(tocompare);

        //then
        final Field field = pojo.getClass().getDeclaredField("administrator");
        field.setAccessible(true);
        assertEquals(tocompare, field.get(pojo), "foo");
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
    void getExpiryDate() throws NoSuchFieldException, IllegalAccessException, ParseException {
        //given
        final Survey pojo = new Survey();
        final Field field = pojo.getClass().getDeclaredField("expiryDate");
        field.setAccessible(true);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        field.set(pojo, sdf.parse("2021-04-15 09:54:31"));

        //when
        final Date result = pojo.getExpiryDate();

        //then
        assertEquals(sdf.parse("2021-04-15 09:54:31"), result, "magic_values");
    }

    @Test
    void setExpiryDate() throws NoSuchFieldException, IllegalAccessException {
        final Survey pojo = new Survey();

        Date datetest = new Date();
        //when
        pojo.setExpiryDate(datetest);

        //then
        final Field field = pojo.getClass().getDeclaredField("expiryDate");
        field.setAccessible(true);
        assertEquals(datetest, field.get(pojo), "foo");
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
