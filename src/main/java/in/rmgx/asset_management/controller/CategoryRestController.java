package in.rmgx.asset_management.controller;

import in.rmgx.asset_management.models.Category;
import in.rmgx.asset_management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * This controller handles all the endpoints for Category. Base request mapping for CategoryController is /categories
 *
 * author : Keshav
 * Date : March 20, 2021
 */
@RestController
@RequestMapping("/categories")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    /***
     * This is GET methods to fetch all the categories.
     * @return - List of Categories
     */
    @GetMapping("/")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    /***
     * This is GET method to fetch category by id.
     * @param cid - id of the category to be fetched
     * @return - Category
     */
    @GetMapping("/{cid}")
    public Category getCategoryById(@PathVariable(name = "cid")Long cid) {
        return categoryService.getCategoryById(cid);
    }

    /***
     * This is POST method to add a new category
     * @param category - category to added
     */
    @PostMapping("/add")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    /***
     * This is a PUT method to update an existing category.
     * @param category - category to be updated
     */
    @PutMapping("/update")
    public void addOrUpdateCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }
}
