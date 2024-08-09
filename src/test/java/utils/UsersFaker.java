package utils;


import com.github.javafaker.Faker;

import java.util.Locale;

public class UsersFaker {
    public  Faker faker = new Faker(new Locale("en-GB"));

    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String userEmail = faker.internet().emailAddress();
    public final String userGender = faker.options().option("Male", "Female", "Other");
    public final String phoneNumber = faker.number().digits(10);
    public final String wrongPhoneNumber = faker.number().digits(9);


    public final  String subjects = faker.options().option(
            "Maths", "Accounting", "Arts", "Social Studies",
            "Biology", "Physics", "Chemistry", "Computer Science", "Commerce",
            "Economics", "Civics", "Hindi", "English", "History");
    public final String hobbies = faker.options().option("Sports", "Reading", "Music");
    public final String imageName = faker.options().option("image1.jpg", "image2.jpg", "image3.jpg");
    public final String adress = String.valueOf(faker.address());
    public final String adressPermanent = String.valueOf(faker.address());
    public final String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public final String city = chooseCity();
    public final String yearOfBDay = Integer.toString(faker.number().numberBetween(1900, 2024));
    public final String monthOfBDay = faker.options().option(
            "January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December");
    //public final String dayOfBDay = Integer.toString(chooseDay());
    public final int dayOfBDay = chooseDay();
    public final String dayOfBDayFormated = String.format("%02d", dayOfBDay);
    public final int chooseDay() {
        if (monthOfBDay.equals("February")) {
            return faker.number().numberBetween(1, 28);
        } else if (monthOfBDay.equals("April") || monthOfBDay.equals("June")
                || monthOfBDay.equals("September") || monthOfBDay.equals("November")) {
            return faker.number().numberBetween(1, 30);
        } else {
            return faker.number().numberBetween(1, 31);
        }
    }

    public final String chooseCity() {
        if (state.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (state.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (state.equals("Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        } else {
            return faker.options().option("Jaipur", "Jaipur");
        }
    }
}
