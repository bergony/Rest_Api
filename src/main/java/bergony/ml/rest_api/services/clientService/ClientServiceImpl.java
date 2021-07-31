package bergony.ml.rest_api.services.clientService;

import bergony.ml.rest_api.model.client.Client;
import bergony.ml.rest_api.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Mono<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    @Override
    public Flux<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<Client> saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clientRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return clientRepository.deleteAll();
    }
}
