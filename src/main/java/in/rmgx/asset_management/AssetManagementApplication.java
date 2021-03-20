package in.rmgx.asset_management;

import in.rmgx.asset_management.models.Asset;
import in.rmgx.asset_management.models.AssignmentStatus;
import in.rmgx.asset_management.models.Category;
import in.rmgx.asset_management.repository.AssetRepository;
import in.rmgx.asset_management.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class AssetManagementApplication implements CommandLineRunner {

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(AssetManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Clean up database tables
        assetRepository.deleteAllInBatch();;
        categoryRepository.deleteAllInBatch();

        Category category = new Category("electronics", "All Electronic Gadget");
        Calendar date = Calendar.getInstance();
        date.set(2020, 7, 21);
        Asset asset = new Asset("laptop", date.getTime(), "Working Fine", AssignmentStatus.Available);

        category.setAsset(asset);
        asset.setCategory(category);

        categoryRepository.save(category);
    }
}
