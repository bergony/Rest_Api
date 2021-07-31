package bergony.ml.rest_api.services.psychologistService;

import bergony.ml.rest_api.model.psychologist.Psychologist;
import bergony.ml.rest_api.repositories.PsychologistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@Service
public class PsychologistServiceImpl implements PsychologistService {

    private final PsychologistRepository psychologistRepository;

    public PsychologistServiceImpl(PsychologistRepository psychologistRepository) {
        this.psychologistRepository = psychologistRepository;
    }


    @Override
    public Mono<Psychologist> findById(String id) {
        log.debug("Find the ID:"+id);
        return this.psychologistRepository.findById(id);
    }

    @Override
    public Flux<Psychologist> getAllPsychologists() {
        return psychologistRepository.findAll();
    }

    @Override
    public Mono<Psychologist> savePsychologist(Psychologist psychologist) {
        log.debug("Save the psychologist:" + psychologist.getName());
        return psychologistRepository.save(psychologist);
    }

    @Override
    public  Mono<Void> deleteById(String id) {
        return psychologistRepository.deleteById(id);

    }

    @Override
    public  Mono<Void> deleteAll() {
        log.debug("Delete ALL");
        return psychologistRepository.deleteAll();

    }
}
