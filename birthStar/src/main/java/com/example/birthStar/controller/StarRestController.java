package com.example.birthStar.controller;

import com.example.birthStar.entity.StarEntity;
import com.example.birthStar.service.StarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stars")
@RequiredArgsConstructor
public class StarRestController {

    private final StarService starService;

    @GetMapping
    public ResponseEntity<List<StarEntity>> getAllStars() {
        return ResponseEntity.ok(starService.getAllStars());
    }

    @GetMapping("/{no}")
    public ResponseEntity<StarEntity> getStar(@PathVariable Integer no) {
        return starService.getStarById(no)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{no}")
    public ResponseEntity<StarEntity> updateStar(@PathVariable Integer no, @RequestBody StarEntity newStar) {
        return ResponseEntity.ok(starService.updateStar(no, newStar));
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<?> deleteStar(@PathVariable Integer no) {
        starService.deleteStar(no);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(params = "month")
    public ResponseEntity<StarEntity> getStarByMonth(@RequestParam String month) {
        StarEntity star = starService.getStarByMonth(month);
        if (star != null) {
            return ResponseEntity.ok(star);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}