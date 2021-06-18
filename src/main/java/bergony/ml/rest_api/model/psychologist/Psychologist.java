package bergony.ml.rest_api.model.psychologist;

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

    private String id;
    private int numberCRP;

    private String name;
    private Approach approach;
    private List<Specialization> specializationList = new LinkedList<>();

}
