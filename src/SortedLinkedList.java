/**
 * Represents a sorted linked list that stores elements in ascending order.
 */
public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;

    /**
     * Initializes a sorted linked list object.
     */
    public SortedLinkedList() {
        head = null;
        currentPos = null;
    } // SortedLinkedList

    /**
     * {@code return} the {@code length} of the linked list by using a loop over the list to count
     * the number of nodes.
     *
     * @return {@code length}
     */
    public int getLength() {
        int length = 0;
        NodeType current = head;
        while (current != null) {
            length++;
            current = current.next;
        } // for
        return length;
    } // getLength

    /**
     * Inserts an item into the sorted linked list while maintaining the ascending order.
     *
     * @param item The item to be inserted.
     */
    public void insertItem(ItemType item) {
        if (head == null) {
            head = new NodeType();
            head.info = item;
            head.next = null;
        } else if (item.compareTo(head.info) < 0) {
            NodeType newNode = new NodeType();
            newNode.info = item;
            newNode.next = head;
            head = newNode;
        } else if (item.compareTo(head.info) == 0) {
            System.out.println("Item already exists");
        } else {
            NodeType current = head;
            NodeType previous = null;
            while (current != null && item.compareTo(current.info) > 0) {
                previous = current;
                current = current.next;
            } // if
            if (current != null && item.compareTo(current.info) == 0) {
                System.out.println("Item already exists");
                return;
            } // if
            NodeType newNode = new NodeType();
            newNode.info = item;
            newNode.next = current;
            previous.next = newNode;
        } // if
    } // insertItem

    /**
     * Removes the node in the list that contains an item equal to the item parameter.
     *
     * @param item The item to be removed.
     */
    public void deleteItem(ItemType item) {
        NodeType current = head;
        NodeType previous = null;
        while (current != null && current.info.compareTo(item) != 0) {
            previous = current;
            current = current.next;
        } // while
        if (current != null) {
            if (current == head) {
                head = head.next;
            } else {
                previous.next = current.next;
            } // if
        } // if
    } // deleteItem

    /**
     * Searches the linked list that contains an item equal to the parameter item and return its
     * index. Prints a message if the item is not present in the list.
     *
     * @param item The item to be searched.
     * @return {@code -1} if {@code item} is not found in the list
     */
    public int searchItem(ItemType item) {
        NodeType current = head;
        int index = 0;
        while (current != null) {
            if (item.compareTo(current.info) == 0) {
                return index;
            } // if
            index++;
            current = current.next;
        } // while
        return -1;
    } // searchItem

    /**
     * {@code return} the next item in the list pointed by the {@code currentPos}.
     *
     * @return the next item
     */
    public ItemType getNextItem() {
        if (head == null) {
            System.out.println("The list is empty");
            return null;
        } // if
        if (currentPos.next == null) {
            System.out.println("End of the list has reached");
        } else {
            currentPos = currentPos.next;
        } // if
        if (currentPos != null) {
            return currentPos.info;
        } // if
        return null;
    } // getNextItem

    /**
     * Initializes the {@code currentPos} to null.
     */
    public void resetList() {
        currentPos = null;
    } // resetList

    /**
     * Prints the linked list.
     */
    public void printAll() {
        NodeType current = head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        } // while
        System.out.println();
    } // printAll

    /**
     * Merges two lists and not include any duplicate items in the list. If there are duplicates in
     * the two lists, the merge function should keep only one of the duplicate instances in the
     * resulting list.
     *
     * @param list2 The new list that the original list will be merged with.
     * @return {@code mergeList}.
     */
    public SortedLinkedList mergeList(SortedLinkedList list2) {
        SortedLinkedList mergedList = new SortedLinkedList();
        NodeType current1 = head;
        NodeType current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.info.compareTo(current2.info) < 0) {
                mergedList.insertItem(current1.info);
                current1 = current1.next;
            } else if (current1.info.compareTo(current2.info) > 0) {
                mergedList.insertItem(current2.info);
                current2 = current2.next;
            } else {
                mergedList.insertItem(current1.info);
                current1 = current1.next;
                current2 = current2.next;
            } // if
        } // while
        while (current1 != null) {
            mergedList.insertItem(current1.info);
            current1 = current1.next;
        } // while
        while (current2 != null) {
            mergedList.insertItem(current2.info);
            current2 = current2.next;
        } // while
        return mergedList;
    } // mergeList

    /**
     * Deletes alternate nodes from the list.
     */
    public void deleteAltNodes() {
        if (head == null || head.next == null) {
            return;
        } // if
        NodeType current = head;
        while (current != null && current.next != null) {
            current.next = current.next.next;
            current = current.next;
        } // while
    } // deleteAltNodes

    /**
     * Uses another list, finds the common elements between input list and original list, and then
     * prints the result.
     *
     * @param list2 The new list that the original list will use to find the intersection with.
     * @return {@code intersectionList}.
     */
    public SortedLinkedList intersection(SortedLinkedList list2) {
        SortedLinkedList intersectionList = new SortedLinkedList();
        NodeType current1 = head;
        NodeType current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.info.compareTo(current2.info) < 0) {
                current1 = current1.next;
            } else if (current1.info.compareTo(current2.info) > 0) {
                current2 = current2.next;
            } else {
                intersectionList.insertItem(current1.info);
                current1 = current1.next;
                current2 = current2.next;
            } // if
        } // while
        return intersectionList;
    } // intersection

    /** Prints.*/
    public void printList() {
        NodeType current = head;
        while (current != null) {
            System.out.print(current.info.getValue() + " ");
            current = current.next;
        } // while
        System.out.println("");
    } // printList

    /**
     * Checks if the list contains the {@item}.
     *
     * @param item The item that list will contain or not contain.
     * @return {@code false} if the list does not contain the {@code item}, else {@code true}.
     */
    public boolean contains(ItemType item) {
        NodeType current = head;
        while (current != null) {
            if (item.compareTo(current.info) == 0) {
                return true;
            } // if
            current = current.next;
        } // while
        return false;
    } // contains

    /**
     * Checks if the list is empty.
     *
     * @return {@code true} if empty, else {@code false}.
     */
    public boolean isEmpty() {
        return head == null;
    } // isEmpty
} // SortedLinkedList
