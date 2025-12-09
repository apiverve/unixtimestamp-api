// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     UnixTimestampConverterData data = Converter.fromJsonString(jsonString);

package com.apiverve.unixtimestamp.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static UnixTimestampConverterData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(UnixTimestampConverterData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(UnixTimestampConverterData.class);
        writer = mapper.writerFor(UnixTimestampConverterData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// UnixTimestampConverterData.java

package com.apiverve.unixtimestamp.data;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class UnixTimestampConverterData {
    private long timestamp;
    private String timestampFormat;
    private OffsetDateTime iso8601;
    private String rfc2822;
    private String date;
    private String time;
    private long unixSeconds;
    private long unixMilliseconds;
    private long year;
    private long month;
    private long day;
    private long hour;
    private long minute;
    private long second;
    private String dayOfWeek;
    private String timezone;

    @JsonProperty("timestamp")
    public long getTimestamp() { return timestamp; }
    @JsonProperty("timestamp")
    public void setTimestamp(long value) { this.timestamp = value; }

    @JsonProperty("timestamp_format")
    public String getTimestampFormat() { return timestampFormat; }
    @JsonProperty("timestamp_format")
    public void setTimestampFormat(String value) { this.timestampFormat = value; }

    @JsonProperty("iso_8601")
    public OffsetDateTime getIso8601() { return iso8601; }
    @JsonProperty("iso_8601")
    public void setIso8601(OffsetDateTime value) { this.iso8601 = value; }

    @JsonProperty("rfc_2822")
    public String getRfc2822() { return rfc2822; }
    @JsonProperty("rfc_2822")
    public void setRfc2822(String value) { this.rfc2822 = value; }

    @JsonProperty("date")
    public String getDate() { return date; }
    @JsonProperty("date")
    public void setDate(String value) { this.date = value; }

    @JsonProperty("time")
    public String getTime() { return time; }
    @JsonProperty("time")
    public void setTime(String value) { this.time = value; }

    @JsonProperty("unix_seconds")
    public long getUnixSeconds() { return unixSeconds; }
    @JsonProperty("unix_seconds")
    public void setUnixSeconds(long value) { this.unixSeconds = value; }

    @JsonProperty("unix_milliseconds")
    public long getUnixMilliseconds() { return unixMilliseconds; }
    @JsonProperty("unix_milliseconds")
    public void setUnixMilliseconds(long value) { this.unixMilliseconds = value; }

    @JsonProperty("year")
    public long getYear() { return year; }
    @JsonProperty("year")
    public void setYear(long value) { this.year = value; }

    @JsonProperty("month")
    public long getMonth() { return month; }
    @JsonProperty("month")
    public void setMonth(long value) { this.month = value; }

    @JsonProperty("day")
    public long getDay() { return day; }
    @JsonProperty("day")
    public void setDay(long value) { this.day = value; }

    @JsonProperty("hour")
    public long getHour() { return hour; }
    @JsonProperty("hour")
    public void setHour(long value) { this.hour = value; }

    @JsonProperty("minute")
    public long getMinute() { return minute; }
    @JsonProperty("minute")
    public void setMinute(long value) { this.minute = value; }

    @JsonProperty("second")
    public long getSecond() { return second; }
    @JsonProperty("second")
    public void setSecond(long value) { this.second = value; }

    @JsonProperty("day_of_week")
    public String getDayOfWeek() { return dayOfWeek; }
    @JsonProperty("day_of_week")
    public void setDayOfWeek(String value) { this.dayOfWeek = value; }

    @JsonProperty("timezone")
    public String getTimezone() { return timezone; }
    @JsonProperty("timezone")
    public void setTimezone(String value) { this.timezone = value; }
}