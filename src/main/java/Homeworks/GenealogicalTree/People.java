package Homeworks.GenealogicalTree;

public class People {
    private String name;
    private Gender gender;

    public People(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }
}
