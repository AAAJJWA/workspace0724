package com.kh.yugioh.service;

import com.kh.yugioh.controller.dto.request.CardRequest;
import com.kh.yugioh.controller.dto.response.CardResponse;

import java.util.List;

public interface CardService {

    CardResponse create(CardRequest request);

    List<CardResponse> findAll();

    CardResponse findById(Long id);

    List<CardResponse> findMyCards(String loginId);

    void delete(Long id);
}
