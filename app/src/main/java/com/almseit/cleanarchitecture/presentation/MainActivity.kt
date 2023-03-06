package com.almseit.cleanarchitecture.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.almseit.cleanArchitecture.data.repository.UserRepositoryImpl
import com.almseit.cleanArchitecture.data.storage.SharedPrefsUserStorage
import com.almseit.cleanArchitecture.domain.model.SaveUserNameParam
import com.almseit.cleanArchitecture.domain.useCase.GetUserNameUseCase
import com.almseit.cleanArchitecture.domain.useCase.SaveUserNameUseCase
import com.almseit.cleanarchitecture.R

class MainActivity : AppCompatActivity() {


    private val userRepository by lazy { UserRepositoryImpl(userStorage = SharedPrefsUserStorage(context = applicationContext)) }

    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository)}
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataTextView = findViewById<TextView>(R.id.tvData)
        val dataEditText:EditText = findViewById(R.id.etData)
        val sendButton = findViewById<Button>(R.id.btSend)
        val receiveButton = findViewById<Button>(R.id.btReceive)

        sendButton.setOnClickListener {
            // click button SAVE DATA
            val text = dataEditText.text.toString().trim()
            val params = SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(params)
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            //click button GET DATA
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}