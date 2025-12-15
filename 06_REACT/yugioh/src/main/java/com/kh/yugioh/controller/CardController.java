package com.kh.yugioh.controller;

import com.kh.yugioh.controller.dto.request.CardRequest;
import com.kh.yugioh.controller.dto.response.CardResponse;
import com.kh.yugioh.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/api/cards")
    public ResponseEntity<CardResponse> create(
            @RequestBody CardRequest request
    ) {
        CardResponse response = cardService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/api/cards")
    public ResponseEntity<List<CardResponse>> list() {
        List<CardResponse> cards = cardService.findAll();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/api/cards/my")
    public ResponseEntity<List<CardResponse>> myCards(
            @RequestParam String loginId
    ) {
        List<CardResponse> myCards = cardService.findMyCards(loginId);
        return new ResponseEntity<>(myCards, HttpStatus.OK);
    }

    @DeleteMapping("/api/cards/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        cardService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
