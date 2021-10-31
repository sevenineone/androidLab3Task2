package ru.spbstu.lab2task2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import ru.spbstu.lab2task2.databinding.Activity2Binding
import android.view.Menu


class Activity2 : AppCompatActivity() {

    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        binding.toFirst.setOnClickListener {
            finish()
        }
        binding.toThird.setOnClickListener {
            startActivityForResult(
                Intent(
                    this,
                    Activity3::class.java
                ), 1
            )
        }
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.activity_about -> {
                startActivity(Intent(this, ActivityAbout::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}