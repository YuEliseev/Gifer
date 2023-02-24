package ru.yuEliseev.Gifer.Config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.yuEliseev.Gifer.Model.Gif;

@Configuration
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "client")
public class GifClientConfig {

    private String gifUrl;
    private String apiKey;
    private String errorGifId;
    private String errorGifOriginal;
    private String errorGifPreview;

    public Gif getErrorGif(){
        return new Gif(errorGifId, "Ooops", errorGifOriginal, errorGifPreview);
    }

}