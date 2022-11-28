package Homeworks.WardrobeAndMan;

import java.util.ArrayList;

public class Human {
    private String name;
    private ArrayList<Things> things = new ArrayList<>();
    public Human(String name) {
        this.name = name;
    }

    public void buyCup(String name) {
        things.add(new Cup(name, Human.this));
    }
    public void buyDecanter(String name) {
        things.add(new Decanter(name, Human.this));
    }
    public void buyVase(String name) {
        things.add(new Vase(name, Human.this));
    }
    public void sell(String name) {
        for (int i = 0; i < things.size(); i++) {
            if (name == things.get(i).getName()) {
                things.remove(i);
            }
        }
    }
    public Things getThing(String name) {
        for (Things thing : things) {
            if (name == thing.getName()) {
                return thing;
            }
        }
        return new Cup(null, Human.this);
    }

}
