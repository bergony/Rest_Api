package bergony.ml.rest_api.controllers;

import bergony.ml.rest_api.model.client.Client;
import bergony.ml.rest_api.services.clientService.ClientService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(ClientController.BASE_URL)
public class ClientController {

    public static final String BASE_URL = "/client/";

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Client> getAllClients() {
        return clientService.getAllClients();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Client> createClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }


    @DeleteMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteAll() {
        return clientService.deleteAll();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void>  deleteById(@PathVariable String id){
         return clientService.deleteById(id);
    }



    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public  Mono<Client> getClientById(@PathVariable String id){
        return clientService.findById(id);
    }


}
