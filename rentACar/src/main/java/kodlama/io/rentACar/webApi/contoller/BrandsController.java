package kodlama.io.rentACar.webApi.contoller;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.dtos.requests.CreateBrandRequest;
import kodlama.io.rentACar.dtos.requests.UpdateBrandRequest;
import kodlama.io.rentACar.dtos.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dtos.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

    private BrandService brandService;


    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")//@PathVariable yani yukarıdaki Requestmapping kısmında /api/brands/1 yazdık diyelim, id'si 1 olan gelecek
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED) // post'lar 201 döndürsün diye bu işlemi yaptık. 201 kodu bir Http standardı.
    public void add(CreateBrandRequest createBrandRequest){ // 201 bir veri oluştuğunu anlatır. 200 işlem başarılı oldu demektir.
        this.brandService.add(createBrandRequest);
    }

    @PutMapping // Güncelleme için kullanılır.
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);

        // @RequestBody yapılan requestin body'sinden okunacak diyoruz.
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
