package nure.lytovchenko.Controllers;

import nure.lytovchenko.DAO.CategoryDAO;
import nure.lytovchenko.Models.Category;
import nure.lytovchenko.Models.Item;
import nure.lytovchenko.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    ItemService itemService;
    @Autowired
    CategoryDAO categoryDAO;
    @GetMapping()
    public String Categories(Model model){
        model.addAttribute("categories",categoryDAO.getAll());
        return "Categories";
    }

    @GetMapping(value = "/addCategory")
    public String addCategoryForm(Model model){
        model.addAttribute("category",new Category());
        return "addCategory";
    }

    @PostMapping(value = "/add")
    public String addCategory(@ModelAttribute("category")Category category){
        System.out.println(category.getName());
        categoryDAO.add(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String ItemDisplay(@PathVariable int id, Model model){
        model.addAttribute("item",categoryDAO.getById(id));
        return "ItemCard";
    }
}
