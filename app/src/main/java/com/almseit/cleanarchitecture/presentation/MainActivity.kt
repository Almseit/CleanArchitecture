package com.almseit.cleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.almseit.cleanarchitecture.R
import com.almseit.cleanarchitecture.app.App

class MainActivity : AppCompatActivity() {


    @javax.inject.Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)
        Log.d("AAA", "Activity created")
        vm = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]
        val dataTextView = findViewById<TextView>(R.id.tvData)
        val dataEditText:EditText = findViewById(R.id.etData)
        val sendButton = findViewById<Button>(R.id.btSend)
        val receiveButton = findViewById<Button>(R.id.btReceive)


        vm.resultLD.observe(this, Observer{
            dataTextView.text = it
        })

        sendButton.setOnClickListener {
            // click button SAVE DATA
            val text = dataEditText.text.toString().trim()
            vm.save(text)
            //vm.resultLD.value = "" Не должно!!!

        }

        receiveButton.setOnClickListener {
            //click button GET DATA
            vm.load()
        }
    }
}