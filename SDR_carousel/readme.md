SDR Carousel - Image Slider Portlet Installation Guide 1.0
===

순서
---

1. 일반 설명
2. 설치
3. 포틀릿에서 필요한 **SLIDER_STRUCTURE** 구성
4. 포틀릿의 **SLIDER_STRUCTURE** 에서 필요한 **SLIDER_TEMPLATE** 를 구성
5. Carousel Image Slider Portlet의 Web Contents 구성
6. Carousel Image Slider Portlet 구성

1.일반적인 설명
---
이 플러그인을 Release하면 모든 포털 관리자가 모듈을 끌어서 놓기 만하고 Liferay의 문서 라이브러리에서 이미지를 사용하여 이미지 슬라이드를 추가하여 이미지 슬라이더를 추가하고 사용자 정의 할 수 있습니다.

포틀릿은 Jquery를 사용하여 작성되었습니다.

2.설치
---

1. 관리자로 로그인하고 Control Panel(제어판)로 이동하십시오.
2. Apps(응용프로그램)  → App Manager(응용프로그램 관리자) → Install(설치)을 클릭하세요.
3. File Upload를 클릭 한 다음 찾아보기를 클릭하고 SDR Carousel portlet war 파일을 검색합니다. 이 이름은 "SDR_carousel-portlet-0.0.1-SNAPSHOT.war"와 유사합니다.
   ![Alt text](SDR_carousel_readme_01.png)
    그림 1: App Manager

4. war 파일이 선택되면 Install 버튼을 클릭하세요.
   ![Alt text](SDR_carousel_readme_02.png)
    그림 2: Upload a new WAR File.

5. 포틀릿이 설치되면 구성을 시작할 수 있습니다.

3.포틀릿에서 필요한 **SLIDER_STRUCTURE** 구성
---

1.  관리자로 로그인하고 Dock Bar에서 Admin (관리) → Site Administration (사이트 관리) → Content (컨텐츠)로 이동합니다.
   ![Alt text](SDR_carousel_readme_03.png)
    그림 3: Content Menu

   2.Web Content → Manage → Structures 를 클릭하세요.
    ![Alt text](SDR_carousel_readme_04.png)
    그림 4: Structures Menu

   3.팝업창에서 +Add를 클릭하여 필요한 **"SLIDER_STRUCTURE"** 필드를 생성합니다.
    ![Alt text](SDR_carousel_readme_05.png)
    그림 5: Add Structure

2. **"SLIDER_STRUCTURE"** 의 이름과 설명을 입력합니다.
   ![Alt text](SDR_carousel_readme_06.png)
    그림 6: Structure Name and Description, required values.

3. 이제 슬라이더에 필요한 Structure 필드를 만들 차례입니다.
    - "View"와 "Source"탭이 보일 때까지 Structures 팝업을 아래로 스크롤하세요.
    - "Source" 탭을 클릭하세요.
    - 그런 다음 다음 페이지에 나타나는 xml을 복사하여 텍스트 영역에 붙여 넣어 기존의 모든 xml 내용을 바꿉니다.

```xml
<root available-locales="en_US" default-locale="en_US">
	<dynamic-element dataType="string" indexType="" name="title" readOnly="false" repeatable="false" required="false" showLabel="true" type="text" width="small">
		<meta-data locale="en_US">
			<entry name="label">
				<![CDATA[Title]]>
			</entry>
			<entry name="predefinedValue">
				<![CDATA[]]>
			</entry>
			<entry name="tip">
				<![CDATA[]]>
			</entry>
		</meta-data>
	</dynamic-element>
	<dynamic-element dataType="string" indexType="" name="link" readOnly="false" repeatable="false" required="false" showLabel="true" type="text" width="small">
		<meta-data locale="en_US">
			<entry name="label">
				<![CDATA[Link]]>
			</entry>
			<entry name="predefinedValue">
				<![CDATA[]]>
			</entry>
			<entry name="tip">
				<![CDATA[]]>
			</entry>
		</meta-data>
	</dynamic-element>
	<dynamic-element dataType="string" indexType="" name="text" readOnly="false" repeatable="false" required="false" showLabel="true" type="textarea" width="small">
		<meta-data locale="en_US">
			<entry name="label">
				<![CDATA[Text]]>
			</entry>
			<entry name="predefinedValue">
				<![CDATA[]]>
			</entry>
			<entry name="tip">
				<![CDATA[]]>
			</entry>
		</meta-data>
	</dynamic-element>
	<dynamic-element dataType="image" fieldNamespace="wcm" indexType="" name="image" readOnly="false" repeatable="false" required="false" showLabel="true" type="wcm-image" width="">
		<meta-data locale="en_US">
			<entry name="label">
				<![CDATA[Image]]>
			</entry>
			<entry name="predefinedValue">
				<![CDATA[]]>
			</entry>
			<entry name="tip">
				<![CDATA[]]>
			</entry>
		</meta-data>
	</dynamic-element>
</root>
```

