import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FillFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulFillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Volodin");
        $("#userEmail").setValue("lex@test.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("11");
        $(".react-datepicker__year-select").selectOptionByValue("1989");
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#subjectsInput").setValue("ph").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("image.jpg");
        $("#currentAddress").setValue("Lenina Street, 1a");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Jaiselmer")).click();
        $("#submit").click();

        $(".table").shouldHave(text("Student Name Alexander Volodin"));
        $(".table").shouldHave(text("Student Email lex@test.ru"));
        $(".table").shouldHave(text("Gender Male"));
        $(".table").shouldHave(text("Mobile 7123456789"));
        $(".table").shouldHave(text("Date of Birth 15 December,1989"));
        $(".table").shouldHave(text("Subjects Chemistry, Physics"));
        $(".table").shouldHave(text("Hobbies 	Sports, Music"));
        $(".table").shouldHave(text("Picture image.jpg"));
        $(".table").shouldHave(text("Address Lenina Street, 1a"));
        $(".table").shouldHave(text("State and City Rajasthan Jaiselmer"));

    }
}
