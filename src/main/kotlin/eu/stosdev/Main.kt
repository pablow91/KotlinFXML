package eu.stosdev

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class UberControllerImpl() : UberController() {

}

class SampleApp : Application() {

    override fun start(primaryStage: Stage) {
        val mainController = UberControllerImpl()
        primaryStage.setScene(Scene(mainController.root, 600.0, 400.0))
        primaryStage.show()

        /*val resource = javaClass<SampleApp>().getResource("test.fxml")
        val parser = FXMLParser(resource)
        parser.load<VBox>()
        println(parser.getClassCode(javaClass<SampleApp>().getPackage().toString(), "UberController"))
        System.exit(0)
        VBox().getChildren()*/
    }

}

fun main(args: Array<String>) {
    Application.launch(javaClass<SampleApp>())
}