package in.rmgx.asset_management.service.impl;

import in.rmgx.asset_management.models.Asset;
import in.rmgx.asset_management.models.AssignmentStatus;
import in.rmgx.asset_management.repository.AssetRepository;
import in.rmgx.asset_management.service.AssetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public List<Asset> getAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Asset getAssetById(Long assetId) {
        Optional<Asset> asset = assetRepository.findById(assetId);
        return asset.get();
    }

    @Override
    public void addAsset(Asset asset) {
        assetRepository.save(asset);
    }

    @Override
    public boolean deleteAsset(Long aid) {
        Asset asset = getAssetById(aid);
        if(asset.getAssignmentStatus() == AssignmentStatus.ASSIGNED) {
            log.error("Asset can not be deleted as it is assigned");
            return false;
        }
        assetRepository.delete(asset);
        return true;
    }

    @Override
    public Asset getAssetByName(String name) {
        return assetRepository.findByAssetName(name);
    }

    @Override
    public boolean updateAssignmentStatus(Long assetId, String assignmentStatus) {
        Asset asset = getAssetById(assetId);

        if(!assignmentStatus.equals(AssignmentStatus.ASSIGNED.toString())
                && !assignmentStatus.equals(AssignmentStatus.RECOVERED.toString())) {
            log.error("Asset could not be updated as the parameter passed is invalid");
            return  false;
        }
        if(assignmentStatus.equals(AssignmentStatus.ASSIGNED.toString()) && asset.getAssignmentStatus() == AssignmentStatus.ASSIGNED) {
            return false;
        }
        if (assignmentStatus.equals(AssignmentStatus.ASSIGNED.toString())) {
            asset.setAssignmentStatus(AssignmentStatus.ASSIGNED);
        } else {
            asset.setAssignmentStatus(AssignmentStatus.RECOVERED);
        }
        addAsset(asset);
        return true;
    }
}
