package bergony.ml.rest_api.services.appointmentService;

import bergony.ml.rest_api.model.appointment.Appointment;
import bergony.ml.rest_api.model.client.Client;
import bergony.ml.rest_api.model.psychologist.Psychologist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AppointmentService {

    Mono<Appointment> findById(String id);

    Flux<Appointment> getAllAppointments();

    Flux<Appointment> getAllAppointmentsByPsychologist(Psychologist psychologist);

    Flux<Appointment> getAllAppointmentsByClient(Client client);

    Mono<Appointment> saveAppointment(Appointment appointment);

    Mono<Void> deleteById(String id);

    Mono<Void> deleteAll();

}
