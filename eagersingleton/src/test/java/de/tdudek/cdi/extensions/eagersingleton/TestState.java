package de.tdudek.cdi.extensions.eagersingleton;

import javax.inject.Singleton;

/**
 * created: 11.06.13 by Thomas
 */
@Singleton
public class TestState {

    private int eager;
    private int notEager;

    public void incrementEager() {
        eager++;
    }

    public void incrementNonEager() {
        notEager++;
    }

    public int getEager() {
        return eager;
    }

    public int getNotEager() {
        return notEager;
    }
}
