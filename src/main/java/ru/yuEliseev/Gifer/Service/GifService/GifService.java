package ru.yuEliseev.Gifer.Service.GifService;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yuEliseev.Gifer.Client.GifClient;
import ru.yuEliseev.Gifer.Config.GifClientConfig;

@Service
public class GifService {

    @Autowired
    private GifClientConfig gifClientConfig;
    @Autowired
    private GifClient gifClient;

    public String GetPreview(String tag){

        String jsonString = gifClient.GetGifJSON(gifClientConfig.getApiKey(), tag);

        JSONObject jsonObject = new JSONObject(jsonString);

        return jsonObject.getJSONObject("data")
                .getJSONObject("images")
                .getJSONObject("original")
                .get("url")
                .toString();
    }

}
