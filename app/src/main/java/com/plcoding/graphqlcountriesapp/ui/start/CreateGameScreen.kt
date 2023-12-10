import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domains.domain.models.Player
import com.example.domains.domain.models.Team
import com.plcoding.graphqlcountriesapp.ui.start.CreateGameViewModel

@Composable
fun GameInfoScreen(
    viewModel: CreateGameViewModel = hiltViewModel()
) {
    val gameState = viewModel.state.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = "Game Information",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                fontSize = 24.sp
            )
        }

        gameState.value.gameId?.let { gameId ->
            item {
                Text(
                    text = "Game ID: $gameId",
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
            }

            gameState.value.teams.takeIf { it!!.size >= 2 }?.let { teams ->
                item {
                    Text(
                        text = "Teams:",
                        modifier = Modifier.padding(8.dp)
                    )
                }

                items(teams.size) { index ->
                    TeamItem(team = teams[index])
                }
            }

            gameState.value.winner?.let { winner ->
                item {
                    Text(
                        text = "Winner:",
                        modifier = Modifier.padding(8.dp)
                    )
                }

                item {
                    Text(text = winner.teamId)
                }
            }
        }
    }
}

@Composable
fun TeamItem(team: Team) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        Text(
            text = "Team ID: ${team.teamId}",
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            modifier = Modifier.padding(4.dp)
        )

        team.players.takeIf { it.size >= 2 }?.let { players ->
            Text(text = "Players:")
            players.forEach { player ->
                PlayerItem(player = player)
            }
        }
    }
}

@Composable
fun PlayerItem(player: Player) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Player ID: ${player.playerId}")
        Text(text = "Player Name: ${player.playerName}")
    }
}
