package ddripoffmodel;

public class Stat {
	private String name;
	private int value;
	
	public String getName(){
		return name;
	}
	public Stat(String name,int value){
		this.name = name;
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value){
		this.value = value;
	}
}
