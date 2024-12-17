document.addEventListener("DOMContentLoaded", () => {
    const calendarHeader = document.querySelector("#calendarHeader .month span");
    const calendarYear = document.querySelector("#calendarHeader .year");
    const calendarBody = document.querySelector(".calendarTable tbody");

    let currentDate = new Date();

    // 달력을 렌더링하는 함수
    function renderCalendar(date) {
        const year = date.getFullYear();
        const month = date.getMonth();

        // 월과 연도 업데이트
        calendarHeader.textContent = month + 1; // JavaScript 월은 0부터 시작
        calendarYear.textContent = year;

        // 달력 테이블 초기화
        calendarBody.innerHTML = "";

        // 첫날과 마지막 날 계산
        const firstDay = new Date(year, month, 1).getDay();
        const lastDate = new Date(year, month + 1, 0).getDate();

        let day = 1; // 일 시작

        for (let i = 0; i < 6; i++) {
            const row = document.createElement("tr");

            for (let j = 0; j < 7; j++) {
                const cell = document.createElement("td");

                // 첫 주: 첫날의 요일부터 시작
                if (i === 0 && j < firstDay) {
                    cell.classList.add("previousMonth");
                    cell.textContent = new Date(year, month, -(firstDay - j - 1)).getDate();
                } else if (day > lastDate) {
                    // 마지막 날짜 이후의 날짜 표시
                    cell.classList.add("nextMonth");
                    cell.textContent = day - lastDate;
                    day++;
                } else {
                    // 현재 월 날짜 표시
                    cell.textContent = day;
                    if (
                        day === new Date().getDate() &&
                        month === new Date().getMonth() &&
                        year === new Date().getFullYear()
                    ) {
                        cell.id = "today"; // 오늘 날짜 강조
                    }
                    cell.classList.add("currentMonth"); // 현재 월 날짜에 클래스 추가
                    day++;
                }
                row.appendChild(cell);
            }
            calendarBody.appendChild(row);

            // 마지막 날짜를 넘으면 루프 종료
            if (day > lastDate) break;
        }
    }

    // 이전 달 버튼
    document.getElementById("previousMonthIcon").addEventListener("click", () => {
        currentDate.setMonth(currentDate.getMonth() - 1);
        renderCalendar(currentDate);
    });

    // 다음 달 버튼
    document.getElementById("nextMonthIcon").addEventListener("click", () => {
        currentDate.setMonth(currentDate.getMonth() + 1);
        renderCalendar(currentDate);
    });

    // 날짜 클릭 이벤트 (이벤트 위임 방식)
    document.querySelector(".calendarTable").addEventListener("click", (event) => {
        // 클릭된 요소가 <td>인지 확인
        if (event.target.tagName.toLowerCase() === "td" && event.target.classList.contains("currentMonth")) {
            let selectedDay = event.target.textContent.trim(); // 선택된 날짜 값
            let year = calendarYear.textContent; // 년도 가져오기
            let month = calendarHeader.textContent; // 월 가져오기

            // 날짜 포맷: YYYY-MM-DD
            let fullDate = year + "-" + String(month).padStart(2, "0") + "-" + String(selectedDay).padStart(2, "0");

            // 폼의 hidden input에 값 설정
            document.getElementById("selectedDate").value = fullDate;

            // 폼 제출
            document.getElementById("dateForm").submit();
        }
    });

    // 초기 달력 렌더링
    renderCalendar(currentDate);
});
