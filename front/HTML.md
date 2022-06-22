* HTML 
  * 설계도면 : 방이 3개, 화장실 2개, 거실 1개 
* CSS 
  * 디자인 : 방, 화장실, 거실의 위치/크기, 벽지 색, 인테리어
* JAVASCRIPT
  * 기능 : 화장실문을 열면 변기 뚜껑이 올라오는 기능



# HTML

* 태그들로 이루어진 문서

  * 쌍태그
    * 여는 태그와 닫는 태그로 구성
    * 항상 같이 나옴
    *  `<태그명>` `</태그명>` 
  * 단일태그 
    * 태그를 하나만 사용
    * `<태그명/>` 또는 `<태그명>` 

### 기본태그

* `<!DOCTYPE html>`
  * html5 문서임을 알려주는 태그
  * doctype은 소문자로 써도 됨
    * 일반적으로 대문자로 씀 

* `<html>` `</html>`

  * html 태그 안에 다양한 태그를 이용하여 화면을 구성

* `<head>` `</head>`

  * 화면에 안보이는 태그
  * 화면에 대한 정보를 나타낼때 사용
    * charset
    * title
    * 파비콘
    * 기본 화면 비율
  * 카톡에 링크를 보낼 때 자동으로 가져와지는 이미지, 제목, 내용에 대한 요약들
  * css나 js파일을 연결
    * body태그에도 가능하지만, 주로 head태그에 넣음 

* `<body>` `</body>`

  * 화면에 보이는 태그
  * body 태그에 원하는 태그들을 배치하여 화면을 구성

* `<meta>` 

  * 문서와 관련된 정보를 나타내는 태그 

* `<title>` `</title>`

  * 브라우저 탭에 나타나는 문자열을 지정하는 태그



### 텍스트 관련 태그

* `<h태그>` `</h태그>`

  * `<h1>` ~ `<h6>` 까지 있음

  * 제목 태그

    * 기사제목과 같이 제목에 해당하는 부분에 사용

  * 숫자가 작을수록 글자 크기가 크다

  * block태그

  * ```html
    <h1>제목</h1>
    ```

* `<p>` `</p>`

  * 새 문단을 작성할 때 사용하는 태그
  * 주로 기사 내용을 작성할 때 사용
  * 위아래 기본 여백이 있다.
  * block태그

* `<br>` 또는 `<br/>`

  * 줄바꿈

* 글자 두껍게 하는 태그

  * `<b>` `</b>` 나 `<strong>` `</strong>`
    * inline태그
    * 문서를 분석할 때 b태그는 아무 역할이 없지만 strong 태그는 강조된 내용으로 분석을 함 

* 글자 기울이는 태그
  * `<i>` `</i>`
    * inline태그
    * 주로 기울이는 태그로 사용되기 보다는 아이콘을 배치할 때 사용
  * `<em>` `</em>`
    * inline태그
    * 문서를 분석할 때 약하게 강조된 내용으로 분석을 함 
* `<ins>` `</ins>`
  * inline태그
  * 밑줄태그, 글자에 밑줄을 그어지는 주는 태그
* `<del>` `</del>`
  * inline태그
  * 취소선 태그, 글자 가운데에 줄을 그어주는 태그 
* `<sup>` `</sup>` 
  * inline태그
  * 위첨자 태그
  * 제곱같은 표시할 때 사용
* `<sub>` `</sub>`
  * inline태그
  * 아래 첨자 태그
  * log와 같이 아래 첨자가 필요할 때 사용
* `<hr>` 또는 `<hr/>`
  * 가로줄 태그
  * block태그



### 입력 태그

