package javawizards.surveywzrd.exceptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ForbiddenExceptionTest {

    private ForbiddenException forbiddenexception;
    @BeforeEach
    void setUp() throws Exception{
        forbiddenexception = new ForbiddenException();
    }
    @AfterEach
    void tearDown() {
    }
}