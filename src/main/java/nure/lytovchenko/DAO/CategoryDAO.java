package nure.lytovchenko.DAO;

import nure.lytovchenko.Models.Category;
import nure.lytovchenko.Models.Item;

import java.util.List;

public interface CategoryDAO {
    Category getById(int id);
    List<Category> getAll();
    void add(Category category);
    void update(Category category);
}
