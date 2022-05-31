

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

* 데이터를 추가/수정/삭제/읽어올 때 사용

### insert

* 테이블에 데이터를 추가할 때 사용

```mysql
insert [into] 테이블명[(속성1, 속성2, ..., 속성n)] values(값1, 값2, ..., 값n), (값1, 값2, ..., 값n);
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

# DCL

* 사용자 권한 부여, 비번 설정등을 할 때 사용