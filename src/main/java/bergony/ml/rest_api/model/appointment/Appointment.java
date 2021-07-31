package bergony.ml.rest_api.model.appointment;

import bergony.ml.rest_api.enums.AppointmentState;
import bergony.ml.rest_api.model.client.Client;
import bergony.ml.rest_api.model.psychologist.Psychologist;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "This is  the ID of Appointment")
    private String id;

    @ApiModelProperty(value = "This is the psychologist", required = true)
    private Psychologist psychologist;

    @ApiModelProperty(value = "This is the client", required = true)
    private Client client;

    @ApiModelProperty(value = "This is the DateTime", required = true)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataHora;

    @ApiModelProperty(value = "This is the Price of the appointment", required = true)
    private BigDecimal valor;

    @ApiModelProperty(value = "State of the appointment")
    private AppointmentState state;

    @ApiModelProperty(value = "State of the payment")
    private boolean paymentStatus = false;




}
