package xyz.teamgravity.explosionfab

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import xyz.teamgravity.explosionfab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation = AnimationUtils.loadAnimation(this, R.anim.circle_scale).apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
        }

        binding.apply {
            explosionB.setOnClickListener {
                explosionB.visibility = View.INVISIBLE
                animationView.visibility = View.INVISIBLE

                animationView.startAnimation(animation) {
                    // animation end callback
                    root.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.purple_500))
                    animationView.visibility = View.INVISIBLE
                }
            }
        }
    }
}