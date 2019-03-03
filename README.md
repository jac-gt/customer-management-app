
## A demo Spring Boot application for managing customers using REST API

This is a Java Srping Boot application to perform CRUD operations using a REST API.

You can import the project into an IDE as a Maven project and run the main class

/customer-management/src/main/java/com/jlab/customermanagement/CustomerManagementApplication.java

To create a customer post data to the api /api/v1/customers. Example 
```
curl -i -X POST \
  http://localhost:8080/api/v1/customers \
  -H 'Content-Type: application/json' \
  -d '{  "fullName": { "firstName": "CustomerA", "lastName": "ALastName",  "middleName": "SomeMiddleName"  },
        "title": "Mr",
        "sex": "Male",
        "initials": "J",
        "maritalStatus": "Married",
        "creditRating": 50,
        "nabCustomer": true,
        "address": [
                {
                        "type": "Residence",
                        "unitNo": 1,
                        "streetName": "ABC Street",
                        "suburb": "XYZ Suburb",
                        "city": "Melbourne",
                        "state": "Vic",
                        "country": "Australia",
                        "pincode": "1000"
                },
                {
                        "type": "Mailing",
                        "unitNo": 100,
                        "streetName": "ABC Street",
                        "suburb": "DEF",
                        "city": "Perth",
                        "state": "WA",
                        "country": "Australia",
                        "pincode": "6000"
                }
        ]
}'
```
To read the customer details use the GET method

```
curl -i -X GET http://localhost:8080/api/v1/customers/1
```

To update a customer use the PUT method
```
curl -i -X PUT \
  http://localhost:8080/api/v1/customers/1 \
  -H 'Content-Type: application/json' \
  -d '{
    "fullName": {
        "firstName": "ModifiedCustomerA",
        "lastName": "ALastName",
        "middleName": "ABC"
    },
    "title": "Mr",
    "sex": "Male",
    "initials": "J",
    "maritalStatus": "Married",
    "creditRating": 50,
    "nabCustomer": true,
    "address": [
        {
            "type": "Residence",
            "unitNo": 1,
            "streetName": "ABC Street",
            "suburb": "XYZ Suburb",
            "city": "Melbourne",
            "state": "Vic",
            "country": "Australia",
            "pincode": "1000"
        },
        {
            "type": "Mailing",
            "unitNo": 100,
            "streetName": "ABC Street",
            "suburb": "DEF",
            "city": "Perth",
            "state": "WA",
            "country": "Australia",
            "pincode": "6000"
        }
    ]
}'
```
To delete a customer use the DELETE method

```
curl -i -X DELETE http://localhost:8080/api/v1/customers/1
```
