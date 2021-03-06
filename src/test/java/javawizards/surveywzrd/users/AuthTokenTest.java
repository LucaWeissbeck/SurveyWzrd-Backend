package javawizards.surveywzrd.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
class AuthTokenTest {

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void getAuthKey() throws NoSuchFieldException, IllegalAccessException {
        //given
        final AuthToken pojo = new AuthToken();
        final Field field = pojo.getClass().getDeclaredField("authKey");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getAuthKey();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setAuthKey() throws NoSuchFieldException, IllegalAccessException {
        final AuthToken pojo = new AuthToken();

        //when
        pojo.setAuthKey("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("authKey");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }


}