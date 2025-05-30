package com.example.theater.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.theater.dto.performanceDto;

@Mapper
public interface IPerformanceDao {

	@Select("SELECT * FROM tperformance ORDER BY pid DESC")
	List<performanceDto> getList();

	@Select("SELECT * FROM tperformance")
	List<performanceDto> getAll();

	@Insert("INSERT INTO tperformance (pid, title, description, status, reg_date) VALUES (performance_seq.NEXTVAL, #{title}, #{description}, #{status}, SYSDATE)")
	void insertPerformance(performanceDto dto);

	//@Select("SELECT * FROM tperformance WHERE pid = #{pid}")
	//performanceDto getPerformanceById(int pid);
	@Select("SELECT pid, title, description, status, reg_date FROM tperformance WHERE pid = #{pid}")
	performanceDto getPerformanceById(int pid);
	
}
