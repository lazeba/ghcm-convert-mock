package com.thomascook.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Set;

public class ChcResponseBody {

    private Set<String> convertedCodeValue;

    @JsonCreator
    public ChcResponseBody(@JsonProperty("convertedCodeValue") Set<String> convertedCodeValue) {
        this.convertedCodeValue = convertedCodeValue;
    }

    public Set<String> getConvertedCodeValue() {
        return convertedCodeValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ChcResponseBody))
            return false;
        ChcResponseBody that = (ChcResponseBody) o;
        return Objects.equals(convertedCodeValue, that.convertedCodeValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertedCodeValue);
    }

    @Override
    public String toString() {
        return "ChcResponseBody{" +
                "convertedCodeValue=" + convertedCodeValue +
                '}';
    }
}
