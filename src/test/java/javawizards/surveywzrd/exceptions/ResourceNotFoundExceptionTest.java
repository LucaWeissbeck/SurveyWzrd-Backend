package javawizards.surveywzrd.exceptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ResourceNotFoundExceptionTest {

    private ResourceNotFoundException resourcenotfoundexception;

    @BeforeEach
    void setUp() throws Exception {
        resourcenotfoundexception = new ResourceNotFoundException();
    }

    @AfterEach
    void tearDown() {
    }
}