package hu.syngu00.monitoringdemo.models.entities.listeners;

import hu.syngu00.monitoringdemo.models.entities.CommonRevisionEntity;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.envers.RevisionListener;

@Slf4j
public class CommonRevisionEntityListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        if (log.isDebugEnabled()) {
            log.debug("new revision, {}", revisionEntity);
        }
        CommonRevisionEntity exampleRevEntity = (CommonRevisionEntity) revisionEntity;
        exampleRevEntity.setTriggeredBy("UNKNOWN");
    }
}
