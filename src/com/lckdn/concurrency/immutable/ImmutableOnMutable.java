package com.lckdn.concurrency.immutable;

import java.util.HashSet;
import java.util.Set;

public final class ImmutableOnMutable {

    private final Set<String> names = new HashSet<>();

    public ImmutableOnMutable() {
        names.add("Alex");
        names.add("John");
        names.add("Paul");
    }

    public boolean isStored(String name) {
        return names.contains(name);
    }

    public static void main(String[] args) {
        ImmutableOnMutable immutableOnMutable = new ImmutableOnMutable();
//        immutableOnMutable.names.
    }
}
