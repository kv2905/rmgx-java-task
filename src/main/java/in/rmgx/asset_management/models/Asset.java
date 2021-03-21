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
    private Long assetId;
    private String assetName;

    @Temporal(TemporalType.DATE)
    private Date purchasedDate;

    private String conditionNotes;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus assignmentStatus = AssignmentStatus.AVAILABLE;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
