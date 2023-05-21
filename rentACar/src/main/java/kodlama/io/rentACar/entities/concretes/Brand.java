package kodlama.io.rentACar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "brands")
@Data // Getter - Setter ve parametresiz constructor oluşturur.
@AllArgsConstructor // Bütün parametleri barındıran constructor oluşturur.
@NoArgsConstructor
@Entity // Sen bir veri tabanı varlığısın ve tablo olarak buraya karşılık geliyorsun diye belirtir.
public class Brand {

    @Id  // Veri tabanında primary key alanı olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generated value id'nin otomatik arttırma anlamına gelir.
    @Column(name = "id") // Vermesekte olur
    private int id;

    @Column(name = "name")
    private String name;

    //Bulunduğumuz nesne ilk yazılır, yani biz Brand classındayız. Bir brand var çok model var. One to Many
    @OneToMany(mappedBy = "brand") // Marka -> modeller (mappedby) dediğimiz, hangi alan ile ilişkilendirecek demektir.
    List<Model> models; // Bir arabanın modelleri vardır. One to Many

}
