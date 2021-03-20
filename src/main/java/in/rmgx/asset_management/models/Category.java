package in.rmgx.asset_management.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    private String categoryName;
    private String description;
    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "category")
    private Asset asset;

    public Category(String name, String description) {
        this.categoryName = name;
        this.description = description;
    }
}
