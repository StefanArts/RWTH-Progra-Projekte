package de.stefan.progra.projects.homework9;

import java.util.HashSet;
import java.util.Set;

public class ArrayMap<K, V> extends AbstractMap<K, V> {

    private Entry<K,V>[] entries;

    public ArrayMap(Entry<K,V>[] entries) {
        this.entries = GenericArrayHelper.copyArray(entries);
    }

    public ArrayMap() {
        entries = GenericArrayHelper.newEntryArrayOfSize(10);
    }
    @Override
    public V getOrThrow(K key) throws UnknownKeyException {
        if(key == null) throw new UnknownKeyException("Key is null");
        for(Entry<K, V> entry : entries) {
            if(entry == null || !entry.getKey().equals(key)) continue;
            return entry.getValue();
        }
        throw new UnknownKeyException();
    }

    /*
    TODO: Ist nicht wichtiger, ob schon ein key existiert?
     */
    public void put(K key, V value) {
        for(int i = 0; i < entries.length; i++) {
            if(entries[i] != null && !entries[i].getKey().equals(key)) continue;
            entries[i] = new Entry<K, V>(key, value);
            return;
        }
        int entriesLength = entries.length;
        entries = GenericArrayHelper.copyArrayWithIncreasedSize(entries, entriesLength + 1);
        entries[entriesLength] = new Entry<K, V>(key, value);
    }

    @Override
    public Set<K> keysAsSet() {
        HashSet<K> keysAsSet = new HashSet<K>();
        for(Entry<K, V> entry : entries) {
            if(entry == null || entry.getKey() == null) continue;
            keysAsSet.add(entry.getKey());
        }
        return keysAsSet;
    }
}
