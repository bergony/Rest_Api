package bergony.ml.rest_api.services;

import bergony.ml.rest_api.model.psychologist.Psychologist;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PsychologistService {

    Psychologist findById(String id);

    List<Psychologist> getPsychologists();

    Psychologist savePsychologist(Psychologist psychologist);

    void deleteByid( String id);

    void deleteAll();

}