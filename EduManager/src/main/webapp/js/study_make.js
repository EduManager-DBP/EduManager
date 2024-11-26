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
    const article = button.parentElement; // 해당 버튼의 부모 article
    article.remove(); // 부모 article 삭제
}