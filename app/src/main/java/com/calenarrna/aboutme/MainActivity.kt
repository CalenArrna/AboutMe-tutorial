package com.calenarrna.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.calenarrna.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Csabi Nagy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.myName = myNameq
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener {
            binding.apply {
                myName?.nickname = nicknameEdit.text.toString()
                invalidateAll()
                binding.nicknameEdit.visibility = View.GONE
                binding.doneButton.visibility = View.GONE
                binding.nicknameText.visibility = View.VISIBLE
                // Hide the keyboard.
                val inputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(binding.doneButton.windowToken, 0)
            }
        }
        binding.nicknameText.setOnClickListener {
            binding.apply {
                binding.nicknameText.visibility = View.GONE
                binding.nicknameEdit.visibility = View.VISIBLE
                binding.doneButton.visibility = View.VISIBLE
                binding.nicknameEdit.requestFocus()
                //show the keyboard?
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(binding.nicknameEdit, 0)
            }
        }
    }


}