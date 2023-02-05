package test;

public class Super {
	private static int count;
	private String Email;
	static {
		count=10;
	}

	public Super() {
		super();
		Email = "dfgh@fghj";
		count++;
	}
	
	public static int getCount() {
		return count;
	}

}
