# focus

목차 5번까지의 내용이 AWS에 서비스를 배포하고 실행하기 위한 절차 입니다.

6번 이후의 내용은 추가적으로 진행한 내용입니다.
SQS Test내용과 Lambda에서 Javascript로 index.js를 작성하여 배포할 때의 코드 내용입니다.

목차
1. Lambda 함수 생성과 기능 구현. <br/>
2. DynamoDB Table 생성과 Lambda함수 환경변수 설정. <br/>
3. 구현된 코드, S3에 업로드. <br/>
4. Amazon S3로 부터 Lambda에 코드소스를 업로드. <br/>
5. API GateWay 생성 및 설정. <br/>

6. Demo9에 SQS 예제. <br/>
7. Javascript로 index.js를 작성하고 배포하기. <br/>

--------------------------------------------------------------------------------------


<b>  위 목차 내용에 대한 자세한 과정입니다. <br/>
 1. Lambda 함수 생성과 기능 구현.</b> <br/>

<img width="350" alt="1-Make-Lambda" src="https://user-images.githubusercontent.com/79136534/172765521-e6524448-9a43-431d-90f5-201e2065c8e6.png"> <br/>
<img width="300" alt="2-Make-Lambda" src="https://user-images.githubusercontent.com/79136534/172765693-8f227df2-f103-453d-95fc-7a087cb772fb.png">

AWS Management 페이지에서 람다 함수를 검색한 후,  <br/>
AWS Lambda페이지에서 함수 생성을 클릭합니다. <br/>
1번과 2번의 차례에 따라,  <br/>
함수이름, 런타임 설정, 역할구성, 역할 이름 설정을 해준 후, 함수를 생성합니다. <br/><br/>


<b> 2. DynamoDB Table 생성과 Lambda함수 환경변수 설정.</b> <br/>
<img width="350" alt="3-Make-DynamoDB" src="https://user-images.githubusercontent.com/79136534/172766351-45254ba1-8dc6-465f-b56a-02be01fd9ed7.png"> <br/>
<img width="350" alt="4-Make-DynamoDB" src="https://user-images.githubusercontent.com/79136534/172766675-f2c3587c-dff3-430a-bfa3-1c98fb4b441c.png"> <br/>

테이블 생성을 클릭하고  <br/>
테이블 이름, 파티션 키 를 설정해 준 후 아래에 테이블 생성을 클릭합니다. <br/><br/>

<b> 3. 구현된 코드, S3에 업로드.</b> <br/>
<img width="350" alt="5-Make-S3Bucket" src="https://user-images.githubusercontent.com/79136534/172767321-f5292a6c-ed88-4c3f-b8b2-cef6d530727d.png"> <br/>
<img width="350" alt="6-Make-S3Bucket" src="https://user-images.githubusercontent.com/79136534/172767327-b7ef7de8-f63f-4700-b4df-73734d9c51cb.png"> <br/>
S3 버킷 생성을 클릭합니다. <br/>
버킷명과 리전을 설정해줍니다. <br/><br/>

<img width="350" alt="7-Make-S3Bucket" src="https://user-images.githubusercontent.com/79136534/172768480-a2c5f84e-77ad-488b-a189-862a2c72b48c.png"> <br/>
<img width="350" alt="8-Make-S3Bucket" src="https://user-images.githubusercontent.com/79136534/172768482-ec2e1176-9137-45cc-98aa-170290d5c5ef.png"> <br/>
<img width="350" alt="9-Make-S3Bucket" src="https://user-images.githubusercontent.com/79136534/172768486-9b2a8fc9-1aa5-4916-a520-1d3b10a0466b.png"> <br/>
버킷을 생성한 후, 구현된 jar파일을 담아줍니다. <br/> <br/>

<img width="350" alt="image" src="https://user-images.githubusercontent.com/79136534/172768630-33fde658-2d07-4cc3-b0ff-1f3ff538fa56.png">

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

