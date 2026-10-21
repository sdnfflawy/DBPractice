# 원격 MariaDB 연결 Java SQL 콘솔

Ubuntu 서버의 MariaDB에 Windows의 Java 프로그램으로 원격 접속하여
테이블을 조회, 삽입, 수정, 삭제하는 콘솔 프로그램입니다.

## 기술 스택
Java 21, JDBC(MariaDB Connector/J), MariaDB, Linux Ubuntu

## 구조
Main → StudentDAO → DBConnection → JDBC 드라이버 → MariaDB

## JDBC 드라이버
공식 다운로드: https://mariadb.com/downloads/connectors/

## 실행 방법
1. 서버에 DB(test)와 students 테이블 생성
2. 접속 정보 설정
3. MariaDB Connector/J jar을 Build Path에 추가
4. Main 실행
