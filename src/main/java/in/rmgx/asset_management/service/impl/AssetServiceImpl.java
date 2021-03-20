package in.rmgx.asset_management.service.impl;

import in.rmgx.asset_management.models.Asset;
import in.rmgx.asset_management.models.AssignmentStatus;
import in.rmgx.asset_management.repository.AssetRepository;
import in.rmgx.asset_management.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public void setAssetRepository(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public List<Asset> getAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Asset getAssetById(Long aid) {
        Optional<Asset> asset = assetRepository.findById(aid);
        return asset.get();
    }

    @Override
    public void addAsset(Asset asset) {
        assetRepository.save(asset);
    }

    @Override
    public String deleteAsset(Long aid) {
        Asset asset = getAssetById(aid);
        if(asset.getAssignmentStatus() == AssignmentStatus.ASSIGNED) {
            return "Can't delete! The asset is assigned";
        }
        assetRepository.delete(asset);
        return "Deleted";
    }
}
