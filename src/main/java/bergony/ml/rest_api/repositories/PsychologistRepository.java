package bergony.ml.rest_api.repositories;

import bergony.ml.rest_api.model.psychologist.Psychologist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PsychologistRepository extends CrudRepository<Psychologist, String > {
}
