package model.domain.member;

public class Member { // 수정은 pw, phone
    private String id;
    private String password;
    private String name;
    private String email;
    private String phone;

    public Member() {
    }

    public Member(String id, String password, String name, String email, String phone) {
        super();
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    /* 비밀번호 검사 */
    public boolean matchPassword(String password) {
        if (password == null) {
            return false;
        }
        return this.password.equals(password);
    }

    public boolean isSameMember(String id) {
        return this.id.equals(id);
    }

}