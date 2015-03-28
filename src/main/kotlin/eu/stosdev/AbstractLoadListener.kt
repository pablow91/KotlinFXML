package eu.stosdev

import com.sun.javafx.fxml.LoadListener

open class AbstractLoadListener : LoadListener {
    override fun readLanguageProcessingInstruction(language: String?) {
    }

    override fun beginUnknownTypeElement(name: String?) {
    }

    override fun beginScriptElement() {
    }

    override fun beginUnknownStaticPropertyElement(name: String?) {
    }

    override fun beginReferenceElement() {
    }

    override fun readInternalAttribute(name: String?, value: String?) {
    }

    override fun readComment(comment: String?) {
    }

    override fun readPropertyAttribute(name: String?, sourceType: Class<*>?, value: String?) {
    }

    override fun endElement(value: Any?) {
    }

    override fun beginInstanceDeclarationElement(type: Class<*>?) {
    }

    override fun readEventHandlerAttribute(name: String?, value: String?) {
    }

    override fun beginIncludeElement() {
    }

    override fun beginRootElement() {
    }

    override fun readImportProcessingInstruction(target: String?) {
    }

    override fun beginPropertyElement(name: String?, sourceType: Class<*>?) {
    }

    override fun readUnknownStaticPropertyAttribute(name: String?, value: String?) {
    }

    override fun beginDefineElement() {
    }

    override fun beginCopyElement() {
    }

}