package br.com.dasa.mirror.api.service;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import br.com.dasa.mirror.api.enumeration.*;
import br.com.dasa.mirror.api.model.*;
import br.com.dasa.mirror.api.service.impl.BrandService;
import br.com.dasa.mirror.api.service.impl.UnitService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UnitService unitService;

    @Autowired
    private BrandService brandService;

    @LocalServerPort
    int port;

    private MedicalOrders medicalOrders;
    private Patient paciente;
    private Admission admmissao;
    private Payments payment;
    private AdditionalProperties additionalProperties;
    private Questions question;
    private ResponseMedicalOrders responseMedicalOrders;

    private Doctor doctor;
    private Exams exams;
    private Exams examsMedicalOrders;
    private Questions questions;
    private Scheduling scheduling;
    private List<AdditionalProperties> listAdditionalProperties = new ArrayList<>();
    private List<Payments> listPaymets = new ArrayList<>();
    private List<Questions> listQuestions = new ArrayList<>();
    private List<Exams> listExams = new ArrayList<>();
    private List<MedicalOrders> listMedicalOrders = new ArrayList<>();
    private List<ResponseMedicalOrders> listResponseMedicalOrders = new ArrayList<>();
    private List<Exams> listExamsMedicalOrders = new ArrayList<>();


    @Before
    public void setUp() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

    }

    public void criaAdmissao(){

        additionalProperties = new AdditionalProperties("","");
        listAdditionalProperties.add(additionalProperties);

        paciente = new Patient("123456689", "888", "");
        doctor = new Doctor("SP-CRM-111110", "SP-CRM-11111", "SP-CRM-111110");
        scheduling = new Scheduling("2019-12-01", listAdditionalProperties, "");


        exams = new Exams("",listAdditionalProperties, "CODEMIRROR","13.00", "2019-11-26T16:57:42.396Z",  "Gel", "MIRROR GEL", Status.PENDENTE,"312321");
        listExams.add(exams);

        question = new Questions("Está de Jejum", "1", listAdditionalProperties, "");
        listQuestions.add(question);

        payment = new Payments(PaymentMethod.CREDIT_CARD, listAdditionalProperties, PaymentType.PRIVATE, "200.00", "8ead6445-ed38-4aac-b91d-35a63d9eedcb", "");
        listPaymets.add(payment);

        medicalOrders = new MedicalOrders("CRM", "123", State.RO, listExams, "");
        listMedicalOrders.add(medicalOrders);

        admmissao = new Admission("DDIG", "DPI", "13", "", "8a2f05d0-104a-48a7-94d9-6d2d06516fe4",AdmissionStatus.PRE_ADMISSION, "32", listPaymets, listQuestions, scheduling, listMedicalOrders);

    }

//    @Test
//    public void deveVerificarSeDeParaMarcaFoiRealizado() {
//        given().contentType("application/json").body(admmissao).when().post("/admission/consumer").then()
//                .statusCode(200).body("brandId", equalTo("8"));
//    }
//
//    @Test
//    public void deveVerificarSeDeParaUnidadeFoiRealizado() {
//        given().contentType("application/json").body(admmissao).when().post("/admission/consumer").then()
//                .statusCode(200).body("unitId", equalTo("636"));
//    }


    @Test
    public void deveVerificarSeDeParaMarcaFoiRealizado() {
        Brand brand = brandService.convertBrandGlieseToBrandDataProvider("31");
        assertEquals("1",brand.getIdDataProvider().toString());
    }

    @Test
    public void deveVerificarSeDeParaUnidadeFoiRealizado() {
        Unit unit = unitService.convertUnityGlieseToUnityDataProvider("DAP");
        assertEquals("696",unit.getIdDataProvider().toString());
    }

}
