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

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category getCategoryById(Long cid) {
        Optional<Category> c = categoryRepository.findById(cid);
        return c.get();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
}
