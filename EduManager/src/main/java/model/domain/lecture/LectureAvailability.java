package model.domain.lecture;

public class LectureAvailability {
    private long lectureId; // 강의 ID
    private String name;    // 강의 이름
    private int availableSeats; // 잔여 좌석 수

    // 기본 생성자
    public LectureAvailability() {
    }

    // 매개변수 있는 생성자
    public LectureAvailability(long lectureId, String name, int availableSeats) {
        this.lectureId = lectureId;
        this.name = name;
        this.availableSeats = availableSeats;
    }

    // Getter 및 Setter
    public long getLectureId() {
        return lectureId;
    }

    public void setLectureId(long lectureId) {
        this.lectureId = lectureId;
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
                "lectureId=" + lectureId +
                ", name='" + name + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
