package bergony.ml.rest_api.model.psychologist;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Approach {

    @ApiModelProperty(value = "This is  the ID of the Approach", required = true)
    private String id;
    @ApiModelProperty(value = "This is  the Name of the Approach", required = true)
    private String name;
}
