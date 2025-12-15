package com.kh.yugioh.service;

import com.kh.yugioh.controller.dto.request.CardRequest;
import com.kh.yugioh.controller.dto.response.CardResponse;

import java.util.List;

public interface CardService {

    CardResponse create(CardRequest request);

    List<CardResponse> findAll();

    List<CardResponse> findMyCards(String ownerLoginId);

    void delete(Long id);
}
