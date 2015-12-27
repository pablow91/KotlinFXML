package eu.stosdev

import javafx.fxml.FXML
import javafx.scene.control.Button

public class SampleController {

    //Normal binding using property delegation
    val button: Button by bindFXML()
    //Alternative syntax
    //val button by bindFXML<Button>()

    //Optional button which is present in FXML
    val optionalButton: Button? by bindOptionalFXML()
    //Optional button which is not present in FXML
    val nonExistingButton: Button? by bindOptionalFXML()

    //This button is not present in FXML - cause exception after initialize method
    //val shouldNotExists: Button by bindFXML()

    fun initialize() {
        println("SampleController")
        println("button ${button}")
        println("optional ${optionalButton}")
        println("nonExistingButton ${nonExistingButton}")
    }

    //Method invoked by pressing top button
    @FXML fun test() {
        println("First button clicked")
    }

}
