package controller.calendar;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.service.LectureManager;
import model.domain.calendar.*;

public class CalendarController implements Controller {
	// private static final int countPerPage = 100; // 한 화면에 출력할 사용자 수

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 현재 날짜를 기준으로 기본값 설정
        LocalDate currentDate = LocalDate.now();
        
        // 파라미터로 연도와 월 가져오기 (기본값: 현재 날짜)
        String yearParam = request.getParameter("year");
        String monthParam = request.getParameter("month");

        // 파라미터가 없으면 현재 연도와 월을 기본값으로 설정
        int year = (yearParam != null && !yearParam.isEmpty()) ? Integer.parseInt(yearParam) : currentDate.getYear();
        int month = (monthParam != null && !monthParam.isEmpty()) ? Integer.parseInt(monthParam) : currentDate.getMonthValue();

        // LectureManager를 통해 데이터 가져오기
        LectureManager manager = LectureManager.getInstance();
        List<CalendarDTO> calendarList = manager.getCalendarList(year, month);

        // 데이터를 JSP에 전달
        request.setAttribute("calendarEntries", calendarList);
        request.setAttribute("year", year);
        request.setAttribute("month", month);

        // 반환할 JSP 파일 경로
        return "calendarView.jsp";
	}
}