* `<input>` 또는 `<input/>`

  * type이라는 속성을 통해 다양한 형태의 입력방식을 제공

  * 한줄만 가능

  * inline-block 태그

  * 속성 type

    * text

      * ```html
        <input type="text" name="변수명">
        ```

      * 문자들을 입력받을 때 사용

      * 가장 흔하게 사용함

      * 로그인창에서 아이디 입력칸, 검색창, 회원 가입에서 각종 입력칸등

    * password

      * ```html
        <input type="password" name="변수명">
        ```

      * 비밀번호 입력처럼 값을 안보이게 할 때 사용

    * button

      * ```html
        <input type="button">
        ```

      * 일반 버튼을 만듬

    * reset

      * ```html
        <input type="reset">
        ```

      * 다른 input태그에 입력된 값들을 초기화. 단, 같은 form태그로 감싸진 input태그들을 초기화

    * submit

      * ```html
        <input type="submit">
        ```

      * 서버로 데이터를 전송하는 버튼을 만듬

      * 회원가입, 로그인 버튼, 검색 버튼 

      * 같은 form태그로 감싸진 입력태그(input태그, select태그, textarea)들을 전송

    * checkbox

      * ```html
        <input type="checkbox" value="값" name="변수명">
        ```

      * 여러개 선택할 때 사용하는 속성

      * 체크박스가 선택되면 value에 있는 값을 선택

      * 같은 항목에 대해서 name을 동일하게 지정하고, value를 반드시 지정

      * value를 지정하지않으면 선택했을 때 on이 전송

      * 이메일 선택해서 삭제

    * radio

      * ```html
        <input type="radio" value="값" name="변수명">
        ```

      * 여러개 중 하나를 선택할 때 사용

      * 회원가입시 성별

      * 같은 name으로 지정된 radio들 중 하나만 선택

      * value를 지정해야함

    * file

      * ```html
        <input type="file" accept="파일확장자|audio/*|video/*|image/*">
        ```

      * 파일을 선택할 때 사용

      * 첨부파일 선택할 때 사용

      * accept 속성과 같이 사용하여 선택할 수 있는 타입을 지정할 수 있다

    * hidden

      * ```html
        <input type="hidden" name="변수명" value="값">
        ```

      * 서버에서 보낸 값중에서 필요는 하지만 사용자가 볼 필요가 없는 값을 감출 때 사용

      * 선택된 여러 항목들을 하나로 합쳐서 서버로 보낼 때

        * 생일은 입력받을 때 년, 월, 일을 따로 입력받고, 서버로 보낼때는 하나로 합쳐서 보낸다면 이때 hidden에 값을 저장하여 전송

    * color

      * ```html
        <input type="color">
        ```

      * 색상 정보를 선택할 수 있게 함

      * 색상 정보를 16진수로 표현

        * #rrggbb
        * r: 255, g :0, b :0  => #ff0000

      * #은 인코딩되어 %23으로 전송

    * 날짜, 시간 선택

      * month
        * 년, 월을 표시
      * week
        * 년, 주를 표시
      * date
        * 년, 월, 일 표시
      * datetime-local
        * 년,월,일,시,분,초 표시
      * time
        * 시, 분, 초 표시
      * 일반적으로 위 속성들 대신 Jquery 플러그인이나 부트스트랩 플러그인을 이용 (date picker, datetime picker)

    * email

      * 입력된 값이 이메일 형식과 맞는지 확인하는 기능이 있음
        * xxx@yyy.zz
      * 이메일 형식이 아닌 경우 알림창으로 알려줌

    * image

      * 이미지를 추가할 때 사용
      * image 태그로 대체할 수 있다
        * 차이점은 input태그로 추가한 이미지에 마우스를 hover하면 마우스 모양이 포인터 모양
      * src속성과 alt 속성이 필요
        * src 속성은 이미지 주소
        * alt 속성은 이미지 불러오기 실패시 보여줄 텍스트

    * number

      * 숫자만 입력 가능
      * up버튼과 down버튼으로 숫자를 조장할 수 있다

    * url

      * 입력된 값이 url 주소형식과 맞는지 확인하는 기능이 있음
      * url 주소 형식이 아닌 경우 알림창으로 알려줌

    * range

      * 범위를 조절할때 사용
      * min,max 속성을 이용하여 범위 단계를 조절할 수 있다.

  * value 속성

    * ```html
      <input type="text" value="값123">
      ```

    * input태그의 값을 지정하는 속성

    * input태그의 초기값을 설정할 때 사용

  * name 속성

    * ```html
      <input type="text" name="id">
      ```

    * 서버로 데이터를 전송할 때, 전송하는 데이터의 이름을 설정하는 속성

    * 서버로 데이터를 전송하려면 **반드시 name이 필요**

  * placeholder속성

    * ```html
      <input type="text" placeholder="아이디를 입력하세요">
      ```

    * input태그의 입력 값 예시처럼 안내문구를 보여줄때 사용하는 속성

    * value의 초기값과 다름

      * value는 실제 값이 input태그에 들어가는 것이고, placeholder는 미리보기 같은 속성으로 값을 입력하면 사라짐

  * accept

    * ```html
      <input type="file" accept="파일확장자|audio/*|video/*|image/*">
      ```

    * 파일 선택시 선택할 수 있는 파일 종류를 제한할 때 사용

    * ,를 통해 여러 종류로 제한할 수 있다

    * 파일 확장자

      * 예 : .hwp
        * .hwp로 끝나는 파일들만 선택 가능

    * audio/*

      * 모든 오디오 파일

    * video/*

      * 모든 비디오 파일

    * image/*

      * 모든 이미지 파일

    * image/png

      * 확장자가 .png인 이미지 파일

  * required

    * 필수로 입력해야 하는 입력창에 추가
    * 입력이 안됐으면 알려줌

  * readonly

    * 읽기 전용으로 수정할 수 없게 해줌
    * 수정은 안되지만 서버에는 전송이 가능

  * disabled

    * 값을 변경할 수 없음
    * 서버에 전송이 불가능

  * tabindex

    * 탭키를 눌렀을 때 순서를 지정

  * checked

    * type이 radio나 checked인 경우 사용하는 속성
    * 기본값을 선택할 때 사용

* `<select>` `</select>`

  * `<option>` `</option>` 와 같이 사용

  * ```html
    <select name="변수명">
        <option>선택1</option>
        <option value="choice2">선택2</option>
    </select>
    ```

  * option태그에 value가 없으면 option태그 사이에 있는 문자열이 value로 자동으로 들어감

  * selected 속성

    * 초기 선택된 값을 보여주고 싶을 때 보여주고 싶은 option태그에 selected 속성을 추가
    * selected 속성이 모든 option태그에 없는 경우 첫번째 option태그에 있는 값이 보여짐

  * inline-block태그

* `<textarea>` `</textarea>`

  * 여러줄 가능

  * rows와 cols 속성을 이용하여 글자들을 제한할 수 있다

  * ```html
    <textarea name="변수명" rows="숫자" cols="숫자"></textarea>
    ```

  * inline-block태그

  * cols : 열의 갯수. 한줄에 몇개의 글자를 배치할지를 정함

  * rows : 한번에 보여지는 줄수를 의미

* `<pre>` `</pre>` 

  * ```html
    <pre>내용</pre>
    ```

  * 입력한 내용 그대로를 화면에 출력

* `<label>` `</label>`

  * input태그의 checkbox나 radio와 같이 사용

    * 글자를 클릭해도, chckbox나 radio가 동작되도록 하기 위해 사용

  * ```html
    <label>내용</label>
    ```

* `<img>`

  * ```html
    <img src="파일경로/파일명" alt="문자열" width="크기" height="크기">
    ```

  * src속성

    * 이미지가 있는 경로 및 파일
    * 경로는 절대 경로와 상대 경로
    * 절대 경로는 최상위 폴더를 기준으로 경로를 작성
    * 상대 경로는 현재 파일을 기준으로 경로를 작성

  * alt속성

    * 이미지 로딩 실패시 보여줄 문자열
    * 생략해도 되지만 생략하면 유효성 검사에 실패 

  * width와 height 속성

    * 크기 조절할 수 있다
    * 숫자만 쓰면 px로 인식
    * auto : 비율에 맞게 자동으로 크기가 조절
    * 생략하면 이미지 원본 크기를 불러옴

* 리스트

  * ```html
    <ol type="1|A|a|I|i" start="숫자">
        <li>리스트1</li>
        <li>리스트2</li>
    </ol>
    <ul type="square|circle">
        <li>리스트1</li>
        <li>리스트2</li>
    </ul>
    <dl>
        <dt>단어</dt>
        <dd>단어 뜻</dd>
    </dl>
    ```

  * `<ol>` `</ol>` 

    * `<li>` `</li>`와 함께 사용
    * 순서가 있는 리스트(숫자, 알파벳 등)
    * type 속성
      * 숫자나, 알파벳, 로마숫자로 변경
      * 1 : 숫자
      * A, a : 알파벳
      * I, i : 로마숫자로 변경
    * start 속성
      * 시작 숫자
    * type속성이나 start 속성을 이용하는 대신 가급적이면 스타일을 이용하는게 좋다(css)

  * `<ul>` `</ul>`

    * `<li>` `</li>`와 함께 사용
    * 순서가 없는 리스트(점, 사각형 등)

  * `<dl>` `</dl>`

    * `<dt>` `</dt>`, `<dd>` `</dd>`와 함께 사용

* 표(`<table>` `</table>`)

  * table, cation, thead, tfoot, tbody, tr, td, th 태그들로 이루어져 있음

  * `<table></table>`

    * 표 전체를 감싸는 태그
    * border는 테두리
    * css로 하는 것이 좋다

  * `<caption></caption>` 

    * 표 제목. 표 상단에 문장열로 출력, 가운데 정렬
    * 선택

  * `<thead></thead>`

    * 표의 행 중에서 상단에 배치하는 행들의 그룹
    * 일반적으로 각 열의 제목 같은 값들이 옴
    * 선택

  * `<tbody></tbody>`

    * 표의 행 중에서 중간에 배치하는 행들의 그룹
    * 일반적으로 값들이 옴.
    * 선택

  * `<tfoot></tfoot>`

    * 표의 행 중에서 하단에 배치하는 행들의 그룹
    * 일반적으로 평균같은 값들이 옴
    * 선택

  * tbody, tfoot, thead는 배치 순서에 상관없이 화면상 무조건 thead, tbody, tfoot순으로 보임

  * `<tr></tr>`

    * 필수
    * 한 행을 의미
    * td 태그 또는 th태그로 구성

  * `<th></th>`

    * 열 제목으로 사용
    * 굵은 글씨, 가운데 정렬

  * `<td></td>`

    * 데이터로 사용
    * 얇은 글씨, 왼쪽 정렬

  * colspan, rowspan 속성

    * td, th태그에 사용
    * 여러 셀들을 합칠 때 사용
    * colspan
      * 여러 열들을 합쳐서 하나의 셀로 사용
    * rowspan 
      * 여러 행들을 합쳐서 하나의 셀로 사용

  * ```html
    <table>
    	<tr>
            <th>제목1</th>
            <th>제목2</th>
        </tr>
        <tr>
            <td>데이터1</td>
            <td>데이터2</td>
        </tr>
    </table>
    
    <table>
        <caption>표 제목</caption>
        <thead>
        	<tr>
                <th>제목1</th>
                <th>제목2</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>데이터1</td>
                <td>데이터2</td>
            </tr>
        </tbody>
        <tfoot>
        	<tr>
                <td>데이터1</td>
                <td>데이터2</td>
            </tr>
        </tfoot>
    </table>
    ```

* `<button></button>`

  * 버튼을 만드는 태그

  * type 속성

    * button
      * 일반 버튼
    * submit
      * 같은 form태그에 있는 입력 태그의 값들을 서버로 전성
    * reset
      * 같은 form태그에 있는 입력 태그의 값들을 초기화
    * 속성을 지정하지 않으면 기본 submit

  * ```html
    <button type="button|submit|reset" >버튼명</button>
    ```

* `<form></form>`

  * 입력한 정보들을 서버에 보내기 위한 태그

  * action 속성

    * 데이터를 보낼 경로
    * URI을 입력
    * action을 생략하면 현재 URI가 자동으로 입력

  * method 속성

    * get
      * 서버에 보낼 데이터를 URI에 추가해서 전송
        * URI뒤에 ?와 &로 서버로 보낼 데이터를 전송
        * URI경로?변수명=값&변수명=값

      * URI에 데이터가 노출되도 문제 없는 경우 사용
      * 뉴스상세
      * 카페 게시글목록

    * post
      * header에 정보를 담아서 전송
      * URI에 정보가 노출되지 않음
      * 로그인, 회원가입
      * 전송되는 데이터가 많은 경우
        * 게시글 쓰기

      * 첨부파일이 있는 경우

    * method가 생략되면 get방식

  * enctype 속성

    * 데이터를 전송하는 타입
    * 첨부파일을 업로드할 때 반드시 사용
      * multiparty/form-data
      * 첨부파일을 서버에 업로드시 해당 속성값으로 지정하지 않으면 첨부파일명만 전송

  * block태그

  * ```html
    <form action="URI경로" method="get|post" enctype="값">
    	<!-- input태그와 select 태그등과 같은 입력 태그들로 구성-->    
    </form>
    ```

* `<a></a>`

  * href 속성

    * 이동할 URI를 입력

  * target 속성

    * 이동할 때 이동 방식을 결정
    * _blank
      * 새창에서 열기

    * _self
      * 현재창에서 열기

    * _parent
      * 부모창에서 열기

    * _top
      * 최고 조상창에서 열기

  * 다른페이지로 이동하는 기능(하이퍼링크)

    * ```html
      <a href="URI주소" target="_blank|_self|_parent|_top">요소</a>
      ```

  * 현재페이지내에서 특정 위치로 이동하는 기능(앵커)

    * ```html
      <a href="#아이디명">요소</a>
      
      <elemnt id="아이디명">요소</elemnt>
      ```

  * 파일 다운로드

    * ```html
      <a href="파일경로/파일명" download>텍스트</a>
      ```

    * download 속성을 이용하여 클릭시 파일을 다운로드하게 함

  * a태그로 이루어져 있지만 이동하지 않게 하는 방법

    * ```html
      <a href="javascript:0">요소</a>
      ```

  * inline 태그

  * a태그 색상

    * 파란색
      * 방문한적이 없는 링크

    * 보라색
      * 방문한적이 있는 링크

    * 빨간색
      * 누르고 있을 때

    * css를 통해 색상을 변경할 수 있다


* `<iframe></iframe>`

  * 사용 예시

    * 사이트에서 유튜브 영상 가져올 때 사용
    * 네이버 광고

  *  

  * ```html
    <iframe 
            src="URI" 
            srcdoc="HTML 문서 텍스트로 출력될 내용" 
            name="프레임 윈도우 이름"
            width="프레임 폭"
            height="프레임 높이">
        iframe을 다루지 않은 브라우저에 의해 대신 출력될 텍스트
    </iframe>
    ```

    * width : 기본 300
    * heigth : 기본 150
    * scrdoc이 있는 경우 src는 무시됨

  * iframe을 이용하여 화면을 가져오면 iframe이 자식창이 됨

* 미디어 태그

  * audio, video태그

  * `<video></video>`

    * 비디오 영상을 추가하는 태그

    * ```html
      <video src="파일명" width="가로길이" height="세로길이" controls autoplay></video>
      
      <video width="가로길이" height="세로길이" controls autoplay>
      	<source src="파일명" type="비디오타입">
          브라우저가 video 태그를 지원하지 않습니다.
      </video>
      ```

      * controls
        * 비디오 영상을 컨트롤할 수 있는 컨트롤러를 보여줄지 말지를 결정
      * autoplay
        * 자동 재생 여부

    * 비디오타입(MIME Type)

      * MP4 : video/mp4
      * WebM : video/webm
      * Ogg : video/ogg

  * `<audio></audio>` 

    * 오디오를 추가하는 태그

    * ```html
      <audio scr="파일명" controls autoplay></audio>
      
      <audio width="가로길이" height="세로길이" controls autoplay>
      	<source src="파일명" type="비디오타입">
          브라우저가 video 태그를 지원하지 않습니다.
      </audio>
      ```

  * `<div></div>`

    * block태그
    * 별다른 기능은 없음
    * 요소들을 묶어서 관리할 때 사용

  * `<span></span>`

    * inline 태그
    * 별다른 기능은 없음
    * 요소 일부에 스타일을 적용할 때 사용

* 시맨틱 태그
  * 기능은 없음(div태그와 같음)
  * 의미만 부여
  * `<nav></nav>`, `<footer></footer>`, `<article></article>` 등

### block vs inline vs inlie-block

* block
  * 새 라인에서 시작
  * 가로, 세로 크기를 조절할 수 있음
* inline
  * 현재 라인에서 시작
  * 가로, 세로 크기를 조절할 수 없음
* inline-block
  * 현재 라인에서 시작
  * 가로, 세로 크기를 조절할 수 있음



### HTML 특징

* HTML 파일에서 주석
  * 기본 
    * <!-- 주석 -->
  * style 태그 안에서 주석
    * /* */
  * script 태그 안에서 주석
    * //
    * /* */
* HTML에서는 공백 처리가 다른 언어와 다름
  * 엔터를 여러개 쳐도 공백(스페이스) 1개로 인식
  * 공백을 여러개 두어도 공백 1개로 인식
* 여러 태그를 복합적으로 같이 사용할 때 주의사항
  * 순서를 마음대로 해도 되나, block태그가 밖으로, inline태그가 안으로 들어오도록 하는 것이 좋다.

* 태그의 속성은 태그 안에 들어가 있고, 속성 값은 =을 통해 표현한다

  * ```html
    <태그명 속성명="값"></태그명>
    <태그명 속성명='값'></태그명>
    <태그명 속성명=값></태그명>
    ```

  * 상황에 따라서 값을 생략할 수도 있다.

  * " 대신 '로도 가능하지만, 일반적으로 "로 사용

  * "를 생략할 수 있지만, 생략하면 =과 값을 붙여써야 함