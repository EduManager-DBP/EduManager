let selectedAge = null;

function selectAge(age) {
    selectedAge = age;
    console.log("선택된 연령대:", selectedAge);

    // 버튼 스타일 업데이트
    const buttons = document.querySelectorAll('.age-button');
    buttons.forEach(button => button.classList.remove('selected'));
    
    const selectedButton = document.getElementById(`${age}Button`);
    if (selectedButton) {
        selectedButton.classList.add('selected');
    }
}

function saveAge() {
    if (!selectedAge) {
        alert("연령대를 선택해주세요.");
        return false;
    }

    // 선택된 연령대를 서버에 저장하거나 처리
    console.log("연령대 저장:", selectedAge);
}
