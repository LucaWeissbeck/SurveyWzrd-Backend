package javawizards.surveywzrd.results;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurveyFeedbackRepository extends CrudRepository<SurveyFeedback, Long> {
    SurveyFeedback findById(long id);
}
