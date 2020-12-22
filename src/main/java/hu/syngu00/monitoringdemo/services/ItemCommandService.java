package hu.syngu00.monitoringdemo.services;

import hu.syngu00.monitoringdemo.exception.NotFoundException;
import hu.syngu00.monitoringdemo.mappers.ItemMapper;
import hu.syngu00.monitoringdemo.models.dtos.ItemDto;
import hu.syngu00.monitoringdemo.repositories.ItemRepository;
import hu.syngu00.monitoringdemo.validators.ItemValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ItemCommandService {

    private final ItemRepository repository;
    private final ItemMapper mapper;
    private final ItemValidation validation;

    public ItemDto persist(ItemDto item) {
        validation.eagerValidate(item);
        return mapper.toDto(repository.save(mapper.toEntity(item)));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(id);
        }
        repository.deleteById(id);
    }

}
