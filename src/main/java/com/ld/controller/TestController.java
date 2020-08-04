package com.ld.controller;

import com.ld.model.Material;
import com.ld.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @program: material_manage
 * @description:
 * @author: LD
 * @create: 2020-08-01 11:34
 **/
@Controller
public class TestController {
    @Autowired
    MaterialService materialService;


    public String insert() {
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(day));
        System.out.println(day);
        Material material = new Material(4L, "ITEM0000000602", "单位", "描述", new Date(), new Date(), true, 1L, new Date(), -1L, -1L, new Date());
        materialService.insert(material);
        return "index";
    }

}
