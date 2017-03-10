
public class Triangle implements InterfaceShapes{

    private double sideA, sideB, sideC, perimeter;


    public Triangle(double a, double b, double c){

      sideA = a;
      sideB = b;
      sideC = c;
      perimeter = 0;
      perimCalc.operate();

    }


    public interface perimeterCalc {

        double operate();
    }

    perimeterCalc perimCalc = () -> perimeter = sideA + sideB + sideC;

    @Override public double perimeterGet() {return perimeter;}
    @Override public int hashCode() {

        int hash = 0;

        hash += sideA + sideB + sideC + perimeter;
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
        System.out.println("Triangle (Side a = "  + df.format(sideA) + " Side b = " + df.format(sideB) + " Side c = " + df.format(sideC) + ") (Perimeter = " + df.format(perimeter) + ")");
    }

}
