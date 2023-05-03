package ru.yuEliseev.Gifer.Config;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import ru.yuEliseev.Gifer.Client.RetreiveMessageErrorDecoder;

public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder(){
        return new RetreiveMessageErrorDecoder();
    }
}
