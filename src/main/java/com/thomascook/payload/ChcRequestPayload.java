package com.thomascook.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tcdl.msb.api.message.payload.RestPayload;

import java.util.Objects;

public class ChcRequestPayload extends RestPayload<Object, Object, Object, ChcRequestBody> {

    private final String event;

    @JsonCreator
    public ChcRequestPayload(@JsonProperty("event")String event, @JsonProperty("body")ChcRequestBody body) {
        this.event = event;
        setBody(body);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ChcRequestPayload))
            return false;
        if (!super.equals(o))
            return false;
        ChcRequestPayload that = (ChcRequestPayload) o;
        return Objects.equals(event, that.event) &&
                Objects.equals(getBody(), that.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), event, getBody());
    }

    @Override public String toString() {
        return "ChcRequestPayload{" +
                "event='" + event + '\'' +
                ", body=" + getBody() +
                '}';
    }
}
