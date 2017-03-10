
public class Circle implements InterfaceShapes {

    private double radius, diameter, perimeter;

    public Circle(double r){

        radius = r;
        diameter = (radius*2);
        perimeter = 0;
        perimCalc.operate();

    }


    public interface perimeterCalc {

        double operate();
    }

    perimeterCalc perimCalc = () -> perimeter = (Math.PI * diameter);

    @Override public double perimeterGet() {return perimeter;}
    @Override public int hashCode(){

        int hash = 0;

        hash += radius + diameter + perimeter;
        return hash;

    }

    @Override public String toString(){

         return this.getClass().getSimpleName();

    }

    @Override public boolean equals(Object obj){

        if(this.hashCode() == obj.hashCode()){

            return true;
        }
         if(obj == null || this != obj){
             return false;
         }
         return false;
    }

    @Override public void display() {


        System.out.println("Circle (Radius = "  + df.format(radius) + ") (Perimeter = " + df.format(perimeter) + ")");
    }
}
