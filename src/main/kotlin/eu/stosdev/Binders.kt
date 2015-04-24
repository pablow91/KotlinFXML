package eu.stosdev

import kotlin.properties.ReadOnlyProperty

public class bindFXML<T : Any> : ReadOnlyProperty<Any?, T> {
    private var value: T? = null

    public override fun get(thisRef: Any?, desc: PropertyMetadata): T {
        val v = value
        if (v == null) {
            throw IllegalStateException("Node was not properly injected")
        }
        return v
    }
}

public class bindOptionalFXML<T : Any> : ReadOnlyProperty<Any?, T?> {
    private var value: T? = null

    public override fun get(thisRef: Any?, desc: PropertyMetadata): T? {
        return value
    }
}