package nure.lytovchenko.Services;

import nure.lytovchenko.DAO.ItemDAO;
import nure.lytovchenko.Models.Item;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDAO itemDAO;

    public Item getItemBy(int id) {
        return itemDAO.getItemBy(id);
    }

    public void add(Item item){
        itemDAO.add(item);
    }

    public List<Item> getAllByCategory(int categoryId){
        return itemDAO.getItemsByCategory(categoryId);
    }

    @Override
    public List<Item> getAll() {
        return itemDAO.getAll();
    }

    @Override
    public void update(Item item) {
        itemDAO.update(item);
    }

    @Override
    public void delete(int id) {
        itemDAO.delete(id);
    }
}
