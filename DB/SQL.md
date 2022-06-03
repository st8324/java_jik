

```mysql
show databases;
```

* 현재 생성된 모든 데이터베이스를 보여주는 쿼리

```mysql
use 데이터베이스명;
```

* 데이터베이스를 선택하는 쿼리

```mysql
show tables;
```

* 현재 선택된 데이터베이스에 있는 모든 테이블들을 보여주는 쿼리

```mysql
desc 테이블명;
```

* 테이블에 있는 속성 정보를 보여주는 쿼리



# DDL

* 데이터를 저장하는 데이터베이스, 테이블을 생성/수정/삭제할 때 사용

* [참고 링크](https://stajun.tistory.com/entry/SQL-DDL-DML-DCL?category=836098)

* 속성명이나 테이블명이 키워드이어도 가능은 하지만 가급적 피하는게 좋다

  * ```mysql
    -- like라는 테이블이 있다면
    -- select * from like; -- 에러가 발생. like 키워드의 역할이 있어서
    select * from `like`; -- `(역따옴표)로 감싸주면 가능
    ```

    



# DML

* 데이터를 추가/수정/삭제/읽어올 때 사용(CRUD)
* C : Create, R : Read, U : Update, D : Delete

### insert

* 테이블에 데이터를 추가할 때 사용

```mysql
insert [into] 테이블명[(속성1, 속성2, ..., 속성n)] values(값1, 값2, ..., 값n), (값1, 값2, ..., 값n);
insert into 속성명1, ..., 속성명n select 속성명1, ..., 속성명n from 테이블명 where 조건식;
```

```mysql
-- 테이블 속성 순서대로 값들의 순서를 맞춰야함
insert into 테이블명 values(값1,값2, ..., 값n);
-- 작성한 속성 순서와 값들의 순서가 같게 데이터가 저장
insert into 테이블명(속성1, 속성2, ..., 속성n) values(값1,값2, ..., 값n);
```

* insert할 때 속성을 입력하는 경우, 생략된 속성들은 기본값이 들어감
  * default로 기본값을 설정했으면 default값으로 들어감
  * default로 기본값을 설정하지 않으면 NULL이 들어감
    * 이 때, 해당 속성이 NOT NULL인 경우 에러가 발생



### update

* 테이블의 데이터를 수정할 때 사용

```mysql
update 테이블명
	set
		속성명1 = 값1,
		속성명2 = 값2,
		...,
		속성명n = 값n
	where 
		조건식;
```

* where이 없거나 where에서 기본키가 안들어가는 경우 MySql 워크벤치에서는 수정하려면 추가 작업이 필요
  * Edit -> Preferences... -> SQL Editor -> Safe Updates 체크를 해제한 후, 나갔다가 다시 들어와야 함



### delete

* 테이블의 데이터를 삭제할 때 사용(한 줄 삭제)

```mysql
delete from 테이블명 where 조건식;
```



### select

* 테이블의 데이터를 검색할때 사용

```mysql
-- 기본
select * from 테이블명;
select 속성명1, 속성명2, ..., 속성명n from 테이블명;
select * from 테이블명 where 조건식;
```

* between A and B

  * 하나의 속성의 값을 범위로 확인하는 경우

  * A이상 B이하로 표현 가능할 때 사용, 연속적인 수치값을 검색하는 경우 사용

  * ```mysql
    select * from 테이블명 where 속성명 >= A and 속성명 <= B;
    select * from 테이블명 where 속성명 between A and B;
    ```

* in(값1, 값2)

  * 값이 연속적이지 않거나, 수치가 아닌 값을 검색하는 경우 사용

  * 속성의 값이 값1또는 값2 중 하나를 만족하면 되는 경우에 사용

  * ```mysql
    select * from 테이블명 where 속성명 = 값1 or 속성명 = 값2 or ... or 속성명 = 값n;
    select * from 테이블명 where 속성명 in(값1, 값2, ..., 값n);
    ```

* **like**

  * 문자열값을 가지는 속성을 검색할 때 사용

  * 와일드 카드와 같이 사용하여 문자열을 검색할 때 사용

  * =은 정확히 일치하는 값을 찾을 때 사용, like은 일부 포함된 단어를 찾는 경우 사용

  * like도 와일드카드와 같이 나오지 않으면 =과 같음

  * ```mysql
    select * from 테이블명 where 속성명 like '문자열';
    select * from 테이블명 where 속성명 like '문자열%';
    select * from 테이블명 where 속성명 like '문자열_';
    ```

  * 와일드카드

    * _ : 한칸의 아무 글자를 의미
    * % : 0개 이상의 아무 글자들을 의미

* 서브쿼리

  * 쿼리문 안에 쿼리문이 있는 형태

  * ```mysql
    select * from 테이블명 where 속성명 = (select 속성명 from 테이블명 where 조건식);
    ```

  * 쿼리의 결과 개수에 따라 동작이 안될 수 도 있다

  * All

    * 서브쿼리 전체를 만족해야 하는 경우에 사용

  * ANY

    * 서브쿼리 중 하나를 만족해도 되는경우에 사용
    *  = any(서브쿼리)를 in(서브쿼리) 로 바꿀 수 있다

* order by 

  * 데이터들을 정렬할 때 사용 

  * order by는 where절 뒤에 나와야 함 

  * order by는 검색이 다 끝나고 정렬

  * asc 또는 desc

    * asc : 기본값, 오름차순
    * desc : 내림차순 

  * ```mysql
    select * from 테이블명 where 조건식 order by 속성명1 정렬방법, 속성명2 정렬방법;
    ```

* distinct

  * 동일한 결과가 있을 때(중복된 결과) 안보이게 해줌

  * ```mysql
    select distinct 속성 from 테이블명 where 조건식;
    ```

* limit

  * 검색 결과중 원하는 개수를 가져올 때 사용

  * ```mysql
    -- 시작번지부터 개수만큼 검색 결과를 가져옴. 시작번지는 0이상
    select * from 테이블명 where 조건식 order by 정렬 limit 시작번지, 개수
    -- 처음부터 개수만큼 검색 결과를 가져옴
    select * from 테이블명 where 조건식 order by 정렬 limit 개수
    ```

  * 웹에서 페이지네이션을 이용할 때 사용

* group by

  * 검색 결과를 속성을 기준으로 묶어주는 역할

  * 기준이 되는 속성은 최소 1개, 여러개가 될 수 있다 

  * 집계함수와 같이 사용

  * ```mysql
    select * from 테이블명 where 조건식 group by 속성명 order by 속성명 limit 시작번지, 개수;
    ```

  * having

    * 집계함수를 이용하여 조건을 걸 때 where절이 아니라 having에 조건식을 써야 함

    * ```mysql
      select * from 테이블명 
      	where 조건식 
      	group by 속성명 
      	having 조건식
      	order by 속성명 
      	limit 시작번지, 개수;
      ```

      

* as

  * 속성의 별명을 만들어주는 역할

  * 주로 검색할 때 속성명 부분에 함수가 들어가서 길어지는 경우 짧게 줄여쓰기 위해 as를 사용 

  * 의미 있는 속성명을 부여하기 위해 사용

  * ```mysql
    select 속성명 as 속성명 from 테이블명;
    ```

    


# DCL

* 사용자 권한 부여, 비번 설정등을 할 때 사용



### truncate VS delete

* truncate을 이용하여 테이블을 초기화하면 새로 데이터를 추가할 때 auto_increment 값이 1부터 시작 
* delete를 이용하여 테이블의 데이터 전체를 삭제하고, 새로 데이터를 추가하면 이전 auto_increment값을 이어서 시작 
* 결론
  * 전체 초기화를 하는 경우 truncate를 이용
  * 부분 삭제를 하는 경우 delete를 이용