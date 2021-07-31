package bergony.ml.rest_api.services.clientService;

import bergony.ml.rest_api.model.client.Client;
import bergony.ml.rest_api.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(String id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();

        clientRepository.findAll().forEach(client -> clientList.add(client) );

        return  clientList;
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteById(String id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void deleteAll(){
        clientRepository.deleteAll();

    }
}
