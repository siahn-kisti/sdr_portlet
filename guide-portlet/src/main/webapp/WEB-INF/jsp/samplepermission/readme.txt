deault.xml 에서 지원되는 기본 권한설정은 아래의 태그들로 가능하나 사용자 지정 권한에 대해서는 별도 태그를 사용한 설정이 불가합니다.(Control Panel 이용)
     
community-defaults (deprecated -> site-member-dafault로 대체)

1. site-member-defaults (site-member 기본권한 필수 입력 사항)
2. guest-defaults (guest 기본권한)
3. guest-unsupported(guest 미지원 권한 설정)
4. layout-manager (layout-manager 기본 권한 미사용시 전체  action권한 부여)
5. owner-defaults (owner 기본권한)

※. 태그의 순서는 상기와 같아야 하며 순서가 바뀔시 오류 발생 
	layout-manager, owner-default 태그는 필수 아님!! 
	생략시 support 상에 명시된 action-key 전체에 대한 권한을 가짐
	
 - default.xml 에서 default 태그 내부에 작성한 action-key는 liferay 상에서 설정해제하여도 적용된것으로 인식된다.
 - guest-unsupported에 추가시 liferay Roles 상에서 수정할수 있는 메뉴 자체가 나오지 않는다.
 - 태그만 입력 후 아무런 action-key를 주지 않으면 모든 권한이 사용가능한 것으로 설정되며 liferay Roles에서 수정가능하다 
 	상기의 경우 VIEW는 적용된것으로 추측된다?
