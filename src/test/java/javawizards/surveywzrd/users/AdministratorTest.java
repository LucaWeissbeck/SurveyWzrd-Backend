package javawizards.surveywzrd.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
class AdministratorTest {

    private Administrator administrator;

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
        final Administrator pojo = new Administrator();
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
        final Administrator pojo = new Administrator();

        //when
        pojo.setId(123l);

        //then
        final Field field = pojo.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals(123l, field.get(pojo), "foo");
    }

    /* @Test
     void getFirstName() throws NoSuchFieldException, IllegalAccessException {
         //given
         final Administrator pojo = new Administrator();
         final Field field = pojo.getClass().getDeclaredField("firstName");
         field.setAccessible(true);
         field.set(pojo, "test");

         //when
         final String result = pojo.getFirstName();

         //then
         assertEquals("test", result, "magic_values");
     }

     @Test
     void setFirstName() throws NoSuchFieldException, IllegalAccessException {
         final Administrator pojo = new Administrator();

         //when
         pojo.setFirstName("test");

         //then
         final Field field = pojo.getClass().getDeclaredField("firstName");
         field.setAccessible(true);
         assertEquals("test", field.get(pojo), "foo");
     }

     @Test
     void getLastName() throws NoSuchFieldException, IllegalAccessException {
         //given
         final Administrator pojo = new Administrator();
         final Field field = pojo.getClass().getDeclaredField("lastName");
         field.setAccessible(true);
         field.set(pojo, "test");

         //when
         final String result = pojo.getLastName();

         //then
         assertEquals("test", result, "magic_values");
     }

     @Test
     void setLastName() throws NoSuchFieldException, IllegalAccessException {
         final Administrator pojo = new Administrator();

         //when
         pojo.setLastName("test");

         //then
         final Field field = pojo.getClass().getDeclaredField("lastName");
         field.setAccessible(true);
         assertEquals("test", field.get(pojo), "foo");
     }
 */
    @Test
    void getEmail() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Administrator pojo = new Administrator();
        final Field field = pojo.getClass().getDeclaredField("email");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getEmail();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setEmail() throws NoSuchFieldException, IllegalAccessException {
        final Administrator pojo = new Administrator();

        //when
        pojo.setEmail("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("email");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }

    @Test
    void getPassword() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Administrator pojo = new Administrator();
        final Field field = pojo.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(pojo, "test");

        //when
        final String result = pojo.getPassword();

        //then
        assertEquals("test", result, "magic_values");
    }

    @Test
    void setPassword() throws NoSuchFieldException, IllegalAccessException {
        final Administrator pojo = new Administrator();

        //when
        pojo.setPassword("test");

        //then
        final Field field = pojo.getClass().getDeclaredField("password");
        field.setAccessible(true);
        assertEquals("test", field.get(pojo), "foo");
    }
}