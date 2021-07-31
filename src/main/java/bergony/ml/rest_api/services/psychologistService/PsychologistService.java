package bergony.ml.rest_api.services.psychologistService;

import bergony.ml.rest_api.model.psychologist.Psychologist;

import java.util.List;


public interface PsychologistService {

    Psychologist findById(String id);

    List<Psychologist> getAllPsychologists();

    Psychologist savePsychologist(Psychologist psychologist);

    void deleteById(String id);

    void deleteAll();

}
