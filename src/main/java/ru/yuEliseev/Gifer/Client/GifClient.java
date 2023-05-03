package ru.yuEliseev.Gifer.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.yuEliseev.Gifer.Config.FeignConfig;

@FeignClient(name = "gif-client", url = "${client.gifUrl}",
        configuration = FeignConfig.class)
public interface GifClient {

    @GetMapping(value = "/random")
    String getRandomGif(@RequestParam("api_key") String api_key,
                            @RequestParam("tag") String tag);

    @GetMapping(value = "/search")
    String getGifBySearch(@RequestParam("api_key") String api_key,
                          @RequestParam("q") String search,
                          @RequestParam("limit") int rows);

    @GetMapping("")
    String getGifById(@RequestParam("api_key") String api_key,
                      @RequestParam("ids") String gifId);


}
