package bergony.ml.rest_api.repositories;

import bergony.ml.rest_api.model.psychologist.Psychologist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PsychologistRepository extends ReactiveCrudRepository<Psychologist, String > {
}
