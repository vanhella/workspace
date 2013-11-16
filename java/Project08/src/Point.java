
public class Point extends Shape{
	private double x;
	private double y;
	public Point(){
		this.x=0.0;
		this.y=0.0;
	}
	public Point(double x, double y){
		this.x=x;
		this.y=y;
	}
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public Point center(){
		return this;
	}
	public boolean contains(Point p) {
		if(p.getX()==this.x&&p.getY()==this.y)
			return true;
		return false;
	}
	public double area(){
		return 0;
	}
	public double distance(Point p){
		return Math.sqrt(Math.pow((this.x-p.x),2)+Math.pow((this.y-p.y),2));
	}
	public String toString(){
		return "("+this.x+","+this.y+")";
	}
	
}
