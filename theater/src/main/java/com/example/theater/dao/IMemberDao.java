package com.example.theater.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.theater.dto.memberDto;

@Mapper
public interface IMemberDao {

	@Select("SELECT * FROM tmember")
	List<memberDto> getList();

	@Select("SELECT * FROM tmember WHERE id = #{id}")
	memberDto getMember(@Param("id") String id);

	@Update("UPDATE tmember SET pw=#{m.pw}, name=#{m.name} WHERE id=#{m.id}")
	void update(@Param("m") memberDto tmember);

	@Delete ("DELETE FROM tmember WHERE id = #{id}")
	void delete(@Param("id") String id);

	@Insert("INSERT INTO tmember (id, pw, name) VALUES (#{id}, #{pw}, #{name})")
	void insertMember(memberDto tmember);

	@Select("SELECT COUNT(*) FROM tmember WHERE id = #{id}")
	int selectid(@Param("id") String id);
	
	@Select("SELECT * FROM tmember WHERE id = #{id} AND pw = #{pw}")
	memberDto login(@Param("id") String id, @Param("pw") String pw);
}
