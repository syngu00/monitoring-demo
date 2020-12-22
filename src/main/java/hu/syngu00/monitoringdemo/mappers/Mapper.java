package hu.syngu00.monitoringdemo.mappers;

public interface Mapper<E, D> {

    E toEntity(D from);

    D toDto(E from);
}
