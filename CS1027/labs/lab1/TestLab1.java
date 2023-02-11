package labs.lab1;

public class TestLab1 {

    public static void main(String[] args){

        //declaring a player
        Player p1 = new Player("Hoyeon Luke Jang", "defence", 99);

        //outputting the variables (3.)
        System.out.println("Name: " + p1.getName());
        System.out.println("Position: " + p1.getPosition());
        System.out.println("Jersey Number: " + p1.getJerseyNum());

        //changing the variables (4.)
        p1.setJerseyNum(99);
        p1.setPosition("forward");

        //outputting the variables (5.)
        System.out.println("Name: " + p1.getName());
        System.out.println("Position: " + p1.getPosition());
        System.out.println("Jersey Number: " + p1.getJerseyNum());

        System.out.println(p1);

    }

}
