# 🛒 Core Java Case Study: Online Shopping Application

This project is a console-based Online Shopping Application developed in Core Java. It demonstrates Object-Oriented Programming (OOP) concepts, collection framework usage, and basic service-layer design through a simple menu-driven interface for both Customers and Admins.

---

## ✨ Features

### 💻 Console-Driven Interface
The application offers separate menus for Admin and Customer roles.

### 👥 Admin Functionality
* **Product Management:** Add, remove, and view products in the catalog.
* **Order Management:** View all placed orders and update an order's status (`Pending`, `Completed`, `Delivered`, `Cancelled`).
    * **Stock Logic:** When an order status is updated to **'Completed'**, the stock quantity of the purchased products is automatically reduced. If an order is **'Cancelled'**, the stock is returned.

### 🛍️ Customer Functionality
* **Registration:** Create a new customer profile.
* **Browsing:** View the entire product catalog.
* **Ordering:** Place an order by selecting products and quantities.
* **Order Tracking:** View a list of all their previously placed orders.

---

## 🛠️ Project Structure

The project is organized into packages reflecting the Model-Service-Driver architecture.

| Package | Purpose | Key Classes |
| :--- | :--- | :--- |
| `entities` | Contains the **Model** classes (data structures). | `User`, `Admin`, `Customer`, `Product`, `Order`, `ShoppingCart`, `ProductQuantityPair` |
| `services` | Contains the **Service** classes (business logic and data storage). | `AdminService`, `CustomerService`, `ProductService`, `OrderService` |
| `application` | The **Driver** class containing the `main` method and console interface. | `OnlineShopping` |

---

## 🚀 Getting Started

### Prerequisites

* **Java Development Kit (JDK) 8 or higher** installed on your system.

* ## 💻 How to Run in Eclipse IDE

This section provides the steps to launch and interact with your Core Java Online Shopping Application project directly from the Eclipse IDE.

### 1. Identify the Main Class

The application's execution starts from the `main(String[] args)` method located in the driver class:

* **Main Class:** `com.tns.onlineshopping.application.OnlineShopping`

---

### 2. Execution Steps

You have two primary ways to launch the application using the structure visible in your workspace:

#### Option A: Using the Run Button (Recommended)

1.  In the Eclipse editor, open the **`OnlineShopping.java`** file (located under the `app` package).
2.  Click the **Run** button (a green play icon ▶) in the main toolbar, or use the shortcut **Ctrl + F11** (Windows/Linux) or **⌘ + F11** (Mac).

#### Option B: From the Project Explorer

1.  In the Project Explorer view, navigate to the **`OnlineShopping.java`** file.
2.  **Right-click** on the file.
3.  Select **Run As** -> **Java Application**.

---

### 3. Application Interaction

The application output and input prompts will appear in the **Console** view, typically found at the bottom of the Eclipse window.

1.  The console will first display the preloaded data messages and the main menu.
2.  **Input:** Type your menu choices and other required data (like IDs, quantities, etc.) directly into the **Console** and press Enter.
3.  **Exit:** Choose **3. Exit** from the main menu to cleanly shut down the program.
