package com.kursor.chroniclesofww2.model.serializable

import kotlinx.serialization.Serializable

@Serializable
data class GameData(
    private val myName: String,
    private val enemyName: String,
    private val battleData: Battle.Data,
    val boardHeight: Int,
    val boardWidth: Int,
    val invertNations: Boolean = false,
    val meInitiator: Boolean = true
) {

    val me = if (invertNations) Player(
        myName,
        battleData.nation2divisions,
        battleData.nation2,
        isInitiator = meInitiator
    ) else Player(
        myName,
        battleData.nation1divisions,
        battleData.nation1,
        isInitiator = meInitiator
    )

    val enemy = if (invertNations) Player(
        enemyName,
        battleData.nation1divisions,
        battleData.nation1,
        isInitiator = !meInitiator
    ) else Player(
        enemyName,
        battleData.nation2divisions,
        battleData.nation2,
        isInitiator = !meInitiator
    )

    fun getVersionForAnotherPlayer(): GameData {
        return GameData(
            enemyName,
            myName,
            battleData,
            boardHeight,
            boardWidth,
            invertNations = !invertNations,
            meInitiator = !meInitiator
        )
    }

}