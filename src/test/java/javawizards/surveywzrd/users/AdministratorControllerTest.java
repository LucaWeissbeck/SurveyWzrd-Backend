package javawizards.surveywzrd.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AdministratorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AdministratorRepository administratorRepository;


    @Autowired
    private AuthTokenRepository authTokenRepository;

    @Test
    void registrationWorksThroughAllLayers() throws Exception {
        String email = "test@test.de";
        Administrator user = new Administrator(email, "Test", true);

        mockMvc.perform(post("/api/administrator/public/register", 42L)
                .contentType("application/json")
                //.param("sendWelcomeMail", "true")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

        Administrator adminTest = administratorRepository.findByEmail(email);
        assertEquals(adminTest.getEmail(), email);

    }

    @Test
    void loginWorksThroughAllLayers() throws Exception {
        String email = "test@test.de";
        Administrator user = new Administrator(email, "Test", true);

        mockMvc.perform(post("/api/administrator/public/login", 42L)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.authToken.authKey").isNotEmpty());

    }

    @Test
    void logoutWorks() throws Exception {
        String email = "test@test.de";
        Administrator user = new Administrator(email, "Test", true);

        mockMvc.perform(delete("/api/administrator/logout")
                .contentType("application/json")
                .header("x-api-key", authTokenRepository.findByAdminId(1L).get().getAuthKey())
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
        assertEquals(authTokenRepository.findByAdminId(1L), Optional.empty());

    }

}
