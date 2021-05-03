package javawizards.surveywzrd.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
class ParticipantControllerTest {

    private ParticipantController participantcontroller;


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private ParticipantRepository participantRepository;


    @Test
    void registrationWorksThroughAllLayers() throws Exception {
        Long id = 123L;
        Participant user = new Participant( 123L,  "cookieId",  "platform",  "platformVersion",
                "deviceType",  "browser",  "browserType",  "browserLanguage"
                ,  "locationCountry",  "locationCity");

        mockMvc.perform(post("/api/participant/public/register", 42L)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

        Participant participantTest = participantRepository.findById(id).get(); //static error
        assertEquals(participantTest.getId(), id);
    }

    void loginWorksThroughAllLayers() throws Exception {
        Long id = 123L;


    }
}