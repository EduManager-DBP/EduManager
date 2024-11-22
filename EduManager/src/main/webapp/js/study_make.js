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
