It is a simple exchange rate project. It retrieves the current rate from a free API and performs transactions.
Here is the all documentation for the API, including request and response examples.
API Documentation
Getting Exchange Rate
URL: /rate
Method: GET
Description: Returns the exchange rate between two specified currencies.
Parameters:
base (String) - Base currency (example: USD)
target (String) - Target currency (ex: EUR)
Sample request:
GET /api/forex/rate?base=USD&target=EUR
Sample response:
{
    "baseCurrency": "USD",
    "targetCurrency": "EUR",
    "rate": 0.85
}

Currency Conversion
URL: /convert
Method: POST
Description: Converts the specified amount of base currency to the target currency.
Parameters:
source (String) - Source currency (example: USD)
target (String) - Target currency (ex: EUR)
amount (Double) - Amount to convert
Sample Request:
POST /api/forex/convert?source=USD&target=EUR&amount=100
Sample response:
{
    "sourceCurrency": "USD",
    "targetCurrency": "EUR",
    "sourceAmount": 100.0,
    "targetAmount": 85.0,
    "
    transactionId": "d2c7eeb6-8a3e-4c55-9d12-3f42b1234567"
}

Currency Conversion History
URL: /history
Method: GET
Description: Returns the history of all currency conversion transactions.
Sample Request:
GET /api/forex/history
Sample response:
[
    {
        "sourceCurrency": "USD",
        "targetCurrency": "EUR",
        "sourceAmount": 100.0,
        "targetAmount": 85.0,
        "timestamp": "2024-07-29T12:34:56"
    },
    {
        "sourceCurrency": "GBP",
        "targetCurrency": "USD",
        "sourceAmount": 200.0,
        "targetAmount": 250.0,
        "timestamp": "2024-07-29T12:35:56"
    }

]


