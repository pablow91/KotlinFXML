package eu.stosdev

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

public class bindFXML<T : Any> : ReadOnlyProperty<Any?, T> {
    private var value: T? = null

    public override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        val v = value
        if (v == null) {
            throw IllegalStateException("Node was not properly injected")
        }
        return v
    }
}

public class bindOptionalFXML<T : Any> : ReadOnlyProperty<Any?, T?> {
    private var value: T? = null

    public override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        return value
    }
}
