package com.demo.interviews;


import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TEST4 {
    public static void main(String[] args) {

        /*
        String s1 = "TARGET";
        String s2 = "MARKETO".concat(";").concat(s1);
        String s3 = "MAGENTO".concat(";").concat(s2);
        String s4 = "CCE STOCK".concat(";").concat(s3);
        String s5 = "ANALYTICS".concat(";").concat(s4);

        System.out.println(s5);
        System.out.println("-----------");
        */

        String s6 = "TARGET;ANALYTICS;MAGENTO;CCE STOCK;MARKETO;";

        String[] arr = s6.split(";");
        Arrays.sort(arr);
        s6 = String.join(";", arr);
        System.out.println(s6);

    }
}


/*
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.Date;

// Assuming you have a Hibernate Session instance named session

Date startDate = ... // Your start date
Date endDate = ...   // Your end date

Criteria criteria = session.createCriteria(YourEntity.class);

criteria.add(Restrictions.between("dateColumn", startDate, endDate));

List<YourEntity> resultList = criteria.list();


In this example:

YourEntity.class should be replaced with the actual class representing the entity in Hibernate.
"dateColumn" should be replaced with the name of the date column in your entity.
startDate and endDate should be java.util.Date objects representing the start and end dates of your range.
This Criteria Query will retrieve all entities where the date in the specified column (dateColumn) falls within the given range.

Make sure to handle the exceptions that may be thrown, such as HibernateException and ParseException if you're parsing dates from strings.

If you're using a different ORM or have specific requirements, please let me know, and I'll provide more tailored guidance.


*/