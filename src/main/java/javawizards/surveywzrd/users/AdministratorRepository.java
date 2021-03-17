package javawizards.surveywzrd.users;

import javawizards.surveywzrd.results.SurveyFeedback;
import javawizards.surveywzrd.surveys.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long>{
    Administrator findById(long id);
    Administrator findByEmail(String email);

}
