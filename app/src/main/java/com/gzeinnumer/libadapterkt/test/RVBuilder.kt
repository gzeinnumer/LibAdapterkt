package com.gzeinnumer.libadapterkt.test

import androidx.viewbinding.ViewBinding

class RVBuilder<VB : ViewBinding>() {

    private lateinit var bindViewHolder: BindViewHolder<VB>
    private var list: List<String>? = null
    private var emptyLayout = -1

    fun setItems(list: List<String>?): RVBuilder<VB> {
        this.list = list
        return this
    }

    fun setCustomNoItem(emptyLayout: Int): RVBuilder<VB> {
        this.emptyLayout = emptyLayout
        return this
    }

    fun bind(bindViewHolder: BindViewHolder<VB>): RVBuilder<VB> {
        this.bindViewHolder = bindViewHolder
        return this
    }

    fun build(): AdapterCreator<VB> {
        return AdapterCreator(
            list!!,
            emptyLayout,
            object : BindViewHolder<VB> {
                override fun bind(holder: VB, position: Int) {
                    bindViewHolder.bind(holder, position)
                }
            })
    }

}