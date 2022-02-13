package com.example.kotlin_retrofit_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kotlin_retrofit_mvvm.databinding.ActivityMainBinding
import com.example.kotlin_retrofit_mvvm.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.user.observe(this, Observer {
         binding.textView3.setText("$it")
        })

        binding.button.setOnClickListener {

            viewModel.setUserId(binding.editTextTextPersonName.text.toString())
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }

}