package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.dtos.requests.CreateBrandRequest;
import kodlama.io.rentACar.dtos.requests.UpdateBrandRequest;
import kodlama.io.rentACar.dtos.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dtos.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {

    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
