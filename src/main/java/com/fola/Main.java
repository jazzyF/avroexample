package com.fola;

import com.fola.model.BusinessInfo;
import com.fola.service.AccountInfoSerDe;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");


        List<String> misc = new ArrayList<>();
        misc.add("hello");
        BusinessInfo businessInfo = new BusinessInfo(LocalDateTime.now(), "foo", UUID.randomUUID(), misc);
        AccountInfoSerDe accountInfoSerDe = new AccountInfoSerDe();
        byte[] serialize = accountInfoSerDe.serialize(businessInfo);
        System.out.println(Arrays.toString(serialize));

        BusinessInfo deserialize = accountInfoSerDe.deserialize(serialize);
        System.out.println(deserialize.toString());
    }
}
