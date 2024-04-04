package runtime;
//Bé na muốn đúc ra tam giác và tram giác vuông

import data.RightTriangle;
import data.Triangle;


public class Program {
    public static void main(String[] args) {
        Triangle ds[] = new Triangle[3];
        Triangle t1 = new RightTriangle(6, 8);
        RightTriangle r1 = new RightTriangle(3, 4);
        Triangle t2 = new Triangle(3, 6, 4);
        ds[0] = t1;
        ds[1] = r1;
        ds[2] = t2;
        for (Triangle item : ds) {
            item.paint();
        }
    }
    
}
