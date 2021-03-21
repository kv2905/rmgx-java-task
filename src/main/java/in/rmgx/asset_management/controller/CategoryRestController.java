package in.rmgx.asset_management.controller;

import in.rmgx.asset_management.models.Category;
import in.rmgx.asset_management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{cid}")
    public Category getCategoryById(@PathVariable(name = "cid")Long cid) {
        return categoryService.getCategoryById(cid);
    }

    @PostMapping("/add")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/update")
    public void addOrUpdateCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }
}
