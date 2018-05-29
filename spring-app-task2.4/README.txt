Task 4 (20 points)
Part1. Implement spring app and JUnit tests for it. Use annotations for beans configuration.
1. Implement services using dependency injection by type on field, constructor, setter
    ok (ServiceWrapper)
2. Implement a service: populate field values from properties file (e.g. database
connection service)
    ok (ServiceWrapper)
3. Implement a service using dependency injection by name, use different scope
    ok (SingletonAndPrototypeService)
4. Implement bean factory with annotations
    ok (BeanFactoryService)
5. Implement beans configuration as Java class using annotations
    ok (Application Config)

Part2. Implement Spring standalone app
1. Configure beans using xml
2. Use different bean scope (singleton, prototype)
3. Use factory-method (singleton) and factory-bean (service locator), implement
FactoryBean interface
4. Pass bean references, string constants and primitive types as constructor
parameters via xml configuration
5. Use setter approach for passing bean parameters
6. Divide complex xml configs into a few simple
7. Implement bean which sets property username=”Awesome» in spring context
8. Implement bean that sends message to log at initialization and destroy phases