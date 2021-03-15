package javawizards.surveywzrd.results;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SurveyFeedbackRepositoryTest {

    private SurveyFeedbackRepository surveyreedbackrepository;
    @BeforeEach
    void setUp() throws Exception{
        surveyreedbackrepository = new SurveyFeedbackRepository() {
            @Override
            public <S extends SurveyFeedback> S save(S entity) {
                return null;
            }

            @Override
            public <S extends SurveyFeedback> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<SurveyFeedback> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<SurveyFeedback> findAll() {
                return null;
            }

            @Override
            public Iterable<SurveyFeedback> findAllById(Iterable<Long> longs) {
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
            public void delete(SurveyFeedback entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends SurveyFeedback> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<SurveyFeedback> findAllBySurvey_Id(long survey_id) {
                return null;
            }

            @Override
            public List<SurveyFeedback> findAllByAnswerOption_Id(long answerOption_id) {
                return null;
            }

            @Override
            public SurveyFeedback findById(long id) {
                return null;
            }
        };
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById() {
    }

    @Test
    void findBySurvey_Id() {
    }
}