package com.example.rest02.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public abstract class BaseEntity {

	@Column(name="regdate", updatable = false) //날짜 바꿀 이유가 x
	@CreatedDate
	private LocalDateTime regDate;
	
	@Column(name="moddate")
	@LastModifiedDate
	private LocalDateTime modDate;
	
}
