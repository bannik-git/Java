package Homeworks.GenealogicalTree;

import java.util.ArrayList;

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