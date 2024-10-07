package com.example.mytrainingsession.data

import android.content.Context
import com.example.mytrainingsession.R

class ExerciseDataBase {
    companion object {
        fun getExercises(context: Context): List<Exercise> {
            return listOf(
                Exercise(
                    name = context.getString(R.string.exercise_squat),
                    description = context.getString(R.string.desc_squat),
                    durationInSeconds = 30,
                    gifImage = R.drawable.squat
                ),
                Exercise(
                    name = context.getString(R.string.exercise_runninginplace),
                    description = context.getString(R.string.desc_runninginplace),
                    durationInSeconds = 30,
                    gifImage = R.drawable.runninginplace
                ),
                Exercise(
                    name = context.getString(R.string.exercise_pushup),
                    description = context.getString(R.string.desc_pushup),
                    durationInSeconds = 30,
                    gifImage = R.drawable.pushup
                ),
                Exercise(
                    name = context.getString(R.string.exercise_plank),
                    description = context.getString(R.string.desc_plank),
                    durationInSeconds = 30,
                    gifImage = R.drawable.plank
                ),
                Exercise(
                    name = context.getString(R.string.exercise_jump),
                    description = context.getString(R.string.desc_jump),
                    durationInSeconds = 30,
                    gifImage = R.drawable.jump
                ),
                Exercise(
                    name = context.getString(R.string.exercise_armraise),
                    description = context.getString(R.string.desc_armraise),
                    durationInSeconds = 30,
                    gifImage = R.drawable.armraise
                ),
                Exercise(
                    name = context.getString(R.string.exercise_legslift),
                    description = context.getString(R.string.desc_legslift),
                    durationInSeconds = 30,
                    gifImage = R.drawable.legslift
                ),
                Exercise(
                    name = context.getString(R.string.exercise_backlift),
                    description = context.getString(R.string.desc_backlift),
                    durationInSeconds = 30,
                    gifImage = R.drawable.backlift
                ),
                Exercise(
                    name = context.getString(R.string.exercise_chestlift),
                    description = context.getString(R.string.desc_chestlift),
                    durationInSeconds = 30,
                    gifImage = R.drawable.chestlift
                ),
                Exercise(
                    name = context.getString(R.string.exercise_handandlegslift),
                    description = context.getString(R.string.desc_handandlegslift),
                    durationInSeconds = 30,
                    gifImage = R.drawable.handandlegslift
                )
            )
        }
    }
}
