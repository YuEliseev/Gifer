package ru.yuEliseev.Gifer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gif {

    private String id;
    private String title;
    private String originalUrl;
    private String previewUrl;

    public Gif(JSONObject jsonObject) {
        this.id = jsonObject.getString("id");
        this.title = jsonObject.getString("title");
        this.originalUrl = getUrl(jsonObject, "original");
        this.previewUrl = getUrl(jsonObject, "preview_gif");
    }

    private String getUrl(JSONObject jsonObject, String key){
        return jsonObject.getJSONObject("images")
                .getJSONObject(key)
                .getString("url");
    }
}
