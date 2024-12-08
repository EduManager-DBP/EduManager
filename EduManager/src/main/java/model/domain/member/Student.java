package model.domain.member;

import java.util.List;

public class Student {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private String ageRange; // 10대: 1, 20대: 2, 30대:3, 그 이상: 4
	private List<String> interestCategory;

	public Student(String id, String pwd, String name, String email, String phone, String ageRange,
			List<String> interestCategory) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.ageRange = ageRange;
		this.interestCategory = interestCategory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public List<String> getInterestCategory() {
		return interestCategory;
	}

	public void setInterestCategory(List<String> interestCategory) {
		this.interestCategory = interestCategory;
	}

	/* 비밀번호 검사 */
	public boolean matchPassword(String pwd) {
		if (pwd == null) {
			return false;
		}
		return this.pwd.equals(pwd);
	}

	public boolean isSameMember(String id) {
		return this.id.equals(id);
	}
}
