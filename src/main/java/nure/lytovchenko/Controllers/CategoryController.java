package nure.lytovchenko.Controllers;

import nure.lytovchenko.DAO.CategoryDAO;
import nure.lytovchenko.Models.Category;
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
        if (category.getId()==0){
            categoryDAO.add(category);
        }else{
            categoryDAO.update(category);
        }
        return "redirect:/categories";
    }

    @GetMapping("/{id}/edit")
    public String CategoryDelete(@PathVariable int id, Model model){
        model.addAttribute("category",categoryDAO.getById(id));
        return "CategoryEdit";
    }

    @GetMapping("/{id}/delete")
    public String CategoryEdit(@PathVariable int id, Model model){
        categoryDAO.delete(id);
        return "redirect:/categories";
    }
}
