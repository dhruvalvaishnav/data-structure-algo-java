package com.demo.interviews;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TEST3 {
    public static void main(String[] args) {

        /*
        List<AdobeTerritoryMemberResponse> atmResponsePreSales = new ArrayList<>();
        atmResponsePreSales.add(new AdobeTerritoryMemberResponse("acc1","other1"));
        atmResponsePreSales.add(new AdobeTerritoryMemberResponse("acc2","other2"));
        atmResponsePreSales.add(new AdobeTerritoryMemberResponse("acc3","other3"));
        atmResponsePreSales.add(new AdobeTerritoryMemberResponse("acc4","other4"));

        Map<String, Set<String>> crmAccountIds = new HashMap<>();
        crmAccountIds.put("ABC", new HashSet<>(Arrays.asList("acc1,acc2", "acc3", "acc4")));

        // Convert List<AdobeTerritoryMemberResponse> to Map camid, AdobeTerritoryMemberResponse
        Map<String, AdobeTerritoryMemberResponse> responseMap = atmResponsePreSales.stream().collect(Collectors.toMap(x -> x.getAccountid(), x -> x));

        // crmAccountIds - keySet ==> key ==> cam id
        for (String camId : crmAccountIds.keySet()) {
            if (responseMap.size() > 0) {
                // second loop, account ids ==> replace the cam id with account
                for (Map.Entry<String, AdobeTerritoryMemberResponse> entry : responseMap.entrySet()) {
                    // this is failing - entry - env acc id and cam id
                    if (entry.getKey().equalsIgnoreCase(camId)) {
                        AdobeTerritoryMemberResponse response = entry.getValue();
                        //response.setAccountId(camId);
                    }
                }
            }
        }
    */


            String number1 = "12.3"; // Should return true
            String number2 = "3.45"; // Should return false (two decimal places)
            String number3 = "123";  // Should return false (no decimal places)
            String number4 = "0.000000";  // Should return false (no decimal places)
            String number5 = "0.01";  // Should return false (no decimal places)
            String number6 = "1.1";  // Should return false (no decimal places)
            String number7 = "360,000.1";  // Should return false (no decimal places)

            System.out.println(number1 + " has one decimal place: " + hasOneDecimalPlace(number1));
            System.out.println(number2 + " has one decimal place: " + hasOneDecimalPlace(number2));
            System.out.println(number3 + " has one decimal place: " + hasOneDecimalPlace(number3));
            System.out.println(number4 + " has one decimal place: " + hasOneDecimalPlace(number4));
            System.out.println(number5 + " has one decimal place: " + hasOneDecimalPlace(number5));
            System.out.println(number6 + " has one decimal place: " + hasOneDecimalPlace(number6));
            System.out.println(number7 + " has one decimal place: " + hasOneDecimalPlace(number7));
        }



        public static boolean hasOneDecimalPlace(String number) {
            // Remove commas from the input string
            String numberWithoutCommas = number.replace(",", "");

            // Define a regular expression pattern to match numbers with one decimal place
            String regex = "^[\\d]+\\.[\\d]{1}$"; // This pattern allows exactly one decimal place with a dot (.)

            // Compile the regex pattern
            Pattern pattern = Pattern.compile(regex);

            // Create a Matcher object
            Matcher matcher = pattern.matcher(numberWithoutCommas);

            // Check if the input matches the pattern
            return matcher.matches();
        }


}

class AdobeTerritoryMemberResponse {
    String accountid;
    String others;

    public AdobeTerritoryMemberResponse(String accountid, String others) {
        this.accountid = accountid;
        this.others = others;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
