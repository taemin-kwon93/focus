# focus

목차 5번까지의 내용이 AWS에 서비스를 배포하고 실행하기 위한 절차 입니다.

6번 이후의 내용은 추가적으로 진행한 내용입니다.
SQS Test내용과 Lambda에서 Javascript로 index.js를 작성하여 배포할 때의 코드 내용입니다.

목차
1. Lambda 함수 생성과 기능 구현.
2. DynamoDB Table 생성과 Lambda함수 환경변수 설정.
3. 구현된 코드, S3에 업로드.
4. Amazon S3로 부터 Lambda에 코드소스를 업로드.
5. API GateWay 생성 및 설정.

6. Demo9에 SQS 예제.
7. Javascript로 index.js를 작성하고 배포하기.

--------------------------------------------------------------------------------------
 1. Lambda 함수 생성과 기능 구현.

<img width="890" alt="1-Make-Lambda" src="https://user-images.githubusercontent.com/79136534/172765521-e6524448-9a43-431d-90f5-201e2065c8e6.png">
AWS Management 페이지에서 람다 함수를 검색한 후, 
AWS Lambda페이지에서 함수 생성을 클릭합니다.

<img width="844" alt="2-Make-Lambda" src="https://user-images.githubusercontent.com/79136534/172765693-8f227df2-f103-453d-95fc-7a087cb772fb.png">
1번과 2번의 차례에 따라, 
함수이름, 런타임 설정, 역할구성, 역할 이름 설정을 해준 후, 함수를 생성합니다. 


 2. DynamoDB Table 생성과 Lambda함수 환경변수 설정.
<img width="886" alt="3-Make-DynamoDB" src="https://user-images.githubusercontent.com/79136534/172766351-45254ba1-8dc6-465f-b56a-02be01fd9ed7.png">
<img width="623" alt="4-Make-DynamoDB" src="https://user-images.githubusercontent.com/79136534/172766675-f2c3587c-dff3-430a-bfa3-1c98fb4b441c.png">

테이블 생성을 클릭하고 
테이블 이름, 파티션 키 를 설정해 준 후 아래에 테이블 생성을 클릭합니다.

 <b>3. 구현된 코드, S3에 업로드.</b>




--------------------------------------------------------------------------------------

**테스트 curl **

curl -X PUT 'https://fx68tqoqbk.execute-api.ap-northeast-2.amazonaws.com/regist' \
  -H 'content-type: application/json' \
  -d '{
    "internationalPhoneNumber" : "테스트ID(S)값입력",
    "name" : "테스트이름값입력",
    "email" : "test@email.com",
    "isAgree" : true
}'

