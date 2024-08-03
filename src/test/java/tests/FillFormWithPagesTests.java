package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.UsersFaker;

class FillFormWithPagesTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    UsersFaker usersFaker;

    @Test
    void successfulFillFormTest() {


        registrationPage.openPage()
                .removeBan()
                .setFirstName(UsersFaker.firstName)
                .setLastName(UsersFaker.lastName)
                .setEmail(UsersFaker.userEmail)
                .setGender(UsersFaker.userGender)
                .setUserNumber(UsersFaker.phoneNumber)
                .setDateOfBirth(UsersFaker.dayOfBDay, UsersFaker.monthOfBDay, UsersFaker.yearOfBDay)
                .setSubjects(UsersFaker.subjects)
                .setHobbies(UsersFaker.hobbies)
                .setImage(UsersFaker.imageName)
                .setAdress(UsersFaker.adress)
                .setState(UsersFaker.state)
                .setCity(UsersFaker.city)

                .submit()

                .checkResult("Student Name " + UsersFaker.firstName + " " + UsersFaker.lastName)
                .checkResult("Student Email " + UsersFaker.userEmail)
                .checkResult("Gender " + UsersFaker.userGender)
                .checkResult("Mobile " + UsersFaker.phoneNumber)
                .checkResult(
                        "Date of Birth " + UsersFaker.dayOfBDay + " "
                                + UsersFaker.monthOfBDay + "," + UsersFaker.yearOfBDay)
                .checkResult("Subjects " + UsersFaker.subjects)
                .checkResult("Hobbies " + UsersFaker.hobbies)
                .checkResult("Picture " + UsersFaker.imageName)
                .checkResult("Address " + UsersFaker.adress)
                .checkResult("State and City " + UsersFaker.state + " " + UsersFaker.city);

    }

    @Test
    void genderValidateFillFormTest() {

        registrationPage.openPage()
                .removeBan()
                .setFirstName(UsersFaker.firstName)
                .setLastName(UsersFaker.lastName)


                .submit()

                .checkValidateGender(registrationPage.redText);


    }

    @Test
    void minimumFormSucsessfullFillFormTest() {

        registrationPage.openPage()
                .removeBan()
                .setFirstName(UsersFaker.firstName)
                .setLastName(UsersFaker.lastName)
                .setGender(UsersFaker.userGender)
                .setUserNumber(UsersFaker.phoneNumber)

                .submit()

                .checkResult("Student Name " + UsersFaker.firstName + " " + UsersFaker.lastName)
                .checkResult("Gender " + UsersFaker.userGender)
                .checkResult("Mobile " + UsersFaker.phoneNumber);


    }

    @Test
    void validatePhoneNumberTest() {

        registrationPage.openPage()
                .removeBan()
                .setFirstName(UsersFaker.firstName)
                .setLastName(UsersFaker.lastName)
                .setGender(UsersFaker.userGender)
                .setUserNumber(UsersFaker.wrongPhoneNumber)


                .submit()

                .checkValidatePhoneNumber(registrationPage.redText);


    }
}
