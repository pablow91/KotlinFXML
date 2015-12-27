package eu.stosdev

import javafx.application.Application
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class SampleApp : Application() {

    override fun start(primaryStage: Stage) {
        val parent: Parent = KotlinFXMLLoader(SampleApp::class.java.getResource("fxml_example.fxml")).load()
        val scene = Scene(parent, 800.0, 600.0);

        primaryStage.setTitle("Kotlin FXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

fun main(args: Array<String>) {
    Application.launch(SampleApp::class.java)
}