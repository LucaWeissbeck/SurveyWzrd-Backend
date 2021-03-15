package javawizards.surveywzrd.results;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurveyFeedbackRepository extends CrudRepository<SurveyFeedback, Long> {
    List <SurveyFeedback> findAllBySurvey_Id(long survey_id);
    List <SurveyFeedback> findAllByAnswerOption_Id(long answerOption_id);
    SurveyFeedback findById(long id);
}
