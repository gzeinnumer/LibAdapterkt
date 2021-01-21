package com.gzeinnumer.libadapterkt.test

import androidx.viewbinding.ViewBinding

interface BindViewHolder<VB : ViewBinding> {
    fun bind(holder: VB, position: Int)
}