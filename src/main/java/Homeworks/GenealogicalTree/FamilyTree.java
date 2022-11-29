package Homeworks.GenealogicalTree;

import java.util.ArrayList;

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

