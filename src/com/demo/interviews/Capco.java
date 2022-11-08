package com.demo.interviews;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

public class Capco {
    public static void main(String[] args) {

    }
}

/*
@Data
@NoAragsConstructor
@AllAragsConstructor
class Person {
    private String name;
    private int age;

    private Date dob;


    //java8
    public List<String> getName()(List<Person> personList) {
        List<String> result = new ArrayList<String>();

        //checks for the null
        if(Objects.isNull(personList)){return null;}

        result =  personList.stream().filter(p-> p.getAge() > 13 && p.getAge() < 19).map(p -> p.getName()).collect(Collectors.toList());
        return Collections.sort(result);
    }

}
 */

/*
 * Create a Person class with following attributes and method
 * Attributes: Name, Age, DateOfBirth
 * Method: getName() -
 * Return the List of Persons name who are teenagers.
public List<String> getName()(List<Person> personList) {
}

Checked - IO, File
Unchecked - ArrayIndexOutOfBoundException

//
public class SubscriptionNotFoundException extends Exception { } -

//
public class Service {

//    Autowired repository
//    repo , service

    public Subscription update(Subscription subscription) throws SubscriptionNotFoundException {
        try {
            Optional<Subscription> sub =  service.findByname(subscription.getName());
            if(sub.isPresent()) {
                repo.update(subscription);
            }
            return sub;
        }
        catch (SubscriptionNotFoundException s) {
            new SubscriptionNotFoundException(1055,"Subscription Not Found in DB");
        }
    }
}

 completablefutures

 Java 8 - features
 Multithreading
 completablefeatures

*/