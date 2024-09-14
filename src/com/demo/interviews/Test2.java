package com.demo.interviews;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Test2 {

    static double dValue = 2051234588;

    public static void main(String[] args) {
//        System.out.println(String.valueOf(dValue));
//        System.out.println(Double.valueOf(dValue));
//        System.out.println(dValue);
//        System.out.println(BigDecimal.valueOf(dValue));
//        System.out.println(new BigDecimal(dValue).floatValue());

//        Map<String,String> map = new HashMap<>();
//        String req = "CAMPAIGN;TARGET;AEP ADD-ON";
//        String opg = Arrays.toString(Arrays.stream(req.split(";")).toArray());
//        System.out.println(opg);
//        System.out.println(String.join(";", req));
//        map.put("OPG",opg);
//        System.out.println(map);


//        String fieldsToCheck = "historicASVOverride";
//        String[] sepFields = fieldsToCheck.trim().split(";");
//        System.out.println(Arrays.toString(sepFields));

        List<Account> accountEntityList = new ArrayList<>();
        accountEntityList.add(new Account("1","245"));
        accountEntityList.add(new Account("2","245"));
        accountEntityList.add(new Account("3","485"));
        accountEntityList.add(new Account("4","245"));

        Map<String, Set<String>> map = new HashMap<>();
        for (Account acc : accountEntityList) {
            Set<String> accIds = map.get(acc.getCamId());
            if (accIds == null) {
                accIds = new HashSet<>();
            }
            accIds.add(acc.getAccountId());
            map.put(acc.getCamId(), accIds);
        }

        System.out.println(map);

        System.out.println(map.values().stream().flatMap(Collection::stream).collect(Collectors.toSet()));

//        String abc = "DR#879877";
//        abc = abc.replaceAll("[^\\dA-Za-z ]", "-");
//        System.out.println(abc);
    }

    public static class Account{
        private String accountId;
        private String camId;

        public Account(String accountId,String camId) {
            this.accountId = accountId;
            this.camId = camId;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public String getCamId() {
            return camId;
        }

        public void setCamId(String camId) {
            this.camId = camId;
        }
    }
}
