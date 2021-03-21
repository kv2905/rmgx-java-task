package in.rmgx.asset_management.service;

import in.rmgx.asset_management.models.Asset;

import java.util.List;

public interface AssetService {
    List<Asset> getAssets();
    Asset getAssetById(Long assetId);
    Asset getAssetByName(String name);
    void addAsset(Asset asset);
    boolean deleteAsset(Long assetId);
    boolean updateAssignmentStatus(Long assetId, String assignmentStatus);
}
