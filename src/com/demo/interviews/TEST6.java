package com.demo.interviews;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Dhruval Vaishnav Created on 19-10-2023
 */
public class TEST6 {

    public static void main(String[] args) {

        //AAA ta = new AAA(1,0,1,1);
        //AAA ta = new AAA(0,null,1,1);
        AAA ta = null;

        boolean isPartnerConsulting = ta != null && ta.getPartnerConsultingInd() == 1;
        boolean isPartnerFulfillmentInd = ta != null && ta.getPartnerFulfillmentInd() == 1;
        boolean isPartnerSellingIndicator = ta != null && ta.getPartnerSellingInd() == 1;
        boolean isPartnerSourcingIndicator = ta != null && ta.getPartnerSrcingInd() == 1;

        System.out.println("getPartnerConsultingInd = " + (ta != null ? ta.getPartnerConsultingInd() == 1 : false));
        System.out.println("getPartnerFulfillmentInd = " + (ta != null ? ta.getPartnerFulfillmentInd() == 1 : false));
        System.out.println("getPartnerSellingInd = " + (ta != null ? ta.getPartnerSellingInd() == 1 : false));
        System.out.println("getPartnerSrcingInd = " + (ta != null ? ta.getPartnerSrcingInd() == 1 : false));


//        System.out.println("isPartnerConsulting = " + isPartnerConsulting);
//        System.out.println("isPartnerFulfillmentInd = " + isPartnerFulfillmentInd);
//        System.out.println("isPartnerSellingIndicator = " + isPartnerSellingIndicator);
//        System.out.println("isPartnerSourcingIndicator = " + isPartnerSourcingIndicator);
    }


}

@Getter
@ToString
class AAA {

    private Integer partnerSrcingInd;
    private Integer partnerSellingInd;
    private Integer partnerFulfillmentInd;
    private Integer partnerConsultingInd;

    public AAA(Integer partnerSrcingInd, Integer partnerSellingInd, Integer partnerFulfillmentInd, Integer partnerConsultingInd) {
        this.partnerSrcingInd = partnerSrcingInd;
        this.partnerSellingInd = partnerSellingInd;
        this.partnerFulfillmentInd = partnerFulfillmentInd;
        this.partnerConsultingInd = partnerConsultingInd;
    }
}