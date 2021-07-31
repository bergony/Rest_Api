package bergony.ml.rest_api.services.appointmentService;

import bergony.ml.rest_api.model.appointment.Appointment;
import bergony.ml.rest_api.model.client.Client;
import bergony.ml.rest_api.model.psychologist.Psychologist;

import java.util.List;

public interface AppointmentService {

    Appointment findById(String id);

    List<Appointment> getAllAppointments();

    List<Appointment> getAllAppointmentsByPsychologist(Psychologist psychologist);

    List<Appointment> getAllAppointmentsByClient(Client client);

    Appointment saveAppointment(Appointment appointment);

    void deleteById(String id);

    void deleteAll();

}
