package javawizards.surveywzrd.surveys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {
    List<Survey> findByAdministrator_Id(Long id);
    Survey findById(long id);
}