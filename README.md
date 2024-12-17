# EduManager

1. 편집 창에 줄번호 표시

General > Editors > Text Editors > Show line numbers

 

2. 편집 창의 폰트의 종류나 크기 변경하기
General > Appearance > Colors and Fonts > Basic > Text Font > Edit 버튼 클릭하여 변경

 

3. 편집 창(또는 다른 창)을 전체화면으로 확대하기

창 위쪽의 제목이 있는 부분을 더블 클릭하면 그 창만 크게 표시되고 다른 창들은 숨겨짐

다시 제목 바를 더블 클릭하면 원 상태로 복구됨. 또는 왼쪽이나 오른쪽 세로 바의 restore 버튼을 클릭하면 숨겨진 창들이 표시됨

 

4. Source 메뉴의 유용한 기능들

(1) 주석 생성/삭제
 
- Toggle Comment: 현재 행을 주석으로 만들거나 해제
- Add Block Comment: 마우스로 여러 행을 선택하여 주석 처리
- Remove Block Comment: 여러 행으로 되어 있는 주석을 해제
 
(2) 소스 코드 정리
 
- Correct Indentation: 현재 행에 대한 들여쓰기 조정
- Format: 전체 프로그램의 들여쓰기를 정리
- Cleanup: 들여쓰기 뿐만 아니라 소스 코드에 포함된 불필요한 import, type cast 등을 자동으로 정리
 
(3) 코드 자동 생성
  
- Generate Constructor using Fields... : 클래스에 포함된 필드들을 초기화하는 생성자 코드를 자동으로 생성
- Generate Getters and Setters... : 클래스에 포함된 필드들에 대한 get method나 set method를 자동 생성
- Generate toString... : 클래스에 대한 toString 메소드를 자동 생성 
- Generate hashCode() and equals()... : hashCode()와 equals() 메소드를 자동 생성 
 
 
5. 클래스, 패키지, 변수, 메소드 등의 이름 변경
 
클래스가 정의된 Java 소스 파일에서 클래스의 이름을 직접 변경하거나 또는 파일의 이름만 변경하면 컴파일 오류가 발생함 (클래스의 이름과 파일의 이름이 항상 일치해야 함)
 
- 파일을 선택하고 마우스 우클릭하여 Refactor >> Rename 기능을 이용하면 클래스 이름이 자동 변경됨
- 패키지 이름을 변경하는 경우에도 Refactor >> Rename 을 이용하면 소속된 클래스들이나 그것들을 이용하는 클래스 파일 내에 선언된 패키지 이름이 자동 변경됨
- 클래스 내에 선언된 변수나 메소드 이름 변경 시에도 Refactor >> Rename 을 이용하면 그것이 참조(사용)된 곳들도 모두 같이 변경됨
   
 
6. 클래스, 패키지의 이동 및 복사
 
- 클래스나 패키지를 다른 패키지로 이동시키려면 Refactor >> Move 이용
- 클래스나 패키지를 복사하려면 Copy(ctrl+c) & Paste(ctrl+v) 이용
    
  
7. Source code navigation
 
(1) source code에서 특정 class/interface/method/variable이 선언되거나 정의된 부분(파일)으로 이동하려면, 마우스로 선택하여 focus를 주고 F3 key를 이용하거나,
Ctrl key를 누른 상태에서 생성되는 link를 마우스로 클릭하여 이동 가능
- 이동한 후 이전 위치로 되돌아 오려면 툴바의 backword 화살표(<-)를 클릭하거나 Alt + 왼쪽 화살표 key(<-) 이용
- 다음 위치로 재이동하려면 툴바의 forword 화살표(->)를 클릭하거나 Alt + 오른쪽 화살표 key(->) 이용
 
(2) 특정 class/interface/method/variable이 참조(사용)되는 부분(파일)들을 모두 찾으려면 마우스로 선택하여 focus를 주고 right-click하여 나타나는 context 메뉴에서 References >> Project를 선택함
 
(3) 같은 source file 내에 있는 method나 variable들로 이동하려면 Outline view에서 직접 선택하거나 Ctrl+O key를 이용하여 pop-up 창을 띄운 후 선택함
 
(4) 툴바에 있는 Toggle Breadscrub을 활성화 하면 editor 창 상단에서 프로젝트 내 folder, package, class 등을 빠르게 선택하여 이동 가능함
