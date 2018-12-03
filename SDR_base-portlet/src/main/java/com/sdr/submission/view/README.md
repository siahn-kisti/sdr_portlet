### View Submission - File Upload

- 파일업로드 임시 경로 및 용량 설정
	- 경로: Admin > Control Panel > Server Administration > File Uploads
	- 용량설정: Overall Maximum File Size
	- 임시경로설정: Temporary Storage Directory

- DataView 파일업로드 경로 설정
	- 설정파일: resources/portlet.properties
	- 경로설정: dataview.temp=E:/Liferay_maven/workspace/sdr-parent/SDR_base-portlet/src/main/webapp
	  (SDR_base-portlet의 workspace 경로로 지정)
	- 실제 fullpath: {dataview.temp}/WEB-INF/jsp/{dataTypeTitle}/






