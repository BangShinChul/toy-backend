### toy project 백엔드 (Spring boot)
---
### AWS CodeDeploy & Travis CI를 통한 Spring boot gradle로 만든 RESTful API 배포 자동화 
참고 URL : 
- http://jojoldu.tistory.com/263?category=635883
- http://jojoldu.tistory.com/265?category=635883
- http://jojoldu.tistory.com/267?category=635883

전체 구조는 아래와 같습니다.
![image](https://user-images.githubusercontent.com/26675063/43045525-00881a90-8df5-11e8-80a6-6f92a264a6bc.png)

***
### 18.09.15 jpa database 정보 jasypt로 암호화 하는 작업
> 참고 : <a href="https://justinrodenbostel.com/2014/06/06/part-5a-additional-credential-security-spring-data-jpa-jasypt/">링크</a>

***
### 18.08.14 gradle jpa + mariadb 참고
- https://springframework.guru/configuring-spring-boot-for-mariadb/
- https://spring.io/guides/gs/accessing-data-rest/
- http://tech.thegajago.com/2016/08/23/%EA%B0%9C%EC%9D%B8%EC%B7%A8%ED%96%A5-jpa-%EC%82%AC%EC%9A%A9%EA%B8%B0-1/
- http://bnbgg.tistory.com/3

***
### 18.08.29 rest api mariadb 부분 설정한 후 배포 
- DB설정을 추가하고나서 rest api가 정상동작하지않는 이슈 발생. 원인 확인해보고 해결할 것.
***

***
### 18.10.20 DB 설정 작업 완료
- DB설정을 추가하고나서 rest api가 정상동작하지않는 이슈 해결 완료. DB 설정 작업 완료.
***

***
### 18.10.21 AWS CodeDeploy CI/CD 작업 수정
- 인스턴스를 Ubuntu 16.04 LTS로 변경하고나서 CodeDeploy가 정상작동하지않는 버그 발견. 
- 문제는 새로 작성한 배포 쉘 스크립트가 퍼미션 설정이 안되어있었음.
- 새로 쉘을 작성하고 사용할땐 꼭 chmod +x script.sh <-- 이와같이 퍼미션 이슈를 해결한 뒤 작업할 것.
***