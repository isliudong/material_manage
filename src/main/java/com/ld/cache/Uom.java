package com.ld.cache;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: material_manage
 * @description: 单位缓存
 * @author: LD
 * @create: 2020-08-04 17:21
 **/
public class Uom {
    private static ArrayList<String> uom = new ArrayList<>(Arrays.asList("米","平方米","立方米","千克","个","其他"));

    public static ArrayList<String> getUom(){
        return uom;
    }
}
