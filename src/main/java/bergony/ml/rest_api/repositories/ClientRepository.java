package bergony.ml.rest_api.repositories;

import bergony.ml.rest_api.model.client.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends ReactiveCrudRepository<Client, String> {
}
