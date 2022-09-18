package Controller;

import Model.Employee;
import Model.Patient;
import Repository.PatientRepository;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static Model.Status.ON_CALL;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import javax.swing.tree.ExpandVetoException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PatientControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PatientRepository patientRepository;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Employee employee = new Employee("45af", "magico", ON_CALL, "RANRAN");
        Patient patient1 = new Patient("45af","Manolo", "29-09-1997", employee);
        Patient patient2 = new Patient("45af","paco", "06-12-1999", employee);

        patientRepository.save(patient1);
        patientRepository.save(patient2);

    }

    @AfterEach
    void tearDown() {
        patientRepository.deleteAll();
    }


    @Test
    void addPatient() {
    }

    @Test
    void setPatients() {
    }

    @Test
    void allPatients() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/patients"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        List<Patient> patients = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Patient>>() {
        });

        assertEquals(2, patients.size());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Manolo"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Paco"));
    }

    @Test
    void readPatientId() {
    }

    @Test
    void readPatientStatus() {
    }

    @Test
    void readPatientDepartment() {
    }
}