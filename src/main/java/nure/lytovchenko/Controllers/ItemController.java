package nure.lytovchenko.Controllers;

import nure.lytovchenko.DAO.CategoryDAO;
import nure.lytovchenko.DAO.UserDAO;
import nure.lytovchenko.Models.Item;
import nure.lytovchenko.Models.Role;
import nure.lytovchenko.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@Controller
@RequestMapping(value = "/items")
public class ItemController {
    @Autowired
    ItemService itemService;
    @Autowired
    CategoryDAO categoryDAO;


    @GetMapping()
    public String listItems(Model model){
        model.addAttribute("items",itemService.getAll());
        model.addAttribute("categories",categoryDAO.getAll());
        return "Items";
    }

    @GetMapping("/category{id}")
    public String ItemsByCategory(@PathVariable int id, Model model){
        model.addAttribute("items",itemService.getAllByCategory(id));
        model.addAttribute("categories",categoryDAO.getAll());
        return "Items";
    }

    @GetMapping("/{id}/edit")
    public String ItemEdit(@PathVariable int id, Model model){
        model.addAttribute("item",itemService.getItemBy(id));
        model.addAttribute("categories",categoryDAO.getAll());
        return "ItemEdit";
    }

    @GetMapping("/{id}/delete")
    public String ItemDelete(@PathVariable int id, Model model){
        itemService.delete(id);
        return "redirect:/items";
    }

    @GetMapping(value = "/addItem")
    public String addItemForm(Model model){
        model.addAttribute("item",new Item());
        model.addAttribute("categories",categoryDAO.getAll());
        return "addItem";
    }

    @GetMapping("/{id}")
    public String ItemDisplay(@PathVariable int id, Model model){
        model.addAttribute("item",itemService.getItemBy(id));
        return "ItemCard";
    }

    @PostMapping(value = "/add")
    public String addItem(@ModelAttribute("item") Item item){
        if (item.getId()==0){
            itemService.add(item);
        }else{
            itemService.update(item);
        }
        return "redirect:/items";
    }
}
