package blin.ann;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class TestingFormWithPageObject extends TestBase {
    Faker faker = new Faker(new Locale("en-IND"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String fullName = firstName + " " + lastName;
    String userEmail = faker.internet().emailAddress();
    String userAddress = faker.address().streetAddress();
    String userNumber = faker.number().digits(10);

    @Test
    void fillFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .typeGender()
                .streetAddress(userAddress)
                .userNumber(userNumber)
                .typeSubject()
                .typeHobbbies("Reading")
                .setDate("8", "6", "1997")
                .uploadPicture()
                .stateCity("Haryana", "Karnal")
                .submit();
        registrationPage.checkResults("Student Name", fullName)
                .checkResults("Student Email", userEmail)
                .checkResults("Gender", "Male")
                .checkResults("Mobile", userNumber)
                .checkResults("Date of Birth", "8 July,1997")
                .checkResults("Subjects", "Maths")
                .checkResults("Hobbies", "Reading")
                .checkResults("Picture", "22.01.2021.png")
                .checkResults("Address", userAddress)
                .checkResults("State and City", "Haryana Karnal");
    }
}
