package collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SizeRestrictedQueueTest {
    private static SizeRestrictedQueue<Integer> queue;

    @Test
    public void testAddingLastOverflow() {
        givenQueue(3, new int[]{1, 2, 3});
        whenAddingLast(10);
        thenQueueContentShouldBe(new int[]{2, 3, 10});
    }

    @Test
    public void testAddingFirstOverflow() {
        givenQueue(3, new int[]{1, 2, 3});
        whenAddingFirst(10);
        thenQueueContentShouldBe(new int[]{10, 1, 2});
    }

    @Test
    public void testNotFullQueue() {
        givenQueue(2, new int[]{1});
        thenQueueFullnessShouldBe(false);
    }

    @Test
    public void testFullQueue() {
        givenQueue(2, new int[]{1, 2});
        thenQueueFullnessShouldBe(true);
    }

    @Test
    public void testAddingContent() {
        givenQueue(3, new int[]{1, 2, 3});
        thenQueueContentShouldBe(new int[]{1, 2, 3});
    }

    private void givenQueue(int size, int[] elements) {
        queue = new SizeRestrictedQueue<>(size);
        List<Integer> queueContent = Arrays.stream(elements)
                .boxed()
                .toList();
        queue.addAll(queueContent);
    }

    private void whenAddingFirst(int element) {
        queue.addFirst(element);
    }

    private void whenAddingLast(int element) {
        queue.addLast(element);
    }

    private void thenQueueFullnessShouldBe(boolean expected) {
        assertEquals(expected, queue.isFull());
    }

    private void thenQueueContentShouldBe(int[] expectedElements) {
        int[] queueElements = queue.stream().mapToInt(i -> i).toArray();
        assertArrayEquals(expectedElements, queueElements);
    }
}