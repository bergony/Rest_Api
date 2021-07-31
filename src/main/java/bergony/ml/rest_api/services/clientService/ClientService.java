package bergony.ml.rest_api.services.clientService;

import bergony.ml.rest_api.model.client.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ClientService {

    Mono<Client> findById(String id);

    Flux<Client> getAllClients();

    Mono<Client> saveClient(Client client);

    Mono<Void> deleteById(String id);

    Mono<Void> deleteAll();

}
