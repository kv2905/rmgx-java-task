package in.rmgx.asset_management.controller;

import in.rmgx.asset_management.models.Category;
import in.rmgx.asset_management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/categories/{cid}")
    public Category getCategoryById(@PathVariable(name = "cid")Long cid) {
        return categoryService.getCategoryById(cid);
    }

    @PostMapping("/categories")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/categories")
    public void addOrUpdateCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }
}
