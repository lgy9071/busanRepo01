package com.example.cart_ex01.sse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class SseService {

    private final Map<Long, List<SseEmitter>> emitters = new ConcurrentHashMap<>();

    // 구독 등록
    public SseEmitter subscribe(Long productId) {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        emitters.computeIfAbsent(productId, k -> new ArrayList<>()).add(emitter);

        emitter.onCompletion(() -> removeEmitter(productId, emitter));
        emitter.onTimeout(() -> removeEmitter(productId, emitter));
        emitter.onError((e) -> removeEmitter(productId, emitter));

        log.info("SSE 연결됨 - productId: {}", productId);
        return emitter;
    }

    // 알림 전송
    public void notifyRestock(Long productId, String productName) {
        List<SseEmitter> list = emitters.getOrDefault(productId, new ArrayList<>());
        log.info("알림 보낼 emitter 수: {}", list.size());

        for (SseEmitter emitter : list) {
            try {
                emitter.send(SseEmitter.event()
                        .name("restock")
                        .data(productName + " 상품이 재입고 되었습니다!"));
            } catch (IOException e) {
                emitter.complete();
            }
        }

        emitters.remove(productId);
    }

    private void removeEmitter(Long productId, SseEmitter emitter) {
        List<SseEmitter> list = emitters.get(productId);
        if (list != null) {
            list.remove(emitter);
        }
    }
}