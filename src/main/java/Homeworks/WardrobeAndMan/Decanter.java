package Homeworks.WardrobeAndMan;

public class Decanter extends  Things{

    private Boolean fullOrEmpty = false;
    public Decanter(String name, Human owner) {
        super(name, owner);
    }

    public void pour() {
        if (!fullOrEmpty) {
            fullOrEmpty = !fullOrEmpty;
        } else {
            System.out.println("Графин полон");
        }
    }

    public void pourOut() {
        if (fullOrEmpty) {
            fullOrEmpty = !fullOrEmpty;
        } else {
            System.out.println("Графин пуст");
        }
    }


}
