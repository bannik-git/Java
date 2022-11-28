package Homeworks.WardrobeAndMan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cupboard {
    private Boolean door = false; // false - закрыта, true - открыта

    private Map<Integer, ArrayList<Things>> thingsOnTheShelf = new HashMap<>(); // хранение вещей на полке

    public Cupboard(){

    }

    public void openDoor() {
        if (!door) {
            this.door = !door;
        } else {
            System.out.println("Дверь открыта");
        }
    }
    public void closeDoor() {
        if (door) {
            this.door = !door;
        } else {
            System.out.println("Дверь закрыта");
        }
    }
     public String getStatusDoor() {
        if (door) {
            return "Дверь открыта";
        }
        return "Дверь закрыта";
     }

    public void putThing(int numberShelfs, Things name) {
        if(door) {
            ArrayList<Things> things = new ArrayList<>();
            things.add(name);
            thingsOnTheShelf.put(numberShelfs, things);
        }

    }

    public void pickUpThing(int numberShelfs, Things name) {
        if (door) {
            ArrayList<Things> things =  thingsOnTheShelf.get(numberShelfs);
            for (int i = 0; i < things.size(); i++) {
                if (things.get(i).getName() == name.getName()) {
                    things.remove(i);
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < thingsOnTheShelf.size(); i++) {
            System.out.println("Полка" + " " + (i + 1));
            ArrayList<Things> things = thingsOnTheShelf.get(i + 1);
            for (int j = 0; j < things.size(); j++) {
                System.out.print(things.get(j).getName() + " ");
            }
            System.out.println();
        }
    }
}