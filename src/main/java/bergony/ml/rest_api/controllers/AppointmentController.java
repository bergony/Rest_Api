package bergony.ml.rest_api.controllers;

import bergony.ml.rest_api.model.appointment.Appointment;
import bergony.ml.rest_api.model.client.Client;
import bergony.ml.rest_api.model.psychologist.Psychologist;
import bergony.ml.rest_api.services.appointmentService.AppointmentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(AppointmentController.BASE_URL)
public class AppointmentController {

    public static final String BASE_URL = "/appointment/";

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }


    @GetMapping("psychologist")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Appointment> getAllAppointmentsByPsychologist(@RequestBody Psychologist psychologist) {
        return appointmentService.getAllAppointmentsByPsychologist(psychologist);
    }


    @GetMapping("client")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Appointment> getAllAppointmentsByClient(@RequestBody Client client) {
        return appointmentService.getAllAppointmentsByClient(client);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Appointment> saveAppointment(@RequestBody Appointment appointment){
        return appointmentService.saveAppointment(appointment);
    }



    @DeleteMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteAll() {
       return appointmentService.deleteAll();
    }



    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteById(@PathVariable String id){
        return appointmentService.deleteById(id);
    }


    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Appointment> getClientById(@PathVariable String id){
        return appointmentService.findById(id);
    }
}
