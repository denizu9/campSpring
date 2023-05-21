package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.dtos.requests.CreateBrandRequest;
import kodlama.io.rentACar.dtos.responses.GetAllModelsResponse;
import kodlama.io.rentACar.entities.concretes.Model;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;

    private ModelMapperService modelMapperService;

    public ModelManager(ModelRepository modelRepository, ModelMapperService modelMapperService) {
        this.modelRepository = modelRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllModelsResponse> getAll() {

        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponse = models.stream().map(model -> this.modelMapperService.forResponse()
                .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Model model = this.modelMapperService.forRequest().map(createBrandRequest, Model.class);

        this.modelRepository.save(model);
    }
}
