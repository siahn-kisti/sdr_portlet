### EXT plugin 실행 절차
1. mvn install 후 mvn deploy
2. deploy가 완료되면 서버 재시작

### EXT plugin 수정한 부분
- SDR_search_ext-ext-impl (portal-impl.jar에 있는 class 수정)
- SDR_search_ext-ext-service (portal-service.jar에 있는 class 수정)