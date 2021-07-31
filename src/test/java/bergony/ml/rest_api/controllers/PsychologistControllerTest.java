package bergony.ml.rest_api.controllers;

import bergony.ml.rest_api.model.psychologist.Approach;
import bergony.ml.rest_api.model.psychologist.Psychologist;
import bergony.ml.rest_api.model.psychologist.Specialization;
import bergony.ml.rest_api.services.psychologistService.PsychologistService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.swagger.annotations.Api;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
class PsychologistControllerTest {

    private static final String ID = "1";
    private static final String NAME = "Bergony";
    private static final int NUMBERCRP = 123456;
    private static final String APPROACH_NAME = "Subjective";
    private static final String SPECIALIZATIONS_NAME = "Clinical Psychology";

    @Mock
    PsychologistService psychologistService;


    PsychologistController psychologistController;
    MockMvc mockMvc;

    Psychologist psychologist;

    Psychologist psychologist1;


    Approach approach;

    Specialization specialization;
    List<Specialization> specializationList = new LinkedList<>();



    @BeforeEach
    void setUp() throws JsonProcessingException {

        approach = Approach.builder().id(ID).name(APPROACH_NAME).build();

        specialization = Specialization.builder().id(ID).name(SPECIALIZATIONS_NAME).build();
        specializationList.add(specialization);

        psychologist =  Psychologist.builder()
                .id(ID)
                .name(NAME)
                .approach(approach)
                .specializationList(specializationList)
                .numberCRP(NUMBERCRP)
                .build();
        psychologist1 = Psychologist.builder().name("Bergony1").build();

        psychologistController = new PsychologistController(psychologistService);

        mockMvc = MockMvcBuilders.standaloneSetup(psychologistController).build();

    }

    @Test
    void getAllPsychologists() throws Exception {

        List<Psychologist> psychologistList = Arrays.asList(psychologist, psychologist1);

        when(psychologistService.getAllPsychologists()).thenReturn(psychologistList);

        mockMvc.perform(get(PsychologistController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", equalTo("Bergony")))
                .andExpect(jsonPath("$[1].name", equalTo("Bergony1")));

    }

    @Test
    void createPsychologist() throws Exception {

        when(psychologistService.savePsychologist(any(Psychologist.class))).thenReturn(psychologist);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(psychologist);

        mockMvc.perform(post(PsychologistController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", equalTo("Bergony")));

    }

    @Test
    void deleteAll() throws Exception {

        mockMvc.perform(delete(PsychologistController.BASE_URL+"/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(psychologistService).deleteAll();

    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete(PsychologistController.BASE_URL+"/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(psychologistService).deleteById(anyString());
    }

    @Test
    void getPsychologistById() throws Exception {

        when(psychologistService.findById(anyString())).thenReturn(psychologist);

        mockMvc.perform(get(PsychologistController.BASE_URL+"/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Bergony")))
                .andExpect(jsonPath("$.numberCRP", equalTo(123456)));




    }
}