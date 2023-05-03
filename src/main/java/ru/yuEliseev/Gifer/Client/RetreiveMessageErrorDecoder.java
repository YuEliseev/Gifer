package ru.yuEliseev.Gifer.Client;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import ru.yuEliseev.Gifer.Exception.ExceptionMessage;
import ru.yuEliseev.Gifer.Exception.BadRequestException;
import ru.yuEliseev.Gifer.Exception.NotFoundException;
import ru.yuEliseev.Gifer.Exception.ServiceNotAvailableException;

import java.io.IOException;
import java.io.InputStream;


public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message = null;
        try (InputStream bodyIs = response.body().asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, ExceptionMessage.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        switch (response.status()) {
            case 400:
                return new BadRequestException(message.getMsg() != null
                        ? message.getMsg() : "Bad Request");
            case 404:
                return new NotFoundException(message.getMsg() != null
                        ? message.getMsg() : "Not found");
            case 503:
                return new ServiceNotAvailableException(message.getMsg() != null
                        ? message.getMsg() : "Api service is unavailable");
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }
}