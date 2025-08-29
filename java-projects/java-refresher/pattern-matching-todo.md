**Case Study: Online Shopping System**

**Scenario:**
Consider an online shopping system where users can purchase various items such as electronics, clothing, and groceries. We'll design classes and methods to manage the inventory, handle purchases, and apply discounts using pattern matching with `instanceof` and advanced patterns.

**Sample Classes:**

1. `Product` - Abstract class representing a generic product.
    - Methods:
        - `abstract double getPrice()` - Returns the price of the product.
        - `abstract String getCategory()` - Returns the category of the product.

2. `ElectronicsProduct` - Represents an electronic product.
    - Fields:
        - `String name` - Name of the electronic product.
        - `double price` - Price of the electronic product.
        - `String brand` - Brand of the electronic product.
    - Methods:
        - `String getModel()` - Returns the model of the electronic product.

3. `ClothingProduct` - Represents a clothing product.
    - Fields:
        - `String name` - Name of the clothing product.
        - `double price` - Price of the clothing product.
        - `String size` - Size of the clothing product.
    - Methods:
        - `String getColor()` - Returns the color of the clothing product.

4. `GroceryProduct` - Represents a grocery product.
    - Fields:
        - `String name` - Name of the grocery product.
        - `double price` - Price of the grocery product.
        - `String category` - Category of the grocery product.
    - Methods:
        - `String getExpirationDate()` - Returns the expiration date of the grocery product.

**Functionality:**

1. **Adding Products to Cart:**
    - Implement a method to add products to the shopping cart. Utilize pattern matching with `instanceof` to handle different types of products efficiently.

2. **Calculating Total Price:**
    - Implement a method to calculate the total price of items in the shopping cart, considering any discounts applied. Use type checks and variable bindings for concise code.

3. **Applying Discounts:**
    - Implement a discount mechanism where discounts are applied based on the category of products purchased. Use advanced patterns to apply discounts efficiently.

4. **Checking Availability:**
    - Implement a method to check the availability of a product in the inventory. Utilize `instanceof` along with null checks for handling different types of products.

**Todos:**

1. Implement the `addToCart` method in the shopping cart class to add products to the cart. Utilize `instanceof` to handle different product types (Electronics, Clothing, Grocery).

2. Complete the `calculateTotalPrice` method in the shopping cart class to calculate the total price of items in the cart, considering any discounts applied. Utilize type checks and variable bindings for different product types.

3. Implement the discount mechanism in the online shopping system. Use advanced patterns to apply discounts based on the category of products purchased.

4. Implement the `checkAvailability` method in the inventory class to check the availability of a product. Utilize `instanceof` along with null checks for handling different product types.