# Incident Management API with Microservices
## Project Overview
This project is a RESTful API built in Java to manage incidents within an organization. 
The API will implement CRUD (Create, Read, Update, Delete) operations for three main entities: Incident, ResponseTeam, and Notification. 
Each microservice will handle one of these entities and communicate with the others through Kafka message events.

## Project Architecture
The project is designed in a microservices architecture connected via Apache Kafka:

- Incident Service: Manages reported incidents.
- Response Team Service: Manages the response teams assigned to each incident.
- Notification Service: Sends notifications about incident status updates to users.
- Authentication Gateway Service: Manages user authentication and authorization.

## Microservice 3: Notification Service
- Entity: Notification
- Fields: id, incidentId, recipient, message, status (enum: SENT, FAILED), sentDate.
- Requirements:
  - Automatically send notifications to users when an incident is created or its status changes.
  - Track the status of sent notifications (sent, failed).
  - Listen to Kafka events for incidents with status changes and send automatic notifications.
- API Endpoints:
  - GET /notifications: Retrieve all notifications.
  - GET /notifications/{id}: Retrieve a specific notification.
  - POST /notifications: Manually send a notification (input: incidentId, recipient, message).
  - DELETE /notifications/{id}: Delete a notification.

___


## Kafka Event Handling
Each microservice listens to and produces events on Kafka:

1. Incident Service: Produces events whenever an incident is created or its status changes.
2. Response Team Service: Listens for events to automatically assign response teams to critical incidents, producing events when a team is assigned.
3. Notification Service: Listens for events and sends automatic notifications when an incident is created or changes status.

___ 
## Technical Requirements
- Data Validation: Each service should include data validation and detailed error handling.
- Swagger/OpenAPI: Automatic documentation generation for each microservice.
- Security: Basic authentication implementation for the microservices' endpoints.
- Logging and Monitoring: Services will generate structured logs to monitor event activity and operation status.

___

This architecture and structure will allow high scalability and modularity in incident management, distributing responsibilities across three well-defined microservices connected through Kafka. It facilitates a clear separation of business logic and maintains a low coupling between services, making it ideal for production environments where stability and performance are essential.
