package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
    // Burada Brand'in primary key'si id olarak verileceği için id'nin türü de int olduğu için Integer olarak veriyoruz.

    // Jpa bir standarttır. Hibernate implementasyonudur.

}
