package Homeworks.GenealogicalTree;

import java.util.ArrayList;


public class GenealogicalTree {
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








