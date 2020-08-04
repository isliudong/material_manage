package com.ld.controller;

import com.ld.cache.Uom;
import com.ld.dto.PaginationDTO;
import com.ld.dto.SearchDTO;
import com.ld.enums.exception.ErrorCode;
import com.ld.enums.exception.MyException;
import com.ld.model.Material;
import com.ld.service.MaterialServiceImpl;
import com.ld.utils.MyUuId;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author LD
 * @program: material_manage
 * @since 2020-08-01 13:17
 **/
@Controller
public class IndexController {

    @Autowired
    MaterialServiceImpl materialService;
    @Autowired
    MyUuId myUuId;


    @RequestMapping("/index")
    public String index(Model model,
                        @RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "5") Integer size,
                        @RequestParam(required = false) String itemCode,
                        @RequestParam(required = false) String description,
                        @RequestParam(required = false) String itemUom,
                        @RequestParam(required = false) String startActiveDate,
                        @RequestParam(required = false) String endActiveDate,
                        @RequestParam(required = false) String enabledFlag) {
        Boolean enabledFlag1;
        if (enabledFlag == null || "".equals(enabledFlag)) {
            enabledFlag1 = null;
        } else {
            enabledFlag1 = "是".equals(enabledFlag);
        }

        Date startDate = null;
        Date endDate = null;
        if ("".equals(itemCode)) {
            itemCode = null;
        }
        if (!Uom.getUom().contains(itemUom)||"全部".equals(itemUom)) {
            itemUom = null;
        }
        if ("".equals(description)) {
            description = null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (startActiveDate != null && !startActiveDate.isEmpty()) {
                startDate = dateFormat.parse(startActiveDate);
            }
            if (endActiveDate != null && !endActiveDate.isEmpty()) {
                endDate = dateFormat.parse(endActiveDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new MyException(ErrorCode.ERROR_DATE);
        }


        SearchDTO searchDto = new SearchDTO();

        searchDto.setDescription(description);

        searchDto.setEnabledFlag(enabledFlag1);
        searchDto.setStartActiveDate(startDate);
        searchDto.setEndActiveDate(endDate);
        searchDto.setItemCode(itemCode);
        searchDto.setItemUom(itemUom);
        searchDto.setPage(page);
        searchDto.setSize(size);

        PaginationDTO<Material> pagination = materialService.search(searchDto);


        model.addAttribute("pagination", pagination);
        model.addAttribute("description", description);
        model.addAttribute("itemCode", itemCode);
        model.addAttribute("itemUom", itemUom);
        model.addAttribute("startActiveDate", startActiveDate);
        model.addAttribute("endActiveDate", endActiveDate);
        model.addAttribute("enabledFlag", enabledFlag);

        return "index";
    }

    @RequestMapping("/insert")
    public String insert(String newDescription,
                         String newItemUom,
                         String newStartActiveDate,
                         String newEndActiveDate,
                         String newEnabledFlag) {

        Material material = initParameter(newDescription, newItemUom, newStartActiveDate, newEndActiveDate, newEnabledFlag);


        synchronized (this) {
            material.setItemCode(myUuId.nextItemCode(materialService.biggestItemCode(), 10));
            materialService.insert(material);
        }

        return "redirect:index";

    }

    @RequestMapping("/update")
    public String update(String updateItemCode,
                         String updateDescription,
                         String updateItemUom,
                         String updateStartActiveDate,
                         String updateEndActiveDate,
                         String updateEnabledFlag) {
        Material material = initParameter(updateDescription, updateItemUom, updateStartActiveDate, updateEndActiveDate, updateEnabledFlag);
        material.setItemCode(updateItemCode);
        material.setLastUpdateDate(new Date());


        synchronized (this) {
            materialService.update(material);
        }
        return "redirect:index";
    }

    /**
     * 提取合法参数到Material模型
     */
    private Material initParameter(String updateDescription, String ItemUom, String updateStartActiveDate, String updateEndActiveDate, String updateEnabledFlag) {
        Boolean enabled;
        if (updateEnabledFlag == null || "".equals(updateEnabledFlag)) {
            enabled = null;
        } else {
            enabled = "是".equals(updateEnabledFlag);
        }

        Date startDate = null;
        Date endDate = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (updateStartActiveDate != null && !updateStartActiveDate.isEmpty()) {
                startDate = dateFormat.parse(updateStartActiveDate);
            }
            if (updateEndActiveDate != null && !updateEndActiveDate.isEmpty()) {
                endDate = dateFormat.parse(updateEndActiveDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!Uom.getUom().contains(ItemUom)) {
            ItemUom = null;
        }

        Material material = new Material();

        material.setEnabledFlag(enabled);
        material.setEndActiveDate(endDate);
        material.setStartActiveDate(startDate);
        material.setItemDescription(updateDescription);
        material.setItemUom(ItemUom);

        return material;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String itemCode) {
        materialService.delete(itemCode);
        return "success";
    }
}
