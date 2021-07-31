package bergony.ml.rest_api.model.appointment;

import bergony.ml.rest_api.enums.AppointmentState;
import bergony.ml.rest_api.model.client.Client;
import bergony.ml.rest_api.model.psychologist.Psychologist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.util.BsonUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    private String id;

    private Psychologist psychologist;

    private Client client;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataHora;

    private BigDecimal valor;

    private AppointmentState state;

    private boolean paymentStatus = false;




}
