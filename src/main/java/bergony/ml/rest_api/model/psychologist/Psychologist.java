package bergony.ml.rest_api.model.psychologist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
