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



**테스트 curl **

curl -X PUT 'https://fx68tqoqbk.execute-api.ap-northeast-2.amazonaws.com/regist' \
  -H 'content-type: application/json' \
  -d '{
    "internationalPhoneNumber" : "테스트ID(S)값입력",
    "name" : "테스트이름값입력",
    "email" : "test@email.com",
    "isAgree" : true
}'

