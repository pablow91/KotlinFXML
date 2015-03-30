package eu.stosdev

import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.VBox

public abstract class UberController {
    val root: Parent
    val button: Button
    val optionalButton: Button
    val no_button: Button

    init {
        button = Button()
        button.setMnemonicParsing(false)
        button.setId("button")
        button.setLayoutX(273.0)
        button.setLayoutY(82.0)
        button.setText("Button")
        optionalButton = Button()
        optionalButton.setMnemonicParsing(false)
        optionalButton.setId("optionalButton")
        optionalButton.setLayoutX(273.0)
        optionalButton.setLayoutY(139.0)
        optionalButton.setText("Button")
        no_button = Button()
        no_button.setMnemonicParsing(false)
        no_button.setId("no_button")
        no_button.setLayoutX(273.0)
        no_button.setLayoutY(198.0)
        no_button.setText("Button")
        val object0 = AnchorPane()
        object0.setPrefHeight(-1.0)
        object0.setMaxHeight(-1.0)
        object0.setPrefWidth(-1.0)
        object0.setMaxWidth(-1.0)
        object0.getChildren().add(button)
        object0.getChildren().add(optionalButton)
        object0.getChildren().add(no_button)
        val object1 = VBox()
        object1.setPrefHeight(400.0)
        object1.setPrefWidth(640.0)
        object1.getChildren().add(object0)
        root = object1
    }
}
