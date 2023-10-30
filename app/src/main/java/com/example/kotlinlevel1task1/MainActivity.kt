package com.example.kotlinlevel1task1

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinlevel1task1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var counter = 0
    private val adapter: MainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNT, 0)
            setData()
        }

        initViews()
    }

    @Override
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, counter)
    }

    private fun initViews() {
        val layoutManager = GridLayoutManager(this, getColumnCountByOrientation())
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        binding.addButton.setOnClickListener {
            counter++
            setData()
        }
    }

    private fun setData() {
        adapter.setData(generateDataForAdapter(counter))
    }

    private fun generateDataForAdapter(last: Int): List<Int> {
        val list = mutableListOf<Int>()
        for (i in 1..last) list.add(i)
        return list
    }

    private fun getColumnCountByOrientation(): Int {
        val orientation = resources.configuration.orientation
        return if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            4
        } else {
            3
        }
    }

    companion object {
        private const val KEY_COUNT = "COUNT"
    }
}