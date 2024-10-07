package com.example.mytrainingsession.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mytrainingsession.data.ExerciseDataBase
import com.example.mytrainingsession.R

class ExerciseListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_list)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = getString(R.string.train)

        val exerciseListView: ListView = findViewById(R.id.exerciseListView)
        val exercises = ExerciseDataBase.getExercises(this)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, exercises.map { it.name })
        exerciseListView.adapter = adapter

        exerciseListView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("exerciseIndex", position)
            }
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_exit -> {
                finishAffinity()
                Toast.makeText(this, getString(R.string.complete), Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

