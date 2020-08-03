package com.ld.utils;

import com.ld.mapper.MaterialMapper;
import com.ld.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @program: material_manage
 * @description:
 * @author: LD
 * @create: 2020-08-03 10:34
 **/

@Component
public class MyUuId {
    /**
    * @decription:指定位数code
    **/
    public String nextItemCode(String biggestItemCode,int digit){
        String nextCode = String.format("%0" + digit + "d", Long.parseLong(biggestItemCode.substring(4)) + 1);
        return "ITEM"+nextCode;
    }


}
