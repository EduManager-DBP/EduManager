let selectedAge = null;

function selectAge(ageGroup) {
    // 연령대 문자열을 숫자로 변환
    const ageMap = {
        teen: 10,
        twenties: 20,
        thirties: 30,
        fortyPlus: 40
    };
    
    selectedAge = ageMap[ageGroup];
    console.log("선택된 연령대:", selectedAge);

    // 버튼 스타일 업데이트
    const buttons = document.querySelectorAll('.age-button');
    buttons.forEach(button => button.classList.remove('selected'));
    
    const selectedButton = document.getElementById(`${ageGroup}Button`);
    if (selectedButton) {
        selectedButton.classList.add('selected');
        document.getElementById('ageInput').value = selectedAge; // 선택된 연령대 숫자 설정
    }
}

function submitAge() {
    const age = document.getElementById('ageInput').value;
    if (age) {
        document.getElementById('ageForm').submit(); // 연령대가 선택되었으면 폼 제출
    } else {
        alert('연령대를 선택해주세요.');
    }
}
