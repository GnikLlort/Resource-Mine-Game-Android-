package com.example.myapplication

class Game {
    var water = 0
    var iron = 0
    var wood = 0
    var gold = 0
    var helium3 = 0

    var waterMineLevel = 1
    var ironMineLevel = 1
    var woodMineLevel = 1
    var goldMineLevel = 1
    var heliumMineLevel = 1

    fun upgradeWaterMine() {
        waterMineLevel++
        water += waterMineLevel * 10
    }

    fun upgradeIronMine() {
        ironMineLevel++
        iron += ironMineLevel * 10
    }

    fun upgradeWoodMine() {
        woodMineLevel++
        wood += woodMineLevel * 10
    }

    fun upgradeGoldMine() {
        goldMineLevel++
        gold += goldMineLevel * 10
    }

    fun upgradeHeliumMine() {
        heliumMineLevel++
        helium3 += heliumMineLevel * 10
    }
}
