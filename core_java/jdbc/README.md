# Introduction
This java app is named JDBC, which is used to read, write, update, and delete (CURD) data against an RDBMS database using JDBC. It is designed for a company that wants to save and manage information from customers, compute making and check orders from customers. We manage all the files by Maven. As this app's name given, we implement the app on Intellij with JDBC API. All data are saved and manipulated inside PostgreSQL. We create a container with the image that has PostgreSQL installed, then upload and access all the databases through docker.

# Implementaiton
## ER Diagram
![ER_Diagram](./assets/hplussport%20-%20public.png)

## Design Patterns
We have two types of DAO that are related to two different objects, one is Customer DAO and the other is for Order DAO. However, we now only have Customer DAO that is fully completed and these two are similar models, so the following DAO we will discuss would be only on Customer DAO.

We first create a customer DTO in order to manage to translate the customer's information as a whole object easily. Then, we would design CRUD inside our DAO.
- Create(C): We create a new customer object, save all the information inside this object by setter function, then connect to psql through JDBC, gain and send prepare statement. We would expect that the data will be created by executing "INSERT" in psql. The function will return a customer object to supervise if the data has been created.
- Read(R): We create a new customer object, then connect to psql through JDBC, gain and send prepare statement. From our table, we gain our customer information by finding them through the table by the unique key, customer_id, using the "SELECT" method. The function will return a customer object that reads from the table.
- UPDATE(U): We connect to psql through JDBC, gain and send prepare statement, then find the customer who needs to be updated by using the Read function. We then set the customer object with new information. Apply update by executing the "UPDATE" command in psql. The function will return a customer object to supervise if the data has been updated.
- Delete(D):  We connect to psql through JDBC, gain and send prepare statement, then find the customer who needs to be deleted by using the Read function. We then execute the "DELETE by customer_id" command on psql. This function is void function.
# Test
We first setup our database with data that is not real by executing the following command:
```bash
### Creating starter data
1. `psql -h localhost -U postgres -f database.sql`
2. `psql -h localhost -U postgres -d hplussport -f customer.sql`
3. `psql -h localhost -U postgres -d hplussport -f product.sql`
4. `psql -h localhost -U postgres -d hplussport -f salesperson.sql`
5. `psql -h localhost -U postgres -d hplussport -f orders.sql`


### Creating stored procedure
1. `psql -h localhost -U postgres -f stored_proc.sql`
```
After finish implementing, we test the DAO inside the JDBC Executor. For each tests, we would connect to psql through the docker to check if the execution is successful or not. All the results fulfil our expectations.