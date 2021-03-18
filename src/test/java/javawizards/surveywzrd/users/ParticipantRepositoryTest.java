package javawizards.surveywzrd.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantRepositoryTest {

    private ParticipantRepository participantrepository;

    @BeforeEach
    void setUp() throws Exception {
        participantrepository = new ParticipantRepository() {
            @Override
            public Participant findById(long id) {
                return null;
            }

            @Override
            public Participant findByCookieId(String id) {
                return null;
            }

            @Override
            public boolean existsByCookieId(String id) {
                return false;
            }

            @Override
            public <S extends Participant> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Participant> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Participant> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Participant> findAll() {
                return null;
            }

            @Override
            public Iterable<Participant> findAllById(Iterable<Long> longs) {
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
            public void delete(Participant entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends Participant> entities) {

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