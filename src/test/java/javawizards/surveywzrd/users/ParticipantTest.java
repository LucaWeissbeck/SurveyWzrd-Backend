package javawizards.surveywzrd.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
class ParticipantTest {

    private Participant participant;

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
        final Participant pojo = new Participant();
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
        final Participant pojo = new Participant();

        //when
        pojo.setId(123l);

        //then
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals(123l, field.get(pojo), "foo");
    }

    @Test
    void getCookie_id() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Participant pojo = new Participant();
        final Field field = pojo.getClass().getDeclaredField("cookieId");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getCookieId();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setCookie_id() throws NoSuchFieldException, IllegalAccessException {
        final Participant pojo = new Participant();

        //when
        pojo.setCookieId("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("cookieId");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }

    @Test
    void getOs() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Participant pojo = new Participant();
        final Field field = pojo.getClass().getDeclaredField("platform");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getPlatform();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setOs() throws NoSuchFieldException, IllegalAccessException {
        final Participant pojo = new Participant();

        //when
        pojo.setPlatform("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("platform");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }

    @Test
    void getBrowser_language() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Participant pojo = new Participant();
        final Field field = pojo.getClass().getDeclaredField("browserLanguage");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getBrowserLanguage();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setBrowser_language() throws NoSuchFieldException, IllegalAccessException {
        final Participant pojo = new Participant();

        //when
        pojo.setBrowserLanguage("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("browserLanguage");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }

    @Test
    void getLocation() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Participant pojo = new Participant();
        final Field field = pojo.getClass().getDeclaredField("locationCountry");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getLocationCountry();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setLocation() throws NoSuchFieldException, IllegalAccessException {
        final Participant pojo = new Participant();

        //when
        pojo.setLocationCountry("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("locationCountry");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }
}
