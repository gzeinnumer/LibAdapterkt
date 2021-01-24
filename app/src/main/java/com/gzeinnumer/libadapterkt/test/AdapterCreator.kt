package com.gzeinnumer.libadapterkt.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.gzeinnumer.libadapterkt.test.BindViewHolder

class AdapterCreator<VB : ViewBinding>(private val list: List<String>,
                                       private val emptyLayout: Int,
                                       private val bindViewHolder: BindViewHolder<VB>
) : AdapterCreatorParent<VB>(list, emptyLayout, bindViewHolder) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //holder.itemView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), GblVariabel.anim));
        if (list.isNotEmpty()) bindViewHolder.bind((holder as ViewHolderNotEmpty) as VB, position)
    }

    override fun getItemCount(): Int {
        return if (list.isNotEmpty()) list.size else 1
    }

    class ViewHolderNotEmpty(itemView: ViewBinding) : RecyclerView.ViewHolder(itemView.root){
        var binding = itemView
    }
    class ViewHolderEmpty(itemView: View) : RecyclerView.ViewHolder(itemView)

//    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
//        get() = TODO("Not yet implemented")
}