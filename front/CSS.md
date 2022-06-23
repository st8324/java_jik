# CSS(Cascadeing Style Sheet)

### css 적용 방법

1. 각 태그에 style 속성을 이용

   * ```html
     <태그명 style="속성명:값; 속성명:값;"></태그명>
     ```

   * 해당 요소만 적용됨

   * 우선 순위가 가장 높음

2. `<style></style>`를 이용

   * head태그에 style 태그를 넣어서 활용

   * ```html
     <head>
         <style>
         	/* css 표현*/
             선택자{
                 속성명 : 값;
                 속성명 : 값;
             }
         </style>
     </head>
     ```

3. 외부 css파일을 연결하여 이용

   * head태그에 link태그를 이용하여 활용

   * ```html
     <head>
         <link rel="stylesheet" href="파일경로/파일명.css">
     </head>
     ```



### 선택자(selector)

* 요소(태그로 이루어진 요소)를 선택하는 이름

* 선택자와 일치하는 요소들에게 동일한 스타일을 적용

* 종류

  * 태그 선택자

    * 해당 태그명과 일치하는 모든 요소에 적용

    * 태그명

    * ```css
      /* 모든 p태그 요소들에게 글자 색을 빨강색으로 지정 */
      p{
          color : red;
      }
      ```

  * 클래스 선택자

    * 클래스와 일치하는 모든 요소에 적용

    * .클래스명

    * ```css
      .red{
          color : red;
      }
      ```

  * id 선택자

    * 해당 아이디와 일치하는 요소에 적용

    * 동일한 아이디를 가진 요소는 1개이하이어야 한다

    * #아이디명

    * ```css
      #id{
          color : red;
      }
      ```

  * 전체 선택자

    * 모든 요소에 적용

    * ```css
      *{
      	color : red;
      }
      ```

  * 속성 선택자

    * 해당 속성을 가진 모든 요소에 적용

    * []를 이용

    * ```css
      [요소속성명=값]{
          속성명 : 값;
      }
      ```

  * 가상 클래스 선택자

    * 어떤 상황이나 조건에서 적용

    * :가상클래스명

    * 대표적인 가상 클래스

      * :hover 
        * 마우스를 요소 위에 올림
      * :focus
        * 요소가 활성화됨. input태그들
      * :nth-child(n), :nth-of-type(n)
        * n번째 요소를 선택
        * first-child, last-child, first-of-type, last-of-type
    
    * ```css
      :가상클래스명{
          속성명 : 값;
      }
      
      a:hover{
          color : gray;
      }
      ```

* 선택자 조합

  * 요소들을 선택하기 위해 여러 선택자들을 혼합해서 사용

  * 자식 관계

    * `>`로 표현 

    * ```css
      선택자(부모요소) > 선택자(자식요소){
          속성명 : 값;
      }
      ```

    * 자식요소

      * 요소 안에 요소들이 배치되었을 때 안에 있는 요소가 자식요소, 밖에 있는 요소가 부모 요소
      * 쌍 태그 안에 태그들이 배치

  * 자손 관계

    * 자식 요소를 포함한 자손 요소들과의 관계

    * ` 공백` 으로 표현

    * ```css
      선택자(조상요소) 선택자(자손요소){
          속성명 : 값;
      }
      ```

  * 본인 관계

    * 일치하는 요소들 중에서 일부를 선택

    * 붙여서 표현

    * ```css
      선택자선택자{
      	속성명 : 값;
      }
      ```

    * 순서가 중요

    * 순서에 따라서 다른 선택자가 선택될 수 있음

      * 두번째 선택자에 태그명이 오는 경우

      * ```css
        /*div태그이면서 name 클래스를 가진 요소들을 선택
        	=> namediv 클래스를 가진 요소를 선택*/
        .namediv{
        	속성명 : 값;
        }
        /*div태그이면서 name 클래스를 가진 요소들을 선택(X)*/
        div.name{
        	속성명 : 값;
        }
        ```

    * 본인관계에서 불가능한 경우

      * 선택자 2개가 모두 태그명인 경우
      * 선택자 2개가 모두 아이디인 경우
        * 요소 하나엔 아이디를 최대 1개 지정가능

### 스타일 상속

