# READEME

## svn ignore files

* Eclipse > Preferences > Team > Ignored Resources

```shell
# default
.svn
target
build
classes
rebel.xml

# ide
.project
.settings
.classpath
.iml
.idea

# os
.DS_Store
Thumbs.db
```

* svn에 수동으로 올리지 말아야 할 파일 (개인PC경로세팅파일, 속성이 변경되면 commit 해야함)

```
/sdr-parent/pom.xml
/sdr-parent/SDR_base-portlet/src/main/resources/portlet.properties
```


## DB 변경사항

> service.xml table, colum 변경사항 전파..  
> service-build 는 코드 생성기 임으로 수정 및 삭제하는 기능은 없음..    
> 현재 각자 별도의 DB를 사용함으로 테이블의 동기화는 각자 아래의 sql 문을 실행   

```sql
--2017.06.15
drop table sdr_Dataset_User;
alter table sdr_SdrUsers add createUser LONG;
```
