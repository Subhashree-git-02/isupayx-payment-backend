# iSupayX Payment Backend

A Spring Boot REST API developed as part of the iSupayX payment API assessment.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API

## Features

- Create Merchant
- Get Merchant by Merchant ID
- Create Payment
- Get Payment by Payment ID
- Duplicate Payment validation
- MySQL database persistence

## API Endpoints

### Merchant

POST
`/api/merchants`

GET
`/api/merchants/{merchantId}`

### Payment

POST
`/api/payments`

GET
`/api/payments/{paymentId}`

## Database

MySQL database used for storing merchant and payment information.

## How to Run

```bash
mvnw.cmd spring-boot:run


The application will start at:
http://localhost:8080
