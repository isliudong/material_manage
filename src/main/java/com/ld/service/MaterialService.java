package com.ld.service;

import com.ld.dto.PaginationDTO;
import com.ld.dto.SearchDTO;
import com.ld.model.Material;

/**
 * @author liudong
 */
public interface MaterialService {

    int insert(Material record);

    PaginationDTO<Material> search(SearchDTO searchDto);


    Long getTotalCount();

    int update(Material material);

    int delete(String itemCode);

    String biggestItemCode();



}
