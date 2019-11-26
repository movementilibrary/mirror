package br.com.dasa.mirror.api.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import br.com.dasa.mirror.api.enumeration.AdmissionStatus;
import br.com.dasa.mirror.api.enumeration.PaymentMethod;
import br.com.dasa.mirror.api.enumeration.PaymentType;
import br.com.dasa.mirror.api.enumeration.Status;
import br.com.dasa.mirror.api.model.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = {"test"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmissionControllerTest {

    @LocalServerPort
    int port;
    private Patient paciente;
    private Admission admmissao;
    private Payments payment;
    private AdditionalProperties additionalProperties;
    private Questions question;
    private MedicalOrders medicalOrdersOrder;
    private Doctor doctor;
    private Exams exams;
    private Scheduling scheduling;
    private List<AdditionalProperties> listAdditionalProperties;
    private List<Payments> listPaymets;
    private List<Questions> listQuestions;
    private List<MedicalOrders> listMedicalOrders;
    private List<Exams> listExams;

    @Before
    public void setUp() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

        listAdditionalProperties = new ArrayList<>();
        listPaymets = new ArrayList<>();
        listQuestions = new ArrayList<>();
        listMedicalOrders = new ArrayList<>();
        listExams = new ArrayList<>();

        additionalProperties = new AdditionalProperties("", "");
        listAdditionalProperties.add(additionalProperties);

        paciente = new Patient("123456689", "888", "");
        doctor = new Doctor("SP-CRM-111110", "SP-CRM-11111", "SP-CRM-111110");
        scheduling = new Scheduling("2019-12-01", listAdditionalProperties, "");

        exams = new Exams(listAdditionalProperties,
                        "H1 EDTA 4 ML",
                        "",
                        "DEL",
                        "DA-KSA",
                        "Medicamento",
                        "825646627301",
                        "0",
                        "123456789");
        listExams.add(exams);

        question = new Questions("Está de Jejum", "1", listAdditionalProperties, "");
        listQuestions.add(question);

        payment = new Payments(PaymentMethod.CREDIT_CARD, listAdditionalProperties, PaymentType.PRIVATE, "200.00", "8ead6445-ed38-4aac-b91d-35a63d9eedcb", "");
        listPaymets.add(payment);


        admmissao = new Admission("DDIG",
                                    "DPI",
                                    "13",
                                    "",
                                    "8a2f05d0-104a-48a7-94d9-6d2d06516fe4",
                                    AdmissionStatus.ADMISSION,
                                    "32",
                                    listPaymets,
                                    listQuestions,
                                    scheduling,
                                    listMedicalOrders);
    }

    @Test
    public void deveVerificarSeDeParaMarcaFoiRealizado() {
        given().contentType("application/json").body(admmissao).when().post("/admission/consumer").then()
                .statusCode(200).body("brandId", equalTo("8"));
    }

    @Test
    public void deveVerificarSeDeParaUnidadeFoiRealizado() {
        given().contentType("application/json").body(admmissao).when().post("/admission/consumer").then()
                .statusCode(200).body("unitId", equalTo("636"));
    }

}
