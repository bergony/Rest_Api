package bergony.ml.rest_api.model.psychologist;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.List;

@Getter
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Psychologist {

    @ApiModelProperty(value = "This is  the ID of psychology")
    private String id;

    @ApiModelProperty(value = "This is  the number of regional council of psychology", required = true)
    private int numberCRP;

    @ApiModelProperty(value = "This is  the Name", required = true)
    private String name;

    @ApiModelProperty(value = "This is the Approach", required = true)
    private Approach approach;

    @ApiModelProperty(value = "These are the specializations", required = true)
    private List<Specialization> specializationList = new LinkedList<>();

}
