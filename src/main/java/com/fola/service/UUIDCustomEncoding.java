package com.fola.service;

import org.apache.avro.Schema;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.Encoder;
import org.apache.avro.reflect.CustomEncoding;

import java.io.IOException;
import java.util.UUID;

public class UUIDCustomEncoding extends CustomEncoding<UUID> {

    {
        schema = Schema.create(Schema.Type.STRING);
        schema.addProp("CustomEncoding", "UUIDAsStringEncoding");
    }

    @Override
    protected void write(Object datum, Encoder out) throws IOException {
        out.writeString(datum.toString());
    }

    @Override
    protected UUID read(Object reuse, Decoder in) throws IOException {
        if (reuse instanceof UUID) {
            return (UUID) reuse;
        }
        return UUID.fromString(in.readString());
    }
}
