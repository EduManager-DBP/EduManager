//단일선택
function selectLectureCategory(button) {
    const hiddenInput = document.getElementById('categories');
    const selectedButton = document.querySelector('.category.selected');

    // 이전에 선택된 버튼이 있으면 선택 해제
    if (selectedButton) {
        selectedButton.classList.remove('selected');
    }

    // 선택한 버튼 스타일 추가
    button.classList.add('selected');

    // 숨겨진 input의 value를 업데이트
    hiddenInput.value = button.getAttribute('data-index');
}

/*//다중선택
function selectLectureCategory(button) {
    const hiddenInput = document.getElementById('categories');
    let selectedCategories = hiddenInput.value ? hiddenInput.value.split(',') : [];
    const index = button.getAttribute('data-index');

    // 선택된 번호가 이미 있다면 제거, 없으면 추가
    if (selectedCategories.includes(index)) {
        selectedCategories = selectedCategories.filter(item => item !== index);
        button.classList.remove('selected'); // 선택 표시 제거
    } else {
        selectedCategories.push(index);
        button.classList.add('selected'); // 선택 표시 추가
    }

    // 숨겨진 input의 value 업데이트
    hiddenInput.value = selectedCategories.join(',');
}*/
document.addEventListener('DOMContentLoaded', () => {
    const categoryButtons = document.querySelectorAll('.category');

    categoryButtons.forEach(button => {
        button.addEventListener('click', () => {
            selectLectureCategory(button);
        });
    });
});
function addSchedule() {
  // 기존 article 요소를 복제
  const originalArticle = document.querySelector('.schedule');
  const newArticle = originalArticle.cloneNode(true);

  // 새로운 article 요소 안의 input 태그들을 찾아 값을 비움
  const inputs = newArticle.querySelectorAll('input');
  inputs.forEach((input) => {
    input.value = ''; // input 값을 비움
  });

  // 새로운 article 요소를 section 밑에 추가
  const section = document.getElementById('schedule');
  const plusButton = document.getElementById('plus_btn');

  // 버튼 앞에 새 article을 추가
  section.insertBefore(newArticle, plusButton);
}

// 일정 삭제 함수
//다 삭제되면 작동 안함..버그.. 아예 하나는 고정으로 해야지
function deleteSchedule(button) {
    const articles = document.querySelectorAll('.schedule');
    if (articles.length > 1) {
        const article = button.parentElement;
        article.remove();
    } else {
        alert("최소 한 개의 일정은 필요합니다.");
    }
}
