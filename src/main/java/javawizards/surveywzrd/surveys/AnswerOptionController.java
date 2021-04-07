package javawizards.surveywzrd.surveys;

import javawizards.surveywzrd.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/survey/answeroptions")
public class AnswerOptionController {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AnswerOptionRepository answerOptionRepository;

    @GetMapping("/public/{surveyID}")
    public List<AnswerOption> getAllAnswerOptionsBySurveyID(@PathVariable(value = "surveyID") Long surveyID) {
        return answerOptionRepository.findAllBySurvey_id(surveyID);
    }

    @RequestMapping(value = "/{surveyID}", method = RequestMethod.POST)
    public AnswerOption addAnswerOption(@PathVariable(value = "surveyID") Long surveyID, @RequestBody AnswerOption answerOption) {
        return surveyRepository.findById(surveyID).map(survey -> {
            answerOption.setSurvey(survey);
            return answerOptionRepository.save(answerOption);
        }).orElseThrow(() -> new ResourceNotFoundException("SurveyID " + surveyID + " not found"));

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAnswerOption(@PathVariable Long id) {
        answerOptionRepository.deleteById(id);


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public AnswerOption updateAnswerOption(@RequestBody AnswerOption answerOption, @PathVariable Long id) {
        return answerOptionRepository.findById(id).map(answerOption1 -> {
            answerOption1.setValue(answerOption.getValue());
            return answerOptionRepository.save(answerOption1);
        }).orElseThrow(() -> new ResourceNotFoundException("AnswerOptionID " + id + "not found"));

    }

}
