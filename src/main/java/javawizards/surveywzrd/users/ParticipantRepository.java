package javawizards.surveywzrd.users;

import javawizards.surveywzrd.surveys.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Long>{
    Participant findById(long id);
    Participant findByCookieId(String id);
    boolean existsByCookieId(String id);
}
