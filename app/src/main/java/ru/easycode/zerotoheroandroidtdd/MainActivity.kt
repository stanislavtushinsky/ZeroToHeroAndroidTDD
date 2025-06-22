package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var textWatcher: TextWatcher
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var savedText = ""

        textWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int,
            ) = Unit

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int,
            ) {

            }

            override fun afterTextChanged(s: Editable?) {
                binding.actionButton.isEnabled = s?.length == 3
                savedText = binding.inputEditText.text.toString()
            }
        }

        binding.inputEditText.addTextChangedListener(textWatcher)

        binding.actionButton.setOnClickListener {
            binding.titleTextView.text = savedText
            binding.inputEditText.setText("")
            binding.actionButton.isEnabled = false
        }
    }
}