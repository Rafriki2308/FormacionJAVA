package com.bosonit.ej6.pathvariableheaders.Repository;

import com.bosonit.ej6.pathvariableheaders.Model.Greeting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GreetingRepository {

    private static List<Greeting> greetingList = new ArrayList<>();

    public String addGreeting(Greeting greeting){
        greetingList.add(greeting);
        return "Saludo añadido";
    }

    public Greeting getGreetingById(int id){

        return greetingList.get(id -1);
    }

    public Greeting modifyGreetingById(int val1, String val2){
        Greeting greeting = this.getGreetingById(val1);
        greeting.setContent(val2);
        greetingList.set(val1-1,greeting);
        return greeting;
    }

}
