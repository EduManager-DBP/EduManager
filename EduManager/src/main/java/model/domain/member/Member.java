package model.domain.member;

public class Member {
    private String memberId;
    private String memberName;
    private String password;

    public Member() {}

    public Member(String memberId, String memberName, String password) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.password = password;
    }

    public String getUserId() { return memberId; }
    public void setUserId(String memberId) { this.memberId = memberId; }
    public String getUserName() { return memberName; }
    public void setUserName(String memberName) { this.memberName = memberName; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
