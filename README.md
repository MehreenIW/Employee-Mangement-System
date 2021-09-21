# Employee-Mangement-System

<!-- ABOUT THE PROJECT -->
## About The Project

API Integration Project with Kimai and Bamboo's open API's. Kimai one way integration with Bamboo, to create employees from the Kimai System to the Bamboo System at defined intervals. Fields include the name of the employee and their role.
### Built With

Project Technology stack.
* Java
* Maven
* Spring Boot Framework

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple example steps.

### Prerequisites

* Install Java Runtime Environment or Java Development kit.
* Install Docker

### Installation

1. Create BambooHr account [Link](https://www.bamboohr.com/homepage-customer/) to create API key using Basic Authentication with your Username and Password.
2. Create Kimai account [Link](https://www.kimai.cloud/).
3. Clone the repo
   ```sh
   git clone https://github.com/MehreenIW/Employee-Mangement-System.git
   ```
3. Build the Docker image using maven package.
   ```sh
   mvn clean package
   ```
4. Run the Docker image using your Bamboo API and Kimai credentials to authenticate.
   ```txt
   docker run -e KIMAI_USERNAME=<Your Kimai username> -e KIMAI_PASSWORD=<Your Kimai password> -e BAMBOO_AUTHENTICATION=<Your Basic Authentication key for Bamboo> -t employee-management-system:0.0.1-SNAPSHOT <Number in minutes to schedule each run>
   ```


