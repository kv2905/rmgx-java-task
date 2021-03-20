package in.rmgx.asset_management.service;

import in.rmgx.asset_management.models.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategories();
    public Category getCategoryById(Long cid);
    public void addCategory(Category category);
}
