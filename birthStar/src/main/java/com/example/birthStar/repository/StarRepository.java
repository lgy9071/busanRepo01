package com.example.birthStar.repository;

import com.example.birthStar.entity.StarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StarRepository extends JpaRepository<StarEntity, Integer> {
    StarEntity findByMonth(String month);

    List<StarEntity> findByMonthIn(List<String> month);
}
