package br.com.dasa.mirror.api.service;


import br.com.dasa.mirror.api.enumeration.*;
import br.com.dasa.mirror.api.model.*;
import br.com.dasa.mirror.api.service.impl.MedicalOrderServiceImpl;
import io.restassured.RestAssured;

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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = {"test"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicalOrderServiceTest {

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

    @Autowired
    private MedicalOrderServiceImpl medicalOrderService;


    @Before
    public void setUp(){

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

        criaAdmissao();
        criaMedicalOrders();


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

    public void criaMedicalOrders(){
        examsMedicalOrders = new Exams("",listAdditionalProperties, "CODADMISSION","26.00", "2019-11-26T16:57:42.396Z",  "Gel", "ADMISSION GEL", Status.PENDENTE,"312321");
        listExamsMedicalOrders.add(examsMedicalOrders);

        responseMedicalOrders = new ResponseMedicalOrders("1f2fb6df-539f-4c74-a615-a199d96c841c","123",listExamsMedicalOrders);
        listResponseMedicalOrders.add(responseMedicalOrders);
    }

    @Test
    public void deveVerificarSeDeParaUnidadeFoiRealizado() {
        List<ResponseMedicalOrders> responseMedicalOrders = medicalOrderService.atualizaListaDeExamesMedicalOrders(admmissao, listResponseMedicalOrders);
        assertEquals("CODEMIRROR", responseMedicalOrders.get(0).getExams().get(0).getExamCode());
        assertEquals("13.00", responseMedicalOrders.get(0).getExams().get(0).getPrice());
    }

}
