package model.dao.lecture;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.dao.JDBCUtil;
import model.domain.Schedule;

public class LectureScheduleDao {
    private JDBCUtil jdbcUtil = null;

    public LectureScheduleDao() {
        jdbcUtil = new JDBCUtil();
    }

    // 스케줄 생성
    public void createSchedule(int lectureid, String dayOfWeek, Time startTime, Time endTime, String frequency, Date startDate, String type, String title) {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO lectureschedule (lecturescheduleid, dayofweek, starttime, endtime, frequency, lectureid, startdate, type, title) ");
        query.append("VALUES (SEQ_LECTURE_SCHEDULE_ID.nextval, ?, ?, ?, ?, ?, ?, ?, ?)");

        jdbcUtil.setSqlAndParameters(query.toString(), 
            new Object[] { dayOfWeek, startTime, endTime, frequency, lectureid, startDate, type ,title});

        try {
            int rs = jdbcUtil.executeUpdate();
            if (rs > 0) {
                System.out.println("스케줄이 성공적으로 생성되었습니다.");
            } else {
                System.out.println("스케줄 생성에 실패했습니다.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
    }

    // 스케줄 조회 by ID
    public Schedule findScheduleById(int scheduleId) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT * ");
        query.append("FROM lectureschedule ");
        query.append("WHERE lecturescheduleid = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { scheduleId });

        try {
            Schedule schedule = null;
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                schedule = new Schedule();
                schedule.setScheduleId(rs.getInt("lecturescheduleid"));
                schedule.setDayOfWeek(rs.getString("dayofweek"));
                schedule.setStartTime(rs.getTime("starttime").toLocalTime());
                schedule.setEndTime(rs.getTime("endtime").toLocalTime());
                schedule.setFrequency(rs.getString("frequency"));
                schedule.setLectureId(rs.getInt("lectureid"));
                schedule.setStartDate(rs.getDate("startdate").toLocalDate());
                schedule.setType(rs.getString("type"));
                schedule.setTitle(rs.getString("title"));
            }
            return schedule;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }

    // 스케줄 목록 조회 by lecture ID
    public List<Schedule> findSchedulesBylectureId(int lectureid) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT * ");
        query.append("FROM lectureschedule ");
        query.append("WHERE lectureid = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { lectureid });
        List<Schedule> schedules = new ArrayList<>();

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setScheduleId(rs.getInt("lecturescheduleid"));
                schedule.setDayOfWeek(rs.getString("dayofweek"));
                schedule.setStartTime(rs.getTime("starttime").toLocalTime());
                schedule.setEndTime(rs.getTime("endtime").toLocalTime());
                schedule.setFrequency(rs.getString("frequency"));
                schedule.setLectureId(lectureid);
                schedule.setStartDate(rs.getDate("startdate").toLocalDate());
                schedule.setType(rs.getString("type"));
                schedule.setTitle(rs.getString("title"));
                schedules.add(schedule);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return schedules;
    }

    // 스케줄 업데이트
    public void updateSchedule(int scheduleId, String dayOfWeek, Time startTime, Time endTime, String frequency, Date startDate, String type, String title) {
        StringBuffer query = new StringBuffer();
        query.append("UPDATE lectureschedule ");
        query.append("SET dayofweek = ?, starttime = ?, endtime = ?, frequency = ?, startdate = ?, type = ? , title = ?");
        query.append("WHERE lecturescheduleid = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), 
            new Object[] { dayOfWeek, startTime, endTime, frequency, startDate, type, title, scheduleId});

        try {
            int rs = jdbcUtil.executeUpdate();
            if (rs > 0) {
                System.out.println("스케줄이 성공적으로 업데이트되었습니다.");
            } else {
                System.out.println("스케줄 업데이트에 실패했습니다.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
    }

    // 스케줄 삭제
    public void deleteScheduleById(int scheduleId) {
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM lectureschedule ");
        query.append("WHERE lecturescheduleid = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { scheduleId });

        try {
            int rs = jdbcUtil.executeUpdate();
            if (rs > 0) {
                System.out.println("스케줄이 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("스케줄 삭제에 실패했습니다. 해당 ID의 스케줄이 존재하지 않습니다.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
    }
}
