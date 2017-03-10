/**
 * Created by achimienti on 2/17/2017.
 */

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.lang.String;
public class Main {

    private static ArrayList<InterfaceShapes> shapeCollection = new ArrayList<>();

    //Adds shape to shapeCollection
    public static void shapeAdd(String[] shape) {


        String shapeName = shape[0];

        for (int i = 0; i < shape.length; i++) {

            try {
                switch (shape[i]) {

                    case "Circle":
                        if (Double.parseDouble(shape[i + 1]) > 0) {
                            shapeCollection.add(new Circle(Double.parseDouble(shape[i + 1])));

                        } else {
                            throw new IOException(shape[i]);
                        }
                        break;

                    case "Square":
                        if (Double.parseDouble(shape[i + 1]) > 0) {
                            shapeCollection.add(new Square(Double.parseDouble(shape[i + 1])));
                        } else {
                            throw new IOException(shape[i]);
                        }
                        break;

                    case "Rectangle":
                        if (Double.parseDouble(shape[i + 1]) > 0 && Double.parseDouble(shape[i + 2]) > 0) {
                            shapeCollection.add(new Rectangle(Double.parseDouble(shape[i + 1]), Double.parseDouble(shape[i + 1])));

                        } else {
                            throw new IOException(shape[i]);
                        }
                        break;

                    case "Triangle":
                        if ((Double.parseDouble(shape[i + 1]) > 0 && Double.parseDouble(shape[i + 2]) > 0 && Double.parseDouble(shape[i + 3]) > 0)) {

                            shapeCollection.add(new Triangle(Double.parseDouble(shape[i + 1]), Double.parseDouble(shape[i + 2]), Double.parseDouble(shape[i + 3])));
                        } else {
                            throw new IOException(shape[i]);
                        }
                        break;

                    case "Parallelogram":
                        if (Double.parseDouble(shape[i + 1]) > 0 && Double.parseDouble(shape[i + 2]) > 0) {

                            shapeCollection.add(new Parallelogram(Double.parseDouble(shape[i + 1]), Double.parseDouble(shape[i + 2])));

                        } else {
                            throw new IOException(shape[i]);
                        }
                        break;

                }
            }
            catch(IOException rip){
                System.out.println("This " + rip + " has invalid paramaters");
            }

        }

    }



    //Sorts shapes in shape collection
    public static void sortShapes(){

        Collections.sort(shapeCollection, (firstObject, secondObject) -> {

            int nameCheck = firstObject.toString().compareTo(secondObject.getClass().getSimpleName());

            if(nameCheck != 0){

                return nameCheck;
            } else {

                if (firstObject.perimeterGet() == secondObject.perimeterGet()) {

                    return 0;

                } else if (firstObject.perimeterGet() < secondObject.perimeterGet()) {

                    return -1;

                } else {

                    return 1;
                }
            }
        });

    }

    //Deletes shape from shape collection
    public static void shapeDelete(String shapeName, boolean minimum) {

        int minShape = 0, maxShape = 0;
        double max = 0, min = 0;

        for(InterfaceShapes i: shapeCollection){
            if (i.perimeterGet() > max && i.toString().equalsIgnoreCase(shapeName)) {
                max = i.perimeterGet();
                maxShape = shapeCollection.indexOf(i);

            }
        }

        for(InterfaceShapes i: shapeCollection){
            if(i.perimeterGet() < min && i.toString().equalsIgnoreCase(shapeName)){
                min = i.perimeterGet();
                minShape = shapeCollection.indexOf(i);

            }
        }


    }






    //Calculates the total perimeter of the Shapes
    public static void totalPerimeter(String shapeName){



        double perimeter = 0;

        for(InterfaceShapes i :shapeCollection){
            if(shapeName.compareToIgnoreCase(i.getClass().getSimpleName()) == 0) {
                perimeter += i.perimeterGet();
            }

        }

        System.out.println("The total perimeter of all of the " + shapeName + "s is " + perimeter);

    }


    //The main
    static public void main(String args[]) {


        String fileText = "";
        String file = System.getProperty("user.dir");
        fileText = Reader.readFile(file  + "\\src\\Shapes.txt");

        String current = "", previous = "";

        String[] lineSection = fileText.split("[,\n]");

        for (int i = 0; i < lineSection.length; i++) {
            lineSection[i].trim();
        }

        shapeAdd(lineSection);

        for(InterfaceShapes i: shapeCollection){

            i.display();

        }

        sortShapes();

        System.out.println("---------------------------------");
        System.out.println("Sorted Shapes:");

        for(InterfaceShapes i: shapeCollection){

            current = i.toString();
            if(current != previous){
                System.out.println("---------------------------------");

            }
            i.display();
            previous = current;

        }

        System.out.println("---------------------------------");
        System.out.println("Deleting Shapes");


        shapeDelete("Triangle", true);
        shapeDelete("Circle", false);

        for(InterfaceShapes i: shapeCollection){

            current = i.toString();
            if(current != previous){
                System.out.println("---------------------------------");

            }
            i.display();
            previous = current;
        }

        System.out.println("---------------------------------");
        System.out.println("Total Perimeter of Shapes");
        System.out.println("---------------------------------");

        totalPerimeter("Parallelogram");
        totalPerimeter("Triangle");
    }
}
