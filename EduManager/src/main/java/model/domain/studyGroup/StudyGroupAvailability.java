package model.domain.studyGroup;

public class StudyGroupAvailability {
    private long studyGroupId; // 강의 ID
    private String name;    // 강의 이름
    private int availableSeats; // 잔여 좌석 수

    // 기본 생성자
    public StudyGroupAvailability() {
    }

    // 매개변수 있는 생성자
    public StudyGroupAvailability(long studyGroupId, String name, int availableSeats) {
        this.studyGroupId = studyGroupId;
        this.name = name;
        this.availableSeats = availableSeats;
    }

    // Getter 및 Setter
    public long getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(long studyGroupId) {
        this.studyGroupId = studyGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // toString 메서드 (디버깅 및 로깅 용도)
    @Override
    public String toString() {
        return "LectureAvailability{" +
                "lectureId=" + studyGroupId +
                ", name='" + name + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
