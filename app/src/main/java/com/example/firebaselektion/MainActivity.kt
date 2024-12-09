package com.example.firebaselektion

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.firebaselektion.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var vm : PersonViewModel
    lateinit var personAdapter: ArrayAdapter<Person>

    val persons = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        vm = ViewModelProvider(this).get(PersonViewModel::class.java)

        personAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, persons)
        binding.lvPersons.adapter = personAdapter

        vm.persons.observe(this){ personList ->
            persons.clear()
            persons.addAll(personList)
            personAdapter.notifyDataSetChanged()
        }

        binding.addBtn.setOnClickListener {
            addPerson()
        }
    }

    fun addPerson() {
        if(binding.etName.text.isNotBlank() && binding.etPhone.text.isNotBlank()) {
            val name = binding.etName.text.toString()
            val phone = binding.etPhone.text.toString()

            vm.addPerson(name, phone)
        }
    }
}