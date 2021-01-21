package com.gzeinnumer.libadapterkt.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

interface ViewBindingInflater {

    val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> ViewBinding

}

@Suppress("UNCHECKED_CAST")
class AutomaticBindingInflater<T : ViewBinding>(private val cls : Class<T>) : ViewBindingInflater {

    override val bindingInflater get() = ::inflate

    private fun inflate(inflater: LayoutInflater, parent : ViewGroup?, attachToRoot : Boolean) : T {
        val method =  cls.getMethod("inflate")
        method.invoke(inflater, parent, attachToRoot)
        return method.invoke(inflater, parent, attachToRoot) as T
    }

}

inline fun <reified T : ViewBinding> AutomaticBindingInflater() : AutomaticBindingInflater<T>{
    return AutomaticBindingInflater(T::class.java)
}

fun playTest(){
//    val bindingInflater = AutomaticBindingInflater<MainBinding>()
}