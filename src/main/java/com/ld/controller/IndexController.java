package com.ld.controller;

import com.ld.dto.PaginationDTO;
import com.ld.dto.SearchDto;
import com.ld.model.Material;
import com.ld.service.MaterialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * @program: material_manage
 * @description:
 * @author: LD
 * @create: 2020-08-01 13:17
 **/
@Controller
public class IndexController {

    @Autowired
    MaterialServiceImpl materialService;


    @RequestMapping("/index")
    public String index(Model model,
                        @RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "5") Integer size,
                        @RequestParam(required = false) String itemCode,
                        @RequestParam(required = false) String description,
                        @RequestParam(required = false) String itemUom,
                        @RequestParam(required = false) String startActiveDate,
                        @RequestParam(required = false) String endActiveDate,
                        @RequestParam(required = false) String enabledFlag)
    {
        Boolean enabledFlag1;
        if(enabledFlag==null||"".equals(enabledFlag)){
            enabledFlag1=null;
        }else {
            enabledFlag1= "是".equals(enabledFlag);
        }

        Date startDate=null;
        Date endDate=null;
        if("".equals(itemCode)){
            itemCode=null;
        }
        if ("".equals(itemUom)) {
            itemUom=null;
        }
        if("".equals(description)){
            description=null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(startActiveDate!=null&&!startActiveDate.isEmpty()) {
                startDate = dateFormat.parse(startActiveDate);
            }
            if (endActiveDate!=null&&!endActiveDate.isEmpty()) {
                endDate = dateFormat.parse(endActiveDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SearchDto searchDto = new SearchDto();
        searchDto.setDescription(description);

        searchDto.setEnabledFlag(enabledFlag1);
        searchDto.setStartActiveDate(startDate);
        searchDto.setEndActiveDate(endDate);
        searchDto.setItemCode(itemCode);
        searchDto.setItemUom(null);
        searchDto.setPage(page);
        searchDto.setSize(size);

        PaginationDTO<Material> pagination= materialService.search(searchDto);


        model.addAttribute("pagination",pagination);
        model.addAttribute("description",description);
        model.addAttribute("itemCode",itemCode);
        model.addAttribute("itemUom",itemUom);
        model.addAttribute("startActiveDate",startActiveDate);
        model.addAttribute("endActiveDate",endActiveDate);
        model.addAttribute("enabledFlag",enabledFlag);

        return "index";
    }

    @RequestMapping("/insert")
    public String insert(String newDescription,
                         String newItemUom,
                         String newStartActiveDate,
                         String newEndActiveDate,
                         String newEnabledFlag){

        Boolean enabled;
        if(newEnabledFlag==null||"".equals(newEnabledFlag)){
            enabled=null;
        }else {
            enabled= "是".equals(newEnabledFlag);
        }

        Date startDate=null;
        Date endDate=null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(newStartActiveDate!=null&&!newStartActiveDate.isEmpty()) {
                startDate = dateFormat.parse(newStartActiveDate);
            }
            if (newEndActiveDate!=null&&!newEndActiveDate.isEmpty()) {
                endDate = dateFormat.parse(newEndActiveDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Material material = new Material();

        material.setEnabledFlag(enabled);
        material.setEndActiveDate(endDate);
        material.setStartActiveDate(startDate);
        material.setItemDescription(newDescription);
        material.setItemUom(newItemUom);

        //可能线程问题
        material.setItemCode("ITEM" +(materialService.getTotalCount()+1));
        materialService.insert(material);
        return "redirect:index";

    }

    @RequestMapping("/update")
    public String update(String updateItemCode,
                         String updateDescription,
                         String updateItemUom,
                         String updateStartActiveDate,
                         String updateEndActiveDate,
                         String updateEnabledFlag){
        Boolean enabled;
        if(updateEnabledFlag==null||"".equals(updateEnabledFlag)){
            enabled=null;
        }else {
            enabled= "是".equals(updateEnabledFlag);
        }

        Date startDate=null;
        Date endDate=null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(updateStartActiveDate!=null&&!updateStartActiveDate.isEmpty()) {
                startDate = dateFormat.parse(updateStartActiveDate);
            }
            if (updateEndActiveDate!=null&&!updateEndActiveDate.isEmpty()) {
                endDate = dateFormat.parse(updateEndActiveDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Material material = new Material();

        material.setEnabledFlag(enabled);
        material.setEndActiveDate(endDate);
        material.setStartActiveDate(startDate);
        material.setItemDescription(updateDescription);
        material.setItemUom(updateItemUom);
        material.setItemCode(updateItemCode);


        materialService.update(material);
        return "redirect:index";
    }

    @RequestMapping("/delete")
    public String delete(String itemCode){
        materialService.delete(itemCode);
        return "redirect:index";
    }
}
