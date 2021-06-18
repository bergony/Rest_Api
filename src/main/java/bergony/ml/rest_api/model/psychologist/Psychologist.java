package bergony.ml.rest_api.model.psychologist;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@Builder
public class Psychologist {

    private String id;
    private int numberCRP;

    private String name;
    private Approach approach;
    private List<Specialization> specializationList;

}
