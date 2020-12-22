package hu.syngu00.monitoringdemo.models;

public interface BasicPersistentEntity extends AbstractPersistentEntity<Long> {

    Long getId();

    void setId(Long id);

    @Override
    default Long getIdentifier() {
        return getId();
    }

    @Override
    default void setIdentifier(Long identifier) {
        setId(identifier);
    }
}
