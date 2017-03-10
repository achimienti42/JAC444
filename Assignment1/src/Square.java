

public class Square implements InterfaceShapes {

    private double length, perimeter;

   public Square(double l){

       length = l;
       perimeter = 0;
       perimCalc.operate();

   }



    public interface perimeterCalc {

        double operate();
    }

        perimeterCalc perimCalc = () -> perimeter = length * 4;

        @Override public double perimeterGet() {return perimeter;}
        @Override public int hashCode(){

            int hash = 0;

            hash += length + perimeter;
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
            System.out.println("Square (Length = "  + df.format(length) + ") (Perimeter = " + df.format(perimeter) + ")");
        }


}
