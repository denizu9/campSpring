package kodlama.io.rentACar.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {
    private int id;
    private String name;
    private String brandName; // id getirmek istemiyorum sadece marka ismi gelsin istiyorum. O yüzden id vermedim, istesersem onu da verebilirim.


}
