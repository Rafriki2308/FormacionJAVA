import java.util.Optional;

public class Person {

    private String name;
    private String town;
    private Optional<Integer> age;

    public Person (){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Optional<Integer> getAge() {
        return age;
    }

    public void setAge(Optional<Integer> age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  "Name: " + name +
                ". Town: " + town +
                ". Age: " + age.get();
    }
}
