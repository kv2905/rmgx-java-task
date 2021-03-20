package in.rmgx.asset_management.service;

import in.rmgx.asset_management.models.Asset;

import java.util.List;

public interface AssetService {
    List<Asset> getAssets();
    Asset getAssetById(Long aid);
    void addAsset(Asset asset);
    String deleteAsset(Long aid);
    Asset getAssetByName(String name);
}
