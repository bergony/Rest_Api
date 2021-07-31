package bergony.ml.rest_api.services.appointmentService;

import bergony.ml.rest_api.enums.AppointmentState;
import bergony.ml.rest_api.model.appointment.Appointment;
import bergony.ml.rest_api.model.client.Client;
import bergony.ml.rest_api.model.psychologist.Psychologist;
import bergony.ml.rest_api.repositories.AppointmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Mono<Appointment> findById(String id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public Flux<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Flux<Appointment> getAllAppointmentsByPsychologist(Psychologist psychologist) {
        Flux<Appointment> appointmentFlux = this.appointmentRepository.findByPsychologist(psychologist);

        appointmentFlux.filter(appointment -> appointment.getState().equals(AppointmentState.AVAILABLE))
                .subscribe(appointment -> System.out.println(appointment.getClient().getName()));

        return appointmentFlux;
    }

    @Override
    public Flux<Appointment> getAllAppointmentsByClient(Client client) {
        Flux<Appointment> appointmentFlux = this.appointmentRepository.findByClient(client);

        appointmentFlux.filter(appointment -> appointment.isPaymentStatus())
                .subscribe(appointment -> System.out.println(appointment.getClient().getName() + " " + appointment.isPaymentStatus()));

        return appointmentFlux;
    }

    @Override
    public Mono<Appointment> saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return appointmentRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return appointmentRepository.deleteAll();
    }
}
