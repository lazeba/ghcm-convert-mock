package com.thomascook.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ChcRequestBody {

    private final String codeValue;
    private final String sourceCodeTypeID;
    private final String targetCodeTypeID;

    @JsonCreator
    public ChcRequestBody(@JsonProperty("codeValue") String codeValue,
                          @JsonProperty("sourceCodeTypeID") String sourceCodeTypeID,
                          @JsonProperty("targetCodeTypeID") String targetCodeTypeID) {
        this.codeValue = codeValue;
        this.sourceCodeTypeID = sourceCodeTypeID;
        this.targetCodeTypeID = targetCodeTypeID;
    }

    //getters are needed for testing purposes
    public String getCodeValue() {
        return codeValue;
    }

    public String getSourceCodeTypeID() {
        return sourceCodeTypeID;
    }

    public String getTargetCodeTypeID() {
        return targetCodeTypeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ChcRequestBody))
            return false;
        ChcRequestBody that = (ChcRequestBody) o;
        return Objects.equals(codeValue, that.codeValue) &&
                Objects.equals(sourceCodeTypeID, that.sourceCodeTypeID) &&
                Objects.equals(targetCodeTypeID, that.targetCodeTypeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeValue, sourceCodeTypeID, targetCodeTypeID);
    }

    @Override
    public String toString() {
        return "ChcRequestBody{" +
                "codeValue='" + codeValue + '\'' +
                ", sourceCodeTypeID='" + sourceCodeTypeID + '\'' +
                ", targetCodeTypeID='" + targetCodeTypeID + '\'' +
                '}';
    }
}