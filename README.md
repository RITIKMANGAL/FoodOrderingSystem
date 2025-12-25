# Food Ordering System

## Overview

This is an in-memory, console-based food ordering system that allows onboarding restaurants, updating their menus, and placing orders using pluggable selection strategies (Lowest Cost or Highest Rating). The system enforces restaurant order capacity, menu completeness, and provides robust error handling and modular design.

---

## Features

- **Restaurant Onboarding:** Add new restaurants with menu, rating, and order capacity.
- **Menu Management:** Add or update menu items and prices (no deletion allowed).
- **Order Placement:** Place orders specifying items, quantities, and selection strategy.
- **Order Assignment:** Orders are auto-assigned to a restaurant that can fulfill all items and has available capacity.
- **Selection Strategies:** Pluggable strategies for order assignment:
  - Lowest Bill Cost
  - Highest Rating
- **Order Completion:** Mark orders as completed to free up restaurant capacity.
- **Validation & Error Handling:** Input validation and custom exceptions.
- **In-Memory Storage:** All data is stored in memory using Java collections.
- **Separation of Concerns:** Clean separation between models, repositories, services, and strategies.

---

## Project Structure

```
src/
  main/
    java/
      constant/           # Order status enums
      exception/          # Custom exceptions
      model/              # Core domain models (Order, Restaurant, User)
      pojo/               # MenuItem class
      repository/         # In-memory repositories
      service/            # Service interfaces and selection strategy interface
      serviceImpl/        # Service and strategy implementations
      MainApp.java        # Main driver program
```

---

## How to Run

1. **Compile the project** (from the project root):
   ```sh
   javac -d out @(Get-ChildItem -Recurse -Filter *.java -Path src | ForEach-Object { $_.FullName })
   ```
2. **Run the main application:**
   ```sh
   java -cp out MainApp
   ```

---

## Usage

- The main program (`MainApp.java`) demonstrates:
  - Onboarding restaurants and updating menus.
  - Placing orders with different selection strategies.
  - Marking orders as completed.
  - Handling cases where orders cannot be fulfilled.

- You can modify `MainApp.java` to add more test cases or make the system interactive.

---

## Sample Test Cases

- Onboard restaurants R1, R2, R3 with different menus, ratings, and capacities.
- Add and update menu items (no deletion).
- Place orders with:
  - All items available in a single restaurant.
  - More orders than a restaurant's capacity (should not assign).
  - Items not available in any single restaurant (should not assign).
- Mark orders as completed and place new orders.

---

## Design Highlights

- **Strategy Pattern:** Used for pluggable restaurant selection strategies.
- **Exception Handling:** Custom `ValidationException` and input checks.
- **Immutability:** Orders and menu items are immutable where appropriate.
- **No Database:** All data is in-memory for simplicity and speed.

---

## Extending the System

- Add new selection strategies by implementing the `SelectionStrategy` interface.
- Make the system interactive by reading user input in `MainApp.java`.
- Add more business rules or features (e.g., user wallets, order splitting) as needed.

---

## Limitations

- No persistent storage (all data lost on program exit).
- No web or GUI interface (console-based only).
- Does not support splitting orders across multiple restaurants or wallet functionality (can be added as extensions).

---

## License

This project is for educational and demonstration purposes.
