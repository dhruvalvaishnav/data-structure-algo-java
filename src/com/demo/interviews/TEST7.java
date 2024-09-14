package com.demo.interviews;

/**
 * @author Dhruval Vaishnav Created on 12-12-2023
 */
public class TEST7 {

    public static void main(String[] args) {

        String s = "RenewalType";

        System.out.println(toCamelCase(s));
        System.out.println(String.valueOf(0L));
        System.out.println(String.valueOf(0));

        boolean jobCompleteStatus = false;
        Double bufferAccountForRegionalJobs = Math.ceil((15 * 99) / 100);
        System.out.println(bufferAccountForRegionalJobs);
        if (bufferAccountForRegionalJobs <= 10) {
            jobCompleteStatus = true;
        }
        System.out.println(jobCompleteStatus);

    }

    private static String toCamelCase(final String init) {
        if (init == null)
            return null;

        final StringBuilder ret = new StringBuilder(init.length());

        for (final String word : init.split(" ")) {
            if (!word.isEmpty()) {
                ret.append(Character.toUpperCase(word.charAt(0)));
                ret.append(word.substring(1).toLowerCase());
            }
            if (!(ret.length() == init.length()))
                ret.append(" ");
        }

        return ret.toString();
    }


}
