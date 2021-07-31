package bergony.ml.rest_api.services.clientService;

import bergony.ml.rest_api.model.client.Client;

import java.util.List;

public interface ClientService {

    Client findById(String id);

    List<Client> getAllClients();

    Client saveClient(Client client);

    void deleteById(String id);

    void deleteAll();

}
