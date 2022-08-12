package com.kursor.chroniclesofww2.model.serializable

import kotlinx.serialization.Serializable

@Serializable
data class GameData(
    private val myName: String,
    private val enemyName: String,
    private val battle: Battle,
    val boardHeight: Int,
    val boardWidth: Int,
    val invertNations: Boolean = false,
    val meInitiator: Boolean = true
) {

    val me = if (invertNations) Player(
        myName,
        battle.data.nation2divisions,
        battle.data.nation2,
        isInitiator = meInitiator
    ) else Player(
        myName,
        battle.data.nation1divisions,
        battle.data.nation1,
        isInitiator = meInitiator
    )

    val enemy = if (invertNations) Player(
        enemyName,
        battle.data.nation1divisions,
        battle.data.nation1,
        isInitiator = !meInitiator
    ) else Player(
        enemyName,
        battle.data.nation2divisions,
        battle.data.nation2,
        isInitiator = !meInitiator
    )

    fun getVersionForAnotherPlayer(): GameData {
        return GameData(
            enemyName,
            myName,
            battle,
            boardHeight,
            boardWidth,
            invertNations = !invertNations,
            meInitiator = !meInitiator
        )
    }

}