## Description of Changes
- Created a **custom error page** (`src/main/resources/templates/error.html`) to replace the default Spring Boot Whitelabel Error Page.  
- Added a **CustomErrorController** to ensure the new error page is shown for HTTP 404 responses.  
- Implemented a **unit test** (`ErrorPageTest`) using MockMvc to verify that the custom error page is returned with HTTP status 404.  
- Added a new **REST endpoint** `/time` that returns the current server time in JSON format.  
- Created a **TimeDTO** data class to represent the time response.  
- Added a **TimeProvider** interface and a `TimeService` implementation to make time retrieval testable and flexible.  
- Implemented an **extension function** `LocalDateTime.toDTO()` to easily convert the current time into a `TimeDTO`.  
- Added a **test** to ensure the `/time` endpoint returns a JSON response with a 200 OK status.  
- Configured the server to run over **HTTPS** using a **self-signed SSL certificate** (`localhost.p12`).  
- Enabled **HTTP/2** support in the application configuration and verified the secure endpoint manually in the browser.  

## Technical Decisions
- Used **Thymeleaf** for the error page because it integrates naturally with Spring Boot templates.  
- Added a **CustomErrorController** since Spring Boot 3.x no longer automatically uses `error.html` without it.  
- Used **MockMvc** for testing because it allows simulating HTTP requests without running the full server.  
- Created a **TimeProvider interface** and used **dependency injection** to keep the time logic flexible and easy to mock in tests.  
- Added an **extension function** to improve code readability and avoid repetitive object creation when converting `LocalDateTime` to `TimeDTO`.  
- Used a **self-signed SSL certificate** to enable HTTPS locally and configured **HTTP/2** since it is fully supported by Spring Boot with Tomcat.  
- Verified the HTTPS endpoint manually using the browser and command-line tools instead of automated tests, as MockMvc does not handle TLS.  

## Learning Outcomes
- Learned how to **replace the Whitelabel Error Page** with a custom HTML page in Spring Boot.  
- Understood how to use **MockMvc** to test HTTP responses in a Spring Boot + Kotlin project.  
- Learned that in Spring Boot 3.x a **CustomErrorController** is required to display custom error pages correctly.  
- Learned how to **create a REST endpoint** in Kotlin with Spring Boot and return structured JSON responses.  
- Understood the benefits of **interfaces and dependency injection** for making code easier to test and extend.  
- Learned how to use **extension functions** in Kotlin to write cleaner and more readable code.  
- Learned how to **enable HTTPS and HTTP/2** in a Spring Boot application using a self-signed certificate and test it manually in a local environment.  

## AI Disclosure
### AI Tools Used
- Chatgpt   

### AI-Assisted Work
- The AI provided **guidance and examples** for implementing the custom error page and the `CustomErrorController` required in Spring Boot 3.x.  
- Suggested how to write the **unit test** (`ErrorPageTest`) with MockMvc and how to structure assertions to validate the 404 custom page.  
- Explained how to create the **/time REST endpoint**, including the `TimeDTO` data class, the `TimeProvider` interface, the `TimeService` implementation, and the `LocalDateTime.toDTO()` extension function.  
- Gave detailed instructions for **generating and configuring a self-signed SSL certificate**, enabling **HTTPS** and **HTTP/2**, and verifying the secure endpoint.  
- Helped troubleshoot **test failures** and library import issues (Hamcrest, MockMvc).  
- Percentage of AI-assisted vs. original work: **≈40% AI-assisted / 60% user work**.  
- Modifications: I adjusted and integrated the AI suggestions into the real project, fixed package names, and adapted the tests to the actual HTML content.

### Original Work
- Set up the **development environment** (Gradle, Kotlin, Spring Boot), organized the **project structure**, and managed file locations correctly.  
- Wrote and **executed the code** following the guidance: created the `error.html`, implemented the `CustomErrorController`, added the `/time` endpoint, and created the `TimeDTO` and service classes.  
- Solved **build issues and import errors**, configured dependencies, and ensured the project compiled and tests passed.  
- Installed and configured **OpenSSL** on Windows, fixed PATH issues, and successfully generated the SSL certificate.  
- Ran and verified the application manually using `curl` and the browser, ensuring HTTPS and HTTP/2 were active.  
- Learned and applied concepts such as **dependency injection**, DTOs, extension functions in Kotlin, and manual server testing with custom configurations.  
