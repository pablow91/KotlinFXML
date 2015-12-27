# KotlinFXML

This project helps to bind FXML instances with Kotlin Controller fields during its initialization.

The main problem is that JavaFX can bind FXML instances with Java Controller fields by using @FXML
annotation (and it is a really great feature!) but when we start to use Kotlin Controller then this magic
does not work; see corresponding [Kotlin issue](https://devnet.jetbrains.com/message/5537479).

Others features of JavaFX Controllers work fine, this seems like a lack of functionality.

There are 2 ways to use my code:  
1. For Windows: run "gradlew.bat build". Otherwise, run the gradlew executable with "build" as the parameter. This will build the project and will make a library jar in the build/libs folder.  
2. Add AbstractLoadListener.kt, Binders.kt, and KotlinFXMLLoader.kt to your project.

To use the library, substitude
`@FXML val view: View` with `val view: View by bindFXML()` or `val view: View by bindOptionalFXML()`.
See [SampleController.kt](src/main/kotlin/eu/stosdev/SampleController.kt) for more examples.
