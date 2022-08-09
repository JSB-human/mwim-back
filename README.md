# 내가 만든 세상 백엔드 서버

## 개요
Nextjs와 연결하기 위한 Spring boot를 활용한 REST API서버

## 프론트
[내가 만든 세상](https://github.com/JSB-human/mwim)

## 개발 환경
### 언어
Java (JDK 1.8)
### 서버
AWS EC2
### 프레임워크
Spring Boot, MyBatis, Spring Security
### 데이터베이스
MariaDB, Amazon RDS
### API
JavaMail

## 작업

### Next js와 연결 
Nextjs에서의 proxy 설정으로 cors에러는 나오지 않았지만 Spring Security 적용 후 다시 cors에러 발생  
> SecurityConfig.java 에서 cors설정을 해줌으로 해결되었다.

### JavaMail Gmail 연결
Gmail에서의 보안 수준이 낮은 앱의 액세스 허용의 지원이 종료되었다.
![image](https://user-images.githubusercontent.com/59051855/183757687-c88d1aa4-4341-486f-82ca-5e7a6640a350.png)
> 앱 비밀번호를 부여받아 액세스 하는데 성공했다.

### EC2 https 적용
프론트는 vercel을 사용했기에 https가 적용되어있다. EC2에 올려져있는 서버도 https로 만들어야했다. 돈을 들이지 않고.
> 무료 도메인을 받은뒤 CloudFlare를 사용했다.

