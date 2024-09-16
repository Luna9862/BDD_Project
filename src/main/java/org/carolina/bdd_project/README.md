The system allows users to create, view, update, and delete products from a product catalog, making it easy to manage product information such as names and prices. 
The application connects to a database (in this case, SQLite) to store product data so that it can be accessed at any time. By interacting with this system through Postman, a tool used to send requests to web applications, users can manage their product data without needing a user interface.
This means users can directly input data or retrieve information by sending requests to the system using specific web addresses (URLs).
Set the URL to:
http://localhost:8080/products
Go to the Body tab, and select raw and JSON format.
Enter the JSON object that represents the product you want to create. 

json
Copy code
{
"name": "Laptop",
"price": 999.99
}
Click Send.

Expected Response: You should receive a response with the created product, which includes the automatically generated ID:

json
Copy code
{
"id": 1,
"name": "Laptop",
"price": 999.99
}
Get a Product by ID (GET Request)
Click New > HTTP Request.

Change the request type to GET.
Set the URL to (replacing 1 with the ID of the product you want to retrieve):
http://localhost:8080/products/1
Click Send.

Response: 

json
Copy code
{
"id": 1,
"name": "Laptop",
"price": 999.99
}
Update a Product (PUT Request)
Click New > HTTP Request.
Change the request type to PUT.
(replacing 1 with the ID of the product you want to update):
http://localhost:8080/products/1
Go to the Body tab, select raw and JSON, and update the JSON object with the new values. For example:
json
Copy code
{
"name": "Updated Laptop",
"price": 899.99
}
Click Send.
Response: You should receive the updated product details:
json
Copy code
{
"id": 1,
"name": "Updated Laptop",
"price": 899.99
}
Delete a Product (DELETE Request)
Click New > HTTP Request.
Change the request type to DELETE.
 (replacing 1 with the ID of the product you want to delete):

http://localhost:8080/products/1
Response: The product should be deleted, and you might receive a 204 No Content or 200 OK status as confirmation. There will likely be no response body.
List All Products (GET Request)
Click New > HTTP Request.
Change the request type to GET.
http://localhost:8080/products
Click Send.
Response: You should receive a list of all products stored in the database:
json
Copy code
[
{
"id": 1,
"name": "Laptop",
"price": 999.99
},
{
"id": 2,
"name": "Phone",
"price": 499.99
}
]