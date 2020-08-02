package com.ld.service;

import com.ld.dto.PaginationDTO;
import com.ld.dto.SearchDto;
import com.ld.mapper.MaterialMapper;
import com.ld.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: material_manage
 * @description: service
 * @author: LD
 * @create: 2020-08-01 11:31
 **/
@Service
public class MaterialServiceImpl implements MaterialService{

    @Autowired
    private MaterialMapper materialMapper;
    @Override
    public int insert(Material record) {
        return materialMapper.insertSelective(record);
    }

    @Override
    public PaginationDTO<Material> search(SearchDto searchDto) {

        Long totalCount = materialMapper.totalCount(searchDto);

        Integer size = searchDto.getSize();
        Integer page = searchDto.getPage();
        int totalPage;

        /*
        * 页面范围限制
        * */
        if (totalCount % size == 0) {
            totalPage = (int) (totalCount / size);
        } else {
            totalPage = (int) (totalCount / size + 1);
        }
        if (page < 1) {
            page = 1;
        } else if (totalPage>0&&page > totalPage) {
            page = totalPage;
        }

        /*
        * 分页初始位置计算
        * */
        Integer offset = size * (page - 1);
        searchDto.setPage(offset);



        List<Material> materials = materialMapper.search(searchDto);
        PaginationDTO<Material> paginationDTO = new PaginationDTO<>();
        paginationDTO.setData(materials);
        paginationDTO.setPagination(totalPage, page);


        return paginationDTO;
    }

    @Override
    public Long getTotalCount() {
        return materialMapper.totalCount(new SearchDto());
    }

    @Override
    public int update(Material material) {
        return materialMapper.updateByItemCodeSelective(material);
    }

    @Override
    public int delete(String itemCode) {

        return materialMapper.deleteByItemCode(itemCode);
    }


}
