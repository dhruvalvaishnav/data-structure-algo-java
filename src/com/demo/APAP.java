package com.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dhruval Vaishnav Created on 23-04-2024
 */
public class APAP {
    public static void main(String[] args) {

        String setASTUserIds = "0051400000BqoWHAAZ;005a0000009AIAEAA4;00530000004psUUAAY;0058G000000I3NPQA0;0058G000000jTNPQA2;";
        String setASTProfileIds = "00ea0000001dnB9AAI;00ea0000001dnBEAAY;";
        System.out.println("setASTUserIds :: " + setASTUserIds);
        System.out.println("setASTProfileIds :: " + setASTProfileIds);

        Set<String> setUserAccessID = new HashSet<>(Arrays.asList(setASTUserIds.split(";")));
        Set<String> setProfileAccessID = new HashSet<>(Arrays.asList(setASTProfileIds.split(";")));
        System.out.println("setUserAccessID :: " + setUserAccessID);
        System.out.println("setProfileAccessID ::  " + setProfileAccessID);

        if (setProfileAccessID.contains("0055Y00000GrD5iQAF") || setUserAccessID.contains("SF-0058G000003TIO4")) {
            System.out.println("INNNNN");
        }
    }
}
