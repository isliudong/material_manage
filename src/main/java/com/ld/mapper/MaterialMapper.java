package com.ld.mapper;

import com.ld.dto.SearchDto;
import com.ld.model.Material;

import java.util.List;

/**
 * @author liudong
 */
public interface MaterialMapper {

    int deleteByPrimaryKey(Long itemId);


    int insert(Material record);


    int insertSelective(Material record);


    Material selectByPrimaryKey(Long itemId);


    int updateByItemCodeSelective(Material record);


    int updateByPrimaryKey(Material record);

    List<Material> search(SearchDto searchDto);

    Long totalCount(SearchDto searchDto);

    int deleteByItemCode(String itemCode);
}