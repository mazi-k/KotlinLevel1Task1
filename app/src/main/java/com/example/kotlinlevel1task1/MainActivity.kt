package com.example.kotlinlevel1task1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinlevel1task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var counter = 0

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNT, 0)
            setData()
        }

        binding.addButton.setOnClickListener {
            updateData()
        }
    }

    @Override
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, counter)
    }

    private fun setData() {
        binding.counter.text = counter.toString()
        for (i in (1..counter)) {
            val frame = ScrollView(this)
            layoutInflater.inflate(R.layout.square_item, frame)
            binding.gridLayout.addView(frame)
            val square = frame.findViewById<Button>(R.id.square)
            square.text = i.toString()
        }
    }

    private fun updateData() {
        counter++
        binding.counter.text = counter.toString()
        val frame = ScrollView(this)
        layoutInflater.inflate(R.layout.square_item, frame)
        binding.gridLayout.addView(frame)
        val square = frame.findViewById<Button>(R.id.square)
        square.text = counter.toString()

    }

    companion object {
        private const val KEY_COUNT = "COUNT"
    }
}