package com.demo.interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Dhruval Vaishnav Created on 05-10-2023
 */
public class TEST5 {
    public static void main(String[] args) {
        List<String> list2 = new ArrayList<>(List.of(new String[]{"WKFT","MERCHANT SERVICES","AEP INTELLIGENCE","ATTRIBUTION AI","RTCDP CONNECTIONS","SITES","ASSETS","MARKETO-MEASURE","CCE WKFT","TARGET","MAGENTO","FORMS","CAMPAIGN","CJA","MARKETO-ENGAGE","AEP ADD-ONS","JOURNEY","CCE AEM","AAM","RTCDP","AEP ADD-ON: PRIVACY AND SECURITY SHIELD","PREMIER SUPPORT","ANALYTICS"}));
        List<String> list3 = new ArrayList<>(List.of(new String[]{"CCE AEM","AEP INTELLIGENCE","ANALYTICS","TARGET","MARKETO-MEASURE","JOURNEY","WKFT","RTCDP","AEP ADD-ON: PRIVACY AND SECURITY SHIELD","ATTRIBUTION AI","CJA","CCE WKFT","MAGENTO","RTCDP CONNECTIONS","CAMPAIGN","SITES","AAM","ASSETS","MERCHANT SERVICES","MARKETO-ENGAGE","FORMS","AEP ADD-ONS","PREMIER SUPPORT"}));

        Collections.sort(list2);
        System.out.println(list2);
        Collections.sort(list3);
        System.out.println(list3);

        System.out.println(list2.equals(list3));
    }
}
