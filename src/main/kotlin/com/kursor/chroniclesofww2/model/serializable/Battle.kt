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

    constructor(
        id: Int,
        name: String,
        description: String,
        nation1: Nation,
        nation1divisions: Map<Division.Type, Int>,
        nation2: Nation,
        nation2divisions: Map<Division.Type, Int>
    ) : this(
        id = id,
        name = name,
        description = description,
        data = Data(
            id = id,
            nation1 = nation1,
            nation1divisions = nation1divisions,
            nation2 = nation2,
            nation2divisions = nation2divisions
        )
    )

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