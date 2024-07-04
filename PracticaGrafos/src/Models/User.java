package Models;
import java.util.List;

public class User extends NodeGraph<User> {
    private String name;
    private int age;
    private List<String> interests;

    public User(String name, int age, List<String> interests) {
        super(null);   
        this.name = name;
        this.age = age;
        this.interests = interests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
    
}

    