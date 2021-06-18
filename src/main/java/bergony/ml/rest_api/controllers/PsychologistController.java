package bergony.ml.rest_api.controllers;

import bergony.ml.rest_api.model.psychologist.Psychologist;
import bergony.ml.rest_api.services.PsychologistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(PsychologistController.BASE_URL)
public class PsychologistController {

    public static final String BASE_URL = "/psychologist/";


    private final PsychologistService psychologistService;

    public PsychologistController(PsychologistService psychologistService) {
        this.psychologistService = psychologistService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Psychologist> getAllPsychologists() {
        return psychologistService.getAllPsychologists();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Psychologist createPsychologist(@RequestBody Psychologist psychologist){
        log.debug("Psychologist "+ psychologist);
        return psychologistService.savePsychologist(psychologist);
    }

    @DeleteMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll() {
        psychologistService.deleteAll();
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void  deleteById(@PathVariable String id){
        psychologistService.deleteById(id);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Psychologist getPsychologistById(@PathVariable String id){
        return psychologistService.findById(id);
    }


}
