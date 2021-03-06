package javawizards.surveywzrd.surveys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Long> {
    List<AnswerOption> findAllBySurvey_id(Long surveyID);

    Optional<AnswerOption> findByIdAndSurveyId(Long id, Long surveyID);
}

