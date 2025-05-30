package com.example.theater.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.theater.dto.boardDto;

@Mapper
public interface IBoardDao {

	@Insert("INSERT INTO tboard (bno, title, content) VALUES (tboard_seq.NEXTVAL, #{title}, #{content})")
	void insert(boardDto board);

	@Select("SELECT * FROM tboard ORDER BY bno DESC")
	List<boardDto> getList();

	@Update("UPDATE tboard SET title = #{title}, content = #{content} WHERE bno = #{bno}")
	void updateBoard(boardDto dto);

	@Delete("DELETE FROM tboard WHERE bno = #{bno}")
	void deleteBoard(int bno);

	@Select("SELECT * FROM tboard WHERE bno = #{bno}")
	boardDto getBoard(@Param("bno") int bno);

}
