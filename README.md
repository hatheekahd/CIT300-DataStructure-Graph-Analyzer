# CIT300 Data Structure and Graph Performance Analyzer

**Module:** CIT300 Data Structures and Algorithms
**Assignment:** Graded Practical Assignment 2
**Language:** Java (console application, Eclipse / VS Code)

## Project Description
A menu-driven Java console application that demonstrates the practical
application of data structures, algorithms, searching, graph concepts
and algorithmic complexity. The system allows users to work with an
array, stack, queue, linked list, searching algorithms and a graph,
and compares the performance of different algorithms.

## Group Members and Contributions

| Student Name | Student ID | Assigned Responsibility | Individual Contribution |
|---|---|---|---|
| MAH. Hatheek Ahamed | 23DA2-1128 | Array and Searching, Integration | `IntArrayList` (insert, delete, search, display), `SearchOperations` (linear and binary search with step counting), `SearchResult` model, `Main.java` full menu integration and Performance Comparison |
| MAM. Afkah | 23DA2-1026 | Stack and Queue | `StackOperations` (push, pop, peek, display, empty-stack handling), `QueueOperations` (enqueue, dequeue, peek, display, empty-queue handling) |
| TM. Rahmy | 23DA2-0641 | Linked List | `LinkedListOperations` (insert, delete, search, display) |
| SM. Nasmir | 23DA2-1039 | Graph | `GraphOperations` (adjacency list, add vertex, add edge, display, BFS traversal, DFS traversal) |

**All members:** testing, debugging, documentation and GitHub collaboration.

## Technologies Used
- Java (JDK 17+)
- Eclipse IDE / Visual Studio Code
- Git and GitHub (branches, commits, pull requests)

## Project Structure
```
src/
 ├─ model/       SearchResult.java
 ├─ array/       IntArrayList.java
 ├─ searching/   SearchOperations.java
 ├─ stackqueue/  StackOperations.java, QueueOperations.java
 ├─ linkedlist/  LinkedListOperations.java
 ├─ graph/       GraphOperations.java
 └─ app/         Main.java (menu), test classes
```

## Main System Features
- Array: insert, delete, search, display
- Stack: push, pop, peek, display, with empty-stack error handling
- Queue: enqueue, dequeue, peek/front, display, with empty-queue error handling
- Linked List: insert, delete, search, display
- Searching: Linear Search and Binary Search, each with step counting
- Graph: add vertex, add edge, display, BFS traversal, DFS traversal
- Performance Comparison: shows step counts for Linear vs Binary Search
  and BFS vs DFS traversal in a formatted table, with an explanation
  of algorithmic complexity (O(n) vs O(log n), O(V+E))
- Display All Results: shows the current state of every data structure
  and the last recorded search/traversal results
- Input validation throughout (invalid menu choices, non-numeric input,
  empty input, duplicate vertices, missing vertices/edges)

## How to Run
1. Clone the repository:
   `git clone https://github.com/hatheekahd/CIT300-DataStructure-Graph-Analyzer.git`
2. Open the project in Eclipse (File > Import > Existing Projects into Workspace) or VS Code.
3. Run `src/app/Main.java`.
4. Use the console menu (options 1 to 9). Each component has its own submenu.

## Main Menu
```
1. Array Operations
2. Stack Operations
3. Queue Operations
4. Linked List Operations
5. Searching Operations
6. Graph Operations
7. Performance Comparison
8. Display All Results
9. Exit
```

## Git Workflow
Each member worked on their own branch and merged into `main` through pull requests:

| Branch | Member |
|---|---|
| `feature/array-searching` | MAH. Hatheek Ahamed |
| `feature/stack-queue` | MAM. Afkah |
| `feature/linked-list` | TM. Rahmy |
| `feature/graph` | SM. Nasmir |
| `feature/main-integration` | MAH. Hatheek Ahamed |
| `feature/readme` | MAH. Hatheek Ahamed |