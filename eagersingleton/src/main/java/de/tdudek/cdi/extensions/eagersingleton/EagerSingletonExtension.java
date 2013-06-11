package de.tdudek.cdi.extensions.eagersingleton;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.*;
import javax.inject.Singleton;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Ensures that all beans annotated with @{@link javax.inject.Singleton} and @{@link de.tdudek.cdi.extensions.eagersingleton.Eager}
 * are initialized directly.
 *
 * created: 11.06.13 by Thomas
 */
@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
public class EagerSingletonExtension implements Extension {

    private final Set<Bean<?>> eagerSingletonBeans = new LinkedHashSet<>();

    <X> void processBean(@Observes ProcessBean<X> event) {
        if (event.getAnnotated().isAnnotationPresent(Eager.class) &&
                event.getAnnotated().isAnnotationPresent(Singleton.class)) {
            eagerSingletonBeans.add(event.getBean());
        }
    }

    void afterDeploymentValidation(@Observes AfterDeploymentValidation event, BeanManager manager) {
        for (Bean<?> bean : eagerSingletonBeans) {
            manager.getReference(bean, bean.getBeanClass(), manager.createCreationalContext(bean)).toString(); // calls #toString() to ensure that the class is really loaded
        }
    }

}
