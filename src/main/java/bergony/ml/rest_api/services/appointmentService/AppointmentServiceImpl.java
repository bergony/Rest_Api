package bergony.ml.rest_api.services.appointmentService;

import bergony.ml.rest_api.model.appointment.Appointment;
import bergony.ml.rest_api.model.client.Client;
import bergony.ml.rest_api.model.psychologist.Psychologist;
import bergony.ml.rest_api.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment findById(String id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentRepository.findAll().forEach(appointment -> appointmentList.add(appointment));

        return appointmentList;
    }

    @Override
    public List<Appointment> getAllAppointmentsByPsychologist(Psychologist psychologist) {
        return appointmentRepository.findByPsychologist(psychologist);
    }

    @Override
    public List<Appointment> getAllAppointmentsByClient(Client client) {
        return appointmentRepository.findByClient(client);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteById(String id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        appointmentRepository.deleteAll();
    }
}
