import java.util.ArrayList;

/**
 * ArrayListSortedList is an ArrayList-based implementation of a sorted list.
 * Entries are maintained in sorted order according to their natural ordering.
 * The list grows dynamically as needed.
 * 
 * @param <T> The type of entries in the sorted list, must be Comparable
 */
public class ArrayListSortedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
    private ArrayList<T> list;

    /**
     * Constructs an empty sorted list.
     */
    public ArrayListSortedList() {
        this.list = new ArrayList<>();
    }

    /**
     * Adds a new entry to this sorted list in its proper order.
     * The list's size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    @Override
    public void add(T newEntry) {
        int position = 0;

        // Find the correct position to insert
        for (int i = 0; i < list.size(); i++) {
            if (newEntry.compareTo(list.get(i)) < 0) {
                position = i;
                list.add(position, newEntry);
                return;
            }
            position = i + 1;
        }

        // If we get here, add at the end
        list.add(position, newEntry);
    }

    /**
     * Removes the first or only occurrence of a specified entry from this sorted list.
     *
     * @param anEntry The object to be removed.
     * @return True if anEntry was located and removed; otherwise returns false.
     */
    @Override
    public boolean remove(T anEntry) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(anEntry)) {
                list.remove(i);
                return true;
            }
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
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(anEntry)) {
                return i + 1; // Positions start at 1
            }

            // If anEntry should come before list.get(i), return negative position
            if (anEntry.compareTo(list.get(i)) < 0) {
                return -(i + 1);
            }
        }

        // Entry would be added at the end
        return -(list.size() + 1);
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
        if (givenPosition < 1 || givenPosition > list.size()) {
            throw new IndexOutOfBoundsException("Position " + givenPosition + " is out of bounds.");
        }
        return list.get(givenPosition - 1);
    }

    /**
     * Sees whether this list contains a given entry.
     *
     * @param anEntry The object that is the desired entry.
     * @return True if the list contains anEntry, or false if not.
     */
    @Override
    public boolean contains(T anEntry) {
        return list.contains(anEntry);
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
        if (givenPosition < 1 || givenPosition > list.size()) {
            throw new IndexOutOfBoundsException("Position " + givenPosition + " is out of bounds.");
        }
        return list.remove(givenPosition - 1);
    }

    /**
     * Removes all entries from this list.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Gets the length of this list.
     *
     * @return The integer number of entries currently in the list.
     */
    @Override
    public int getLength() {
        return list.size();
    }

    /**
     * Sees whether this list is empty.
     *
     * @return True if the list is empty, or false if not.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Retrieves all entries that are in this list in the order in which they occur in the list.
     *
     * @return A newly allocated array of all the entries in the list. If the list is empty,
     *         the returned array is empty.
     */
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Comparable[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
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
        return "[" + String.join(", ", list.stream().map(Object::toString).toArray(String[]::new)) + "]";
    }
}
