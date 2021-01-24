package com.gzeinnumer.libadapterkt.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.gzeinnumer.libadapterkt.R

abstract class AdapterCreatorParent<VB : ViewBinding>(
    private val list: List<String>,
    private val emptyLayout: Int,
    private val bindViewHolder: BindViewHolder<VB>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
//    private var binding: VB? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (list.isEmpty()) {
            AdapterCreator.ViewHolderEmpty(
                LayoutInflater.from(parent.context).inflate(
                    if (emptyLayout == -1) R.layout.empty_item else emptyLayout,
                    parent,
                    false
                )
            )
        } else {
            AdapterCreator.ViewHolderNotEmpty(bindingInflater.invoke(LayoutInflater.from(parent.context), parent, false))
//            AdapterCreator.ViewHolderNotEmpty(bindingInflater.invoke(LayoutInflater.from(parent.context), parent, false))
        }
    }
}
