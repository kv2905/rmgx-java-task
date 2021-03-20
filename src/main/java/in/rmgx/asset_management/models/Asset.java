package in.rmgx.asset_management.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;
    private String assetName;

    @Temporal(TemporalType.DATE)
    private Date purchasedDate;

    private String conditionNotes;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus assignmentStatus;

    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Asset(String assetName, Date purchasedDate, String conditionNotes, AssignmentStatus assignmentStatus) {
        this.assetName = assetName;
        this.purchasedDate = purchasedDate;
        this.assignmentStatus = assignmentStatus;
        this.conditionNotes = conditionNotes;
    }
}
