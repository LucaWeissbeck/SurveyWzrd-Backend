package javawizards.surveywzrd.surveys;

import javawizards.surveywzrd.exceptions.ForbiddenException;
import javawizards.surveywzrd.exceptions.ResourceNotFoundException;
import javawizards.surveywzrd.users.Administrator;
import javawizards.surveywzrd.users.AdministratorRepository;
import javawizards.surveywzrd.users.AuthTokenRepository;
import javawizards.surveywzrd.users.AuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/survey")
public class SurveyController {
    private final SurveyRepository surveyRepository;
    private final AdministratorRepository administratorRepository;
    private final AuthTokenRepository authTokenRepository;
    private final AuthTokenService authTokenService;

    @Autowired
    public SurveyController(SurveyRepository surveyRepository, AdministratorRepository administratorRepository, AuthTokenRepository authTokenRepository, AuthTokenService authTokenService) {
        this.surveyRepository = surveyRepository;
        this.administratorRepository = administratorRepository;
        this.authTokenRepository = authTokenRepository;
        this.authTokenService = authTokenService;
    }

    @RequestMapping(value = "/getAll/", method = RequestMethod.GET)
    public ResponseEntity<List<Survey>> getAllSurveys(@RequestHeader Map<String, String> headers) throws ServletException {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            return new ResponseEntity<>((List<Survey>) surveyRepository.findAll(), HttpStatus.OK);
        }
        throw new ServletException("You are not an owner. No access right.");

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Survey>> getAllSurveysByAdministrator(@RequestHeader Map<String, String> headers) {
        Administrator administrator = authTokenService.authenticate(headers);
        return new ResponseEntity<>(surveyRepository.findAllByAdministrator_Id(administrator.getId()), HttpStatus.OK);

    }

    @RequestMapping(value = "/public/{id}", method = RequestMethod.GET)
    public Survey getSurvey(@PathVariable Long id) {
        return surveyRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(id.toString())); //SurveyNotFoundException(id));

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Survey addSurvey(@RequestBody Survey survey, @RequestHeader Map<String, String> headers) {
        Administrator administrator = authTokenService.authenticate(headers);
        survey.setAdministrator(administrator);
        return surveyRepository.save(survey);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Survey updateSurvey(@RequestBody Survey survey, @PathVariable Long id, @RequestHeader Map<String, String> headers) {
        Administrator administrator = authTokenService.authenticate(headers);
        Optional<Survey> surveyscope = surveyRepository.findById(id);
        if (surveyscope.isPresent()) {
            if (!(surveyscope.get().getAdministrator().getId() == administrator.getId()))
                throw new ForbiddenException("The requesting admin has no permissions for this entity.");

            surveyRepository.findById(id)
                    .map(survey1 -> {
                        survey1.setName(survey.getName());
                        survey1.setDescription(survey.getDescription());
                        survey1.setExpiryDate(survey.getExpiryDate());
                        survey1.setQuestion(survey.getQuestion());
                        survey1.setMultiSelect(survey.isMultiSelect());
                        return surveyRepository.save(survey1);
                    });
        }

        survey.setId(id);
        return surveyRepository.save(survey);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSurvey(@PathVariable Long id, @RequestHeader Map<String, String> headers) {
        Administrator administrator = authTokenService.authenticate(headers);
        Optional<Survey> survey = surveyRepository.findById(id);
        if (!survey.isPresent()) throw new ResourceNotFoundException();
        if (!(survey.get().getAdministrator().getId() == administrator.getId()))
            throw new ForbiddenException("The requesting admin has no permissions for this entity.");
        surveyRepository.deleteById(id);

    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAll(@RequestHeader Map<String, String> headers) throws ServletException {
        Administrator administrator = authTokenService.authenticate(headers);
        if (administrator.isOwner()) {
            surveyRepository.deleteAll();
        } else {
            throw new ServletException("You are not an owner. No access right.");
        }

    }
}
