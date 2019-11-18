package com.fola.service;

import com.fola.model.BusinessInfo;

public class AccountInfoSerDe {


    private static final GenericSerDe<BusinessInfo> SERIALIZER_DESERIALIZER = new GenericSerDe<>();

    public byte[] serialize(BusinessInfo businessInfo) {
        return SERIALIZER_DESERIALIZER.serialize(businessInfo, BusinessInfo.class);
    }

    public BusinessInfo deserialize(byte[] data) {
        return SERIALIZER_DESERIALIZER.deserialize(data, BusinessInfo.class);
    }

}
