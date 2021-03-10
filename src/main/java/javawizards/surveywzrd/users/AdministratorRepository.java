package javawizards.surveywzrd.users;

import javawizards.surveywzrd.surveys.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long>{
    Administrator findById(long id);
}