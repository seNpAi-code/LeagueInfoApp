data class TeamsResponse(val teams: List<Team>?)
data class Team(
    val idTeam: String,
    val strTeam: String,
    val strTeamBadge: String
)

data class EquipmentResponse(val equipment: List<Equipment>?)
data class Equipment(val strEquipment: String)
