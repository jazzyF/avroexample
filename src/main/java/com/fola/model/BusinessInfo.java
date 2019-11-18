package com.fola.model;

import com.fola.service.LocalDateTimeCustomEncoding;
import com.fola.service.UUIDCustomEncoding;
import org.apache.avro.reflect.AvroEncode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class BusinessInfo {

    @AvroEncode(using = LocalDateTimeCustomEncoding.class)
    private LocalDateTime openedDate;
    private String name;
    @AvroEncode(using = UUIDCustomEncoding.class)
    private UUID uuid;
    private List<String> miscellaneous;

    public BusinessInfo() {
    }

    public BusinessInfo(LocalDateTime openedDate, String name, UUID uuid, List<String> miscellaneous) {
        this.openedDate = openedDate;
        this.name = name;
        this.uuid = uuid;
        this.miscellaneous = miscellaneous;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "openedDate=" + openedDate +
                ", name='" + name + '\'' +
                ", uuid=" + uuid +
                ", miscellaneous=" + miscellaneous +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessInfo that = (BusinessInfo) o;
        return openedDate.equals(that.openedDate) &&
                name.equals(that.name) &&
                uuid.equals(that.uuid) &&
                miscellaneous.equals(that.miscellaneous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openedDate, name, uuid, miscellaneous);
    }

    public LocalDateTime getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(LocalDateTime openedDate) {
        this.openedDate = openedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<String> getMiscellaneous() {
        return miscellaneous;
    }

    public void setMiscellaneous(List<String> miscellaneous) {
        this.miscellaneous = miscellaneous;
    }
}
