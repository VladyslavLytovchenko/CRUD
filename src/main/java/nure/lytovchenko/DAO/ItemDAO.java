package nure.lytovchenko.DAO;

import nure.lytovchenko.Models.Item;

import java.util.List;


public interface ItemDAO {

    Item getItemBy(int id);

    void add(Item item);

    List<Item> getAll();

    List<Item> getItemsByCategory(int id);

    void update(Item item);

    void delete(int id);


}
