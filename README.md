
# Book Store Application

An Object-Oriented Programming (OOP) console application simulating a book store, developed as part of the Fawry internship requirements.

## Features

- Book inventory management (CRUD operations)
- Different book types (EBook, PaperBook)
- Order processing system
- Email order service
- Shipping order service
- Showcase functionality

## Application Structure

```
# STC
- [ ] Contracts  
  - [ ] IEmailable  
  - [ ] lOrder  
  - [ ] ISaleable  
  - [ ] IShippable  

## Core
- [x] Book  
- [x] CheckoutDetails  
- [x] EBook  
- [x] EmailOrder  
- [x] PaperBook  
- [x] ShippingOrder  
- [x] ShowcaseBook  

## Enums
- [x] BookType  
- [x] Factories  
- [x] OrderServiceFactory  

## Services
- [x] Email  
- [x] EmailService  
- [x] IEmailService  

## Order
- [x] EbookOrderService  
- [x] lOrderService  
- [x] PaperBookOrderService  

## Tests
- [x] BookInventory  
- [x] Main
```

## Main Functionality

```java
public static void main(String[] args) {
    TestBookCrud(); // done
    TestE_bookOrder(); // done
    TestPaperBookOrder(); // done
}
```

## Sample Output

```
EBook,
[
ISBN=4d36c859-bc0e-4ea1-896f-b093f7f103be,
title=The Great Gatsby,
price=10.99,
quantity=70,
year=1925,
]

EBook,
[
ISBN=92649479-e65f-4153-a13b-af3a5e75e9f6,
title=To Kill a Mockingbird,
price=8.99,
quantity=80,
year=1960,
]

Starting Order Processing
----------------
EMAIL SENT TO YOU WITH THE ORDER DETAILS:

CHECKOUT DETAILS:
[
ISBN=960a8ad9-1575-44b1-895c-f69087ec4fdd,
title=Master C#,
price=10.99,
customerName=Mohamed,
OrderType=Email,
message=Order will be sent to: mohamed@gmail.com,
date=Tue Jul 08 21:25:43 EEST 2025,
]
```

## OOP Concepts Implemented

- Inheritance
- Polymorphism
- Encapsulation
- Abstraction
- Interfaces
- Factory Pattern

## How to Run

1. Clone the repository
2. Compile the Java files
3. Run the Main class

## Requirements

- Java JDK 8 or higher
```

This README includes:
1. Project title and description
2. Key features
3. Application structure (from your image)
4. Main functionality
5. Sample output
6. OOP concepts implemented
7. Running instructions
8. Requirements

You can customize it further by adding installation instructions, usage examples, or contribution guidelines if needed.
