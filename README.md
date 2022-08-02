# DynamicBeat
# 개발 환경
- 개발 언어 : JAVA
- Tool : Eclipse
- 외부 라이브러리 : jlayer-1.0.1.jar

- mp3파일들은 유튜브에서 저작권 없는 mp3 파일을 다운 받아 사용.
- 배경 이미지를 제외 모든 이미지 파일은 그림판, 포토샵을 이용해 제작.
- JFrame으로 동작하고 멀티 스레드를 이용하여 구현.
- jlayer-1.0.1.jar 라이브러리를 사용하여 mp3 재생.

# 개발 순서
1. 자바 개발 환경 구축 및 GUI 시작하기
2. 게임 시작 화면 개발하기
3. 시작 화면에 음악 삽입하기
4. 메뉴 바 구현하기
5. 화면 전환
6. 곡 선택 화면 디자인
7. 곡 선택 기능 구현
8. 게임 화면으로 이동하기
9. 리팩토링
10. 게임 화면 디자인
11. 키보드 입력 이벤트 리스너
12. 개별 게임 곡 재생하기
13. 노트 이동 애니메이션
14. 박자에 맞추어 노트 찍기
15. 노트 판정 함수 구현하기
16. 노트 판정 디자인 입히기

# 실행 화면
1. 인트로 화면
![image](https://user-images.githubusercontent.com/106687047/182035658-1b48a80e-5dbf-4c39-8fb7-27ed64f4445f.png)

2. 곡 선택 화면
![image](https://user-images.githubusercontent.com/106687047/182035723-af9a0330-6b87-404d-8638-347ecbc30f98.png)
![image](https://user-images.githubusercontent.com/106687047/182035733-6c9666e4-0dc2-45b4-9bc0-b824ebd36e20.png)
![image](https://user-images.githubusercontent.com/106687047/182035736-e165ea3e-1501-4f89-a988-74a5778dee87.png)

4. 게임 실행 화면
![image](https://user-images.githubusercontent.com/106687047/182035770-617c36b3-80b6-4a5c-b5af-67360bff6f93.png)
![image](https://user-images.githubusercontent.com/106687047/182035774-0ed2bbdc-1ebb-427b-bd85-bc38c2f29ce9.png)
![image](https://user-images.githubusercontent.com/106687047/182035778-b8af3068-7230-4a09-9dd0-396a10398254.png)

# 스레드 설명
- Main : 게임 실행 파일.
- DynamicBeat :
- Music : 인트로, 곡 선택, 게임 실행 음악 재생
- Game : 게임 화면, 노트 판정 등 구현
- Note : 떨어지는 노트 속도, 갯수 등 설정
- Track : 곡 선택 화면에서 보여지는 곡 정보, mp3등 저장
- Beat : 떨어지는 노트 정보 저장
- KeyListener : 키 입력 함수

# 개선 해야 할 점
- 판정에 따른 점수 추가
- 점수 랭킹
- 난이도 추가
