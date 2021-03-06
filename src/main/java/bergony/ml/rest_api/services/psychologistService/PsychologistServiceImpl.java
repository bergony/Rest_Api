package bergony.ml.rest_api.services.psychologistService;

import bergony.ml.rest_api.model.psychologist.Psychologist;
import bergony.ml.rest_api.repositories.PsychologistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PsychologistServiceImpl implements PsychologistService {

    private final PsychologistRepository psychologistRepository;

    public PsychologistServiceImpl(PsychologistRepository psychologistRepository) {
        this.psychologistRepository = psychologistRepository;
    }


    @Override
    public Psychologist findById(String id) {
        log.debug("Find the ID:"+id);
        return psychologistRepository.findById(id).orElse(null);
    }

    @Override
    public List<Psychologist> getAllPsychologists() {
        List<Psychologist> psychologistList = new ArrayList<>();

        psychologistRepository.findAll().forEach(psychologist -> {
            log.debug("Add the Psychologist: " + psychologist.getName());
            psychologistList.add(psychologist);
        });


        return psychologistList;
    }

    @Override
    public Psychologist savePsychologist(Psychologist psychologist) {
        log.debug("Save the psychologist:" + psychologist.getName());
        return psychologistRepository.save(psychologist);
    }

    @Override
    public void deleteById(String id) {
        Psychologist PsyToDelete = psychologistRepository.findById(id).orElse(null);

        assert PsyToDelete != null;
        log.debug("Delete the" + PsyToDelete.getName());
        psychologistRepository.deleteById(id);

    }

    @Override
    public void deleteAll() {
        log.debug("Delete ALL");
        psychologistRepository.deleteAll();
    }
}
