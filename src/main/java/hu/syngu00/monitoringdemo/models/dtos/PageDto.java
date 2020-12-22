package hu.syngu00.monitoringdemo.models.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PageDto<T> {
    private Long totalElements;
    private Integer actualElements;
    private Integer totalPage;
    private Integer actualPage;
    private List<T> items;
}
