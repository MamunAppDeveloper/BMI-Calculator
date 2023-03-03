package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.heightPicker.minValue = 10
        binding.heightPicker.maxValue = 250

        binding.weightPicker.minValue = 10
        binding.weightPicker.maxValue = 200

        binding.weightPicker.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }

        binding.heightPicker.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        val height = binding.heightPicker.value
        val doubleHeight = height.toDouble() / 100

        val weight = binding.weightPicker.value
        val BMI = weight.toDouble() / (doubleHeight * doubleHeight)

        binding.resultView.text = String.format("Your BMI is:%.2f",BMI)
        binding.healthView.text = String.format("You are: %s",healthyMessage(BMI))


    }

    private fun healthyMessage(bmi:Double):String
    {

        if (bmi < 18.0)
            return "Underweight"
        if (bmi < 25.0)
            return "Healthy"
        if (bmi < 30.0)
            return "Overweight"

        return "Obese"
    }
}


