package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

public interface MemberDAO {

	String selectEmail(@Param("id")String id);

}
