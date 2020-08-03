package com.ld.service;

import com.ld.dto.PaginationDTO;
import com.ld.dto.SearchDto;
import com.ld.model.Material;

/**
 * @author liudong
 */
public interface MaterialService {
    int insert(Material record);

    PaginationDTO<Material> search(SearchDto searchDto);

    Long getTotalCount();

    int update(Material material);

    int delete(String itemCode);

    String biggestItemCode();

}
