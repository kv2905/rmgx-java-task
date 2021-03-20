package in.rmgx.asset_management.repository;

import in.rmgx.asset_management.models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
}
