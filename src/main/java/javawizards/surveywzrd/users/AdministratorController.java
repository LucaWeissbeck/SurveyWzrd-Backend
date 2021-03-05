package javawizards.surveywzrd.users;

import javawizards.surveywzrd.surveys.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/administrator")
public class AdministratorController {
    private AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorController(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Administrator>> getAllAdmins() {
        return new ResponseEntity<>((List<Administrator>) administratorRepository.findAll(), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Administrator getAdmin(@PathVariable Long id) {
        return administratorRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(id.toString())); //SurveyNotFoundException(id));

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Administrator addAdmin(@RequestBody Administrator administrator) {
        return administratorRepository.save(administrator);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Administrator updateAdmin(@RequestBody Administrator administrator, @PathVariable Long id) {
        return administratorRepository.findById(id)
                .map(administrator1 -> {
                    administrator1.setFirstName(administrator.getFirstName());
                    administrator1.setLastName(administrator.getLastName());
                    administrator1.setEmail(administrator.getEmail());
                    administrator1.setPw(administrator.getPw());
                    return administratorRepository.save(administrator1);
                })
                .orElseGet(() -> {
                    administrator.setId(id);
                    return administratorRepository.save(administrator);
                });

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAdmin(@PathVariable Long id) {
        administratorRepository.deleteById(id);

    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAll() {
        administratorRepository.deleteAll();

    }
}
