package ir.MrMohamadHosein.neumorphism

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ir.MrMohamadHosein.neumorphism.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firstRunShowDialogWelcome()

        binding.btnGoToActivity2.setOnClickListener {
            val intent = Intent(this , MainActivity2::class.java)
            startActivity(intent)
        }

    }

    private fun firstRunShowDialogWelcome() {

        val shared = getSharedPreferences("mainSharedPref.xml", Context.MODE_PRIVATE)
        val isFirstRun = shared.getBoolean("isFirstRun", true)
        if (isFirstRun) {

            val dialog = AlertDialog.Builder(this)
            dialog.setMessage("")
            dialog.show()

            shared.edit().putBoolean("isFirstRun" , false).apply()
        }

    }

}