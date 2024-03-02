package com.example.assignment2

import android.os.Bundle
import android.widget.EditText
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.assignment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val location = binding.locationEditText.text.toString()
            val type = binding.typeEditText.text.toString()

            if (name.isBlank() || location.isBlank() || type.isBlank()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            } else {
                addRowToTable(name, location, type)
                clearInputFields()
            }
        }
    }

    private fun addRowToTable(name: String, location: String, type: String) {
        val tableRow = TableRow(this).apply {
            layoutParams = TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
            )
        }

        tableRow.addView(createTextView(name,0.5f))
        tableRow.addView(createTextView(location,0.3f))
        tableRow.addView(createTextView(type,0.2f))

        binding.tableLayout.addView(tableRow)
    }

    private fun createTextView(text: String, weight: Float): TextView {
        return TextView(this).apply {
            this.text = text
            gravity = android.view.Gravity.LEFT
            background = ContextCompat.getDrawable(context, R.drawable.cell_border)
            setPadding(8, 8, 8, 8)
            layoutParams = TableRow.LayoutParams(
                0, // Width set to 0
                TableRow.LayoutParams.WRAP_CONTENT,

                weight // Weight as passed to the function
            )
        }
    }


    private fun clearInputFields() {
        binding.nameEditText.text.clear()
        binding.locationEditText.text.clear()
        binding.typeEditText.text.clear()
    }
}
