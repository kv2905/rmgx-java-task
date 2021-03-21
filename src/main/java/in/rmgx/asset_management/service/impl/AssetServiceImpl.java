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

    /***
     * This method is called by the AssetController. It fetches all the assets from the Repository.
     *
     * @return -  List of Assets
     */
    @Override
    public List<Asset> getAssets() {
        return assetRepository.findAll();
    }

    /***
     * This method is called by the AssetController. It fetches a asset from the Repository
     * with a particular ID
     *
     * @return -  Asset
     */
    @Override
    public Asset getAssetById(Long assetId) {
        Optional<Asset> asset = assetRepository.findById(assetId);
        return asset.get();
    }

    /***
     * This method is called by the AssetController. It adds a new asset to the Repository.
     * @param asset - asset to be added
     */
    @Override
    public void addAsset(Asset asset) {
        assetRepository.save(asset);
    }

    /***
     * This method is invoked by the AssetController and deletes a particular asset. Asset Id is passed by the caller
     * as a parameter
     *
     * Checks - If the assignment status of an asset is ASSIGNED, then asset cannot be deleted and and error message is
     * thrown.
     * @param aid - id of asset to be deleted
     * @return boolean if the asset is deleted or not
     */
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

    /***
     * This method is called by the AssetController. It fetches a asset from the Repository
     * with a particular name
     *
     * @param name - name of the asset to be fetched
     * @return Asset
     */
    @Override
    public Asset getAssetByName(String name) {
        return assetRepository.findByAssetName(name);
    }

    /***
     * This method is invoked by the AssetController and updates a particular asset. Asset Id is passed by the caller
     * as a parameter along with the new assignment status
     * Checks - If the assignment status passed by caller is invalid asset can't be updated
     * Checks - If the asset is already assigned and we pass new assignment status also ASSIGNED
     * then also asset can;t be updated
     *
     * @param assetId id of the asset to be update
     * @param assignmentStatus new assignment status
     * @return boolean if the asset is updated
     */
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
