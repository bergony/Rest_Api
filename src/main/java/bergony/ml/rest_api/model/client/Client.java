package bergony.ml.rest_api.model.client;

import bergony.ml.rest_api.model.psychologist.Approach;
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

    private String id;

    private String name;

    private String cpf;



}
