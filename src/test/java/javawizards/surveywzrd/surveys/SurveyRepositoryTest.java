package javawizards.surveywzrd.surveys;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SurveyRepositoryTest {

    private SurveyRepository surveyrepository;
    @BeforeEach
    void setUp() throws Exception{
        surveyrepository = new SurveyRepository() {
            @Override
            public List<Survey> findByAdministrator_Id(Long id) {
                return null;
            }

            @Override
            public Survey findById(long id) {
                return null;
            }

            @Override
            public <S extends Survey> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Survey> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Survey> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Survey> findAll() {
                return null;
            }

            @Override
            public Iterable<Survey> findAllById(Iterable<Long> longs) {
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
            public void delete(Survey entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends Survey> entities) {

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
    void findByAdministrator_Id() {
    }

    @Test
    void findById() {
    }
}