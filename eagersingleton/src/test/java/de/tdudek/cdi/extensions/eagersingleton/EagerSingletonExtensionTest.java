package de.tdudek.cdi.extensions.eagersingleton;

import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.UnsatisfiedResolutionException;
import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * created: 11.06.13 by Thomas
 */
@RunWith(WeldJUnit4Runner.class)
public class EagerSingletonExtensionTest {

    @Inject TestState eagerState;
    @Inject Instance<TestSingleton> nonEagerSingleton; // should not be instantiated until #get() is invoked
    @Inject Instance<TestEagerSingleton> eagerSingleton;

    @Test
    public void isEagerBuild() {
        assertEquals(1, eagerState.getEager());
        assertEquals(0, eagerState.getNotEager());

        nonEagerSingleton.get();

        assertEquals(1, eagerState.getEager());
        assertEquals(1, eagerState.getNotEager());
    }

    @Test
    public void canInjectEagerSingleton() {
        final TestEagerSingleton singleton = eagerSingleton.get();
    }

}
