# EcommerceApp
To setup the project on local machine in development environment:-
1) Install Mysql(Preferably 8.0)
2) Download the complete code with git clone https://github.com/vigyat123/EcommerceApp.git
3) Import the code on IDE(preferably Intellij)
4) Create a database(CREATE SCHEMA `ecommerce_app_db2`;). Please don't change the name. Table migration will happen through flyway during      program execution
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

Note: Currently there are two ItemTypes:- LAPTOP & BOOK

b) http://localhost:8080/deleteItemOfSeller/{item_name}/{seller} 
   DELETE
   
c) http://localhost:8080/getAllOrders?pageIndex=0&size=2
GET
{pageIndec and Size} follow standard pagination settings
   
