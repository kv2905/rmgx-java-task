package in.rmgx.asset_management.controller;

import in.rmgx.asset_management.models.Asset;
import in.rmgx.asset_management.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * This controller handles all the endpoints for Assets. Base request mapping for AssetController is /assets
 *
 * author : Keshav
 * Date : March 20, 2021
 */
@RestController
@RequestMapping("/assets")
public class AssetRestController {
    @Autowired
    AssetService assetService;

    /***
     * This rest endpoint is invoked on /assets/ and returns all the assets in the system irrespective of the
     * assignment status.
     *
     * @return - List of Assets
     */
    @GetMapping("/")
    public List<Asset> getAssets() {
        return assetService.getAssets();
    }

    /***
     * This GET method return a particular asset as per the asset Id passed by the caller.
     * @param assetId - Long value of asset id
     * @return - Asset
     */
    @GetMapping("/{assetId}")
    public Asset getAssetById(@PathVariable(name = "assetId")Long assetId) {
        return assetService.getAssetById(assetId);
    }

    /***
     * This GET method return a particular asset as per name passed by the caller.
     * @param name - name of asset to be searched
     * @return - Asset
     */
    @GetMapping("/search")
    public Asset getAssetByName(@RequestParam String name) {
        return assetService.getAssetByName(name);
    }

    /***
     * This POST method helps to add a new asset.
     * @param asset - the asset to be added
     */
    @PostMapping("/add")
    public void addAsset(@RequestBody Asset asset) {
        assetService.addAsset(asset);
    }

    /***
     * This PUT method helps to update an existing asset.
     * @param asset - the asset to be updated
     */
    @PutMapping("/update")
    public void addOrUpdate(@RequestBody Asset asset) {
        assetService.addAsset(asset);
    }

    /***
     * This PUT method helps to update to assignment status of an asset.
     * If the asset is already assigned it returns a bad request.
     * @param assetId - id of the asset to be updated
     * @param assignmentStatus - new assignment status
     * @return - ResponseEntity<String>
     */
    @PutMapping("/assign/{assetId}")
    public ResponseEntity<String> updateAssignmentStatus(@PathVariable(name = "assetId")Long assetId, @RequestParam String assignmentStatus) {
        //check if asset is assigned or not
        if(assetService.updateAssignmentStatus(assetId, assignmentStatus)){
            return ResponseEntity.ok().body("Updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid Operation");
        }
    }

    /***
     * This DELETE method helps to delete an asset.
     * If the asset can not be deleted it returns a bad request
     * @param assetId - id of the asset to be deletes
     * @return - ResponseEntity<String>
     */
    @DeleteMapping("/delete/{assetId}")
    public ResponseEntity<String> deleteAsset(@PathVariable(name = "assetId")Long assetId) {
        if (assetService.deleteAsset(assetId)) {
            return ResponseEntity.ok().body("Deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Can't be Deleted! The asset is assigned!");
        }
    }
}
