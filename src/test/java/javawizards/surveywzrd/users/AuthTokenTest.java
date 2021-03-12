package javawizards.surveywzrd.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class AuthTokenTest {

    private AuthToken authtoken;

    @BeforeEach
    void setUp() throws Exception{
        authtoken = new AuthToken();
    }

    @AfterEach
    void tearDown() {
    }
}