package kodlama.io.rentACar.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
    private int id; // Update yaparken id gerekiyor. Create yaparken gerekmez.
    private String name;
}
