package ru.sapteh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String lastName;
    private String firstName;
    private String patronomic;
    private Date date;
    private String days;
    private int year;


    public Person(String lastName, String firstName, String patronomic, Date date, int year, String days){
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronomic = patronomic;
        this.date = date;
        this.days = days;
        this.year = year;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronomic() {
        return patronomic;
    }

    public Date getDate() {
        return date;
    }
    public String getDays() {
        return days;
    }

//    public int GetQuantityDays(){
//        return (int)(( getDate().getTime()- getDate().getTime())/1000/24/60/60) ;


    public int getYear() {
        return year;
    }
    @Override
    public String toString() {
        return String.format(" %s %s %s %s %s %s   \n",
                getLastName(),getFirstName(),getPatronomic(),
                new SimpleDateFormat("dd.MM.yyyy").format(getDate()),getYear(),getDays());
    }
}
