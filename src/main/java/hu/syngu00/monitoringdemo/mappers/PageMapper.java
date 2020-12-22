package hu.syngu00.monitoringdemo.mappers;


import hu.syngu00.monitoringdemo.exception.SpanishInquisitionException;
import hu.syngu00.monitoringdemo.models.dtos.PageDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PageMapper<E, D> implements Mapper<Page<E>, PageDto<D>> {

    private final Mapper<E, D> mapper;

    public static <E, D> PageDto<D> toDto(Mapper<E, D> mapper, Page<E> page) {
        return new PageMapper<>(mapper).toDto(page);
    }

    @Override
    public Page<E> toEntity(PageDto<D> from) {
        throw new SpanishInquisitionException("We should not receive page as an input");
    }

    @Override
    public PageDto<D> toDto(Page<E> from) {
        if (from == null) {
            return null;
        }

        PageDto<D> to = new PageDto<>();

        to.setTotalElements(from.getTotalElements());
        to.setActualElements(from.getSize());
        to.setTotalPage(from.getTotalPages());
        to.setActualPage(from.getNumber());
        to.setItems(from.stream().map(mapper::toDto).collect(Collectors.toList()));

        return to;
    }
}
