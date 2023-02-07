package ru.yuEliseev.Gifer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yuEliseev.Gifer.Service.GifService.GifService;

@Controller
@RequestMapping("/gif")
public class GifController {

    @Autowired
    private GifService gifService;

    @GetMapping("/random/{tag}")
    public String random(@PathVariable("tag") String tag, Model model){
        model.addAttribute("gif", gifService.getRandom(tag));

        return "view";
    }
    @GetMapping("/search/{search}")
    public String search(@PathVariable("search") String search,
                         Model model){
        model.addAttribute("gifList", gifService.getSearchingResults(search));

        return "list";
    }
    @GetMapping("/get/{id}")
    public String getByID(@PathVariable("id") String id, Model model){
        model.addAttribute("gif", gifService.getById(id));

        return "view";
    }


}
