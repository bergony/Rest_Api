package bergony.ml.rest_api.model.psychologist;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Specialization {

        @ApiModelProperty(value = "This is  the ID of the Approach",required = true)
        private String id;
        @ApiModelProperty(value = "This is  the Name of the Approach", required = true)
        private String name;

}
