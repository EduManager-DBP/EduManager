package model.domain.member;

public class Student extends Member {
    private int ageRange; // 10대: 1, 20대: 2, 30대:3, 그 이상: 4
    // private List<String> interestCategory;

    public Student() {
    }

    public Student(String id, String pwd, String name, String email, String phone) {
        super(id, pwd, name, email, phone);
        // TODO Auto-generated constructor stub
    }

    public int getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(int ageRange) {
        this.ageRange = ageRange;
    }
    // public List<String> getInterestCategory() { return interestCategory; }
    // public void setInterestCategory(List<String> interestCategory) {
    // this.interestCategory = interestCategory; }
}
