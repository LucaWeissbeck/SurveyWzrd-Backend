package javawizards.surveywzrd.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthTokenService {
    @Autowired
    private AuthTokenRepository authTokenRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    public Administrator authenticate(Map<String, String> headers) {
        return administratorRepository.findById
                (authTokenRepository.findByauthKey(headers.get("x-api-key")).get().getAdmin().getId()).get();
    }
}
