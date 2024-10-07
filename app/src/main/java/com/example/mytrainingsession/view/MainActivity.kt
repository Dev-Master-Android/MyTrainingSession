package com.example.mytrainingsession.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mytrainingsession.data.Exercise
import com.example.mytrainingsession.data.ExerciseDataBase
import com.example.mytrainingsession.R
import pl.droidsonroids.gif.GifImageView

class MainActivity : AppCompatActivity() {

    private lateinit var titleTV: TextView
    private lateinit var exerciseTV: TextView
    private lateinit var timerTV: TextView
    private lateinit var descriptionTV: TextView
    private lateinit var startBtn: Button
    private lateinit var continueBtn: Button
    private lateinit var gifIV: GifImageView

    private var exerciseIndex = 0
    private lateinit var currentExercise: Exercise
    private lateinit var timer: CountDownTimer

    private lateinit var exercises: List<Exercise>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        exercises = ExerciseDataBase.getExercises(this)
        exerciseIndex = intent.getIntExtra("exerciseIndex", 0)

        titleTV = findViewById(R.id.titleTV)
        exerciseTV = findViewById(R.id.exerciseTV)
        timerTV = findViewById(R.id.timerTV)
        descriptionTV = findViewById(R.id.descriptionTV)
        startBtn = findViewById(R.id.startBtn)
        continueBtn = findViewById(R.id.continueBtn)
        gifIV = findViewById(R.id.gifIV)

        startBtn.setOnClickListener {
            startWorkout()
        }
        continueBtn.setOnClickListener {
            continueWork()
        }
    }

    private fun continueWork() {
        timer.cancel()
        continueBtn.isEnabled = false
        startNextExercise()
    }

    private fun startWorkout() {
        titleTV.text = getString(R.string.title_training)
        startBtn.isEnabled = false
        startBtn.text = getString(R.string.train)
        gifIV.visibility = View.VISIBLE
        startNextExercise()
    }

    private fun startNextExercise() {
        if (exerciseIndex < exercises.size) {
            currentExercise = exercises[exerciseIndex]
            exerciseTV.text = currentExercise.name
            descriptionTV.text = currentExercise.description
            gifIV.setImageResource(currentExercise.gifImage)
            timerTV.text = formatTime(currentExercise.durationInSeconds)
            timer = object : CountDownTimer(
                currentExercise.durationInSeconds * 1000L,
                1000
            ) {
                override fun onTick(millisUntilFinished: Long) {
                    timerTV.text = formatTime((millisUntilFinished / 1000).toInt())
                }

                override fun onFinish() {
                    timerTV.text = getString(R.string.upr_complete)
                    gifIV.visibility = View.VISIBLE
                    continueBtn.isEnabled = true
                    gifIV.setImageResource(0)
                }
            }.start()
            exerciseIndex++
        } else {
            exerciseTV.text = getString(R.string.train_complete)
            descriptionTV.text = ""
            timerTV.text = ""
            gifIV.visibility = View.VISIBLE
            continueBtn.isEnabled = false
            startBtn.isEnabled = true
            startBtn.text = getString(R.string.start_again)
        }
    }

    @SuppressLint("DefaultLocale")
    private fun formatTime(seconds: Int): CharSequence {
        val minutes = seconds / 60
        val seconds = seconds % 60
        return String.format("%02d:%02d", minutes, seconds)
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

