//package br.com.dasa.mirror.api.service;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.equalTo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import br.com.dasa.mirror.api.model.AdditionalProperties;
//import br.com.dasa.mirror.api.model.Admission;
//import br.com.dasa.mirror.api.model.Doctor;
//import br.com.dasa.mirror.api.model.Exams;
//import br.com.dasa.mirror.api.model.Patient;
//import br.com.dasa.mirror.api.model.Payments;
//import br.com.dasa.mirror.api.model.Questions;
//import br.com.dasa.mirror.api.model.Scheduling;
//import io.restassured.RestAssured;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles(value = { "test" })
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class AdmissionControllerTest {
//
//	@LocalServerPort
//	int port;
//	private Patient paciente;
//	private Admission admmissao;
//	private Payments payment;
//	private AdditionalProperties additionalProperties;
//	private Questions question;
//	private Orders order;
//	private Doctor doctor;
//	private Exams exams;
//	private Scheduling scheduling;
//	private List<AdditionalProperties> listAdditionalProperties;
//	private List<Payments> listPaymets;
//	private List<Questions> listQuestions;
//	private List<Orders> listOrders;
//	private List<Exams> listExams;
//
//	@Before
//	public void setUp() {
//
//		RestAssured.baseURI = "http://localhost";
//		RestAssured.port = port;
//
//		listAdditionalProperties = new ArrayList<>();
//		listPaymets = new ArrayList<>();
//		listQuestions = new ArrayList<>();
//		listOrders = new ArrayList<>();
//		listExams = new ArrayList<>();
//
//		additionalProperties = new AdditionalProperties("", "");
//		listAdditionalProperties.add(additionalProperties);
//
//		paciente = new Patient("123456689", "888", "");
//		doctor = new Doctor("SP-CRM-111110", "SP-CRM-11111", "SP-CRM-111110");
//		scheduling = new Scheduling("", "");
//
//		exams = new Exams("12092019", "H1 EDTA 4 ML", "", "DEL", "DA-KSA", listAdditionalProperties, "825646627301",
//				"0", "123456789");
//		listExams.add(exams);
//
//		question = new Questions("", "", listAdditionalProperties);
//		listQuestions.add(question);
//
//		payment = new Payments("9", listAdditionalProperties, "Balcao", "200.00", "");
//		listPaymets.add(payment);
//
//		order = new Orders(doctor, listExams);
//		listOrders.add(order);
//
//	//	admmissao = new Admission("51", "", paciente, listPaymets, listQuestions, "JAM", listOrders, scheduling);
//	}
//
//	@Test
//	public void deveVerificarSeDeParaMarcaFoiRealizado() {
//		given().contentType("application/json").body(admmissao).when().post("/admission/consumer").then()
//				.statusCode(200).body("brandId", equalTo("8"));
//	}
//
//	@Test
//	public void deveVerificarSeDeParaUnidadeFoiRealizado() {
//		given().contentType("application/json").body(admmissao).when().post("/admission/consumer").then()
//				.statusCode(200).body("unitId", equalTo("636"));
//	}
//
//}
