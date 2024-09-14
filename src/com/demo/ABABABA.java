package com.demo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class ABABABA {

    public static void main(String[] args) {
        //System.out.println(isMatched());
        Date createdTime = new Date();
        System.out.println(createdTime);
        LocalDateTime ct = null;
        if (createdTime != null) {
            // Convert java.util.Date to Instant using getTime() method
            Instant instant = Instant.ofEpochMilli(createdTime.getTime());
            System.out.println(instant);
            // Convert Instant to LocalDateTime
            ct = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            System.out.println(ct);
        } else {
            System.out.println("else");
            // Handle the case when createdTime is null
            // For example, you can assign a default LocalDateTime or handle it based on your application logic
        }
    }

    private static boolean isMatched() {
        boolean isMatched = false;

        boolean adobeRoleMatch = true;
        boolean salesRepMatch = true;
        boolean accountMatch = true;
        boolean taMatch = true;
        boolean opgListMatch = true;
        boolean atMatch = 1814437 == 1814437;

        boolean subIdMatch = false;

        // Check if both atmRuleNames contain "named"
        if (atmRuleNamesContainNamed()) {
            subIdMatch = isSubIdMatch();
            if (adobeRoleMatch && salesRepMatch && accountMatch && taMatch && opgListMatch && atMatch && subIdMatch) {
                isMatched = true;
            }
        } else if (adobeRoleMatch && salesRepMatch && accountMatch && taMatch && opgListMatch && atMatch) {
            isMatched = true;
        }


        return isMatched;
    }

    private static boolean atmRuleNamesContainNamed() {
        String existingAtmRuleName = "Lisa Maria Kantorovitch assigned as a named account from Sub Id : 666378";
        String atmRuleName = "POOL AMERICAS DX/DME 91826070 assigned as a industry";

        return existingAtmRuleName.contains("named") && atmRuleName.contains("named");
    }

    private static boolean isSubIdMatch() {
        String existingAtmRuleName = "Lisa Maria Kantorovitch assigned as a named account from Sub Id : 666378";
        String atmRuleName = "POOL AMERICAS DX/DME 91826070 assigned as a industry";

        boolean subIdMatch = false;

        if (Objects.nonNull(atmRuleName) && !atmRuleName.isEmpty() && Objects.nonNull(existingAtmRuleName) && !existingAtmRuleName.isEmpty()) {
            String[] atmRuleNameParts = atmRuleName.split(": ");
            String[] existingRuleNameParts = existingAtmRuleName.split(": ");

            if (atmRuleNameParts.length == 2 && existingRuleNameParts.length == 2) {
                long atmSubId = Long.parseLong(atmRuleNameParts[1].trim());
                long existingAtmSubId = Long.parseLong(existingRuleNameParts[1].trim());
                subIdMatch = atmSubId == existingAtmSubId;
            }
        }
        return subIdMatch;
    }
}
