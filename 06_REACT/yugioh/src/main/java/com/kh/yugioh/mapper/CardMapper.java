package com.kh.yugioh.mapper;

import com.kh.yugioh.entity.Card;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CardMapper {

    void save(Card card);

    List<Card> findAll();

    List<Card> findOwner(@Param("ownerLoginId") String ownerLoginId);

    Card findId(@Param("id") Long id);

    void deleteId(@Param("id") Long id);
}
