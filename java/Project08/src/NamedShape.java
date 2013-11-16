
public abstract class NamedShape extends Shape{
	private String name;
	public NamedShape(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
}
