## How to run on Docker container
### MacOS
```
cd scripts
sh localbuild.sh
```
### WindowsOS
```
cd scripts
sh .localbuild.sh
```

## Project structure

### waggle-common

- AOP
- 로깅 기능
- 공통 config, enum 클래스
- common response

### waggle-api

- controller
- service
- repository
- entity

### waggle-admin

- 관리자 페이지에 필요한 기능

### waggle-service

- batch scheduler 기능