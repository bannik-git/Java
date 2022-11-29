package Homeworks.GenealogicalTree;

public class FamilyTies {
    private People people1;
    private Relation re;
    private People people2;

    public FamilyTies(People p1, Relation re, People p2) {
        this.people1 = p1;
        this.re = re;
        this.people2 = p2;
    }

    @Override
    public String toString() {
        return String.format("s% s% s%", people1.getName(), re, people2.getName());
    }

    public Relation getRe() {
        return this.re;
    }

    public People getPeople(int i) {
        if (i == 1) {
            return this.people1;
        }
        return this.people2;
    }


}
