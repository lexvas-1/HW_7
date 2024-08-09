package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.UsersFaker;

class FillFormWithPagesTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    UsersFaker usersFaker = new UsersFaker();

    @Test
    void successfulFillFormTest() {


        registrationPage.openPage()
                .removeBan()
                .setFirstName(usersFaker.firstName)
                .setLastName(usersFaker.lastName)
                .setEmail(usersFaker.userEmail)
                .setGender(usersFaker.userGender)
                .setUserNumber(usersFaker.phoneNumber)
                .setDateOfBirth(usersFaker.dayOfBDayFormated, usersFaker.monthOfBDay, usersFaker.yearOfBDay)
                .setSubjects(usersFaker.subjects)
                .setHobbies(usersFaker.hobbies)
                .setImage(usersFaker.imageName)
                .setAdress(usersFaker.adress)
                .setState(usersFaker.state)
                .setCity(usersFaker.city)

                .submit()

                .checkResult("Student Name " + usersFaker.firstName + " " + usersFaker.lastName)
                .checkResult("Student Email " + usersFaker.userEmail)
                .checkResult("Gender " + usersFaker.userGender)
                .checkResult("Mobile " + usersFaker.phoneNumber)
                .checkResult(
                        "Date of Birth " + usersFaker.dayOfBDayFormated + " "
                                + usersFaker.monthOfBDay + "," + usersFaker.yearOfBDay)
                .checkResult("Subjects " + usersFaker.subjects)
                .checkResult("Hobbies " + usersFaker.hobbies)
                .checkResult("Picture " + usersFaker.imageName)
                .checkResult("Address " + usersFaker.adress)
                .checkResult("State and City " + usersFaker.state + " " + usersFaker.city);

    }

    @Test
    void genderValidateFillFormTest() {

        registrationPage.openPage()
                .removeBan()
                .setFirstName(usersFaker.firstName)
                .setLastName(usersFaker.lastName)


                .submit()

                .checkValidateGender(registrationPage.redText);


    }

    @Test
    void minimumFormSucsessfullFillFormTest() {

        registrationPage.openPage()
                .removeBan()
                .setFirstName(usersFaker.firstName)
                .setLastName(usersFaker.lastName)
                .setGender(usersFaker.userGender)
                .setUserNumber(usersFaker.phoneNumber)

                .submit()

                .checkResult("Student Name " + usersFaker.firstName + " " + usersFaker.lastName)
                .checkResult("Gender " + usersFaker.userGender)
                .checkResult("Mobile " + usersFaker.phoneNumber);


    }

    @Test
    void validatePhoneNumberTest() {

        registrationPage.openPage()
                .removeBan()
                .setFirstName(usersFaker.firstName)
                .setLastName(usersFaker.lastName)
                .setGender(usersFaker.userGender)
                .setUserNumber(usersFaker.wrongPhoneNumber)


                .submit()

                .checkValidatePhoneNumber(registrationPage.redText);


    }
}
