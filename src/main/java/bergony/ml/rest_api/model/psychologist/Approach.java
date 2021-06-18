package bergony.ml.rest_api.model.psychologist;

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

    private String id;
    private String name;
}
