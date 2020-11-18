package ru.sapteh;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);

        File file = new File("Student.txt");
        file.createNewFile();
        ArrayList<Person> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            while (reader.ready()) {
                Person person = getPerson(reader.readLine());
                list.add(person);
            }
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите данные");
         String write = reader.readLine();
        FileWriter fw = new FileWriter(file);
        Person person = getPerson(write);
        list.add(person);
        for (Person person1 : list) {
            fw.write(person1.toString());
        }
        fw.close();
    }
    public static Person getPerson(String stringLine) throws ParseException {
        String[] strPerson = stringLine.split(" ");
        String lastname = strPerson[0];
        String firstname = strPerson[1];
        String patronomic = strPerson[2];
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(strPerson[3].replaceAll("\\p{Punct}","."));
        int year = (int)(( new Date().getTime()- date.getTime())/1000/24/60/60/30/12) ;
       // int days = (int)(( Date.getTime()- date.getTime())/1000/24/60/60) ;
        String days = String.format("%ta",date);
        return new Person( lastname, firstname, patronomic, date,year,days);
    }
}
