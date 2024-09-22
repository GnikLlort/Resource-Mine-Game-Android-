package com.example.myapplication

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Declare variables for resources
    private var waterAmount = 0
    private var ironAmount = 0
    private var woodAmount = 0
    private var goldAmount = 0
    private var helium3Amount = 0

    // Declare variables for mine levels
    private var waterLevel = 1
    private var ironLevel = 1
    private var woodLevel = 1
    private var goldLevel = 1
    private var helium3Level = 1

    // Declare variables for storage limits
    private var waterStorage = 5000
    private var ironStorage = 5000
    private var woodStorage = 5000
    private var goldStorage = 5000
    private var helium3Storage = 5000

    // SharedPreferences for saving/loading resources
    private lateinit var sharedPreferences: SharedPreferences

    // TextView references
    private lateinit var tvWater: TextView
    private lateinit var tvIron: TextView
    private lateinit var tvWood: TextView
    private lateinit var tvGold: TextView
    private lateinit var tvHelium3: TextView

    private lateinit var tvWaterLevel: TextView
    private lateinit var tvIronLevel: TextView
    private lateinit var tvWoodLevel: TextView
    private lateinit var tvGoldLevel: TextView
    private lateinit var tvHelium3Level: TextView

    private lateinit var tvWaterStorage: TextView
    private lateinit var tvIronStorage: TextView
    private lateinit var tvWoodStorage: TextView
    private lateinit var tvGoldStorage: TextView
    private lateinit var tvHelium3Storage: TextView

    private lateinit var tvWaterGeneration: TextView
    private lateinit var tvIronGeneration: TextView
    private lateinit var tvWoodGeneration: TextView
    private lateinit var tvGoldGeneration: TextView
    private lateinit var tvHelium3Generation: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("game_data", MODE_PRIVATE)

        // Reference TextViews
        tvWater = findViewById(R.id.tvWater)
        tvIron = findViewById(R.id.tvIron)
        tvWood = findViewById(R.id.tvWood)
        tvGold = findViewById(R.id.tvGold)
        tvHelium3 = findViewById(R.id.tvHelium3)

        tvWaterLevel = findViewById(R.id.tvWaterLevel)
        tvIronLevel = findViewById(R.id.tvIronLevel)
        tvWoodLevel = findViewById(R.id.tvWoodLevel)
        tvGoldLevel = findViewById(R.id.tvGoldLevel)
        tvHelium3Level = findViewById(R.id.tvHelium3Level)

        tvWaterStorage = findViewById(R.id.tvWaterStorage)
        tvIronStorage = findViewById(R.id.tvIronStorage)
        tvWoodStorage = findViewById(R.id.tvWoodStorage)
        tvGoldStorage = findViewById(R.id.tvGoldStorage)
        tvHelium3Storage = findViewById(R.id.tvHelium3Storage)

        tvWaterGeneration = findViewById(R.id.tvWaterGeneration)
        tvIronGeneration = findViewById(R.id.tvIronGeneration)
        tvWoodGeneration = findViewById(R.id.tvWoodGeneration)
        tvGoldGeneration = findViewById(R.id.tvGoldGeneration)
        tvHelium3Generation = findViewById(R.id.tvHelium3Generation)

        // Load previously saved resource values
        loadResources()
        // Start the resource generation process
        startResourceGeneration()

        // Set upgrade button listeners
        findViewById<Button>(R.id.btnUpgradeWaterMine).setOnClickListener { upgradeMine("water") }
        findViewById<Button>(R.id.btnUpgradeIronMine).setOnClickListener { upgradeMine("iron") }
        findViewById<Button>(R.id.btnUpgradeWoodMine).setOnClickListener { upgradeMine("wood") }
        findViewById<Button>(R.id.btnUpgradeGoldMine).setOnClickListener { upgradeMine("gold") }
        findViewById<Button>(R.id.btnUpgradeHelium3Mine).setOnClickListener { upgradeMine("helium3") }
    }

        // Does the upgrades and stuff.
        // Checks if there is enough resources to upgrade.

        private fun upgradeMine(mineType: String) {
        val upgradeCost = 500 // Define the cost for upgrading (modify as needed)

        when (mineType) {
            "water" -> {
                if (waterLevel < 10 && waterAmount >= upgradeCost) {
                    waterLevel++
                    waterStorage += 500
                    waterAmount -= upgradeCost // Deduct the cost
                } else {
                    showToast("Not enough resources to upgrade Water Mine!")
                }
            }
            "iron" -> {
                if (ironLevel < 10 && ironAmount >= upgradeCost) {
                    ironLevel++
                    ironStorage += 500
                    ironAmount -= upgradeCost // Deduct the cost
                } else {
                    showToast("Not enough resources to upgrade Iron Mine!")
                }
            }
            "wood" -> {
                if (woodLevel < 10 && woodAmount >= upgradeCost) {
                    woodLevel++
                    woodStorage += 500
                    woodAmount -= upgradeCost // Deduct the cost
                } else {
                    showToast("Not enough resources to upgrade Wood Mine!")
                }
            }
            "gold" -> {
                if (goldLevel < 10 && goldAmount >= upgradeCost) {
                    goldLevel++
                    goldStorage += 500
                    goldAmount -= upgradeCost // Deduct the cost
                } else {
                    showToast("Not enough resources to upgrade Gold Mine!")
                }
            }
            "helium3" -> {
                if (helium3Level < 10 && helium3Amount >= upgradeCost) {
                    helium3Level++
                    helium3Storage += 500
                    helium3Amount -= upgradeCost // Deduct the cost
                } else {
                    showToast("Not enough resources to upgrade Helium-3 Mine!")
                }
            }
        }
        updateUI() // Update the UI after upgrading
    }

    // Function to show toast messages
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Function to load resources from SharedPreferences
    private fun loadResources() {
        waterAmount = sharedPreferences.getInt("water", 0)
        ironAmount = sharedPreferences.getInt("iron", 0)
        woodAmount = sharedPreferences.getInt("wood", 0)
        goldAmount = sharedPreferences.getInt("gold", 0)
        helium3Amount = sharedPreferences.getInt("helium3", 0)

        waterLevel = sharedPreferences.getInt("waterLevel", 1)
        ironLevel = sharedPreferences.getInt("ironLevel", 1)
        woodLevel = sharedPreferences.getInt("woodLevel", 1)
        goldLevel = sharedPreferences.getInt("goldLevel", 1)
        helium3Level = sharedPreferences.getInt("helium3Level", 1)

        // Load storage limits
        waterStorage = 5000 + (waterLevel - 1) * 500
        ironStorage = 5000 + (ironLevel - 1) * 500
        woodStorage = 5000 + (woodLevel - 1) * 500
        goldStorage = 5000 + (goldLevel - 1) * 500
        helium3Storage = 5000 + (helium3Level - 1) * 500

        updateUI() // Update UI after loading resources
    }

    // Function to start auto-generating resources periodically
    private fun startResourceGeneration() {
        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                // Increment resource amounts based on generation rates
                if (waterAmount < waterStorage) waterAmount += waterLevel * 5
                if (ironAmount < ironStorage) ironAmount += ironLevel * 5
                if (woodAmount < woodStorage) woodAmount += woodLevel * 5
                if (goldAmount < goldStorage) goldAmount += goldLevel * 5
                if (helium3Amount < helium3Storage) helium3Amount += helium3Level * 5

                saveResources() // Save updated resource values
                updateUI() // Update UI with the latest values

                // Schedule the next resource generation
                handler.postDelayed(this, 1000) // Every second
            }
        }
        handler.post(runnable) // Start the runnable
    }

    // Function to save current resource values and levels to SharedPreferences
    private fun saveResources() {
        val editor = sharedPreferences.edit()
        editor.putInt("water", waterAmount)
        editor.putInt("iron", ironAmount)
        editor.putInt("wood", woodAmount)
        editor.putInt("gold", goldAmount)
        editor.putInt("helium3", helium3Amount)

        editor.putInt("waterLevel", waterLevel)
        editor.putInt("ironLevel", ironLevel)
        editor.putInt("woodLevel", woodLevel)
        editor.putInt("goldLevel", goldLevel)
        editor.putInt("helium3Level", helium3Level)

        editor.apply() // Commit changes to SharedPreferences
    }

    // Function to update the UI with the current resource values, levels, and generation rates
    @SuppressLint("SetTextI18n")
    private fun updateUI() {
        tvWater.text = "Water: $waterAmount"
        tvIron.text = "Iron: $ironAmount"
        tvWood.text = "Wood: $woodAmount"
        tvGold.text = "Gold: $goldAmount"
        tvHelium3.text = "Helium-3: $helium3Amount"

        tvWaterLevel.text = "Level: $waterLevel"
        tvIronLevel.text = "Level: $ironLevel"
        tvWoodLevel.text = "Level: $woodLevel"
        tvGoldLevel.text = "Level: $goldLevel"
        tvHelium3Level.text = "Level: $helium3Level"

        tvWaterStorage.text = "Storage: $waterStorage"
        tvIronStorage.text = "Storage: $ironStorage"
        tvWoodStorage.text = "Storage: $woodStorage"
        tvGoldStorage.text = "Storage: $goldStorage"
        tvHelium3Storage.text = "Storage: $helium3Storage"

        tvWaterGeneration.text = "Generating: ${waterLevel * 5}/s"
        tvIronGeneration.text = "Generating: ${ironLevel * 5}/s"
        tvWoodGeneration.text = "Generating: ${woodLevel * 5}/s"
        tvGoldGeneration.text = "Generating: ${goldLevel * 5}/s"
        tvHelium3Generation.text = "Generating: ${helium3Level * 5}/s"
    }
}
