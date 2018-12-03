# README.md

## Liferay

### 공식사이트

liferay <https://www.liferay.com/>  
Quick Start <https://web.liferay.com/quick-start>  
developer network <https://dev.liferay.com/>  
Tutorials <https://dev.liferay.com/develop/tutorials/-/knowledge_base/6-2/tutorials>  
Liferay IDE <https://web.liferay.com/downloads/liferay-projects/liferay-ide>  


### liferay defulat column

groupId          (site ID) 커뮤니티 별 ID  
companyId        포털 인스턴스의 pk  
userId           유저Id  
userName         유저명  
createDate       등록일  
//modifiedDate     수정일  
//deleteDate       삭제일(임의로추가)  


### service.xml 테이블 수정시 반영이 안될때

> 테이블 생성 또는 수정은 서버(liferay tomcat) 기동될때 반영됨.  
> 테이블의 데이터는 모두 삭제 됨으로 주의.

방법1. src/main/resources/service.properties의 build.number를 강제로 증가.  

방법2. ServiceComponent 테이블의 컬럼 데이터 삭제  

select * from ServiceComponent where buildNamespace = 'SDR';  

-- delete from ServiceComponent where buildNamespace = 'SDR';  

