package com.kh.yugioh.controller;

import com.kh.yugioh.controller.dto.request.CardRequest;
import com.kh.yugioh.controller.dto.response.CardResponse;
import com.kh.yugioh.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    // 카드 생성
    @PostMapping
    public ResponseEntity<CardResponse> create(
            @RequestBody CardRequest request
    ) {
        CardResponse response = cardService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 전체 카드 조회
    @GetMapping
    public ResponseEntity<List<CardResponse>> list() {
        List<CardResponse> cards = cardService.findAll();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    // 내 카드 조회
    @GetMapping("/my")
    public ResponseEntity<List<CardResponse>> myCards(
            @RequestParam String loginId
    ) {
        List<CardResponse> myCards = cardService.findMyCards(loginId);
        return new ResponseEntity<>(myCards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardResponse> detail(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(cardService.findById(id));
    }

    // 카드 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        cardService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
