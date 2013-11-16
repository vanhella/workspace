
public class Circle extends NamedShape{
	private Point center;
	private double radius;
	public Circle(String name,Point center,double radius){
		super(name);
		this.center=center;
		this.radius=radius;
	}
	public double getRadius(){
		return radius;
	}
	public Point center(){
		return center;
	}
	public boolean contains(Point p){
		if(p.distance(this.center)<=this.radius)
			return true;
		return false;
	}
	public double area(){
		return Math.PI*radius*radius;
	}
	public String toString(){
		return String.format("%s:C(%s,%s)", this.getName(),center,radius);
	}
}