6.	"View" 탭을 클릭하고 생성 된 Structure Fields를 살펴보고, "Save" 버튼을 클릭하여 팝업을 닫으세요.
   ![Alt text](SDR_carousel_readme_07.png)
    그림 7: SLIDER_STRUCTURE Fields

7.	최근에 만든 **"SLIDER_STRUCTURE"** 를 보여주는 팝업창으로 바뀝니다.
   ![Alt text](SDR_carousel_readme_08.png)
    그림 8: SLIDER_STRUCTURE Added

8.	오른쪽 상단 "X" 버튼을 눌러 Structures 팝업을 닫고, 다음 Template 작성을 진행합니다.

4.포틀릿의 **SLIDER_STRUCTURE** 에서 필요한 **SLIDER_TEMPLATE** 를 구성
---

1. 관리자로 로그인하고 Dock Bar에서 Admin (관리) → Site Administration (사이트 관리) → Content (컨텐츠)로 이동합니다.
   ![Alt text](SDR_carousel_readme_09.png)
    그림 9: Content Menu

2. Web Content → Manage → Templates를 클릭하세요.
  ![Alt text](SDR_carousel_readme_10.png)
  그림 10: Templates Menu

3. **"SLIDER_STRUCTURE"** 의 템플리트 작성. (모든 Liferay의 Structures는 템플릿이 필요합니다.)
4. 팝업창에서 + 추가를 클릭하여 필요한 **"SLIDER_TEMPLATE"** 필드를 채 웁니다.
   ![Alt text](SDR_carousel_readme_11.png)
    그림 11: Add Template

5. **"SLIDER_TEMPLATE"** 의 이름을 입력합니다.
   - 그런 다음 Details 아래의 "Select"버튼을 클릭하십시오.
   - 팝업에서 **SLIDER_STRUCTURE** 행의 "Choose"버튼을 클릭하십시오.
   - 그런 다음 Languange's Select box에서 "FreeMarker (.ftl)"를 선택하십시오.
     ![Alt text](SDR_carousel_readme_12.png)
     그림 12: SLIDER_TEMPLATE Template

6. 마지막으로 팝업의 마지막에 있는 "Save"버튼을 클릭하세요. 최근에 만든 **"SLIDER_TEMPLATE"** 을 보여주는 팝업창으로 바뀝니다.
   ![Alt text](SDR_carousel_readme_13.png)
    그림 13: SLIDER_TEMPLATE added.

7. 오른쪽 상단의 "X" 버튼을 클릭하여 템플릿 팝업을 닫으세요.

- 이제 SDR Carousel Slider Back End 구성이 완료되었습니다.
- 다음 단계에서 페이지에 포틀릿을 배치 할 때 사용할 두 개의 테스트 Web Content를 작성하겠습니다.

5.Carousel Image Slider Portlet의 Web Contents 구성
---

1. 관리자로 로그인하고 Dock Bar에서 Admin (관리) → Site Administration (사이트 관리) → Content (컨텐츠)로 이동합니다.
  ![Alt text](SDR_carousel_readme_14.png)
  그림 14 : Content Menu

