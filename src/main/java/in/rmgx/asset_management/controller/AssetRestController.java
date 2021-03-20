package in.rmgx.asset_management.controller;

import in.rmgx.asset_management.models.Asset;
import in.rmgx.asset_management.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetRestController {
    @Autowired
    AssetService assetService;

    public void setAssetService(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping("/assets")
    public List<Asset> getAssets() {
        return assetService.getAssets();
    }

    @GetMapping("/assets/{aid}")
    public Asset getAssetById(@PathVariable(name = "aid")Long aid) {
        return assetService.getAssetById(aid);
    }

    @PostMapping("/assets")
    public void addAsset(@RequestBody Asset asset) {
        assetService.addAsset(asset);
    }

    @PutMapping("/assets")
    public void addOrUpdate(@RequestBody Asset asset) {
        assetService.addAsset(asset);
    }
}
