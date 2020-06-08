package com.example.kotlinplayground.recyclerview

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinplayground.R
import kotlinx.android.synthetic.main.activity_recyclerview.*

class SampleRecyclerViewActivity : AppCompatActivity() {
    private val arrData = arrayListOf(
        LocalData("Example 1"),
        LocalData("Example 2"),
        LocalData("Example 3"),
        LocalData("Example 4")
    )
    val localData: (LocalData) -> Unit = { localData ->
        toast(message = "You clicked mama ${localData.name}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        initRecyclerView()
    }

    fun Context.toast(
        context: Context = applicationContext,
        message: String,
        toastDuration: Int = Toast.LENGTH_SHORT
    ) {
        Toast.makeText(context, message, toastDuration).show()
    }

    fun Context.stringResToast(
        context: Context = applicationContext,
        message: Int,
        toastDuration: Int = Toast.LENGTH_SHORT
    ) {
        Toast.makeText(context, context.getString(message), toastDuration).show()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//            adapter =
//                MainAdapter(this@MainActivity, localData = arrData, onItemClickListener = object :
//                    OnItemClickListener {
//                    override fun onItemClicked(data: LocalData) {
//                        toast(message =data.name)
//                    }
//                })
//            adapter= MainAdapter(this@MainActivity, localData = arrData){
//                toast(message = "You clicked ${it.name}")
//            }
            adapter = SampleRecyclerAdapter(
                this@SampleRecyclerViewActivity, localData = arrData,
                onItemClickListener = localData
            )

        }


    }

    fun setPosition(name: String) {
        toast(message = "Androidly Short Toasts")

    }
}
