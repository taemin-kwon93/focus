# focus

목차 5번까지의 내용이 AWS에 서비스를 배포하고 실행하기 위한 절차 입니다.

6번 이후의 내용은 추가적으로 진행한 내용입니다.
SQS Test내용과 Lambda에서 Javascript로 index.js를 작성하여 배포할 때의 코드 내용입니다.

<b>목차</b>
1. Lambda 함수 생성과 기능 구현. <br/>
2. DynamoDB Table 생성과 Lambda함수 환경변수 설정. <br/>
3. 구현된 코드, S3에 업로드. <br/>
4. Amazon S3로 부터 Lambda에 코드소스를 업로드. <br/>
5. API GateWay 생성 및 설정. <br/>

6. Demo9에 SQS 예제. <br/>
7. Javascript로 index.js를 작성하고 배포하기. <br/>

--------------------------------------------------------------------------------------<br/><br/><br/>

<b>본문</b><br/>

 1. Lambda 함수 생성과 기능 구현.</b> <br/>

<img width="450" alt="2-Make-Lambda" src="https://user-images.githubusercontent.com/79136534/172765693-8f227df2-f103-453d-95fc-7a087cb772fb.png">

AWS Management 페이지에서 람다 함수를 검색한 후,  <br/>
AWS Lambda페이지에서 함수 생성을 클릭합니다. <br/>
1번과 2번의 차례에 따라,  <br/>
함수이름, 런타임 설정, 역할구성, 역할 이름 설정을 해준 후, 함수를 생성합니다. <br/><br/>


<b> 2. DynamoDB Table 생성과 Lambda함수 환경변수 설정.</b> <br/>
<img width="350" alt="4-Make-DynamoDB" src="https://user-images.githubusercontent.com/79136534/172766675-f2c3587c-dff3-430a-bfa3-1c98fb4b441c.png"> <br/>

테이블 생성을 클릭하고  <br/>
테이블 이름, 파티션 키 를 설정해 준 후 아래에 테이블 생성을 클릭합니다. <br/><br/>

<b> 3. 구현된 코드, S3에 업로드.</b> <br/>
<img width="450" alt="6-Make-S3Bucket" src="https://user-images.githubusercontent.com/79136534/172767327-b7ef7de8-f63f-4700-b4df-73734d9c51cb.png"> <br/>
S3 버킷 생성을 클릭합니다. <br/>
버킷명과 리전을 설정해줍니다. <br/><br/>


<img width="450" alt="8-Make-S3Bucket" src="https://user-images.githubusercontent.com/79136534/172768482-ec2e1176-9137-45cc-98aa-170290d5c5ef.png"> <br/>
<img width="450" alt="9-Make-S3Bucket" src="https://user-images.githubusercontent.com/79136534/172768486-9b2a8fc9-1aa5-4916-a520-1d3b10a0466b.png"> <br/>
버킷을 생성한 후, 구현된 jar파일을 담아줍니다. <br/> <br/>

<img width="450" alt="image" src="https://user-images.githubusercontent.com/79136534/172768630-33fde658-2d07-4cc3-b0ff-1f3ff538fa56.png"><br/>
<img width="450" alt="image" src="https://user-images.githubusercontent.com/79136534/172769704-e794d35e-6b62-4490-b1e9-90f36ba54060.png"><br/>
Lambda 파일 업로드를 S3에 객체 URL로 부터 받아옵니다.<br/> 
핸들러정보를 해당 파일에 맞게 수정해줍니다. <br/>
ex) 패키지경로.클래스명::메소드명 -> example.Hello::handleRequest<br/><br/>

<img width="600" alt="10-Make-Gate" src="https://user-images.githubusercontent.com/79136534/172771274-0ce567a6-7bfe-4756-89f5-c7f981c4e88e.png"><br/>
API Gateway를 생성해준 후 경로와 통합 설정을 해줍니다.<br/>




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

