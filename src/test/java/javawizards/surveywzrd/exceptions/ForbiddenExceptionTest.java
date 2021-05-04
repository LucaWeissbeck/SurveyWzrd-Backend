package javawizards.surveywzrd.exceptions;


import com.fasterxml.jackson.databind.ObjectMapper;
import javawizards.surveywzrd.SurveywzrdTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ForbiddenExceptionTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    SurveywzrdTestUtils surveywzrdTestUtils;


    @Test
    void testForbiddenException() throws Exception {
        mockMvc.perform(get("/api/survey/getAll"))
                .andExpect(status().isForbidden());
        surveywzrdTestUtils.createAdministratorAndAuthToken(1L,"test@test.de");
        surveywzrdTestUtils.createAdministratorAndAuthToken(2L, "test@test1.de");
        surveywzrdTestUtils.createSurveyAnd3AnswerOptions(1L,1L);
        surveywzrdTestUtils.createSurveyAnd3AnswerOptions(2L,2L);

        mockMvc.perform(delete("/api/survey/2")
                .contentType("application/json")
                .header("x-api-key",surveywzrdTestUtils.getAuthTokenForAdmin(1L).getAuthKey()))
                .andExpect(status().isForbidden()).andExpect(MockMvcResultMatchers.jsonPath("$.error").value("The requesting admin has no permissions for this entity."));


    }



}