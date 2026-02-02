import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranjit.harmony.pojo.Book;
import com.ranjit.harmony.pojo.Category;
import com.ranjit.harmony.pojo.Pet;
import com.ranjit.harmony.pojo.Tag;
import io.cucumber.java.it.Ma;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateUserTest {


    @Test(enabled = false)
    public void createTestUser() throws JsonProcessingException {

        Book b1 = new Book("Java", "Nataraj", 100);
        Book b2 = new Book("C++", "Alon Musk", 201);
        Book b3 = new Book("python", "Trump", 301);

        List<Book> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        ObjectMapper mapper = new ObjectMapper();
        String listJson = mapper.writeValueAsString(list);

        Response response = given()
                .baseUri("https://postman-echo.com")
                .body(listJson)
                //.log().all()
                .when()
                .post("/post")
                .then()
                //.log().all()
                .statusCode(200)
                .extract()
                .response();
        String title = response.jsonPath().getString("json[0].title");
        System.out.println(title);

    }

    @Test
    public void createPetStore() throws JsonProcessingException {
        Category category = new Category(3, "Bannu");

        Tag tag = new Tag(123, "newtag");

        Pet pet = new Pet();
        pet.setId(10000000001L);
        pet.setCategory(category);
        pet.setName("doggie");
        pet.setPhotoUrls(List.of("oldone"));
        pet.setTags(List.of(tag));
        pet.setStatus("available");

        ObjectMapper mapper = new ObjectMapper();

        String jsonPayload = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(pet);

        Response response=given()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .post("/pet")
                .then()
                .extract()
                .response();
        /*String restring=response.asString();
        Pet pet1=mapper.readValue(restring, Pet.class);
        System.out.println(pet1.getId());*/
        System.out.println(response.asPrettyString());
        JsonPath jsonPath = response.jsonPath();
        System.out.println("===========");
        String name=jsonPath.get("name");
        System.out.println(name);
        System.out.println("--deserialization=====");
        //Deserilization
        Pet pet1=mapper.readValue(response.asString(), Pet.class);
        System.out.println(pet1.getCategory().getId());
        List<String> photoList = pet.getPhotoUrls();
        for(String pt:photoList){
            System.out.println("pt= "+pt);

        }
        for(Tag t1:pet1.getTags()){
            System.out.println(t1.getId());
            System.out.println(t1.getName());
            Assert.assertEquals(t1.getName(),"newtag");
        }


    }
}
