package Homeworks.WardrobeAndMan;

public abstract class Things {
        private String name;
         private Human owner;

        public Things(String name, Human owner) {
                this.name = name;
                this.owner = owner;
        }



        public String getName() {
                return this.name;
        }

        public Human getOwner() {
                return this.owner;
        }

}
