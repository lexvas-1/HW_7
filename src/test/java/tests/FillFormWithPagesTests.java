package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


class FillFormWithPagesTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void successfulFillFormTest() {

        registrationPage.openPage()
                .removeBan()
                .setFirstName("Alexander")
                .setLastName("Volodin")
                .setEmail("lex@test.ru")
                .setGender("Male")
                .setUserNumber("7123456789")
                .setDateOfBirth("14", "11", "1989")
                .setSubjects("Chemistry")
                .setHobbies("Sports")
                .setImage("image.jpg")
                .setAdress("Lenina Street, 1a")
                .setState("Rajasthan")
                .setCity("Jaiselmer")

                .submit()

                .checkResult("Student Name Alexander Volodin")
                .checkResult("Student Email lex@test.ru")
                .checkResult("Gender Male")
                .checkResult("Mobile 7123456789")
                .checkResult("Date of Birth 14 December,1989")
                .checkResult("Subjects Chemistry")
                .checkResult("Hobbies 	Sports")
                .checkResult("Picture image.jpg")
                .checkResult("Address Lenina Street, 1a")
                .checkResult("State and City Rajasthan Jaiselmer");

    }

    @Test
    void genderValidateFillFormTest() {

        registrationPage.openPage()
                .removeBan()
                .setFirstName("Alexander")
                .setLastName("Volodin")


                .submit()

                .checkValidateGender(registrationPage.redText);


    }

    @Test
    void minimumFormSucsessfullFillFormTest() {

        registrationPage.openPage()
                .removeBan()
                .setFirstName("Alexander")
                .setLastName("Volodin")
                .setGender("Male")
                .setUserNumber("1234567890")

                .submit()

                .checkResult("Student Name Alexander Volodin")
                .checkResult("Gender Male")
                .checkResult("Mobile 1234567890");


    }

    @Test
    void validatePhoneNumberTest() {

        registrationPage.openPage()
                .removeBan()
                .setFirstName("Alexander")
                .setLastName("Volodin")
                .setGender("Male")
                .setUserNumber("123456789")

                .submit()

                .checkValidatePhoneNumber(registrationPage.redText);


    }
}
