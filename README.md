# KotlinFXML

This project helps to bind FXML instances with Kotlin Controller fields during its initialization.

The main problem is that JavaFX can bind FXML instances with Java Controller fields by using @FXML
annotation (and it is really great feature!) but when we start to use Kotlin Controller then this magic
is not work, see corresponding [Kotlin issue](https://devnet.jetbrains.com/message/5537479).

Others features of JavaFX Controllers work fine and it seems as lack of functionality.

To use my code just put AbstractLoadListener.kt, Binders.kt and KotlinFXMLLoader.kt files to your project and substitude
`@FXML val view: View` to `val view: View by bindFXML()` or `val view: View by bindOptionalFXML()`.
See SampleController.kt file with example of the use.
