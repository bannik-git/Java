package Homeworks;

import java.util.ArrayList;


public class GenealogicalTree1 {
    public static void main(String[] args) {

        People alena = new People("Alena", Gender.FEMALE); // мать
        People jenya = new People("Jenya", Gender.MALE); // отец
        People kostya = new People("Kostya", Gender.MALE); // сын

        People alex = new People("Alex", Gender.MALE); // отец Евгения
        People alexandra = new People("Alexandra", Gender.FEMALE); // мать Евгения
        People sveta = new People("Sveta", Gender.FEMALE); // Мать Alena
        People nik = new People("Nik", Gender.MALE); // Отец Alena

        FamilyTree sidorov = new FamilyTree();
        sidorov.add(alena, Relation.MOTHER, kostya);
        sidorov.add(jenya, Relation.FATHER, kostya);

        sidorov.add(alex, Relation.FATHER, jenya);
        sidorov.add(alexandra, Relation.MOTHER, jenya);

        sidorov.add(sveta, Relation.MOTHER, alena);
        sidorov.add(nik, Relation.FATHER, alena);
        Research a = new Research(sidorov);
//        a.printAllChildren();
//        a.printAllWeman();
//        a.printAllMale();
//        a.printAllFathersAndChildren();
//        a.printAllMotherAndChildren();
        a.printAllTree(kostya);

    }

}

class People {
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


enum Gender {
    MALE,
    FEMALE;
}
enum Relation {
    MOTHER,
    FATHER,
    SON,
    DOUGHTER;
}

class FamilyTies { // класс для хранения данных
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

interface Base {
    ArrayList<FamilyTies> getBase();
}

class FamilyTree implements Base {
    private ArrayList<FamilyTies> tree = new ArrayList<>();

    public ArrayList<FamilyTies> getBase() {
        return tree;
    }

    public void add(People p1, Relation re, People p2) {
        if (re == Relation.FATHER || re == Relation.MOTHER) {
            tree.add(new FamilyTies(p1, re, p2));
            addChildren(p1, re, p2);
        } else {
            tree.add(new FamilyTies(p1, re, p2));
            addParent(p1, re, p2);
        }
    }

    private void addChildren(People p1, Relation re, People p2) {
        if(p2.getGender() == Gender.MALE) {
            tree.add(new FamilyTies(p2, Relation.SON, p1));
        } else {
            tree.add(new FamilyTies(p2, Relation.DOUGHTER, p1));
        }
    }

    private void addParent(People p1, Relation re, People p2) {
        if (p1.getGender() == Gender.MALE) {
            tree.add(new FamilyTies(p2, Relation.FATHER, p1));
        } else {
            tree.add(new FamilyTies(p2, Relation.MOTHER, p1));
        }
    }
}

class Research {
    private ArrayList<FamilyTies> base;

    public Research(Base base) {
        this.base = base.getBase();
    }

    private ArrayList<String> getMenOrWeman(Gender gender) {
        ArrayList<String> menOrWeman = new ArrayList<>();
        for (int i = 0; i < base.size(); i++) {
            People checkPeople = base.get(i).getPeople(1);
            if (checkPeople.getGender() == gender && !menOrWeman.contains(checkPeople.getName())) {
                menOrWeman.add(checkPeople.getName());
            }
        }
        return menOrWeman;
    }

    private ArrayList<String> getAllFamilyTies(Relation searchLink) {
        ArrayList<String> familyTies = new ArrayList<>();
        for (int i = 0; i < base.size(); i++) {
            Relation re = base.get(i).getRe();
            if (re == searchLink) {
                familyTies.add(base.get(i).getPeople(1).getName()+ " " + re.toString() + " " + base.get(i).getPeople(2).getName());
            }
        }
        return familyTies;
    }

    private ArrayList<String> getParents() {
        ArrayList<String> parents = new ArrayList<>();
        for (int i = 0; i < base.size();i++) {
            Relation re = base.get(i).getRe();
            if (re == Relation.FATHER || re == Relation.MOTHER) {
                parents.add(base.get(i).getPeople(1).getName()+ " " + re.toString() + " " + base.get(i).getPeople(2).getName());
            }
        }
        return parents;
    }

    public void printAllMale() {
        ArrayList<String> men = getMenOrWeman(Gender.MALE);
        for (String male: men) {
            System.out.println(male);
        }
    }

    public void printAllWeman() {
        ArrayList<String> weman = getMenOrWeman(Gender.FEMALE);
        for (String woman: weman) {
            System.out.println(woman);
        }
    }

    public void printAllFathersAndChildren () {
        ArrayList<String> fathersAndSons = getAllFamilyTies(Relation.FATHER);
        for (String fatherAndSon: fathersAndSons) {
            System.out.println(fatherAndSon);
        }
    }

    public void printAllMotherAndChildren () {
        ArrayList<String> mothersAndSons = getAllFamilyTies(Relation.MOTHER);
        for (String fatherAndSon: mothersAndSons) {
            System.out.println(fatherAndSon);
        }
    }

    public void printAllChildren() {
        ArrayList<String> parentsAndChildrens = getParents();
        for (String parentAndChildren: parentsAndChildrens) {
            System.out.println(parentAndChildren);
        }
    }

    public ArrayList<String> printAllTree(People start) {
        Relation re;
        ArrayList<String> relation = new ArrayList<>();
        if (start.getGender() == Gender.MALE) {
            re = Relation.SON;
        } else {
            re = Relation.DOUGHTER;
        }
        for (int i = 0; i < base.size(); i++) {
            if (base.get(i).getPeople(1) == start && base.get(i).getRe() == re) {
                relation.add(base.get(i).getPeople(2).getName());
                printAllTree(base.get(i).getPeople(2));
                if (relation.size() >= 2) {
                    System.out.print(relation.get(0) + " " + relation.get(1) + " родители " + start.getName());
                    System.out.println();
                }
            }
        }

        return relation;
    }


}







