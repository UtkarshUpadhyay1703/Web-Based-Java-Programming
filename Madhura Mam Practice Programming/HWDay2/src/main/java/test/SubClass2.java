package test;

public class SubClass2 extends Super {
public int mob;
	
	public SubClass2() {
		super();
		this.mob = 345678;
	}

	public int getMob() {
		return mob;
	}

	public void setMob(int mob) {
		this.mob = mob;
	}

	@Override
	public String toString() {
		return "SubClass2 "+getCount()+ "[mob=" + mob + "]";
	}

}
