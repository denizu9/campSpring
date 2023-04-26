package kodlama.io.rentACar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;


@Service // IOC'ye eklemesi için.
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{

    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true) // Belirsizlik olduğu durumlarda ignore et.
                .setMatchingStrategy(MatchingStrategies.LOOSE); // id, name vs.. Atıyorum bunlardan 2 sini, 1 ini maple
                                                                // bu gevşek yani LOOSE oluyor. Response olduğu için.
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD); // Burada ise request olduğu için id, name vs.. hepsini
                                                                    // maple.
        return this.modelMapper;
    }
}
