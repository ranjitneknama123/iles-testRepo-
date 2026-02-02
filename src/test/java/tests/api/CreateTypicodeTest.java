package tests.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranjit.harmony.client.ApiClient;
import com.ranjit.harmony.constant.Constant;
import com.ranjit.harmony.pojo.*;
import com.ranjit.harmony.steps.InvestmentStep;
import com.ranjit.harmony.utils.CommonUtil;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.instancio.Instancio;
import org.instancio.Model;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.ranjit.harmony.model.ModelProvider.associateDrug2ModelProvider;
import static com.ranjit.harmony.model.ModelProvider.associateDrugModelProvider;
import static org.hamcrest.Matchers.lessThan;

public class CreateTypicodeTest {
    private static InvestmentStep investmentStep = new InvestmentStep();
    private static AssociatedDrug associatedDrugInput;
    private static AssociatedDrug2 associatedDrug2Input;
    private static ApiClient apiClient = new ApiClient();
    private static Model<AssociatedDrug> associatedDrugModelInput;
    private static Model<AssociatedDrug2> associatedDrug2ModelInput;

    @BeforeClass
    public void setUpTestData() {
        associatedDrugModelInput = associateDrugModelProvider();
        associatedDrug2ModelInput = associateDrug2ModelProvider();
    }

    public static String random;

    @Step("Create user API test")
    @Story("POST Create User")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void createTypicodeTest() throws JsonProcessingException {
        associatedDrugInput = Instancio.of(associatedDrugModelInput)
                .create();
        associatedDrug2Input = Instancio.of(associatedDrug2ModelInput)
                .create();


        AssociatedDrug associatedDrug = new AssociatedDrug(associatedDrugInput.getName(), associatedDrugInput.getDose(), associatedDrugInput.getStrength());
        List<AssociatedDrug> associatedDrugList = new ArrayList<>();
        associatedDrugList.add(associatedDrug);

        AssociatedDrug2 associatedDrug2 = new AssociatedDrug2(associatedDrug2Input.getName(), associatedDrug2Input.getDose(), associatedDrug2Input.getStrength());
        List<AssociatedDrug2> associatedDrug2List = new ArrayList<>();
        associatedDrug2List.add(associatedDrug2);

        ClassName className = new ClassName(associatedDrugList, associatedDrug2List);
        List<ClassName> classNames1List = new ArrayList<>();
        classNames1List.add(className);

        ClassName2 className2 = new ClassName2(associatedDrugList, associatedDrug2List);
        List<ClassName2> classNames2List = new ArrayList<>();
        classNames2List.add(className2);

        MedicationsClasses medicationsClasses = new MedicationsClasses(classNames1List, classNames2List);
        List<MedicationsClasses> medicationsClassesList = new ArrayList<>();
        medicationsClassesList.add(medicationsClasses);

        Medication medication = new Medication(medicationsClassesList);
        List<Medication> medicationsList = new ArrayList<>();
        medicationsList.add(medication);

        Labs labs = new Labs("missing_value");
        List<Labs> labList = new ArrayList<>();
        labList.add(labs);

        Diabetes diabetes = new Diabetes(medicationsList);
        List<Diabetes> diabetesList = new ArrayList<>();
        diabetesList.add(diabetes);

        Asthma asthma = new Asthma();
        List<Asthma> asthmaList = new ArrayList<>();
        asthmaList.add(asthma);

        Problems p = new Problems(diabetesList, asthmaList);

        ObjectMapper mapper = new ObjectMapper();
        //String payLoad = mapper.writeValueAsString(p);
        String payLoad = CommonUtil.toJson(p);
        // System.out.println(payLoad);

        //Response response = apiClient.post(endPoint, payLoad);
        Response response = investmentStep.createPost(payLoad);
      /*  Response response = given()
                .contentType(ContentType.JSON)
                .baseUri(base_path)
                .log().all()
                .body(payLoad)
                .when()
                .post(posts)
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .response();*/

        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 201);

        //Deserialization:--> Json to Java Object
        Problems problem = mapper.readValue(response.asString(), Problems.class);
        //Iteration
        diabetesList = problem.getDiabetes();
        for (Diabetes d : diabetesList) {
            medicationsList = d.getMedication();
            for (Medication m : medicationsList) {
                medicationsClassesList = m.getMedicationsClasses();
                for (MedicationsClasses mc : medicationsClassesList) {
                    classNames1List = mc.getClassName();
                    for (ClassName className1 : classNames1List) {
                        associatedDrugList = className1.getAssociatedDrugs();
                        for (AssociatedDrug asd : associatedDrugList) {
                            System.out.println("asd1 name= " + asd.getName());
                            System.out.println("asd1 dose= " + asd.getDose());
                            System.out.println("asd1 strength = " + asd.getStrength());
                            random = asd.getStrength();
                        }
                    }
                    classNames2List = mc.getClassName2();
                    for (ClassName2 cn2 : classNames2List) {
                        associatedDrug2List = cn2.getAssociatedDrugs2();
                        for (AssociatedDrug2 asd2 : associatedDrug2List) {
                            System.out.println("asd2 name= " + asd2.getName());
                            System.out.println("asd2 dose= " + asd2.getDose());
                            System.out.println("asd2 strength= " + asd2.getStrength());
                        }
                    }
                }
            }

        }
        response.then().time(lessThan(Constant.TIME), TimeUnit.SECONDS);
        System.out.println("time=> " + response.getTime());
        System.out.println("Asthma");
        asthmaList = problem.getAsthmas();
        for (Asthma as : asthmaList) {
            System.out.println(as.getStatus());
        }
    }
}
