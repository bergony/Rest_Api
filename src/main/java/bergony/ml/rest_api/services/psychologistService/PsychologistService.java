package bergony.ml.rest_api.services.psychologistService;

import bergony.ml.rest_api.model.psychologist.Psychologist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


public interface PsychologistService {

    Mono<Psychologist> findById(String id);

    Flux<Psychologist> getAllPsychologists();

    Mono<Psychologist> savePsychologist(Psychologist psychologist);

    Mono<Void> deleteById(String id);

    Mono<Void> deleteAll();

}
