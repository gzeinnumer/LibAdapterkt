package com.gzeinnumer.libadapterkt

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gzeinnumer.libadapterkt.databinding.ActivityMainBinding
import com.gzeinnumer.libadapterkt.databinding.ItemRvBinding
import com.gzeinnumer.libadapterkt.lib.RVB
import com.gzeinnumer.libadapterkt.test.AutomaticBindingInflater
import com.gzeinnumer.libadapterkt.test.BindViewHolder
import com.gzeinnumer.libadapterkt.test.RVBuilder

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = AutomaticBindingInflater<ActivityMainBinding>()

//        initView()
//        initView2()

    }

    private fun initView2() {
        val rvB = RVB(AutomaticBindingInflater<ItemRvBinding>())
    }

    private fun initView() {
        val list: MutableList<String> = mutableListOf()

        for (i in 0..29) {
            list.add(i.toString())
        }

        val rvBuilder = RVBuilder<ItemRvBinding>()
            .setItems(list)
            .setCustomNoItem(R.layout.custom_empty_data)
            .bind(object :
                BindViewHolder<ItemRvBinding> {

                override fun bind(holder: ItemRvBinding, position: Int) {
                    holder.tv.text = position.toString()
                    holder.root.setOnClickListener {
                        Toast.makeText(
                            this@MainActivity,
                            position.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
        val adapterCreator = rvBuilder.build()
        binding.rv.layoutManager = LinearLayoutManager(applicationContext)
        binding.rv.hasFixedSize()
        binding.rv.adapter = adapterCreator
    }
}