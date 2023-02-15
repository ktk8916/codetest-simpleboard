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
