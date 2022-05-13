# FitQA-Core
`SpringBoot`기반으로 만들어진 FitQA 서비스의 기본적인 기능을 수행하는 서비스입니다.
다음과 같은 도메인을 포함하고 있습니다.
- 유저 : 소셜 로그인, 유저 CRUD
- 트레이너 : 경력, 학력 등의 트레이너 프로필, 피드백 가격 차등 설정, 트레이너 CRUD
- 피드백 : 유저가 트레이너에게 피드백 요청, 피드백 답변, 피드백 동영상 처리


## How to build

### Variables
빌드를 수행하기 위해서 아래와 같은 작업이 필요합니다. 아래 방법 중 하나를 골라 수행하면 됩니다.

#### Database 설정
- 파일로 설정하기
1. `spring/fitqa-spring-java/src/main/resources` 안에 `database.properties` 파일을 만듭니다.
2. 파일 안에 데이터베이스 정보를 입력합니다.  
**입력예시**
```properties
JDBC_DATABASE_URL=jdbc:postgresql://<db_url>:<port>/<db_name>
JDBC_DATABASE_USERNAME=<username>
JDBC_DATABASE_PASSWORD=<password>
```

- 실행 시 `Env`로 추가하기
1. `gradlew bootRun -Pargs=--JDBC_DATABASE_URL=jdbc:postgresql://<db_url>:<port>/<db_name>,--JDBC_DATABASE_USERNAME=<username>,--JDBC_DATABASE_PASSWORD=<password>`
`gradlew bootRun` 뒤에 `-Pargs` 안에 데이터베이스 정보를 추가합니다


#### Secret Key 설정
- 파일로 설정하기
1. `spring/fitqa-spring-java/src/main/resources` 안에 `secrets.properties` 파일을 만듭니다.
2. 파일 안에 SecretKey 정보를 입력합니다.  
**입력예시**
```properties
GOOGLE_CLIENT_ID=<google_client_id>
GOOGLE_CLIENT_SECRET=<google_client_secret>

KAKAO_CLIENT_ID=<kakao_client_id>
KAKAO_CLIENT_SECRET=<kakao_client_secret>
KAAKO_REDIRECT_URL=<kakao_redirect_url>

NAVER_CLIENT_ID=<naver_client_id>
NAVER_CLIENT_SECRET=<naver_client_id>
NAVER_REDIRECT_URL=<naver_redirect_url>
```

- 실행 시 `Env`로 추가하기
1. `gradlew bootRun` 뒤에 `-Pargs` 안에 데이터베이스 정보를 추가합니다


## Tech/framework used
- Clean Architecture
- Spring Boot
- OAuth2
- AWS SQS
