
public abstract class Shape {
	public Shape(){}
	abstract Point center();
	abstract boolean contains(Point p);
	abstract double area();
}
