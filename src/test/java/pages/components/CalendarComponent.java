package pages.components;


import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {


    public void setDate(String day, String month, String year) {
 int dayInt = Integer.parseInt(day);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + String.format("%02d", dayInt) + ":not(.react-datepicker__day--outside-month)").click();
    }

}