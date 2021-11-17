package blin.ann;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestingForm extends TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Ann");
        $("#lastName").setValue("Blini");
        $("#userEmail").setValue("blinchiki@smetana.ru");
        $(By.className("custom-control-label")).click();
        $("#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").click();
        $(By.className("react-datepicker__month-select")).selectOptionByValue("6");
        $(By.className("react-datepicker__year-select")).selectOptionByValue("1997");
        $$(".react-datepicker__day").findBy(Condition.text("8")).click();
        $(By.id("subjectsInput")).setValue("Maths").pressEnter();
        $$(By.id("hobbiesWrapper")).find(Condition.text("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/22.01.2021.png"));
        $("#currentAddress").setValue("Some address");
        $(By.id("react-select-3-input")).setValue("Haryana").pressEnter();
        $(By.id("react-select-4-input")).setValue("Karnal").pressEnter();
        $(byText("Submit")).click();
    }
}
