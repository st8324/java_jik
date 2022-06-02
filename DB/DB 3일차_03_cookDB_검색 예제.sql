-- 1970년 이후에 출생한 사람의 아이디와 이름을 조회 
select userID, userName from usertbl where birthYear >= 1970;
-- 회원의 키가 180~182인 사람의 이름과 키를 조회
select userName, height from usertbl where height >= 180 and height <= 182;
select userName, height from usertbl where height between 180 and 182;
-- 지역이 경남이거나 충남이거나 경북인 사람의 이름과 주소를 조회 
select userName, addr from usertbl where addr='경남' or addr ='충남' or addr = '경북';
select userName, addr from usertbl where addr in('경남', '충남', '경북');
-- 성이 김씨인 회원의 이름과 키를 조회 
select userName, height from usertbl where userName like '김%';
-- 1970년대 출생한 회원의 아이디와 이름을 조회 
select userID, userName from usertbl where birthYear >=1970 and birthYear < 1980;
select userID, userName from usertbl where birthYear between 1970 and 1979;
select userID, userName from usertbl where birthYear like '197_';
-- 2013년에 가입한 회원의 모든 정보를 조회 
select * from usertbl where mDate like '2013%';
-- KHD 회원이 구매한 제품을 조회 
select prodName from buytbl where userID = 'KHD';
-- 회원의 키가 180~182인 회원 중 경북에 사는 회원 정보를 조회 
select * from usertbl where height between 180 and 182 and addr='경북';
-- 회원의 키가 180미만이거나 182초과인 회원 정보를 조회 
select * from usertbl where height < 180 or height > 182;
select * from usertbl where !(height between 180 and 182);
-- 회원의 키가 180미만이거나 182초과인 회원 중 경남에 사는 회원 정보를 조회 
select * from usertbl where (height < 180 or height > 182) and addr='경남';
-- 김용만 회원보다 큰 회원 정보를 조회 
select * from usertbl where height > (select height from usertbl where userName = '김용만');
-- 경기 지역에 사는 회원 중 가장 큰 회원보다 큰 회원 정보를 조회 
select * from usertbl where height > all(select height from usertbl where addr = '경기');
-- 경기 지역에 사는 회원 중 가장 작은 회원보다 큰 회원 정보를 조회 
select * from usertbl where height > any(select height from usertbl where addr = '경기');
-- KHD 회원이 구매한 제품과 동일한 제품을 구매한 회원 정보를 조회 
select * from buytbl where prodName = any(select prodName from buytbl where userId = 'KHD');
select * from buytbl where prodName in(select prodName from buytbl where userId = 'KHD');
-- KHD 회원이 구매한 제품과 동일한 제품을 구매한 회원아이디만 조회 
select userID from buytbl where userID != 'KHD' and prodName = any(select prodName from buytbl where userId = 'KHD');

-- 구매 목록을 userID와 prodName순으로 정렬하여 조회
select * from buytbl order by userID asc, prodName asc;

-- 회원들이 구매한 제품 목록을 조회
select distinct prodName from buytbl;
