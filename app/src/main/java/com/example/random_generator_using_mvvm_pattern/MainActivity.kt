package com.example.random_generator_using_mvvm_pattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RandomViewModel
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.rndNum)
        button = findViewById(R.id.getRnd)

        val provider = ViewModelProvider(this)
        viewModel = provider.get(RandomViewModel::class.java)
        initView()
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.currentRandomNumber.observe(this, Observer {
            editText.setText(it.toString())
        })
    }

    fun initView() {
        button.setOnClickListener {
            viewModel.generateRandomNumber()
        }
    }
}