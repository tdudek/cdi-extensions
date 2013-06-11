package de.tdudek.cdi.extensions.eagersingleton;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * created: 11.06.13 by Thomas
 */
@Eager @Singleton
public class TestEagerSingleton {

    @Inject TestState state;

    @PostConstruct
    private void onPostContruct() {
        state.incrementEager();
    }

}
