package eu.stosdev

import javafx.scene.Node
import kotlin.properties.ReadOnlyProperty

public class bindFXML<T : Node> : ReadOnlyProperty<Any?, T> {
    private var value: T? = null

    public override fun get(thisRef: Any?, desc: PropertyMetadata): T {
        val v = value
        if (v == null) {
            throw IllegalStateException("Node was not properly injected")
        }
        return v
    }
}

public class bindOptionalFXML<T : Node> : ReadOnlyProperty<Any?, T?> {
    private var value: T? = null

    public override fun get(thisRef: Any?, desc: PropertyMetadata): T? {
        return value
    }
}