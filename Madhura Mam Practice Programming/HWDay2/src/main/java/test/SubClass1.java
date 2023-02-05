package test;

public class SubClass1 extends Super{
	public String name;
	
	public SubClass1() {
		super();
		this.name = "rtyui";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SubClass1 counter="+getCount()+" [name=" + name + "]";
	}
	
}
