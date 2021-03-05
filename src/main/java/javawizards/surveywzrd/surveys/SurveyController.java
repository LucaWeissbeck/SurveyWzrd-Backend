package javawizards.surveywzrd.surveys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/survey")
public class SurveyController {
    private SurveyRepository surveyRepository;

    @Autowired
    public SurveyController(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Survey>> getAllSurveys() {
        return new ResponseEntity<>((List<Survey>) surveyRepository.findAll(), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Survey getSurvey(@PathVariable Long id) {
        return surveyRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(id.toString())); //SurveyNotFoundException(id));

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Survey addSurvey(@RequestBody Survey survey) {
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
