package com.fola.service;

import org.apache.avro.Schema;
import org.apache.avro.io.*;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumReader;
import org.apache.avro.reflect.ReflectDatumWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

class GenericSerDe<T> {

    T deserialize(byte[] bytes, Class<T> clazz) {
        Schema schema = ReflectData.get().getSchema(clazz);


        DatumReader<T> datumReader = new ReflectDatumReader<>(schema);
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byte[] payload = new byte[bytes.length];
        byteBuffer.get(payload);
        Decoder decoder = DecoderFactory.get().binaryDecoder(bytes, null);
        try {
            return datumReader.read(null, decoder);
        } catch (IOException e) {
            throw new SerDeException(e);
        }
    }

    byte[] serialize(T t, Class<T> clazz) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Schema schema = ReflectData.get().getSchema(clazz);
        DatumWriter<T> datumWriter = new ReflectDatumWriter<>(schema);
        BinaryEncoder binaryEncoder = EncoderFactory.get().binaryEncoder(byteArrayOutputStream, null);
        try {
            datumWriter.write(t, binaryEncoder);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new SerDeException(e);
        } finally {
            try {
                binaryEncoder.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
