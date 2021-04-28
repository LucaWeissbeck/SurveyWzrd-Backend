package javawizards.surveywzrd.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthTokenRepository extends CrudRepository<AuthToken, Long> {
    Optional<AuthToken> findByauthKey(String auth_key);
    void deleteByAdmin(Administrator administrator);
    Optional<AuthToken> findByAdminId(Long id);


}
