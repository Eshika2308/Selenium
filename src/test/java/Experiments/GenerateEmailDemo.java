package Experiments;

import java.util.Date;

public class GenerateEmailDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        String dateString =  date.toString();
        String noColonDate = dateString.replaceAll(":","");
        System.out.println(noColonDate);
         String noColonnospace = noColonDate.replaceAll(" ","");
        System.out.println(noColonnospace);
        String emailWithTimeStamp = noColonnospace+"@gmail.com";
        System.out.println(emailWithTimeStamp);

        //String emailWithTimeStamp= date.toString().replaceAll(":","").replaceAll(" ","")+"@gmail.com";;

    }
}
