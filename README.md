# World-Information

## Features

- Angular Material UI tables are implemented in the GUI, allowing users to navigate through the data.

- Each table supports sorting by every column in ascending and descending order.

- Results are displayed across different pages, with users able to select the number of items per page and navigate to the next, previous, first, or last page of results.

- In the final part of the assignment, the displayed results differ from those mentioned in the case study. I encountered difficulty making the last query work with MyBatis, despite it running successfully on the database using MySQL Workbench during testing.

- Due to the issue mentioned above, I employed an alternative query to provide the remaining features that I could implement. This includes a fully functioning slider for filtering years and a dropdown connected to the backend, enabling users to make multiple selections and inform the server about them.

- Pagination is implemented by providing links from the API in a HATEOAS-like manner to the client. 

- A similar logic to the previous point is applied throughout the application to provide the displayed menu on the client, available sorting properties, available URIs and endpoints for each user option, and also the available parameters used in client-server HTTP communication. This ensures that the backend isn't tightly coupled to the frontend.

## Technologies

### Backend

- The backend of the application is written in Spring Boot with Java 8.
- MyBatis is utilized as the ORM.
- MariaDB is employed as the database.

### Frontend

- The frontend is developed in Angular.
- Material UI is used for the paginator, table, and filters in the GUI.

## Setup Info

- Database `port: 3306`
- Client `port: 4200`
- Backend `port: 8080`