* 부모 요소에 있는 스타일을 자손 요소들이 상속을 받음
* 자식 요소는 부모 요소에게 상속 받은 속성들을 적용한후, 본인 요소에 있는 스타일을 적용

### 선택자 우선순위

* 태그 선택자 : 1점
* 클래스 선택자 : 10점
* 아이디 선택자 : 100점
* 선택자 점수가 높은 스타일이 적용
* 선택자 점수가 같은 경우에는 마지막에 있는 스타일이 적용

### 색상 지정 방법

1. 16진수로 표현하는 방법
   * #r1r2g1g2b1b2
   * #ff0000 => 빨강
   * #00ff00 => 녹색
   * 색상별로 각 값들이 같은 경우(r1 == r2, g1==g2, b1==b2)
     * #ff0000 => #f00
2. 지정된 이름으로 표현하는 방법
   * CSS3에서 지정한 이름을 사용
   * red, blue 등 140여개의 색 이름
3. 함수를 이용하는 방법
   * rgb(r,g,b)
     * 빨간색, 녹색, 파란색을 이용하여 색상을 결정
     * r,g,b : 0~255십진수를 입력
   * rgba(r,g,b,a)
     * r,g,b에서 투명도를 추가
     * a : 0~1사이의 실수
   * hsl(h,s,l)
     * 색상, 채도 명도를 이용하여 색상을 결정
   * hsla(h,s,l,a)
     * hsl에서 투명도를 추가

### 속성(property)

* 색 관련 속성들
  * color
    * 글자색을 변경
  * background-color
    * 배경색
  * border-color
    * 테두리색

* 텍스트 관련 속성들
  * text-indent
    * 들여쓰기
    * px길이나 %를 이용
  * text-align
    * 정렬
    * left, right, center, justify(양쪽)
  * text-decoration
    * 텍스트 줄표시
    * none(없음), underline(밑줄), overline(윗줄), line-through(취소선)

* 폰트 관련 속성들

  * font-family 

    * 폰트 종류를 설정하는 속성

    * ```css
      선택자{
          font-family : 폰트명1, 폰트명2, 폰트명3;
      }
      ```

    * 폰트명1이 없으면 폰트명2가, 폰트명1,2가 없으면 폰트명3이 적용

    * 폰트명에 공백이 있는 경우 '' 또는 ""를 이용해서 묶어서 사용

    * 일반적으로 마지막 폰트명은 다음 셋 중 하나를 선택

      * serif
        * serif가 있는 폰트 종류
      * sans-serif
        * serif가 없는 폰트 종류
      * monospace
        * 각 글자 폭이 동일한 폰트 종류

    * 한글명 폰트는 한글명과 영문명을 같이 쓰는것이 좋다

  * font-size

    * 폰트 크기

  * font-style

    * 폰트 기울기

  * font-weight

    * 폰트 굵기
    * 100~900사이의 범위
    * 100단위로 관리
    * bold는 700으로 설정

  * font

    * font-style, font-weight, font-size, font-family를 순서대로 지정하여 사용하는 단축 속성

    * ```
      font : font-sytle, font-weight, font-size, font-family
      ```

    * font-size와 fint-family를 제외한 속성은 생략 가능

