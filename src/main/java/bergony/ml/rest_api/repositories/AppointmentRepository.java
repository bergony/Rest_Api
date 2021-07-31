package bergony.ml.rest_api.repositories;

import bergony.ml.rest_api.model.appointment.Appointment;
import bergony.ml.rest_api.model.client.Client;
import bergony.ml.rest_api.model.psychologist.Psychologist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface AppointmentRepository extends ReactiveCrudRepository<Appointment, String> {

    Flux<Appointment> findByPsychologist(Psychologist psychologist);

    Flux<Appointment> findByClient(Client client);
}
