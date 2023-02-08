package ru.yuEliseev.Gifer.Config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "client")
public class GifClientConfig {
    private String gifUrl;
    private String apiKey;
    private String errorGif;
}