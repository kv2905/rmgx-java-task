package in.rmgx.asset_management.controller;

import in.rmgx.asset_management.models.Asset;
import in.rmgx.asset_management.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetRestController {
    @Autowired
    AssetService assetService;

    @GetMapping("/")
    public List<Asset> getAssets() {
        return assetService.getAssets();
    }

    @GetMapping("/{assetId}")
    public Asset getAssetById(@PathVariable(name = "assetId")Long assetId) {
        return assetService.getAssetById(assetId);
    }

    @GetMapping("/search")
    public Asset getAssetByName(@RequestParam String name) {
        return assetService.getAssetByName(name);
    }

    @PostMapping("/add")
    public void addAsset(@RequestBody Asset asset) {
        assetService.addAsset(asset);
    }

    @PutMapping("/update")
    public void addOrUpdate(@RequestBody Asset asset) {
        assetService.addAsset(asset);
    }

    @PutMapping("/assign/{assetId}")
    public ResponseEntity<String> updateAssignmentStatus(@PathVariable(name = "assetId")Long asssetId, @RequestParam String assignmentStatus) {
        //check if asset is assigned or not
        if(assetService.updateAssignmentStatus(asssetId, assignmentStatus)){
            return ResponseEntity.ok().body("Updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid Operation");
        }
    }

    @DeleteMapping("/delete/{assetId}")
    public ResponseEntity<String> deleteAsset(@PathVariable(name = "assetId")Long assetId) {
        if (assetService.deleteAsset(assetId)) {
            return ResponseEntity.ok().body("Deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Can't be Deleted! The asset is assigned!");
        }
    }
}
