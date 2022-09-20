package probono.model.dto;

public class People {
	private String id;
	private String name;
	private String password;

	public People() {}
	
	public People(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 재능 기부자 id : ");
		builder.append(id);
		builder.append(" 2. 이름 : ");
		builder.append(name);
		builder.append(" 3. 비밀번호 : ");
		builder.append(password);
		return builder.toString();
	}
}
