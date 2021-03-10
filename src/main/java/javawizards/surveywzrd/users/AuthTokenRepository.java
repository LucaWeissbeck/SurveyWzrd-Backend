package javawizards.surveywzrd.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthTokenRepository extends CrudRepository<AuthToken, Long> {
    //AuthToken findByauth_key(String auth_key);

}
