package cn.zyc.pojo;

public class Person {

	private Integer id;
	private String name;
	private String phone;

	public Person(Integer id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public Person() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "id-->" + id + ", name-->" + name + ", phone-->" + phone;
	}

}
