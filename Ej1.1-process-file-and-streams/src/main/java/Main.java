import java.io.FileNotFoundException;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        ReadWrite rw = new ReadWrite();
        String path = "./File.txt";

        try {
            //Get a full list of people

            List<Person> people = rw.getListPeopleFromFile(path);

            //Get a list of people who are under 25 years old
            int age = 25;
            List<Person> listFilteredPeopleByAge = rw.filterPeopleByAge(people, age);

            //Get a list of people who name don't begin by A
            String index = "A";
            List<Person> listFilteredPeopleByName = rw.filterPeopleByName(people, index);


            //Get the first person who lives in Madrid
            String town = "Madrid";
            List<Person> listFilteredPeopleByTown = rw.filterPeopleByTown(people, town);

            //Get the first person who lives in Barcelona
            String town2 = "Barcelona";
            List<Person> listFilteredPeopleByTown2 = rw.filterPeopleByTown(people, town2);


            rw.PrintList(listFilteredPeopleByName);

        } catch (FileNotFoundException | InvalidLineFormatException e) {
            System.out.println("Uppps, nos hemos encontrado una linea inválida en el archivo");
            e.printStackTrace();
        }

    }
}
