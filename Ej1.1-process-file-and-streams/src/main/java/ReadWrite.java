import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ReadWrite {

    public List<Person> getListPeopleFromFile(String path) throws FileNotFoundException, InvalidLineFormatException {

        List<Person> peopleList = new ArrayList<>();

        File f = new File(path);
        Scanner sc = new Scanner(f);

        while(sc.hasNextLine()){
            String s = sc.nextLine();
            //Esta zona comprueba que las lineas no esten vacias, que esten separadas por dos puntos y
            //que exista un nombre
            if(s.isEmpty() || !s.contains(":") || !s.matches("^[A-Z]"))
                throw new InvalidLineFormatException("Formato Inválido");
            String[] personString = s.split(":");
            Person p = new Person();

            p.setName(personString[0]);
            p.setTown((personString[1]));
            p.setAge(personString.length > 2 ?
                    Optional.of(Integer.parseInt(personString[2]))
                    : Optional.of(0));

            peopleList.add(p);
        }

        return peopleList;
    }

    public List<Person> filterPeopleByAge(List<Person> people, int age){

        Stream<Person> st = people.stream();
        List<Person> filteredPeople = st.filter(p-> p.getAge().get() < age)
                .filter(p-> p.getAge().get() > 0)
                .map(p-> {
                    if(p.getTown().isEmpty())
                        p.setTown("Unknown");
                    p.setTown(p.getTown());
                    return p;
                })
                .collect(toList());
        return filteredPeople;
    }

    public List<Person> filterPeopleByName(List<Person> people, String index){

        Stream<Person> st = people.stream();
        List<Person> filteredPeople = st.filter(p-> !(p.getName().startsWith(index)))
                .map(p->{
                    if(p.getTown().isEmpty())
                        p.setTown("Unknown");
                    p.setTown(p.getTown());
                    return p;
                })
                .collect(toList());
        return filteredPeople;
    }



    public List<Person> filterPeopleByTown(List<Person> people, String town){

        Stream<Person> st = people.stream();
        List<Person> filteredPeople = st.filter(p-> p.getTown().contains(town))
                .filter(p-> p.getAge().get() > 0)
                .map(p->{p.setName(p.getName());
                    return p;
                })
                .limit(1)
                .collect(toList());
        return filteredPeople;
    }

    public Boolean PrintList(List<Person> people){
        for (Person p : people) {
            System.out.println("Name: " + p.getName() +
                    ". Town: " + p.getTown() +
                    ". Age: " + p.getAge().get());
        }
        return true;
    }



}
