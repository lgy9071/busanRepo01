package com.example.theater.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.theater.dto.entryDto;
import com.example.theater.dto.eventDto;

@Mapper
public interface IEventDao {
	
	void insertEntry(entryDto entry);

	@Select("SELECT * FROM event_entry_tbl ORDER BY eno DESC")
	List<eventDto> getEntryList();

    // 이벤트 응모 횟수 확인
    @Select("SELECT COUNT(*) FROM event_entry_tbl WHERE eno = #{eno} AND user_id = #{user_id}")
    int getEntryCount(@Param("eno") int eno, @Param("user_id") String user_id);

    // 이벤트 응모
    @Insert("INSERT INTO event_entry_tbl (entry_id, eno, user_id) VALUES (entry_seq.NEXTVAL, #{eno}, #{user_id})")
    void insertEntry(@Param("eno") int eno, @Param("user_id") String user_id);

    @Select("SELECT * FROM event_entry_tbl WHERE user_id = #{user_id} ORDER BY entry_date DESC")
    List<entryDto> getUserEntries(String user_id);
    
    // 이벤트 등록
    @Insert("INSERT INTO event_tbl (eno, title, content, start_date, end_date) " +
            "VALUES (event_seq.NEXTVAL, #{title}, #{content}, #{start_date}, #{end_date})")
    void insertEvent(eventDto dto);
    
    // 이벤트 목록
    @Select("SELECT * FROM event_tbl ORDER BY eno DESC")
    List<eventDto> getList();
    
    // 이벤트 상세
    @Select("SELECT * FROM event_tbl WHERE eno = #{eno}")
    eventDto getEvent(@Param("eno") int eno);
}
