package ru.yuEliseev.Gifer.Controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yuEliseev.Gifer.Config.GifClientConfig;
import ru.yuEliseev.Gifer.Service.GifService.GifService;

@Controller
@RequestMapping("/gif")
public class GifController {

    @Autowired
    private GifService gifService;
    @Autowired
    private GifClientConfig gifClientConfig;

    @GetMapping("/random/{tag}")
    public String random(@PathVariable("tag") String tag, Model model){
        model.addAttribute("gif", gifService.getRandom(tag));

        return "view";
    }
    @GetMapping("/search/{search}")
    public String search(@PathVariable("search") String search,
                         Model model){

        try{
            model.addAttribute("gifList", gifService.getSearchingResults(search));
            return "list";
        }catch (JSONException jsonException){
            jsonException.printStackTrace();
            model.addAttribute("gif", gifClientConfig.getErrorGif());
            return "view";
        }

    }
    @GetMapping("/get/{id}")
    public String getByID(@PathVariable("id") String id, Model model){
        model.addAttribute("gif", gifService.getById(id));

        return "view";
    }


}
