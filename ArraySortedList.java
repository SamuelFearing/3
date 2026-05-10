/**
 * ArraySortedList is an array-based implementation of a sorted list.
 * Entries are maintained in sorted order according to their natural ordering.
 * The array size is fixed at initialization.
 * 
 * @param <T> The type of entries in the sorted list, must be Comparable
 */
public class ArraySortedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
    private T[] list;
    private int length;
    private static final int DEFAULT_CAPACITY = 25;

    /**
     * Constructs an empty sorted list with default capacity.
     */
    @SuppressWarnings("unchecked")
    public ArraySortedList() {
        this.list = new Comparable[DEFAULT_CAPACITY];
        this.length = 0;
    }

    /**
     * Constructs an empty sorted list with specified capacity.
     *
     * @param capacity The initial capacity of the list.
     */
    @SuppressWarnings("unchecked")
    public ArraySortedList(int capacity) {
        this.list = new Comparable[capacity];
        this.length = 0;
    }

    /**
     * Adds a new entry to this sorted list in its proper order.
     * The list's size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    @Override
    public void add(T newEntry) {
        if (length >= list.length) {
            doubleCapacity();
        }

        int position = length + 1;
        for (int i = 1; i <= length; i++) {
            if (newEntry.compareTo(list[i - 1]) < 0) {
                position = i;
                break;
            }
        }

        // Shift elements to the right
        for (int i = length; i >= position; i--) {
            list[i] = list[i - 1];
        }

        // Insert the new entry
        list[position - 1] = newEntry;
        length++;
    }

    /**
     * Doubles the capacity of the list when needed.
     */
    @SuppressWarnings("unchecked")
    private void doubleCapacity() {
        T[] newList = new Comparable[list.length * 2];
        for (int i = 0; i < length; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }

    /**
     * Removes the first or only occurrence of a specified entry from this sorted list.
     *
     * @param anEntry The object to be removed.
     * @return True if anEntry was located and removed; otherwise returns false.
     */
    @Override
    public boolean remove(T anEntry) {
        for (int i = 0; i < length; i++) {
            if (list[i].equals(anEntry)) {
                removeAtIndex(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the entry at a given index.
     *
     * @param index The index of the entry to remove.
     */
    private void removeAtIndex(int index) {
        for (int i = index; i < length - 1; i++) {
            list[i] = list[i + 1];
        }
        list[length - 1] = null;
        length--;
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
        for (int i = 0; i < length; i++) {
            if (list[i].equals(anEntry)) {
                return i + 1; // Positions start at 1
            }

            // If anEntry should come before list[i], return negative position
            if (anEntry.compareTo(list[i]) < 0) {
                return -(i + 1);
            }
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
        return list[givenPosition - 1];
    }

    /**
     * Sees whether this list contains a given entry.
     *
     * @param anEntry The object that is the desired entry.
     * @return True if the list contains anEntry, or false if not.
     */
    @Override
    public boolean contains(T anEntry) {
        return getPosition(anEntry) > 0;
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

        T removedEntry = list[givenPosition - 1];
        removeAtIndex(givenPosition - 1);
        return removedEntry;
    }

    /**
     * Removes all entries from this list.
     */
    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            list[i] = null;
        }
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
    public Comparable[] toArray() {
        @SuppressWarnings("unchecked")
        Comparable[] result = new Comparable[length];
        for (int i = 0; i < length; i++) {
            result[i] = list[i];
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
        for (int i = 0; i < length; i++) {
            sb.append(list[i]);
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
