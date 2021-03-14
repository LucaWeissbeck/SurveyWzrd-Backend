package javawizards.surveywzrd.surveys;

import javawizards.surveywzrd.users.Administrator;
import javawizards.surveywzrd.users.AdministratorRepository;
import javawizards.surveywzrd.users.AuthTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/survey")
public class SurveyController {
    private SurveyRepository surveyRepository;
    private AdministratorRepository administratorRepository;
    private AuthTokenRepository authTokenRepository;

    @Autowired
    public SurveyController(SurveyRepository surveyRepository, AdministratorRepository administratorRepository, AuthTokenRepository authTokenRepository) {
        this.surveyRepository = surveyRepository;
        this.administratorRepository = administratorRepository;
        this.authTokenRepository = authTokenRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Survey>> getAllSurveys() {
        return new ResponseEntity<>((List<Survey>) surveyRepository.findAll(), HttpStatus.OK);

    }

    @RequestMapping(value = "/public/{id}", method = RequestMethod.GET)
    public Survey getSurvey(@PathVariable Long id) {
        return surveyRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(id.toString())); //SurveyNotFoundException(id));

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Survey addSurvey(@RequestBody Survey survey, @RequestHeader Map<String, String> headers) {
        Administrator administrator = administratorRepository.findById(authTokenRepository.findByauthKey(headers.get("x-api-key")).get().getAdmin().getId()).get();
        survey.setAdministrator(administrator);
        return surveyRepository.save(survey);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Survey updateSurvey(@RequestBody Survey survey, @PathVariable Long id) {
        return surveyRepository.findById(id)
                .map(survey1 -> {
                    survey1.setName(survey.getName());
                    survey1.setDescription(survey.getDescription());
                    survey1.setExpiryDate(survey.getExpiryDate());
                    survey1.setQuestion(survey.getQuestion());
                    survey1.setMultiSelect(survey.isMultiSelect());
                    return surveyRepository.save(survey1);
                })
                .orElseGet(() -> {
                    survey.setId(id);
                    return surveyRepository.save(survey);
                });

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSurvey(@PathVariable Long id) {
        surveyRepository.deleteById(id);

    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAll() {
        surveyRepository.deleteAll();

    }
}
