package javawizards.surveywzrd.surveys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/survey/answeroptions")
public class AnswerOptionController {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AnswerOptionRepository answerOptionRepository;

    @GetMapping("/{surveyID}/")
    public Page<AnswerOption> getAllAnswerOptionsBySurveyID(@PathVariable(value = "surveyID") Long surveyID,
                                                             Pageable pageable) {
        //return null;
        return answerOptionRepository.findBySurvey_id(surveyID, pageable);
    }
}
