package hu.syngu00.monitoringdemo.controllers;

import hu.syngu00.monitoringdemo.exception.NotFoundException;
import hu.syngu00.monitoringdemo.models.dtos.ItemDto;
import hu.syngu00.monitoringdemo.models.dtos.PageDto;
import hu.syngu00.monitoringdemo.services.ItemCommandService;
import hu.syngu00.monitoringdemo.services.ItemQueryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "resource/item")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ItemCRUDController {

    private final ItemQueryService queryService;
    private final ItemCommandService commandService;

    @GetMapping("/{id}")
    public ItemDto getOne(@PathVariable(name = "id") Long id) {
        return queryService.getByID(id);
    }

    @GetMapping
    public List<ItemDto> getAll() {
        return queryService.findAll();
    }

    @PostMapping
    public ItemDto save(@RequestBody ItemDto itemToSave) {
        return commandService.persist(itemToSave);
    }

    @PutMapping("/{id}")
    public ItemDto update(@PathVariable(name = "id") Long id, @RequestBody ItemDto itemToUpdate) {
        if (!queryService.exist(id)) {
            throw new NotFoundException(id);
        }
        return commandService.persist(itemToUpdate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        commandService.delete(id);
    }

    @GetMapping("/page")
    public PageDto<ItemDto> page(@RequestParam int page, @RequestParam int size) {
        return queryService.page(page, size);
    }

}
