# Sorted Linked List
This project contains Java classes implementing a sorted singly-linked list. The classes include `SortedLinkedList`, `NodeType`, `ItemType`, and `LinkedListDriver`. The project focuses on providing a robust and efficient implementation of a sorted list data structure in Java, suitable for applications requiring ordered storage of elements.

## Design Overview
The sorted linked list implementation consists of three main classes: `SortedLinkedList`, `NodeType`, and `ItemType`. `SortedLinkedList` represents the sorted linked list itself, while `NodeType` and `ItemType` are helper classes for managing nodes and items within the list. The `LinkedListDriver` class serves as the driver program providing a command-line interface to interact with the sorted linked list.

## Functionality
`ItemType`:
- Represents item types in the linked list.
- Defines methods for comparing item values, getting item values, and initializing item values.

`LinkedListDriver`:
- Serves as the driver program for the sorted singly-linked list.
- Provides a command-line interface to interact with the `SortedLinkedList`.
- Supports commands for inserting, deleting, searching, printing, and performing operations on the list.

`NodeType`:
- Creates nodes in the linked list.
- Defines fields for storing item information and a reference to the next node in the list.

`SortedLinkedList`:
- Represents a sorted singly-linked list that stores elements in ascending order.
- Provides methods for inserting, deleting, searching, merging, and printing items in the list.
- Implements operations to delete alternate nodes and find the intersection with another list.
- Supports operations such as checking if the list is empty, getting the length of the list, and checking for the presence of an item.

## File Structure and Content
```
sorted-linked-list/
├── compile.sh
├── README.md
└── src/
    ├── ItemType.java
    ├── LinkedListDriver.java
    ├── NodeType.java
    └── SortedLinkedList.java
```