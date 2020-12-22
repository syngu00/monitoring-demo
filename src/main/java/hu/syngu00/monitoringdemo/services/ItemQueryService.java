package hu.syngu00.monitoringdemo.services;

import hu.syngu00.monitoringdemo.exception.NotFoundException;
import hu.syngu00.monitoringdemo.mappers.ItemMapper;
import hu.syngu00.monitoringdemo.models.dtos.ItemDto;
import hu.syngu00.monitoringdemo.models.dtos.PageDto;
import hu.syngu00.monitoringdemo.models.entities.Item;
import hu.syngu00.monitoringdemo.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static hu.syngu00.monitoringdemo.mappers.PageMapper.toDto;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ItemQueryService {

    private final ItemRepository repository;
    private final ItemMapper mapper;

    public Optional<ItemDto> findByID(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    public ItemDto getByID(Long id) {
        return findByID(id).orElseThrow(() -> new NotFoundException(id));
    }

    public boolean exist(Long id) {
        return repository.existsById(id);
    }

    public List<ItemDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public PageDto<ItemDto> page(int page, int size) {
        Page<Item> result = repository.findAll(PageRequest.of(page, size, Sort.by(Sort.Order.asc("name"))));
        return toDto(mapper, result);
    }
}
