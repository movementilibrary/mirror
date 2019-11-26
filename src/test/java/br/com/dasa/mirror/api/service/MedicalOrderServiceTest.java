//package br.com.dasa.mirror.api.service;
//
//
//import br.com.dasa.mirror.api.enumeration.AdmissionStatus;
//import br.com.dasa.mirror.api.enumeration.PaymentMethod;
//import br.com.dasa.mirror.api.enumeration.PaymentType;
//import br.com.dasa.mirror.api.model.*;
//import br.com.dasa.mirror.api.service.impl.MedicalOrderService;
//import io.restassured.RestAssured;
//
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles(value = {"test"})
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class MedicalOrderServiceTest {
//
//    @LocalServerPort
//    int port;
//
//
//    private MedicalOrders medicalOrders;
//    private Patient paciente;
//    private Admission admmissao;
//    private Payments payment;
//    private AdditionalProperties additionalProperties;
//    private Questions question;
//
//    private Doctor doctor;
//    private Exams exams;
//    private Exams examsMedicalOrders;
//    private Questions questions;
//    private Scheduling scheduling;
//    private List<AdditionalProperties> listAdditionalProperties;
//    private List<Payments> listPaymets;
//    private List<Questions> listQuestions;
//    private List<Exams> listExams;
//    private List<MedicalOrders> listMedicalOrders;
//    private List<Exams> listExamsMedicalOrders;
//
//    @Autowired
//    private MedicalOrderService medicalOrderService;
//
//
//    @Before
//    public void setUp(){
//
//        RestAssured.baseURI = "http://localhost";
//        RestAssured.port = port;
//
//        listAdditionalProperties = new ArrayList();
//        listPaymets = new ArrayList();
//        listQuestions = new ArrayList<>();
//        listExams = new ArrayList<>();
//        listExamsMedicalOrders = new ArrayList<>();
//        listMedicalOrders = new ArrayList<>();
//
//        additionalProperties = new AdditionalProperties("","");
//        listAdditionalProperties.add(additionalProperties);
//
//        paciente = new Patient("123456689", "888", "");
//        doctor = new Doctor("SP-CRM-111110", "SP-CRM-11111", "SP-CRM-111110");
//        scheduling = new Scheduling("2019-12-01", listAdditionalProperties, "");
//
//        exams = new Exams(listAdditionalProperties,
//                "H1 EDTA 4 ML",
//                "",
//                "DEL",
//                "DA-KSA",
//                "Medicamento",
//                "825646627301",
//                "0",
//                "123456789");
//        listExams.add(exams);
//
//        question = new Questions("Está de Jejum", "1", listAdditionalProperties, "");
//        listQuestions.add(question);
//
//        payment = new Payments(PaymentMethod.CREDIT_CARD, listAdditionalProperties, PaymentType.PRIVATE, "200.00", "8ead6445-ed38-4aac-b91d-35a63d9eedcb", "");
//        listPaymets.add(payment);
//
//
//        admmissao = new Admission("DDIG",
//                "DPI",
//                "13",
//                "",
//                "8a2f05d0-104a-48a7-94d9-6d2d06516fe4",
//                AdmissionStatus.ADMISSION,
//                "32",
//                listPaymets,
//                listQuestions,
//                scheduling,
//                listMedicalOrders);
//    }
//        examsMedicalOrders ;
//    listExamsMedicalOrders.
//
//        medicalOrders = new MedicalOrders("CRM", "123", "SP", "f7ac9c4e-d0f5-406a-adc7-b0543fe0aa9c",listExamsMedicalOrders);
//        listMedicalOrders.add(medicalOrders);
//    }
//
//
//}
