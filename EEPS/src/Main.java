import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        Grade gd = new Grade("Maneger",10.5,15.5);
        Engineer eng = new Engineer();

        // if you need to test these funcs, test one and comment others ..

        eng.addEngineer("Ahmed ",5,10,15.5, gd);

        //eng.editEngineer("5","5","5","5","5","5");

        //eng.deleteEngineer("5");
    }
}
