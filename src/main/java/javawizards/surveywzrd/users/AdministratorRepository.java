package javawizards.surveywzrd.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
    Administrator findById(long id);

    Administrator findByEmail(String email);

}
