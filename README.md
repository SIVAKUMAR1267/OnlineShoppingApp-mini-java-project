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

### How to Run

1.  **Compile the source files** (assuming all `.java` files are in the corresponding package directories):
    ```bash
    javac app.java
    ```
2.  **Run the application** from the root of your source directory:
    ```bash
    java app
    ```

### Initial Data

The application is preloaded with the following data for immediate testing:

| Role | ID | Name |
| :--- | :--- | :--- |
| **Admin** | `100` | `AdminUser` |
| **Customer** | `201` | `Aniket` |
| **Customer** | `202` | `Bhavna` |

* A sample order for `Aniket` is also preloaded with a status of **'Pending'**.
