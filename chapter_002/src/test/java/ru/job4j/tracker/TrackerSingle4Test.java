package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class TrackerSingle4Test {
    @Test
    public void whenFindByNameThanArrayItem() {
        TrackerSingle4 tracker = TrackerSingle4.getInstance();
        Item first = new Item("test1", "Description", 123L);
        tracker.add(first);
        Item second = new Item("test2", "Description2", 1234L);
        tracker.add(second);
        Item third = new Item("test1", "Description3", 12345L);
        tracker.add(third);
        List<Item> result = tracker.findByName("test1");
        List<Item> expect = Arrays.asList(first, third);
        assertThat(result, is(expect));
    }
}
