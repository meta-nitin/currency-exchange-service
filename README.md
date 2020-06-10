# currency-exchange-service
A simple micro service that stores currency multiple factor of one currency to another in an in-memory database. It is a spring cloud client project that makes use of Eureka and Zuul. In order to understand proper use of load balancing using Ribbon, start multiple instances of the micro service on another port (eg 8001).

URL :
1. http://localhost:8000/currencyExchange/{from}-to-{to}
      
      example --> http://localhost:8000/currencyExchange/USD-to-INR
      
2. http://localhost:8765/currency-exchange-service/currencyExchange/{from}-to-{to}
      
      example --> http://localhost:8765/currency-exchange-service/currencyExchange/USD-to-INR
   
   This is a Zuul gateway version of above url(1).
