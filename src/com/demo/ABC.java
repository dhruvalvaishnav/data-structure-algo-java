package com.demo;

import lombok.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dhruval Vaishnav Created on 22-02-2024
 */
public class ABC {

    public static void main(String[] args) {

        List<PQR> list = Arrays.asList(new PQR("32123121"), new PQR("48954b41-8711-44c7-b870-ec26ec957d1c"));
        System.out.println(list);

        String systemUser = "48954b41-8711-44c7-b870-ec26ec957d1c";

        list = list.stream()
                .filter(x -> x.getCrmUserId() != null && !x.getCrmUserId().isEmpty() &&
                        !x.getCrmUserId().toLowerCase().equalsIgnoreCase(systemUser.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("inside" + list);

    }


}


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
class PQR {
    private String crmUserId;
}