2. Web Content → Add → Basic Web Content를 클릭하세요.
  ![Alt text](SDR_carousel_readme_15.png)
  그림 15 : Add Basic Web Content Menu

3. Title을 입력하고 "Publish" 버튼을 클릭하여 **Basic Web Content** 를 생성합니다. (저장하지 않고 Structure를 변경할 시에 오류가 발생할 수 있다고 합니다.)
  ![Alt text](SDR_carousel_readme_16.png)
  그림 16 : Publish Basi Web Content

4. Title을 클릭하여 이전 Web Content를 다시엽니다.
  ![Alt text](SDR_carousel_readme_17.png)
  그림 17 : Reopen Basic Web Content

5. 이제 편집을 시작합니다. 먼저 Structure가 Default로 설정된 선택 단추를 클릭하여 그리드에서 **"SLIDER_STRUCTURE"** 를 선택하세요. 경고 팝업에서 확인을 클릭합니다. Structure를 **"SLIDER_STRUCTURE"** 로 변경하면, 변경한 Structure로 새로 고침됩니다.

![Alt text](SDR_carousel_readme_18.png)
그림 18 : Choose SLIDER_STRUCTURE.

6. 변경 사항을 확인하고 **"SLIDER_STRUCTURE"** 에 내용을 채웁니다.
  ![Alt text](SDR_carousel_readme_19.png)
  그림 19 : SLIDER_STRUCTURE fields.

7. 포틀릿을 구성 할 때 서로 다른 데이터를 가진 다른 유사한 웹 컨텐트를 작성하여 포틀릿을 구성 할 때 전환을 만듭니다.

이 구성 후 Slider 데모 웹 컨텐츠 구성이 완료됩니다.

다음 단계는 슬라이더 포틀릿을 추가하여 기본 Liferay 페이지를 시작하고 이전에 작성한 웹 컨텐츠를 표시하도록 포틀릿을 구성하는 단계입니다.

6.Carousel Image Slider Portlet 구성
---

1. 관리 사용자로 로그인하고 Welcome 페이지 또는 사용하려는 페이지로 이동하여 페이지 왼쪽 막대에서 [+] Icon → Add → Applications → SDR Carousel Slider Portlet 범주를 찾아 → Slider Portlet → Add 클릭.

 ![Alt text](SDR_carousel_readme_20.png)
 그림 20: Adding Slider Portlet.

2. 오른쪽 상단의 포틀릿 구성 아이콘을 클릭 한 다음 드롭 다운 메뉴에서 "Configuration"을 선택하십시오.

 ![Alt text](SDR_carousel_readme_21.png)
 그림 21: Adding Slider Portlet.

3. 이제 SDR Carousel Slider Portlet 팝업이 나타나서 구성을 시작합니다.
4. TAB Slides : Web Content Select Box에서 이전에 작성한 Web Content를 선택하고 "Add Slide"버튼을 클릭하면 해당 순서대로 그리드에 표시되며, Slides 그리드에서 순서를 변경하거나 삭제할 수 있습니다.

 ![Alt text](SDR_carousel_readme_22.png)
 그림 22: Slider Portlet – TAB Slides.

5. TAB Slide Animation : 슬라이더 애니메이션 매개 변수를 지정합니다.

 ![Alt text](SDR_carousel_readme_23.png)
 그림 23: Slider Portlet – TAB Slide Animation.

6. TAB Slide Look and Feel : 이미지 크기, 사용한 테마, 불투명도 및 기타 CSS 관련 항목을 지정할 수있는 곳입니다.

 ![Alt text](SDR_carousel_readme_24.png)
 그림 24: Slider Portlet – TAB Slide Look and Feel.

7. TAB Slide Navigation : 다른 탐색 매개 변수가 설정된 위치입니다.

 ![Alt text](SDR_carousel_readme_25.png)
 그림 25: Slider Portlet – TAB Slide Navigation.

- 이제 Slider Configuration Pop Up을 닫은 후에 우리는 설정한 Carousel Slider를 볼 수있을 것입니다.
