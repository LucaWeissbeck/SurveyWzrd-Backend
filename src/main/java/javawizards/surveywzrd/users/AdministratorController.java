package javawizards.surveywzrd.users;

import javawizards.surveywzrd.exceptions.ForbiddenException;
import javawizards.surveywzrd.exceptions.GeneralException;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Administrator>> getAllAdmins(@RequestHeader Map<String, String> headers) {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            return new ResponseEntity<>((List<Administrator>) administratorRepository.findAll(), HttpStatus.OK);
        }
        throw new ForbiddenException("You are not an owner. No access right.");

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Administrator getAdmin(@PathVariable Long id, @RequestHeader Map<String, String> headers) {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            return administratorRepository.findById(id)
                    .orElseThrow(() -> new NullPointerException(id.toString()));
        }
        throw new ForbiddenException("You are not an owner. No access right.");

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Administrator addAdmin(@RequestBody Administrator administrator1, @RequestHeader Map<String, String> headers) {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            administrator1.setPassword(passwordEncoder.encode(administrator1.getPassword()));
            return administratorRepository.save(administrator1);
        }
        throw new ForbiddenException("You are not an owner. No access right.");

    }

    @RequestMapping(value = "/public/register", method = RequestMethod.POST)
    public Administrator registerAdmin(@RequestBody Administrator administrator) {
        administrator.setPassword(passwordEncoder.encode(administrator.getPassword()));
        String email = administrator.getEmail();
        if (EmailValidator.getInstance().isValid(email) != true){
            throw new ForbiddenException("Please fill in a valid email address");
        }

        try {
            return administratorRepository.save(administrator);

        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new GeneralException("This email already exists. Please use another one or log in.");
        }
    }

    @RequestMapping(value = "/public/login", method = RequestMethod.POST)
    public LoginResult loginAdmin(@RequestBody Administrator administrator) {
        if (administrator.getEmail() == "" || administrator.getPassword() == "") {
            throw new ForbiddenException("Please fill in username and password");
        }

        if (administratorRepository.findByEmail(administrator.getEmail()) == null) {
            throw new ForbiddenException("Email not found.");
        }

        if (!(passwordEncoder.matches(administrator.getPassword(),
                administratorRepository.findByEmail(administrator.getEmail()).getPassword()))) {
            throw new ForbiddenException("Invalid login. Please check your email and password.");
        }
        String authKey = passwordEncoder.encode(administrator.getEmail()) + java.time.Clock.systemUTC().instant();

        return new LoginResult(authTokenRepository.save(new AuthToken(authKey, administratorRepository.findByEmail(administrator.getEmail()))), administratorRepository.findByEmail(administrator.getEmail()).isOwner());

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Administrator updateAdmin(@RequestBody Administrator administratorRB, @PathVariable Long id,
                                     @RequestHeader Map<String, String> headers) {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            return administratorRepository.findById(id)
                    .map(administrator1 -> {
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
        throw new ForbiddenException("You are not an owner. No access right.");

    }

    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    public void logoutAdmin(@RequestHeader Map<String, String> headers) {
        //Administrator administrator = authTokenService.authenticate(headers);
        authTokenRepository.delete(new AuthToken(headers.get("x-api-key")));

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAdmin(@PathVariable Long id, @RequestHeader Map<String, String> headers) {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            administratorRepository.deleteById(id);
        }
        throw new ForbiddenException("You are not an owner. No access right.");
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAll(@RequestHeader Map<String, String> headers) {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            administratorRepository.deleteAll();
        }
        throw new ForbiddenException("You are not an owner. No access right.");

    }
}
