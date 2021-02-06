package com.github.piotrkalanski.ui.cameras.dummy;

import com.github.piotrkalanski.model.Camera;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
// TODO - remove and replace by fetching from REST API (for testing: https://jsonplaceholder.typicode.com/)
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Camera> ITEMS = new ArrayList<Camera>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Camera> ITEM_MAP = new HashMap<>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(new Camera(
                    "" + i,
                    "model" + (i % 3 + 1),
                    "description_" + i
            ));
        }
    }

    private static void addItem(Camera item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
    }
}