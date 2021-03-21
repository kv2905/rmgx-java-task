package in.rmgx.asset_management.service.impl;

import in.rmgx.asset_management.models.Category;
import in.rmgx.asset_management.repository.CategoryRepository;
import in.rmgx.asset_management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /***
     * This method is called by the CategoryController. It fetches all the categories from the Repository.
     *
     * @return -  List of Category
     */
    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    /***
     * This method is called by the CategoryController. It fetches a particular categories from the Repository.
     * by ID
     * @param cid - id of the category of be fetched
     * @return Category
     */
    @Override
    public Category getCategoryById(Long cid) {
        Optional<Category> category = categoryRepository.findById(cid);
        return category.get();
    }

    /***
     * This method is called by the CategoryController. It adds a new category to the Repository.
     * @param category - category to be added
     */
    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
}
