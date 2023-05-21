package kodlama.io.rentACar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name =  "models")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne // Modeller -> marka
    @JoinColumn(name = "brand_id") // Burada Brand'deki maplediğimiz brand ile brand_id arasından postgre fiziksel bir bağ kuracak.
    private Brand brand; // Ancak bir modelin sadece bir tane markası olabilir. One to one

    @OneToMany(mappedBy = "model")
    private List<Car> cars;
}
