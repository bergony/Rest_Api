package bergony.ml.rest_api.services;

import bergony.ml.rest_api.model.psychologist.Approach;
import bergony.ml.rest_api.model.psychologist.Psychologist;
import bergony.ml.rest_api.model.psychologist.Specialization;
import bergony.ml.rest_api.repositories.PsychologistRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class PsychologistServiceImplTest {

    @Mock
    PsychologistRepository psychologistRepository;

    private static final String ID = "1";
    private static final String NAME = "Bergony";
    private static final int NUMBERCRP = 123456;
    private static final String APPROACH_NAME = "Subjective";
    private static final String SPECIALIZATIONS_NAME = "Clinical Psychology";

    PsychologistService psychologistService;

    Psychologist psychologist;

    Approach approach;

    Specialization specialization, specialization1;
    List<Specialization> specializationList = new LinkedList<>();

    @BeforeEach
    void setUp() {

        approach = Approach.builder().id(ID).name(APPROACH_NAME).build();

        specialization = Specialization.builder().id(ID).name(SPECIALIZATIONS_NAME).build();
        specialization1 = Specialization.builder().id(ID+1).name(SPECIALIZATIONS_NAME).build();
        specializationList.addAll(Arrays.asList(specialization, specialization1));

        psychologist =  Psychologist.builder()
                .id(ID)
                .name(NAME)
                .approach(approach)
                .specializationList(specializationList)
                .numberCRP(NUMBERCRP)
                .build();

        psychologistService = new PsychologistServiceImpl(psychologistRepository);
    }

    @Test
    void findById() {

        when(psychologistRepository.findById(anyString())).thenReturn(java.util.Optional.ofNullable(psychologist));

        Psychologist psychologistReturn = psychologistService.findById(ID);

        Assertions.assertNotNull(psychologistReturn.getId());
        Assertions.assertEquals(psychologistReturn.getApproach(), approach);
        Assertions.assertEquals(psychologistReturn.getApproach().getId(), ID);
        Assertions.assertEquals(psychologistReturn.getApproach().getName(), APPROACH_NAME);

        Assertions.assertEquals(psychologistReturn.getSpecializationList(), specializationList);
        Assertions.assertEquals(psychologistReturn.getSpecializationList().get(0).getId(), ID);
        Assertions.assertEquals(psychologistReturn.getSpecializationList().get(0).getName(), SPECIALIZATIONS_NAME);

    }

    @Test
    void getAllPsychologists() {

        Psychologist psychologist1 = new Psychologist();

        List<Psychologist> psychologistList = Arrays.asList(psychologist, psychologist1);

        when(psychologistRepository.findAll()).thenReturn(psychologistList);

        List<Psychologist> allPsychologist = psychologistService.getAllPsychologists();

        Assertions.assertEquals(allPsychologist.size(), 2);


    }

    @Test
    void savePsychologist() {

        when(psychologistRepository.save(any(Psychologist.class))).thenReturn(psychologist);


        Psychologist savedPsychologist = psychologistService.savePsychologist(psychologist);

        Assertions.assertEquals(savedPsychologist.getName(), NAME);
        Assertions.assertEquals(savedPsychologist.getNumberCRP(), NUMBERCRP);
    }

    @Test
    void deleteByid() {

        when(psychologistRepository.findById(anyString())).thenReturn(Optional.of(psychologist));

        psychologistService.deleteById(psychologist.getId());

        verify(psychologistRepository, times(1)).deleteById("1");
    }

    @Test
    void deleteAll() {

        Psychologist psychologist1 = new Psychologist();

        List<Psychologist> psychologistList = Arrays.asList(psychologist, psychologist1);

        when(psychologistRepository.findAll()).thenReturn(psychologistList);

        psychologistService.deleteAll();

        verify(psychologistRepository, times(1)).deleteAll();


    }
}