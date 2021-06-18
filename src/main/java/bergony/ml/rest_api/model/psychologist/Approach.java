package bergony.ml.rest_api.model.psychologist;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Approach {

    private String id;

    private String name;
}
