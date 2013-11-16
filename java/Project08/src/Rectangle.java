
public class Rectangle extends NamedShape{
	private Point ul;
	private Point lr;

	public Rectangle(String name, Point ul,Point lr){
		super(name);
		this.ul=ul;
		this.lr=lr;
	}
	public Point getUL(){
		return this.ul;
	}
	public Point getLR(){
		return this.lr;
	}
	public Point center(){
		return new Point((ul.getX()+lr.getX())/2,(ul.getY()+lr.getY())/2);
	}
	public boolean contains(Point p){
		if(p.getX()<ul.getX()&&p.getX()<lr.getX()
				&&p.getY()<ul.getY()&&p.getY()<lr.getY())
			return true;
		return false;
			
	}
	public double area(){
		return (lr.getX()-ul.getX())*(ul.getY()-lr.getY());
	}
	public String toString(){
		return String.format("%s:R(%s,%s)",this.getName(),ul,lr);
	}
}
