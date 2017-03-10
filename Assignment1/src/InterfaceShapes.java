import java.text.DecimalFormat;

public interface InterfaceShapes {

    DecimalFormat df = new DecimalFormat ("0.####");

    interface perimeterCalc {

        double operate();

    }



    double perimeterGet();

    void display();
}
