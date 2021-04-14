package javawizards.surveywzrd.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/administrator")
public class AdministratorController {
    private final PasswordEncoder passwordEncoder;
    private final AdministratorRepository administratorRepository;
    private final AuthTokenRepository authTokenRepository;
    private final AuthTokenService authTokenService;

    @Autowired
    public AdministratorController(AdministratorRepository administratorRepository, PasswordEncoder passwordEncoder,
                                   AuthTokenRepository authTokenRepository, AuthTokenService authTokenService) {
        this.administratorRepository = administratorRepository;
        this.passwordEncoder = passwordEncoder;
        this.authTokenRepository = authTokenRepository;
        this.authTokenService = authTokenService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Administrator>> getAllAdmins(@RequestHeader Map<String, String> headers) throws ServletException {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            return new ResponseEntity<>((List<Administrator>) administratorRepository.findAll(), HttpStatus.OK);
        }
        throw new ServletException("You are not an owner. No access right.");

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Administrator getAdmin(@PathVariable Long id, @RequestHeader Map<String, String> headers)
            throws ServletException {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            return administratorRepository.findById(id)
                    .orElseThrow(() -> new NullPointerException(id.toString()));
        }
        throw new ServletException("You are not an owner. No access right.");

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Administrator addAdmin(@RequestBody Administrator administrator1, @RequestHeader Map<String, String> headers)
            throws ServletException {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            administrator1.setPassword(passwordEncoder.encode(administrator1.getPassword()));
            return administratorRepository.save(administrator1);
        }
        throw new ServletException("You are not an owner. No access right.");

    }

    @RequestMapping(value = "/public/register", method = RequestMethod.POST)
    public Administrator registerAdmin(@RequestBody Administrator administrator) {
        administrator.setPassword(passwordEncoder.encode(administrator.getPassword()));
        return administratorRepository.save(administrator);

    }

    @RequestMapping(value = "/public/registerandlogin", method = RequestMethod.POST)
    public AuthToken registerAndLogAdmin(@RequestBody Administrator administrator) {
        administrator.setPassword(passwordEncoder.encode(administrator.getPassword()));
        administratorRepository.save(administrator);
        String authKey = passwordEncoder.encode(administrator.getEmail()) + java.time.Clock.systemUTC().instant();
        return authTokenRepository.save(new AuthToken(authKey, administrator));

    }

    @RequestMapping(value = "/public/login", method = RequestMethod.POST)
    public AuthToken loginAdmin(@RequestBody Administrator administrator) throws ServletException {
        if (administrator.getEmail() == null || administrator.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        if (administratorRepository.findByEmail(administrator.getEmail()) == null) {
            throw new ServletException("Email not found.");
        }

        if (!(passwordEncoder.matches(administrator.getPassword(),
                administratorRepository.findByEmail(administrator.getEmail()).getPassword()))) {
            throw new ServletException("Invalid login. Please check your email and password.");
        }
        String authKey = passwordEncoder.encode(administrator.getEmail()) + java.time.Clock.systemUTC().instant();
        return authTokenRepository.save(new AuthToken(authKey, administratorRepository.findByEmail(administrator.getEmail())));

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Administrator updateAdmin(@RequestBody Administrator administratorRB, @PathVariable Long id,
                                     @RequestHeader Map<String, String> headers) throws ServletException {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            return administratorRepository.findById(id)
                    .map(administrator1 -> {
                        administrator1.setFirstName(administratorRB.getFirstName());
                        administrator1.setLastName(administratorRB.getLastName());
                        administrator1.setEmail(administratorRB.getEmail());
                        administrator1.setPassword(passwordEncoder.encode(administratorRB.getPassword()));
                        administrator1.setOwner(administratorRB.isOwner());
                        return administratorRepository.save(administrator1);
                    })
                    .orElseGet(() -> {
                        administratorRB.setId(id);
                        return administratorRepository.save(administratorRB);
                    });
        }
        throw new ServletException("You are not an owner. No access right.");

    }

    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    public void logoutAdmin(@RequestHeader Map<String, String> headers) {
        //Administrator administrator = authTokenService.authenticate(headers);
        authTokenRepository.delete(new AuthToken(headers.get("x-api-key")));

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAdmin(@PathVariable Long id, @RequestHeader Map<String, String> headers) throws ServletException {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            administratorRepository.deleteById(id);
        }
        throw new ServletException("You are not an owner. No access right.");
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAll(@RequestHeader Map<String, String> headers) throws ServletException {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            administratorRepository.deleteAll();
        }
        throw new ServletException("You are not an owner. No access right.");

    }
}
