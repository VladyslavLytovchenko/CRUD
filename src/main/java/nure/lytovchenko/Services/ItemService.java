package nure.lytovchenko.Services;

import nure.lytovchenko.Models.Item;

import java.util.List;

public interface ItemService {
    Item getItemBy(int id);

    void add(Item item);

    List<Item> getAllByCategory(int categoryId);

    List<Item> getAll();

    void update(Item item);

    void delete(int id);
}
