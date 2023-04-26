package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.dtos.requests.CreateBrandRequest;
import kodlama.io.rentACar.dtos.requests.UpdateBrandRequest;
import kodlama.io.rentACar.dtos.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.dtos.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service // Bu sınıf bir Business nesnesidir diyoruz.
@AllArgsConstructor // Burada BrandRepository için yaptığımız injection'ı yaptık. AllArgsConstructor ile.
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll(); // Veri tabanındaki tüm brand'ler geliyor.

        List<GetAllBrandsResponse> brandsResponse =
                brands.stream().map(brand -> this.modelMapperService.forResponse()
                                .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {

        Brand brand = this.brandRepository.findById(id).orElseThrow(); // Brand bulamazsan hata fırlat diyoruz.

        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);

        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
