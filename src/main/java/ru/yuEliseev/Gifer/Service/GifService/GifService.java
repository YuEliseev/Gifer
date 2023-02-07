package ru.yuEliseev.Gifer.Service.GifService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yuEliseev.Gifer.Client.GifClient;
import ru.yuEliseev.Gifer.Config.GifClientConfig;
import ru.yuEliseev.Gifer.Config.GifRequestConfig;
import ru.yuEliseev.Gifer.Model.Gif;

import java.util.ArrayList;
import java.util.List;

@Service
public class GifService {

    @Autowired
    private GifClientConfig gifClientConfig;
    @Autowired
    private GifRequestConfig gifRequestConfig;
    @Autowired
    private GifClient gifClient;

    public Gif getRandom(String tag){
        JSONObject jsonResponse = new JSONObject(gifClient.getRandomGif(gifClientConfig.getApiKey(), tag));

        return new Gif(jsonResponse.getJSONObject("data"));
    }


    public List<Gif> getSearchingResults(String search){
        JSONObject jsonResponse = new JSONObject(gifClient.getGifBySearch(gifClientConfig.getApiKey(),
                search,
                gifRequestConfig.getRows()));

        System.out.println(gifRequestConfig.getRows());

        List<Gif> gifList = new ArrayList<>();

        JSONArray jsonArray = jsonResponse.getJSONArray("data");

        for (int i = 0; i < jsonArray.length(); i++) {
            gifList.add(new Gif(jsonArray.getJSONObject(i)));
        }

        return gifList;

    }

    public Gif getById(String id){

        JSONObject jsonResponse = new JSONObject(gifClient.getGifById(gifClientConfig.getApiKey(), id));
        return new Gif((JSONObject) jsonResponse.getJSONArray("data").get(0));
    }
    //need to refactor this
}

