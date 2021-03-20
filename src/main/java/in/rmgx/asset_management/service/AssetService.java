package in.rmgx.asset_management.service;

import in.rmgx.asset_management.models.Asset;

import java.util.List;

public interface AssetService {
    public List<Asset> getAssets();
    public Asset getAssetById(Long aid);
    public void addAsset(Asset asset);
}
