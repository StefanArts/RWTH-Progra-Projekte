package de.stefan.progra.projects.homework9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Launcher {

    public static void main(String[] args) {
        ArrayMap<String, Integer> map = new ArrayMap<String, Integer>();
        putEntries(map);

        printMap(map);

        Set<String> keys = new HashSet<String>();
        keys.add("unknown");
        try {
            map.getValuesAsSetOrThrow(keys);
        } catch (UnknownKeyException e) {
            System.out.println("unknown key");
        }
    }

    public static void putEntries(AbstractMap<String, Integer> map) {
        map.put("sizeInMB", 42);
        map.put("version", 4);
        map.put("yearOfRelease", 2015);
    }

    public static <K, V> void printMap(AbstractMap<K, V> map) {
        Set<K> keySet = map.keysAsSet();
        for(K key : keySet) {
            try {
                System.out.println(key + ": " + map.getOrThrow(key));
            } catch (UnknownKeyException e) {
                System.out.println("UnknownKeyException was thrown while trying to print a map");
                e.printStackTrace();
            }
        }
    }
}
