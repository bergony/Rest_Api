package bergony.ml.rest_api.model.client;

import bergony.ml.rest_api.model.psychologist.Approach;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @ApiModelProperty(value = "This is  the ID of Client")
    private String id;

    @ApiModelProperty(value = "This is  the Name", required = true)
    private String name;

    @ApiModelProperty(value = "This is  the CPF", required = true)
    private String cpf;



}
