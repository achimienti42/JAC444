
public class Parallelogram implements InterfaceShapes {

    private double length, width, perimeter;

    public Parallelogram(double l, double w){

        length = l;
        width = w;
        perimeter = 0;
        perimCalc.operate();

    }


    public interface perimeterCalc {

        double operate();
    }

    perimeterCalc perimCalc = () -> perimeter = ((2*length)+(2*width));

    @Override public double perimeterGet() {return perimeter;}
    @Override public int hashCode(){

        int hash = 0;

        hash += length + width + perimeter;
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
        System.out.println("Parallelogram (l = "  + df.format(length) + ") (Perimeter = " + df.format(perimeter) + ")");
    }
}
