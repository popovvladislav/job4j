package ru.job4j.collection.tree;

import java.util.*;

/**
 * @param <E> The type of element.
 * @author В-87
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int modCount = 0;


    Tree(final E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Node<E> node = this.findBy(parent).get();
        if (!node.eqValue(child)) {
            node.add(new Node<>(child));
            result = true;
            modCount++;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * The method checks whether the tree is binary or not.
     *
     * @return result.
     */
    boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            if (poll.leaves().size() > 2) {
                result = false;
                break;
            }
            queue.addAll(poll.leaves());
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private Queue<Node<E>> list = new LinkedList<>();
            private boolean flag = true;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (flag) {
                    list.add(root);
                    flag = false;
                }
                return !list.isEmpty();
            }


            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                Node<E> poll = list.poll();
                list.addAll(poll.leaves());
                return poll.getValue();
            }
        };
    }
}
