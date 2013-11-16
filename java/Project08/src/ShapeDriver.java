/*Trevor Brown-Cox
 * CompSci 251
 * Purpose: The purpose of this program is to prompt the user to enter in shapes, where we then again prompt the user to 
 * 			make up points for each and every shape.Then we prompt the user the ArrayList and area of each shape in hat list. 
 * 			Lastly we prompt the user to each in a single point to check if any of the points contains that point and we print the 
 * 			shapes that contains the point.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ShapeDriver {
	public static void main(String[] args){
		ArrayList<Shape> shape = new ArrayList<Shape>();
		Scanner sc = new Scanner(System.in);
		int choice;
		do{
			System.out.print("Enter a shape: \n" +
					"1) point\n" +
					"2) circle\n" +
					"3) rectangle\n" +
					"0) quit\n");
			choice = sc.nextInt();
			if(choice == 1)
				createShapes(choice, sc, shape);
			else if(choice == 2)
				createShapes(choice, sc, shape);
			else if(choice == 3)
				createShapes(choice, sc, shape);
			else if(choice == 0){
				createShapes(choice, sc, shape);
				printShape(shape);
				for(int i = 0; i<shape.size(); ++i){
					System.out.print("Area of "+shape.get(i)+": "+shape.get(i).area()+"\n");
				}
				System.out.print("\n(May Contains) Enter the x and y values of the point: ");
				Point point = new Point(sc.nextDouble(),sc.nextDouble());
				for(int i = 0;i<shape.size();++i){
					if(shape.get(i).contains(point)==true)
						System.out.print(shape.get(i).toString()+"\n");
				}
				System.out.print("\nGoodbye!\n");
				System.exit(0);
			}
		}while(choice != 0);
	sc.close();
	}
	public static Point getPoint(Scanner sc, ArrayList<Shape> shape){
		System.out.print("Enter the x and y values: ");
		Point p = new Point(sc.nextDouble(),sc.nextDouble());
		shape.add(p);
		//System.out.print(shape.toString());
		return p;
	}
	public static Circle getCircle(Scanner sc, ArrayList<Shape> shape){
		System.out.print("Enter a name for the circle: ");
		String name = sc.next();
		System.out.print("Enter the x and y values for the center: ");
		Point cen = new Point(sc.nextDouble(),sc.nextDouble());
		System.out.print("Enter the radius for the circle: ");
		double rad = sc.nextDouble();
		if(rad<=0){
			System.out.print("ERROR: Radius needs to be a postive number!\n");
			return null;
		}
		Circle c = new Circle(name,cen,rad);
		shape.add(c);
		//System.out.print(shape.toString());
		return c;
	}
	public static Rectangle getRectangle(Scanner sc, ArrayList<Shape> shape){
		System.out.print("Enter a name for the rectangle: ");
		String name = sc.next();
		System.out.print("Enter the x and y values for the upper left point: ");
		Point ul = new Point(sc.nextDouble(),sc.nextDouble());
		System.out.print("Enter the x and y values for the lower right point: ");
		Point lr = new Point(sc.nextDouble(),sc.nextDouble());
		Rectangle r = new Rectangle(name,ul,lr);
		shape.add(r);
		//System.out.print(shape.toString());
		return r;
	}
	public static void createShapes(int choice,Scanner sc, ArrayList<Shape> shape){
		switch (choice) {
		case 1:
			Point p = getPoint(sc, shape);
			break;
		case 2:
			Circle c = getCircle(sc, shape);
			break;
		case 3:
			Rectangle r = getRectangle(sc, shape);
			break;
		case 0:
			break;
		}
		return;
	}
	public static void printShape(ArrayList<Shape> shape){
		System.out.print(shape.toString()+"\n");
	}
	
}
