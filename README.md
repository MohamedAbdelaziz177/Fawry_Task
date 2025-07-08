Fawry Task 2: OOP BookStore SimulationProject OverviewThis project is an Object-Oriented Programming (OOP) console application developed as part of the Fawry Internship task. It simulates a basic online bookstore system, demonstrating core OOP principles such as inheritance, polymorphism, and design patterns to manage various book types, inventory, and order processing.FeaturesThe application provides the following key functionalities:Diverse Book Types: Supports different categories of books:EBook: Digital books with specific file formats, processed via email.PaperBook: Physical books requiring shipping.ShowcaseBook: Books for display only, not available for purchase.Comprehensive Inventory Management:Adding new books to the inventory with details like ISBN, title, price, quantity, and publication year.Managing stock quantities for each book.Removing outdated books based on their publication year.Streamlined Order Processing:Facilitates the purchase of single books.Automatically handles different order types (email for EBooks, shipping for PaperBooks).Generates CheckoutDetails for each order, including customer information and order specifics.Extensibility: Designed with extensibility in mind, allowing for easy integration of new book types or order processing methods without significant code modifications.Robust Test Cases: Includes dedicated test methods to verify CRUD operations (Create, Read, Update, Delete) for books and order processing for different book types.Project StructureThe project follows a modular structure, organized into several packages:src/
├── Contracts/          # Interfaces defining core behaviors (IEmailable, IOrder, ISaleable, IShippable)
├── Core/               # Core domain models (Book, CheckoutDetails, EBook, EmailOrder, PaperBook, ShippingOrder, ShowcaseBook)
├── Enums/              # Enumerations (e.g., BookType)
├── Factories/          # Design Patterns implementations (OrderServiceFactory)
├── Services/           # Business logic for various services
│   ├── Email/          # Email service (EmailService, IEmailService)
│   └── Order/          # Order processing services (EbookOrderService, IOrderService, PaperBookOrderService)
└── Tests/              # Test classes for verifying functionality (BookInventory, Main)
Technologies UsedLanguage: JavaBuild Tool: (Assumed, typically Maven or Gradle for Java projects)IDE: IntelliJ IDEA (based on screenshot)Getting StartedPrerequisitesJava Development Kit (JDK) 8 or higher installed on your system.Installation and SetupClone the repository:git clone https://github.com/MohamedAbdelaziz177/Fawry_Task2-BookStore-OOP.git
Navigate to the project directory:cd Fawry_Task2-BookStore-OOP
Build the project (if using Maven/Gradle):If Maven: mvn clean installIf Gradle: gradle build(Please replace with actual build commands if different)Running the ApplicationThe application is a console-based simulation. You can run the main method to see the test cases in action.Open the project in your IDE (e.g., IntelliJ IDEA, Eclipse).Locate the Main.java file in the src/Tests directory.Run the main method directly from your IDE.Alternatively, if you have built a JAR file:java -jar target/your-project-name.jar # Replace with your actual JAR path and name
Usage ExamplesThe main method in src/Tests/Main.java demonstrates the core functionalities:public static void main(String[] args) {
    TestBookCrud();       // Tests adding, updating, and removing books
    TestE_bookOrder();    // Tests ordering an EBook
    TestPaperBookOrder(); // Tests ordering a PaperBook
}
Example Console OutputThe following output snippets show the results of the test cases, demonstrating book inventory management and order processing:// ... (Initial book inventory output) ...
EBook,
[
ISBN=4d36c859-bc0e-4ea1-896f-b093f7f103be,
title=The Great Gatsby,
price=10.99,
quantity=70,
year=1925,
]
// ... (More EBook entries) ...

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
CHECKOUT DETAILS:
[
ISBN=4d36c859-bc0e-4ea1-896f-b093f7f103be,
title=The Great Gatsby,
price=10.99,
customerName=Mohamed,
OrderType=Shipping,
message=Order will be shipped to: mohamed@gmail.com,
date=Tue Jul 08 21:25:43 EEST 2025,
]
Design Patterns AppliedThis project effectively utilizes key OOP principles and design patterns:Polymorphism: Demonstrated through the Book abstract class and its concrete subclasses (EBook, PaperBook, ShowcaseBook). This allows for generic handling of books while specific behaviors (like processSale) are implemented differently based on the book type.Factory Pattern: The OrderServiceFactory (located in src/Factories) is used to encapsulate the creation logic for different order processing services (e.g., EbookOrderService, PaperBookOrderService). This decouples the client code from the concrete implementation classes, making the system more flexible and easier to extend with new order types.Interfaces: The Contracts package defines interfaces (IEmailable, IOrder, ISaleable, IShippable) to enforce contracts and promote loose coupling between components.TestingThe project includes a Tests package with Main.java acting as the primary driver for demonstrating functionality through predefined test scenarios (TestBookCrud, TestE_bookOrder, TestPaperBookOrder).To run these tests, simply execute the main method in src/Tests/Main.java.Future EnhancementsImplement a proper persistence layer (e.g., using a database or file system) to store inventory data.Add user authentication and management.Develop a more interactive command-line interface or a graphical user interface.Expand order functionalities (e.g., order history, cancellation, multiple item orders).Introduce more sophisticated error handling and logging.AuthorMohamed AbdelazizLicenseThis project is open-sourced under the MIT License. See the LICENSE file for more details.
