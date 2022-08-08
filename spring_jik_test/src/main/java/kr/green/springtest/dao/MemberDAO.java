package kr.green.springtest.dao;

import org.apache.ibatis.annotations.Param;

public interface MemberDAO {
	public String getEmail(@Param("id")String id);
}
