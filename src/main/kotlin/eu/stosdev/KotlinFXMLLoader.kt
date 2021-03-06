package eu.stosdev

import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.util.BuilderFactory
import java.net.URL
import java.util.ArrayList
import java.util.ResourceBundle

object KotlinFXMLLoader {
    fun load<T>(location: URL, resources: ResourceBundle? = null, builderFactory: BuilderFactory? = null): T {
        val fxmlLoader = FXMLLoader()
        fxmlLoader.setLocation(location)
        fxmlLoader.setResources(resources)
        fxmlLoader.setBuilderFactory(builderFactory)
        fxmlLoader.impl_setLoadListener(object : AbstractLoadListener() {

            var counter = 0

            override fun beginInstanceDeclarationElement(type: Class<*>?) {
                counter++
            }

            override fun endElement(value: Any?) {
                //If created element has 'id' set try to inject to bindFXML or bindOptionalFXML field delegate
                if (value is Node && value.getId() != null) {
                    val controller: Any = fxmlLoader.getController()
                    try {
                        val field = controller.javaClass.getDeclaredField("${value.getId()}\$delegate")
                        if (field.getType() == javaClass<bindFXML<Node>>() || field.getType() == javaClass<bindOptionalFXML<Node>>()) {
                            field.setAccessible(true)
                            val delegate: Any = field.get(controller)
                            val valueField = delegate.javaClass.getDeclaredField("value")
                            valueField.setAccessible(true)
                            val fieldType = controller.javaClass.getMethod("get${value.getId().capitalize()}").getReturnType()
                            //Check if field type and created object have compatible types
                            if (!fieldType.isInstance(value)) {
                                throw IllegalArgumentException("Node '${value.getId()}' type [${value.javaClass.getName()}] is is not subtype of [${fieldType.getName()}] ")
                            }
                            valueField.set(delegate, value)
                            valueField.setAccessible(false)
                            field.setAccessible(false)
                        }
                    } catch (e: NoSuchFieldException) {
                        println("No field for element ${value.getId()}")
                    }
                }
                counter--;

                //When counter is 0 the root tag has been closed.
                //Now is good time to validate if all fields with bindFXML are set
                if (counter == 0) {
                    val controller: Any = fxmlLoader.getController()
                    val invalidFields = controller.javaClass.getDeclaredFields().filter {
                        if (javaClass<bindFXML<Node>>() != it.getType()) {
                            return@filter false
                        }
                        try {
                            it.setAccessible(true)
                            val valueField = it.getType().getDeclaredField("value")
                            valueField.setAccessible(true)
                            if (valueField.get(it.get(controller)) == null) {
                                return@filter true
                            }
                        } finally {
                            it.setAccessible(false)
                        }
                        return@filter false
                    } map { it.getName().substringBefore("$") } toCollection ArrayList<String>()
                    if (invalidFields.isNotEmpty()) {
                        throw IllegalStateException("Those field ${invalidFields} has not been injected. It they are optional use bindOptionalFXML()")
                    }
                }
            }
        })
        return fxmlLoader.load()
    }
}
