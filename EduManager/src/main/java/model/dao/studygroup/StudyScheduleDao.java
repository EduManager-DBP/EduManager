package model.dao.studygroup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.dao.JDBCUtil;
import model.domain.Schedule;

public class StudyScheduleDao {
    private JDBCUtil jdbcUtil = null;

    public StudyScheduleDao() {
        jdbcUtil = new JDBCUtil();
    }

    // 스케줄 생성
    public int createSchedule(Schedule schedule) {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO studyschedule (studyscheduleid, dayofweek, starttime, endtime, frequency, studygroupid, startdate, type,title) ");
        query.append("VALUES (SEQ_STUDY_SCHEDULE_ID.nextval, ?, ?, ?, ?, ?, SYSDATE, ?,?)");

        jdbcUtil.setSqlAndParameters(query.toString(), 
            new Object[] { schedule.getDayOfWeek(), schedule.getStartTime(), schedule.getEndTime(),
					schedule.getFrequency(), schedule.getStudyGroupId(), schedule.getType(), schedule.getTitle()});

		// StudyGroup에 id setting
		String key[] = { "studyScheduleId"};  // PK 컬럼(들)의 이름 배열       
        try {
            int result = jdbcUtil.executeUpdate(key);
            if (result > 0) {
            	ResultSet rs = jdbcUtil.getGeneratedKeys();

                System.out.println("스케줄이 성공적으로 생성되었습니다.");
                if(rs.next()) {
    		   		int generatedKey = rs.getInt(1);   // 생성된 PK 값
    				return generatedKey;
    		   	}
            } else {
                System.out.println("스케줄 생성에 실패했습니다.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return 0;
    }

    // 스케줄 조회 by ID
    public Schedule findScheduleById(int scheduleId) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT * ");
        query.append("FROM studyschedule ");
        query.append("WHERE studyscheduleid = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { scheduleId });

        try {
            Schedule schedule = null;
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                schedule = new Schedule();
                schedule.setScheduleId(rs.getInt("studyscheduleid"));
                schedule.setDayOfWeek(rs.getString("dayofweek"));
                schedule.setStartTime(rs.getTime("starttime").toLocalTime());
                schedule.setEndTime(rs.getTime("endtime").toLocalTime());
                schedule.setFrequency(rs.getString("frequency"));
                schedule.setStudyGroupId(rs.getInt("studygroupid"));
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

    // 스케줄 목록 조회 by StudyGroup ID
    public List<Schedule> findSchedulesByStudyId(long studygroupid) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT * ");
        query.append("FROM studyschedule ");
        query.append("WHERE studygroupid = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { studygroupid });
        List<Schedule> schedules = new ArrayList<>();

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setScheduleId(rs.getInt("studyscheduleid"));
                schedule.setDayOfWeek(rs.getString("dayofweek"));
                schedule.setStartTime(rs.getTime("starttime").toLocalTime());
                schedule.setEndTime(rs.getTime("endtime").toLocalTime());
                schedule.setFrequency(rs.getString("frequency"));
                schedule.setStudyGroupId(studygroupid);
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
	// 스케줄 목록 id 조회 by lecture IDc
	public List<Integer> findScheduleIdsByStudyId(long studyId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT studyscheduleid ");
		query.append("FROM studyschedule ");
		query.append("WHERE studygroupid = ?");

		jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { studyId });
		List<Integer> scheduleIds = new ArrayList<>();

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			while (rs.next()) {
				scheduleIds.add(rs.getInt("studyscheduleid"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}

		return scheduleIds;
	}
    // 스케줄 업데이트
    public void updateSchedule(Schedule schedule) {
        StringBuffer query = new StringBuffer();
        query.append("UPDATE studyschedule ");
        query.append("SET dayofweek = ?, starttime = ?, endtime = ?, frequency = ?, title = ? ");
        query.append("WHERE studyscheduleid = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), 
            new Object[] { schedule.getDayOfWeek(), schedule.getStartTime(),
    				schedule.getEndTime(), schedule.getFrequency(), schedule.getTitle(), schedule.getScheduleId()});

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
        query.append("DELETE FROM studyschedule ");
        query.append("WHERE studyscheduleid = ?");

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
