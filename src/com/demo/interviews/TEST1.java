package com.demo.interviews;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class TEST1 {
    public static void main(String[] args) throws InterruptedException, ParseException {

//        String accId = "259376ce-72f4-ed11-8847-000d3a4dd285";
//        List<AdobeTerritoryMember> adobeTerritoryMemberList = Arrays.asList(new AdobeTerritoryMember("1117645", "259376CE-72F4-ED11-8847-000D3A4DD285"));
//        Map<String, List<AdobeTerritoryMember>> map = mapAdobeTerritoryMember(adobeTerritoryMemberList);
//        System.out.println(map);
//        List<AdobeTerritoryMember> res = map.get(accId);
//        System.out.println(res);
//        System.out.println(map.get(accId));
//
//        if (map.get(accId) != null) {
//            System.out.println("SUCCESS");
//        }

//        List<String> names = Arrays.asList("Reflection","Collection","Stream");
//
//        List<String> result = names.stream().filter(s->s.equalsIgnoreCase("Reflection")).collect(Collectors.toList());
//
//        System.out.println(names);
//        System.out.println(result);

        //2022-05-25T19:37:18.042Z
//        System.out.println(" time :: " + new Timestamp(new Date().getTime()));
//        System.out.println(" time :: " + new Timestamp(System.currentTimeMillis()));
//        System.out.println(" time :: " + new Date());
//        System.out.println(LocalDateTime.now().toString());

//        List<String> list1 = new ArrayList<>(List.of(new String[]{"SRCH", "PD", "MEDIA OPTIMIZER"}));
//        List<String> list2 = new ArrayList<>(List.of(new String[]{"MEDIA OPTIMIZER", "SRCH", "PD"}));
//
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println(list2.equals(list1));
//
//        //list1=null;
//        Set<String> set1 = new HashSet<>(Optional.ofNullable(list1).orElse(new ArrayList<>()).stream().sorted().collect(Collectors.toList()));
//        Set<String> set2 = new HashSet<>(Optional.ofNullable(list2).orElse(new ArrayList<>()).stream().sorted().collect(Collectors.toList()));
//        System.out.println(set1);
//        System.out.println(set2);
//        System.out.println(set1.equals(set2));

//        LocalDateTime startTime = LocalDateTime.now();
//        System.out.println(startTime.toString());
//
//        Thread.sleep(1000);
//        LocalDateTime endTime = LocalDateTime.now();
//        System.out.println(endTime.toString());
//
//        System.out.println(Duration.between(startTime, endTime).getSeconds());




//        Timestamp timestamp = convertStringToTimestamp(startTime.toString());
//        System.out.println(timestamp.toString());
//        System.out.println(timestamp.toLocalDateTime().toString());
//        LocalDateTime startTime1 =timestamp.toLocalDateTime();
//        System.out.println(startTime1);


//        System.out.println(endTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//        System.out.println(LocalDateTime.now());
//        System.out.println(endTime.format(DateTimeFormatter.ISO_LOCAL_DATE));

//        Timestamp t = new Timestamp(DateUtil.provideDateFormat().parse(startTime.toString()).getTime());
//        System.out.println(t);
//        System.out.println(t.toLocalDateTime());
//        System.out.println(t.toLocalDateTime().toString());

        LocalDateTime tt = LocalDateTime.now();
        String format = tt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'"));
        System.out.println(format);

        //LocalDateTime startTime1 = LocalDateTime.parse(startTime.toString());
        //System.out.println(startTime1);


    }
    static Timestamp convertStringToTimestamp(String strDate) {
        return Optional.ofNullable(strDate) // wrap the String into an Optional
                .map(str -> LocalDate.parse(str).atStartOfDay()) // convert into a LocalDate and fix the hour:minute:sec to 00:00:00
                .map(Timestamp::valueOf) // convert to Timestamp
                .orElse(null); // if no value is present, return null
    }

    private static Map<String, List<AdobeTerritoryMember>> mapAdobeTerritoryMember(List<AdobeTerritoryMember> adobeTerritoryMemberList) {
        Map<String, List<AdobeTerritoryMember>> mapATMByAccountId = new HashMap<String, List<AdobeTerritoryMember>>();

//        for (AdobeTerritoryMember adobeTerritoryMember : adobeTerritoryMemberList) {
//            String accontId = adobeTerritoryMember.getAccountSFDCId();
//            List<AdobeTerritoryMember> atmList = mapATMByAccountId.get(accontId);
//            if (atmList == null) {
//                atmList = new ArrayList<AdobeTerritoryMember>();
//            }
//            atmList.add(adobeTerritoryMember);
//            mapATMByAccountId.put(accontId, atmList);
//        }


        mapATMByAccountId = adobeTerritoryMemberList.stream()
                .collect(Collectors.groupingBy(AdobeTerritoryMember::getAccountSFDCId, Collectors.toList()));

        return mapATMByAccountId;
    }
}

class AdobeTerritoryMember {
    private String adobeTerritoryMemberId;
    private String accountSFDCId;

    public AdobeTerritoryMember(String adobeTerritoryMemberId, String accountSFDCId) {
        this.adobeTerritoryMemberId = adobeTerritoryMemberId;
        this.accountSFDCId = accountSFDCId;
    }

    public String getAdobeTerritoryMemberId() {
        return adobeTerritoryMemberId;
    }

    public void setAdobeTerritoryMemberId(String adobeTerritoryMemberId) {
        this.adobeTerritoryMemberId = adobeTerritoryMemberId;
    }

    public String getAccountSFDCId() {
        return accountSFDCId;
    }

    public void setAccountSFDCId(String accountSFDCId) {
        this.accountSFDCId = accountSFDCId;
    }

    @Override
    public String toString() {
        return "AdobeTerritoryMember{" +
                "adobeTerritoryMemberId='" + adobeTerritoryMemberId + '\'' +
                ", accountSFDCId='" + accountSFDCId + '\'' +
                '}';
    }
}