* 박스 모델 관련 속성

  * box-sizing

    * ```css
      box-sizing : border-box|content-box;
      ```

    * 박스 가로,세로 크기의 기준을 설정하는 속성

    * 기본값은 content-box

    * content-box는 가로,세로를 컨텐츠의 가로,세로로 계산

    * border-box는 가로,세로를 컨텐츠+패딩+테두리의 가로,세로로 계산

  * width, height

    * 가로, 세로를 정하는 속성

    * ```css
      width : 크기;
      hegith : 크기;
      ```

    * box-sizing : content-box

      * 가로 = 컨텐츠의 가로

    * box-sizing : border-box

      * 가로 = 컨텐츠의 가로 + 왼쪽 padding + 오른쪽 padding + 왼쪽 테두리 굵기 + 오른쪽 테두리 굵기

    * width가 같아도 box-sizing에 따라 실제 크기는 달라질 수 있다

  * padding

    * padding-top, padding-right, padding-bottom, padding-left

    * padding

      * padding-top, padding-right, padding-bottom, padding-left를 한번에 쓰는 단축 속성
      * 위, 오른쪽, 아래, 왼쪽 순으로 
      * 위를 기준으로 시계 방향

    * 테두리 안쪽 여백

    * ```css
      padding-top : 크기1;
      padding-right : 크기2;
      padding-bottom: 크기3;
      padding-left : 크기4;
      
      padding: 크기1 크기2 크기3 크기4;
      /* 오른쪽과 왼쪽이 대칭인 경우(크기2) */
      padding : 크기1 크기2 크기3 크기2;
      padding : 크기1 크기2 크기3;
      /* 오른쪽과 왼쪽이 대칭이고, 위와 아래가 대칭인 경우*/
      padding : 크기1 크기2 크기1 크기2;
      padding : 크기1 크기2;
      /* 모든 패딩이 같은 경우 */
      padding : 크기1;
      
      /* 오른쪽 패딩만 다른 경우 */
      padding : 크기1;
      padding-right : 크기2;
      ```
      
    * 패딩 색은 지정할 수 없음

    * 패딩 색은 컨텐츠 색과 동일(background-color)

  * border

    * border-top-width, border-right-width, border-bottom-width, border-left-width
    * border-width
      * 테두리 굵기
    * border-top-style, border-right-style, border-bottom-style, border-left-style
    * border-style
      * 테두리 종류
    * border-top-color, border-right-color, border-bottom-color, border-left-color
    * border-color
      * 테두리 색상
    * border-top, border-right, border-bottom, border-left
      * 테두리 굵기, 종류, 색상을 한번에 지정
    * border
      * 모든 테두리 굵기, 종류, 색상을 한번에 지정

  * margin

    * 테두리 밖 여백

    * 요소의 위치를 지정

    * margin-top, margin-right, margin-bottom, margin-left

    * margin

      * margin-top, margin-right, margin-bottom, margin-left를 순서대로 한번에 적용

    * 두 요소의 margin이 겹치면 하나만 적용

    * auto라는 값을 넣을 수 있다

      * 조건

        1. block태그인 경우

        2. 가로가 지정

      * block태그는 한 라인 전체에 공간을 할당

        * width가 지정된 경우, width를 제외한 나머지 길이가 margin으로 잡힘
        * auto로 지정하면 전체 가로에서 width를 제외한 나머지 여백을 반으로 나누어서 margin-left와 margin-right에 자동으로 할당

    * 요소 좌우 가운데 정렬

      * width 지정 후, margin : 0 auto;

* 둥근 테두리

  * 박스의 테두리를 둥글게 만드는 속성
  * border-top-left-radius, border-top-right-radius, border-bottom-right-radius, border-bottom-left-radius
  * border-radius
  * 버튼 생성할 때 많이 활용
  * border-radius는 길이의 반을 넘어가면 반으로 계산됨

* 이미지 테두리

  * 테두리를 이미지로 지정하는 속성

  * border-image

  * ```
    border-image : url(파일경로/파일명) 테두리이미지크기 타입;
    ```

* 배경

  * 배경색
    * background-color

  * 배경 이미지
    * background-image

  * 배경이미지 시작 위치
    * background-position

  * 배경 이미지 반복 여부
    * background-repeat

  * 배경 이미지 크기
    * background-size

  * background
    * 배경과 관련된 속성들을 한번에 사용하는 단축 속성
    * 배경색 배경이미지 배경위치/배경사이즈 배경반복

