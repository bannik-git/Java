package Homeworks.WardrobeAndMan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WardrobeAndMan {
    public static void main(String[] args) {
    Human nik = new Human("Nik");
    nik.buyCup("cup1");
    nik.buyDecanter("decanter1");
    nik.buyVase("vase1");
//        System.out.println();
    Cupboard cupboard = new Cupboard();
    cupboard.openDoor();
//        System.out.println(cupboard.getStatusDoor());
    cupboard.putThing(1, nik.getThing("cup1"));
    cupboard.putThing(2, nik.getThing("decanter1"));
    cupboard.putThing(3, nik.getThing("vase1"));
    cupboard.print();
    cupboard.pickUpThing(2, nik.getThing("decanter1"));
    cupboard.print();
    }


}





