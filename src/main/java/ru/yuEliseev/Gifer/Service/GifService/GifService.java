package ru.yuEliseev.Gifer.Service.GifService;

import org.json.JSONArray;
import org.json.JSONException;
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

        try {
            return new Gif(getJsonObjectData(jsonResponse));
        }
        catch (JSONException jsonException){
            jsonException.printStackTrace();
            return gifClientConfig.getErrorGif();
        }

    }

    public List<Gif> getSearchingResults(String search) throws JSONException{
        JSONObject jsonResponse = new JSONObject(gifClient.getGifBySearch(gifClientConfig.getApiKey(),
                search,
                gifRequestConfig.getRows()));

        List<Gif> gifList = new ArrayList<>();

        JSONArray jsonArray = getJsonArrayData(jsonResponse);

        for (int i = 0; i < jsonArray.length(); i++) {
            gifList.add(new Gif(jsonArray.getJSONObject(i)));

        }

        return gifList;
    }

    public Gif getById(String id){

        JSONObject jsonResponse = new JSONObject(gifClient.getGifById(gifClientConfig.getApiKey(), id));
        try{
            return new Gif((JSONObject) getJsonArrayData(jsonResponse).get(0));
        }catch (JSONException jsonException){
            return gifClientConfig.getErrorGif();
        }
    }
    //get some issue with GifyAPI to get single gif by id

    private JSONArray getJsonArrayData(JSONObject jsonObject){
        return jsonObject.getJSONArray("datas");
    }
    private JSONObject getJsonObjectData(JSONObject jsonObject){
        return jsonObject.getJSONObject("datas");
    }
}

