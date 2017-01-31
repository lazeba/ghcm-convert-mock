package com.thomascook.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tcdl.msb.api.message.payload.RestPayload;

import java.util.Objects;

public class ChcResponsePayload extends RestPayload<Object, Object, Object, ChcResponseBody> {

    @JsonCreator
    public ChcResponsePayload(@JsonProperty("body") ChcResponseBody body) {
        setBody(body);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ChcResponsePayload))
            return false;
        if (!super.equals(o))
            return false;
        ChcResponsePayload that = (ChcResponsePayload) o;
        return Objects.equals(getBody(), that.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBody());
    }

    @Override
    public String toString() {
        return "ChcResponsePayload{" +
                "body=" + getBody() +
                '}';
    }
}
