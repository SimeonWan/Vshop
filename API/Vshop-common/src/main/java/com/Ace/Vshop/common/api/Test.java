package com.Ace.Vshop.common.api;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> testString = new ArrayList<>();
        for(int i=0;i<1000000;i++){
            testString.add(i+"");
        }
        CommonPage<String> res = CommonPage.returnPage(testString);

        System.out.println(res);
    }
}
