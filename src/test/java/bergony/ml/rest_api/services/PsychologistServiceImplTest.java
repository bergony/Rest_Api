package bergony.ml.rest_api.services;

import bergony.ml.rest_api.model.psychologist.Psychologist;
import bergony.ml.rest_api.repositories.PsychologistRepository;
import com.mongodb.assertions.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class PsychologistServiceImplTest {

    @Mock
    PsychologistRepository psychologistRepository;

    private static final String ID = "1";
    PsychologistService psychologistService;

    @BeforeEach
    void setUp() {

        psychologistService = new PsychologistServiceImpl(psychologistRepository);
    }

    @Test
    void findById() {

        Psychologist psychologist = Psychologist.builder().id(ID).build();

        Mockito.when(psychologistRepository.findById(anyString())).thenReturn(java.util.Optional.ofNullable(psychologist));

        Psychologist psychologistReturn = psychologistService.findById(ID);


        Assertions.assertNotNull(psychologistReturn.getId());

    }

    @Test
    void getPsychologists() {
    }

    @Test
    void savePsychologist() {
    }

    @Test
    void deleteByid() {
    }

    @Test
    void deleteAll() {
    }
}