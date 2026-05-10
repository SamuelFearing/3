/**
 * LinkedListSortedList is a linked list implementation of a sorted list.
 * Entries are maintained in sorted order according to their natural ordering.
 * 
 * @param <T> The type of entries in the sorted list, must be Comparable
 */
public class LinkedListSortedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
    private Node firstNode;
    private int length;

    /**
     * Inner class Node to represent each node in the linked list
     */
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Constructs an empty sorted list.
     */
    public LinkedListSortedList() {
        firstNode = null;
        length = 0;
    }

    /**
     * Adds a new entry to this sorted list in its proper order.
     * The list's size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);

        // If the list is empty or the new entry should be first
        if (firstNode == null || newEntry.compareTo(firstNode.data) < 0) {
            newNode.next = firstNode;
            firstNode = newNode;
        } else {
            // Find the correct position to insert
            Node currentNode = firstNode;
            while (currentNode.next != null && newEntry.compareTo(currentNode.next.data) > 0) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }

        length++;
    }

    /**
     * Removes the first or only occurrence of a specified entry from this sorted list.
     *
     * @param anEntry The object to be removed.
     * @return True if anEntry was located and removed; otherwise returns false.
     */
    @Override
    public boolean remove(T anEntry) {
        if (firstNode == null) {
            return false;
        }

        // Check if the first node contains the entry
        if (firstNode.data.equals(anEntry)) {
            firstNode = firstNode.next;
            length--;
            return true;
        }

        // Search for the entry in the rest of the list
        Node currentNode = firstNode;
        while (currentNode.next != null) {
            if (currentNode.next.data.equals(anEntry)) {
                currentNode.next = currentNode.next.next;
                length--;
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    /**
     * Gets the position of an entry in this sorted list.
     *
     * @param anEntry The object to be found.
     * @return The position of the first or only occurrence of anEntry if it occurs
     *         in the list; otherwise returns the position where anEntry would occur
     *         in the list, but as a negative integer.
     */
    @Override
    public int getPosition(T anEntry) {
        Node currentNode = firstNode;
        int position = 1;

        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                return position; // Found the entry
            }

            // If anEntry should come before currentNode, return negative position
            if (anEntry.compareTo(currentNode.data) < 0) {
                return -position;
            }

            currentNode = currentNode.next;
            position++;
        }

        // Entry would be added at the end
        return -(length + 1);
    }

    /**
     * Retrieves the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of the desired entry.
     * @return A reference to the indicated entry.
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or
     *                                   givenPosition > getLength().
     */
    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition < 1 || givenPosition > length) {
            throw new IndexOutOfBoundsException("Position " + givenPosition + " is out of bounds.");
        }

        Node currentNode = firstNode;
        for (int i = 1; i < givenPosition; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    /**
     * Sees whether this list contains a given entry.
     *
     * @param anEntry The object that is the desired entry.
     * @return True if the list contains anEntry, or false if not.
     */
    @Override
    public boolean contains(T anEntry) {
        Node currentNode = firstNode;

        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    /**
     * Removes the entry at a given position from this list.
     * Entries originally at positions higher than the given position are at the 
     * next lower position within the list, and the list's size is decreased by 1.
     *
     * @param givenPosition An integer that indicates the position of the entry to be removed.
     * @return A reference to the removed entry.
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or
     *                                   givenPosition > getLength().
     */
    @Override
    public T remove(int givenPosition) {
        if (givenPosition < 1 || givenPosition > length) {
            throw new IndexOutOfBoundsException("Position " + givenPosition + " is out of bounds.");
        }

        T removedData;

        if (givenPosition == 1) {
            removedData = firstNode.data;
            firstNode = firstNode.next;
        } else {
            Node currentNode = firstNode;
            for (int i = 1; i < givenPosition - 1; i++) {
                currentNode = currentNode.next;
            }
            removedData = currentNode.next.data;
            currentNode.next = currentNode.next.next;
        }

        length--;
        return removedData;
    }

    /**
     * Removes all entries from this list.
     */
    @Override
    public void clear() {
        firstNode = null;
        length = 0;
    }

    /**
     * Gets the length of this list.
     *
     * @return The integer number of entries currently in the list.
     */
    @Override
    public int getLength() {
        return length;
    }

    /**
     * Sees whether this list is empty.
     *
     * @return True if the list is empty, or false if not.
     */
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Retrieves all entries that are in this list in the order in which they occur in the list.
     *
     * @return A newly allocated array of all the entries in the list. If the list is empty,
     *         the returned array is empty.
     */
    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[]) java.lang.reflect.Array.newInstance(
            firstNode == null ? Comparable.class : firstNode.data.getClass(), 
            length
        );

        Node currentNode = firstNode;
        for (int i = 0; i < length; i++) {
            result[i] = currentNode.data;
            currentNode = currentNode.next;
        }

        return result;
    }

    /**
     * Returns a string representation of this sorted list.
     *
     * @return A string representation of the list's entries.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node currentNode = firstNode;
        while (currentNode != null) {
            sb.append(currentNode.data);
            if (currentNode.next != null) {
                sb.append(", ");
            }
            currentNode = currentNode.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
