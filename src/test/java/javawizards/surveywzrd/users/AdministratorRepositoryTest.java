package javawizards.surveywzrd.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorRepositoryTest {

    private AdministratorRepository administratorRepository;
    @BeforeEach
    void setUp() throws Exception{
        administratorRepository = new AdministratorRepository() {
            @Override
            public Administrator findById(long id) {
                return null;
            }

            @Override
            public Administrator findByEmail(String email) {
                return null;
            }

            @Override
            public <S extends Administrator> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Administrator> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Administrator> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Administrator> findAll() {
                return null;
            }

            @Override
            public Iterable<Administrator> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Administrator entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends Administrator> entities) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById() {
    }
}