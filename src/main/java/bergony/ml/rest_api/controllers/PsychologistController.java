package bergony.ml.rest_api.controllers;

import bergony.ml.rest_api.model.psychologist.Psychologist;
import bergony.ml.rest_api.services.PsychologistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "Psychologist Controller", tags = {"Controller"})
@Slf4j
@RestController
@RequestMapping(PsychologistController.BASE_URL)
public class PsychologistController {

    public static final String BASE_URL = "/psychologist/";

    private final PsychologistService psychologistService;

    public PsychologistController(PsychologistService psychologistService) {
        this.psychologistService = psychologistService;
    }

    @ApiOperation(value = "Get list of Psychologist in the System ", notes = "Return all Psychologist in the System.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Psychologist> getAllPsychologists() {
        return psychologistService.getAllPsychologists();
    }

    @ApiOperation(value = "Create a Psychologist in the System ", notes = "Return the Psychologist that the System create.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Psychologist createPsychologist(@RequestBody Psychologist psychologist){
        log.debug("Psychologist "+ psychologist);
        return psychologistService.savePsychologist(psychologist);
    }

    @ApiOperation(value = "Delete All Psychologist in the System ", notes = "Return void.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @DeleteMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll() {
        psychologistService.deleteAll();
    }


    @ApiOperation(value = "Delete a Psychologist by ID in the System ", notes = "Return void.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void  deleteById(@PathVariable String id){
        psychologistService.deleteById(id);
    }


    @ApiOperation(value = "Get a Psychologist by ID in the System ", notes = "Return the Psychologist if finds the System.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Psychologist getPsychologistById(@PathVariable String id){
        return psychologistService.findById(id);
    }


}
