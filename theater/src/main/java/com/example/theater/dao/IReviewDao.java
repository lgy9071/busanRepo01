package com.example.theater.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.theater.dto.reviewDto;

@Mapper
public interface IReviewDao {
	
	@Insert("INSERT INTO treview (reid, pid, mid, rcomment, rating, reg_date) " +
            "VALUES (review_seq.NEXTVAL, #{pid}, #{mid}, #{rcomment}, #{rating}, SYSDATE)")
    void insertReview(reviewDto dto);

    //@Select("SELECT * FROM treview WHERE pid = #{pid} ORDER BY reid DESC")
    //List<reviewDto> getReviewsByPerformance(int pid);
    
    @Select("SELECT reid, pid, mid, rcomment, rating, reg_date FROM treview WHERE pid = #{pid}")
    List<reviewDto> getReviewsByPerformance(int pid);
}