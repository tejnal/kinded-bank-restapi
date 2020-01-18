### Spring boot2 Restful application with spring data jpa

#Tech stack:
Spring boot2 , Spring rest, spring data jpa, h2 database, mysql

## Overview 
This is simple banking application where we can perform below rest calls 

- POST : http://localhost:8080/accounts/new -- Create customer account 
- GET  : http://localhost:8080/accounts/all  -- It will list out all the customer accounts with deposits and withdrawals
- GET  : http://localhost:8080/accounts/{id} -- List all the customer transactions with by customerId
- PUT  : http://localhost:8080/accounts/2?amount={VALUE} -- Update customer account balance
- DELETE : http://localhost:8080/accounts/{id} -- Delete customer account by customerId
- GET : http://localhost:8080/accounts/{id}/deposits  -- List all the deposits by customerId;
- GET : http://localhost:8080/accounts/{id}/withdrawals  -- List all the withdrawals by customerId;
- POST : http://localhost:8080/accounts/{id}/withdrawal - perform withdrawal on single customer account 
- POST : http://localhost:8080/accounts/{id}/withdrawal - perform deposit on single customer account 

