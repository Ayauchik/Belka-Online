import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.plcoding.graphqlcountriesapp.presentation.PingViewModel

@Composable
fun PingScreen(
    state: PingViewModel.PingState
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            Row(){
                Text(text = "ping: ")
                state.ping?.let { Text(text = it) }
            }
        }
    }
}
