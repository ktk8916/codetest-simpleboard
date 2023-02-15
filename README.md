# codetest-simpleboard


## 프로젝트 환경 

JAVA 1.8  
Spring Boot 2.7.8  
H2 DataBase  
Spring Data Jpa  


## Schema
![image](https://user-images.githubusercontent.com/71807768/218968421-41e1f59c-0ee0-464d-adea-8e1b7ed55ef2.png)

## 요구사항

- 게시판 목록 페이지
  - 게시글 목록 리스트 업
  - 제목 또는 내용 검색 구현
- 게시글 쓰기 페이지
  - 글 쓰기 구현
- 게시글 상세 페이지
  - 조회수 증가 구현
  - 글 삭제 구현
- 게시글 수정 페이지
  - 글 수정 구현

## API 명세

|순서|Method|URI|설명
|:--:|-----|----------|----------|
|1|GET|/board|게시글 전체조회
|2|GET|/board/search/{keyword}|제목, 내용으로 게시글 검색
|3|GET|/board/{no}|게시글 상세조회
|4|POST|/board|게시글 작성
|5|PUT|/board{no}|게시글 수정
|6|DELETE|/board/{no}|게시글 삭제

## Git Convention

- feat : 새로운 기능 추가
- fix : 버그 수정
- docs : 문서 수정
- style : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
- refactor : 코드 리펙토링
- test : 테스트 코드, 리펙토링 테스트 코드 추가
- chore : 빌드 업무 수정, 패키지 매니저 수정

## 고민할 점

- Dto의 사용 범위
  - 메서드당 dto를 부여하면 dto 개수가 너무 많아짐
  - 좀 더 포괄적인 dto를 만들고 컨트롤러에서 조립 고려..?

- 엔터티 생성
  - 엔터티 내의 생성자 및 정적 메서드로 생성 시 인자가 고정됨
  - 엔터티 특성 및 상황에 생성 시 인자가 달라질 수 있음
  - 모든 상황에 맞춰서 메서드를 만들기보단 dto 내 빌더패턴 고려

- 검색 메서드
  - 지금은 제목 or 내용 검색이지만 후에 작성자 검색, 제목만 검색 등 추가가능
  - 상황마다 메서드를 추가하기보단 오버로딩을 고려