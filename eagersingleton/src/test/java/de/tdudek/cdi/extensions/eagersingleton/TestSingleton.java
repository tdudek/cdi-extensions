package de.tdudek.cdi.extensions.eagersingleton;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * created: 11.06.13 by Thomas
 */
@Singleton
public class TestSingleton {

    @Inject TestState state;

    @PostConstruct
    private void onPostContruct() {
        state.incrementNonEager();
    }

}
