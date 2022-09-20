package model.domain;

public class Customer {
	private String id;
	private int pw;
	public Customer() {
		System.out.println("기본 생성자");
	}
	public Customer(String id, int pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		System.out.println("getId()");
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPw() {
		System.out.println("getPw()");
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=");
		builder.append(id);
		builder.append(", pw=");
		builder.append(pw);
		builder.append("]");
		return builder.toString();
	}
	
}



