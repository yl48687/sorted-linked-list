/**
 * Creates item type in the linked list.
 */
public class ItemType {
    private int value;

    /**
     * Constructs {@code ItemType}.
     *
     * @param value The value of the item.
     */
    public ItemType(int value) {
        this.value = value;
    } // ItemType

    /**
     * Compares the value of {@code item} with current object's value.
     *
     * @param item The item being compared.
     * @return {@code -1} if the value of the current object is less than value in
     *         {@code item}, {@code 0} if equal, and {@code 1} if greater.
     */
    public int compareTo(ItemType item) {
        if (this.value < item.getValue()) {
            return -1;
        } else if (this.value == item.getValue()) {
            return 0;
        } else {
            return 1;
        } // if
    } // compareTo

    /**
     * Returns the value.
     *
     * @return value The value being returned.
     */
    public int getValue() {
        return value;
    } // getValue

    /**
     * Initializes the value.
     *
     * @param num The value being initialized.
     */
    public void initialize(int num) {
        this.value = num;
    } // initialize
} // ItemType
