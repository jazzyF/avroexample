package com.fola.service;

import org.apache.avro.Schema;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.Encoder;
import org.apache.avro.reflect.CustomEncoding;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeCustomEncoding extends CustomEncoding<LocalDateTime> {

    {
        schema = Schema.create(Schema.Type.STRING);
        schema.addProp("CustomEncoding", "LocalDateTimeAsStringEncoding");
    }

    @Override
    protected void write(Object datum, Encoder out) throws IOException {
        out.writeString(datum.toString());
    }

    @Override
    protected LocalDateTime read(Object reuse, Decoder in) throws IOException {
        if (reuse instanceof LocalDateTime) {
            return (LocalDateTime) reuse;
        }
        return LocalDateTime.parse(in.readString());
    }

}
