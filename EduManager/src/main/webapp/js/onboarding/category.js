let selectedCategory = null;

function selectInterestCategory(category) {
    selectedCategory = category;
    console.log("선택된 분야:", selectedCategory);

    // 버튼 스타일 업데이트
    const buttons = document.querySelectorAll('.category-button');
    buttons.forEach(button => button.classList.remove('selected'));
    
    const selectedButton = document.getElementById(`category${category}`);
    if (selectedButton) {
        selectedButton.classList.add('selected');
    }
}

function saveCategory() {
    if (!selectedCategory) {
        alert("분야를 선택해주세요.");
        return false;
    }

    // 선택된 연령대를 서버에 저장하거나 처리
    console.log("분야 저장:", selectedCategory);
    alert("회원가입이 완료되었습니다.");
}
