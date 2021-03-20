package in.rmgx.asset_management.service;

import in.rmgx.asset_management.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(Long cid);
    void addCategory(Category category);
}
