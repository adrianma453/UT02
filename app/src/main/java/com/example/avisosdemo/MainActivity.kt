package com.example.avisosdemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.avisosdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnToastCorto.setOnClickListener {
            toast(getString(R.string.toast_short_text), Toast.LENGTH_SHORT)
        }

        binding.btnToastLargo.setOnClickListener {
            toast(R.string.toast_largo_text, Toast.LENGTH_LONG)
        }

        binding.btnSaludo.setOnClickListener {
            val nom = binding.etNombre.text.toString()
            if (nom.isNotBlank()) {
                toast(getString(R.string.hola_nombre, nom))
            } else {
                toast(getString(R.string.hola_nombre, "amigo"))
            }
        }
    }
}