package bergony.ml.rest_api.model.psychologist;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Specialization {

        private String id;
        private String name;

}
