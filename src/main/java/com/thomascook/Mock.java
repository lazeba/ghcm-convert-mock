package com.thomascook;

import com.thomascook.payload.ChcRequestPayload;
import com.thomascook.payload.ChcResponseBody;
import com.thomascook.payload.ChcResponsePayload;
import com.typesafe.config.Config;
import io.github.tcdl.msb.api.MsbContext;
import io.github.tcdl.msb.api.ResponderOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Alexandr Zolotov
 */
@Component
public class Mock {

    @Autowired
    MsbContext msbContext;

    @Autowired
    Config config;

    @PostConstruct
    public void startMock(){

        String namespace = config.getString("ghcm.namespace");
        List<String> responses = config.getStringList("ghcm.responses");

        Set<String> responsesSet = new HashSet<>();
        responsesSet.addAll(responses);

        msbContext.getObjectFactory().createResponderServer(namespace, ResponderOptions.DEFAULTS, (request, responderContext) -> {

            if ("40867".equals(request.getBody().getCodeValue()) && "1".equals(request.getBody().getSourceCodeTypeID())) {
                responderContext
                        .getResponder()
                        .send(new ChcResponsePayload(new ChcResponseBody(responsesSet)));
            } else {
                responderContext
                        .getResponder()
                        .sendAck(0, 0);
            }
        }, ChcRequestPayload.class).listen();
    }

}
