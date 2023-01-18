package ru.yuEliseev.Gifer.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.yuEliseev.Gifer.Config.GifClientConfig;

@FeignClient(name = "gif-client", url = "${client.gifUrl}")
public interface GifClient {

    @GetMapping(value = "/random")
    String GetGifJSON (@RequestParam("api_key") String api_key,
                       @RequestParam("tag") String tag);
}
