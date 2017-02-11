/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.cripto.formatter;

import com.novatronic.cripto.model.Request;
import com.novatronic.cripto.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ricardo
 */
public class ByteFormatter implements CriptoFormatter<Object, Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ByteFormatter.class);
    private final ByteToObject bytesToRequest;
    private final ObjectToByte responseToBytes;

    public ByteFormatter() {
        bytesToRequest = new ByteToObject();
        responseToBytes = new ObjectToByte();
    }

    @Override
    public Object format(Object data) {
        if (data instanceof Response) {
            return responseToByte((Response) data);
        } else {
            return byteToRequest((byte[]) data);
        }
    }

    private Request byteToRequest(byte[] bytes) {
        return bytesToRequest.format(bytes);
    }

    private byte[] responseToByte(Response response) {
        return responseToBytes.format(response);
    }

}
