package javawizards.surveywzrd.surveys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/survey")
public class SurveyController {
    private SurveyRepository surveyRepository;

    @Autowired
    public SurveyController(SurveyRepository surveyRepository){
        this.surveyRepository = surveyRepository;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ResponseEntity<List<Survey>> getAllSurveys(){
        return new ResponseEntity<>((List<Survey>) surveyRepository.findAll(), HttpStatus.OK);

    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public Survey addSurvey(@RequestBody Survey survey){
        return surveyRepository.save(survey);

    }
}
