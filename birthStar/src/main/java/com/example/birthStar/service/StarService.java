package com.example.birthStar.service;

import com.example.birthStar.entity.StarEntity;
import com.example.birthStar.repository.StarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StarService {
    private final StarRepository starRepository;

    public List<StarEntity> getAllStars(){
        return starRepository.findAll();
    }

    public List<StarEntity> getStarByMonths(List<String> months){
        return starRepository.findByMonthIn(months);
    }

    public StarEntity getStarByMonth(String month) {
        return starRepository.findByMonth(month);
    }

    public Optional<StarEntity> getStarById(Integer no) {
        return starRepository.findById(no);
    }

    public StarEntity updateStar(Integer no, StarEntity newStar) {
        return starRepository.findById(no)
                .map(star -> {
                    star.setMonth(newStar.getMonth());
                    star.setStarname(newStar.getStarname());
                    star.setContent(newStar.getContent());
                    return starRepository.save(star);
                }).orElseThrow(() -> new IllegalArgumentException("해당 별자리 없음"));
    }

    public void deleteStar(Integer no) {
        starRepository.deleteById(no);
    }
}


