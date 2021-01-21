package com.gzeinnumer.libadapterkt

import android.view.LayoutInflater
import com.gzeinnumer.libadapterkt.databinding.ActivityTestBinding

//class TestActivity : BaseActivityFinal<ActivityTestBinding>() {
//    var i = 0
//
//    override fun setup() {
//
//        viewBindingApproach()
//    }
//
//    private fun viewBindingApproach() {
//        withBinding {
//            btnText.setOnClickListener { tvText.text = "The current click count is ${++i}"  }
//            btnText.performClick()
//        }
//
//    }
//
//    override fun attachBinding(
//        list: MutableList<ActivityTestBinding>,
//        layoutInflater: LayoutInflater
//    ) {
//        list.add(ActivityTestBinding.inflate(layoutInflater))
//    }
//}