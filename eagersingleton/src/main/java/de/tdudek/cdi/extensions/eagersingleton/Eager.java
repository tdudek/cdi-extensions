package de.tdudek.cdi.extensions.eagersingleton;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Classes annotated with @Eager and @Singleton are build eagerly
 *
 * created: 11.06.13 by Thomas
 */
@Target( { TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Qualifier
public @interface Eager {
}
