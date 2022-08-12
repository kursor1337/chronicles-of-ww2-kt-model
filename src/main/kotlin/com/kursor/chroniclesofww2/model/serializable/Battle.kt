package com.kursor.chroniclesofww2.model.serializable

import com.kursor.chroniclesofww2.model.game.Nation
import com.kursor.chroniclesofww2.model.game.board.Division
import kotlinx.serialization.Serializable

@Serializable
data class Battle(
    val id: Int,
    val name: String,
    val description: String,
    val data: Data
) {

    companion object {
        const val DEFAULT = -865
        const val DEFAULT_MISSION_NAME = "Default"
    }

    @Serializable
    data class Data(
        val id: Int,
        val nation1: Nation,
        val nation1divisions: Map<Division.Type, Int>,
        val nation2: Nation,
        val nation2divisions: Map<Division.Type, Int>
    )

}