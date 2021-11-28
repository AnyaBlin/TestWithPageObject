package blin.ann.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;


import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private static final String SUBMIT_TITLE = "Thanks for submitting the form";
    private SelenideElement
            chooseGender = $(".custom-control-label"),
            addressInput = $("#currentAddress"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            chooseHobbies = $("#hobbiesWrapper"),
            dateClick = $("#dateOfBirthInput"),
            uploadPicture = $("#uploadPicture"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input"),
            clickSubmit = $("#submit");

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public RegistrationPage typeFirstName(String firstName) {
        $("#firstName").setValue(firstName);

        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationPage typeEmail(String email) {
        $("#userEmail").setValue(email);

        return this;
    }

    public RegistrationPage typeGender() {
        chooseGender.click();

        return this;
    }

    public RegistrationPage streetAddress(String address) {
        addressInput.setValue(address);

        return this;
    }

    public RegistrationPage userNumber(String number) {
        $("#userNumber").setValue(number);

        return this;
    }

    public RegistrationPage typeSubject() {
        subjectInput.setValue("Maths").pressEnter();

        return this;
    }


    public RegistrationPage typeHobbbies(String value) {
        chooseHobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setDate(String day, String month, String year) {
        dateClick.click();
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $$(".react-datepicker__day").findBy(text(day)).click();

        return this;
    }

    public RegistrationPage uploadPicture() {
        uploadPicture.uploadFile(new File("src/test/resources/22.01.2021.png"));

        return this;
    }

    public RegistrationPage stateCity(String state, String city) {

        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();

        return this;
    }

    public RegistrationPage submit() {
        clickSubmit.scrollTo().click();

        return this;
    }

    public RegistrationPage checkResults(String label, String text) {

        $("#example-modal-sizes-title-lg").should(have(text(SUBMIT_TITLE)));
        $(".table-responsive").$(byText(label)).parent().shouldHave(text(text));

        return this;
    }
}

