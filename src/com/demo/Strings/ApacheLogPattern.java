package com.demo.Strings;

import java.util.*;
import java.util.stream.Collectors;

// Given an Apache log file, return IP address(es) which accesses the site most often.
// our log is in this format (Common Log Format). One entry per line.
// 10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] "GET /a.gif HTTP/1.0" 200 234
// Log file entries are passed as an array.
// NOTE: In case of tie, this returns a comma-separated list of the IP addresses. Tie is not mentioned explicitly in the exercise on purpose.
public class ApacheLogPattern {
    public static void main(String[] args) {

        String[] input1 = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"};

        String[] input2 = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234",};

        String[] input3 = new String[]{
                "10.0.0.1 - GET 2020-08-24",
                "10.0.0.1 - GET 2020-08-24",
                "10.0.0.2 - GET 2020-08-20",
                "10.0.0.3 - GET 2020-08-24",
                "10.0.0.3 - GET 2020-08-24",
                "10.0.0.3 - GET 2020-08-24",
                "10.0.0.4 - GET 2020-08-24",};

        System.out.println(findTopIpaddress(input1));
        System.out.println(findTopIpaddress(input2));
        System.out.println(findTopIpaddress(input3));
    }

    private static List<String> findTopIpaddress(String[] lines) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> topIPs = new ArrayList<>();
        int freq = 0;

        //find the ip from the given log file
        for (String line : lines) {
            String[] str = line.split(" ");
            map.put(str[0], map.getOrDefault(str[0], 0) + 1);
        }
        //find the max freq of ip
        for (String ip : map.keySet()) {
            freq = Math.max(freq, map.get(ip));
        }
        //find the ip with the max freq and add to the result list
        for (Map.Entry<String, Integer> o : map.entrySet()) {
            if (o.getValue() == freq) topIPs.add(o.getKey());
        }
        return topIPs;
    }

}

/*
Test Cases:
    Input:
    String lines[] = new String[]{
                    "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                    "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                    "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"};
    Output : 10.0.0.1

    Input:
    String  lines[] = new String[]{
                    "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                    "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                    "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                    "10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                    "10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234",};
    Output - 10.0.0.1,10.0.0.2

*/

/*
Another solution :

        List<String> ips = Arrays.stream(lines)
                .map(value -> value.split(" "))
                .map(splitArray -> splitArray[0])
                .collect(Collectors.toList());
        Map<String, Integer> store = new HashMap<>();

        for (String value : ips) {
            store.put(value, store.getOrDefault(value, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> s : store.entrySet()) {
            max = Math.max(max, s.getValue());
        }
        int finalMax = max;
        store.entrySet().parallelStream().filter(stringIntegerEntry -> stringIntegerEntry.getValue().equals(finalMax)).
                forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey()));
 */