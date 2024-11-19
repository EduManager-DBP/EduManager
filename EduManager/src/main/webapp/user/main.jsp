<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
    <title>Edu Manager</title>
  </head>
  <body>
    <div class="page">
      <header>
        <img src='../images/eduLogo.png' />
        <nav>
          <ul>
            <li class="menu"><a href="#">홈</a></li>
            <li class="menu">
              <a href="registration.jsp">강의/스터디 신청</a>
            </li>
            <li class="menu"><a href="studentMypage.jsp">마이페이지</a></li>
            <li class="menu"><a href="">로그아웃</a></li>
          </ul>
        </nav>
      </header>

      <div id="body">
        <div id="schedule">
          <div id="todaySchedule">
            <div class="ScheduleText today">Today Schedule</div>
            <ul class="todaySchedule-list">
              <li class="todaySchedules list1">
                강의명 14:00 ~ 16:00
              </li>
              <li class="todaySchedules list2">
                강의 명 18:00 ~ 20:00
              </li>
            </ul>
          </div>
          <div id="assignment">
            <div class="ScheduleText assignment">Assignment</div>

            <ul class="assignment-list">
              <li class="assignments list1">영단어 암기 Day20~23</li>
              <li class="assignments list2">SQL 30강 문제풀기</li>
            </ul>
          </div>
        </div>
        <div id="calendar">
          <table>
            <div id="calendarHeader">
              <span class="month">
                <img src="../images/previousMonth.svg" id="previousMonthIcon" />
                1 <img src="../images/nextMonth.svg" id="nextMonthIcon" />
              </span>

              <span class="year">2024</span>
            </div>
            <thead>
              <th class="sunday">일</th>
              <th>월</th>
              <th>화</th>
              <th>수</th>
              <th>목</th>
              <th>금</th>
              <th>토 </th>
            </thead>
            <tbody>
              <tr>
                <td class="previousMonth">31</td>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td>4</td>
                <td>5</td>
                <td>6</td>
              </tr>
              <tr>
                <td class="sunday">7</td>
                <td>8</td>
                <td>9</td>
                <td id="today">10</td>
                <td>11</td>
                <td>12</td>
                <td>13</td>
              </tr>
              <tr>
                <td class="sunday">14</td>
                <td>15</td>
                <td>16</td>
                <td>17</td>
                <td>18</td>
                <td>19</td>
                <td>20</td>
              </tr>
              <tr>
                <td class="sunday">21</td>
                <td>22</td>
                <td>23</td>
                <td>24</td>
                <td>25</td>
                <td>26</td>
                <td>27</td>
              </tr>
              <tr>
                <td class="sunday">28</td>
                <td>29</td>
                <td>30</td>
                <td>31</td>
                <td class="nextMonth">1</td>
                <td class="nextMonth">2</td>
                <td class="nextMonth">3</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </body>
</html>
