package in.rmgx.asset_management.repository;

import in.rmgx.asset_management.models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "assets", path = "assets")
public interface AssetRepository extends JpaRepository<Asset, Long> {
    Asset findByAssetName(@Param("assetName") String name);
}
