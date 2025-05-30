package com.example.theater.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.theater.dto.reserveDto;

@Mapper
public interface IReserveDao {

	@Insert("INSERT INTO treservation (rid, pid, mid, showTitle, rdate) " +
	        "VALUES (reserve_seq.NEXTVAL, #{pid}, #{mid}, #{showTitle}, SYSDATE)")
	void insertReserve(reserveDto dto);
	
    @Select("SELECT * FROM treservation WHERE mid = #{mid}")
    public List<reserveDto> getReserveList(String mid); // 특정 회원의 예매 내역
    
//    @Select("SELECT * FROM treservation")
//    public List<reserveDto> getReserveListAll();
    
    @Select("SELECT r.rid, r.mid, r.pid, r.rdate, p.title AS showTitle " +
            "FROM treservation r " +
            "JOIN tperformance p ON r.pid = p.pid")
    public List<reserveDto> getReserveListAll();  // 전체 예매 내역
}