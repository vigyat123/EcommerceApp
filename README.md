# EcommerceApp
To setup the project on local machine in development environment:-
1) Install Mysql(Preferably 8.0)
2) Download the complete code with git clone https://github.com/vigyat123/EcommerceApp.git
3) Import the code on IDE(preferably Intellij)
4) Create a database(CREATE SCHEMA `ecommerce_app_db`;). Please don't change the name. Table migration will happen through flyway during      program execution
5) Find the file EcommerceAppApplication.java and run it 
                                    or 
   Go to project root directory and run the command ./gradlew bootRun

# Project Structure
1) Two Contollers InventoryController and OrdersController.
2) InventoryController exposes the following apis:-


a) http://localhost:8080/addItem 
POST

    {
        "itemName":"Lenovo Thinkpad",
        "price":20000.00,
        "numberOfItems":2,
        "seller":"BlueCorp 2",
        "itemType":"LAPTOP"
    }

If item with a given seller is already present then new no new record will be created but number of items in the already present record will get upated.

Note: Currently there are two ItemTypes:- LAPTOP & BOOK

b) http://localhost:8080/deleteItemOfSeller/{item_name}/{seller} 
   DELETE
   
c) http://localhost:8080/getAllItems?pageIndex=0&size=2
GET

{pageIndex and Size} follow standard pagination settings

d) http://localhost:8080/editItem/{id}
PUT

id is autoincrement id of inventory table
   
3) OrdersController exposes the following apis:-

a) http://localhost:8080/addToCart 
POST


    {
        "buyerEmail":"vigyattripathi@gmail.com",
        "itemsOrderedSet":[

	        {
		        "itemId":2,
		        "numberOfItems":1,
	            "priceOfItem":200.0
	        },
	        {
		        "itemId":3,
		        "numberOfItems":1,
		        "priceOfItem":20000.0
	        }
        ]
    }


ItemId is the autoIncrement id of inventory table

b) http://localhost:8080/getAllOrders?pageIndex=0&size=2
GET

c) http://localhost:8080/placeOrder/{order_id}
PUT

order_id is autoIncrement id of order table

d) http://localhost:8080/cancelOrder/{order_id}
PUT

# Few things to know
1) The given project can handle single and bulk orders(see the above create order payload)
2) OutOfStock is custom exception created to handle Out of stock type of cases