* 그림자

  * 텍스트 그림자

    * text-shadow

      * ```css
        text-shadow : 수평 수직 번짐 색상|none;
        
        text-shadow : 수평 수직 번짐 색상|none, 수평 수직 번짐 색상|none;
        ```

        * 수평 : 글자를 기준으로 x축으로 떨어진 정도
        * 수직 : 글자를 기준으로 y축으로 떨어진 정도
        * 번짐(blur) : 그림자를 선명하게 보여줄건지, 흐리게 보여줄건지 결정하는 속성으로, px로 설정
        * 색상 : 그림자 색상

      * ,를 이용하여 여러 그림자 효과를 한번에 줄 수 있다

  * 박스 그림자

    * box-shadow

      * ```css
        box-shadow : 수평 수직 번짐 크기 색상|none inset;
        ```

        * 크기 : 그림자 크기, 기본은 0, 생략 가능
        * inset : 음각 박스로 보이게 하는 값

      * ,를 이용하여 여러 그림자 효과를 한번에 줄 수 있다

  * 마우스 커서

    * cursor

    * 마우스 모양을 제어

    * ```css
      cursor : auto|crosshair|default|pointer|move|...|url;
      ```

  * 글자 관련 속성

    * line-height
      * 글자의 높이를 지정하는 속성
      * 요소의 height가 지정되어있지 않으면 line-height를 이용하여 높이를 계산
      * 글자를 위아래로 가운데 정렬할 때 사용

    * white-space
      * 공백 처리하는 방법
      * normal
        * 기본값
        * 연속 공백(엔터포함)을 하나로 함침. 한줄이 길어서 넘치면 자동으로 줄바꿈

      * nowrap
        * 연속 공백(엔터포함)을 하나로 함침. 줄바꿈은 br태그로만 일어남

      * pre
        * 연속 공백 유지. 줄 바꿈은 br태그와 엔터로 일어남

      * pre-wrap
        * 연속 공백 유지. 줄 바꿈은 br태그와 엔터로 일어남. 한줄이 길어서 넘치면 자동으로 줄바꿈

      * pre-line
        * 연속 공백을 하나로 함침. 줄바꿈은 br태그와 엔터로 일어남. 한줄이 길어서 넘치면 자동으로 줄바꿈

      * break-spaces
        * pre-wrap과 동일. 단, 아래 차이점을 제외
          * 연속 공백이 줄의 끝에 위치해도 공백을 차지
          * 연속 공백 중간과 끝에도 자동으로 줄을 바꿈

    * letter-spacing
      * 글자 사이의 간격

  * display

    * 요소의 display 설정하는 속성
    * inline, block, inline-block, flex 등
    * 태그의 기본 종류(inline, block, inline-block)와 상관없이 다른 종류로 설정해줄 수 있다.

  * position

    * 요소를 배치하는 방식을 설정
    * 요소 배치는 기본적으로 웹페이지에 나타난 순서대로 배치 됨
    * 이를 position을 통해 바꿀 수 있다
    * static 
      * 기본값

    * relative
      * 상대 배치
      * 원래 있어야 할 위치를 기준으로 상대위치를 계산해여 배치
      * top, bottom, left, right와 같이 사용 됨
      * absolute와 같이 사용됨
        * 자손 요소 중에 absoulte가 있고, 요소가 기준이 될 때 기준이 되는 조상 요소를 relative로 설정

    * absolute
      * 절대 배치
      * 웹페이지 특정 위치에 고정
      * 조상 요소 중에 position이 absolute나 relative가 없으면 브라우저를 기준으로 배치
      * 있으면 가장 가까운 조상요소를 기준으로 배치

    * fixed
      * 고정 배치
      * 브라우저 특정 위치에 고정
      * 위로가기 버튼


### 표준단위

* **em** : 요소의 기본값의 배수, 3em => 기본값의 3배
* **rem** : 문서의 기본값의 배수
* **%** : 요소의 기본값의 %, 100% => 기본값의 100% => 기본값의 1배
* **px** : 픽셀수
* cm : 센티미터
* mm : 밀리미터
* in : 인치, 96px
* pt : 포인터, 1/72인치
* pc : 피카소, 12pt
* deg : 각도
* vh : view height. 브라우저 화면의 높이를 100으로 나눈 값. 100vh 브라우저 화면의 높이
* vw : view width. 브라우저 화면의 너비를 100으로 나눈 값. 100vw 브라우저 화면의 너비



### calc()함수

* 단위가 다른 값들을 계산할 때 사용
* 연산자 앞 뒤로 무조건 공백을 넣어야함
  * 연산자 앞 뒤로 공백을 넣지 않으면 계산을 못함
  * 예 : calc(50% - 200px)

### url 함수

* url 경로나 파일 경로를 가져오는 함수
* '' 또는 ""를 써도 되고 생략해도 됨



### inline-block 요소

* inline-block 요소가 나열되어 있을 때 안에 있는 컨텐츠가 다른 경우 어긋날 수 있다
  * 이를 해결하기 위해 float을 이용
* inlie-block 요소가 나열되어 있을 때 엔터에 의한 공백이 생김