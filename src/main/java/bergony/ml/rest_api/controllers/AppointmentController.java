package bergony.ml.rest_api.controllers;

import bergony.ml.rest_api.model.appointment.Appointment;
import bergony.ml.rest_api.model.client.Client;
import bergony.ml.rest_api.model.psychologist.Psychologist;
import bergony.ml.rest_api.services.appointmentService.AppointmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Appointment Controller", tags = {"Appointment"})
@Slf4j
@RestController
@RequestMapping(AppointmentController.BASE_URL)
public class AppointmentController {

    public static final String BASE_URL = "/appointment/";

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @ApiOperation(value = "Get list of Appointment in the System ",
            notes = "Return all Appointment in the System.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @ApiOperation(value = "Get list of Appointment by Psychologist in the System ",
            notes = "Return all Appointment by Psychologist in the System.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("psychologist")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getAllAppointmentsByPsychologist(@RequestBody Psychologist psychologist) {
        return appointmentService.getAllAppointmentsByPsychologist(psychologist);
    }

    @ApiOperation(value = "Get list of Appointment by client in the System ",
            notes = "Return all Appointment by client in the System.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("client")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> getAllAppointmentsByClient(@RequestBody Client client) {
        return appointmentService.getAllAppointmentsByClient(client);
    }

    @ApiOperation(value = "Create a Appointment in the System ",
            notes = "Return the Appointment that the System create.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        return appointmentService.saveAppointment(appointment);
    }


    @ApiOperation(value = "Delete All Appointment in the System ", notes = "Return void.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @DeleteMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll() {
        appointmentService.deleteAll();
    }


    @ApiOperation(value = "Delete a Appointment by ID in the System ", notes = "Return void.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void  deleteById(@PathVariable String id){
        appointmentService.deleteById(id);
    }


    @ApiOperation(value = "Get a Appointment by ID in the System ",
            notes = "Return the Appointment if finds in the System.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment getClientById(@PathVariable String id){
        return appointmentService.findById(id);
    }


}
