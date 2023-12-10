import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.plcoding.graphqlcountriesapp.presentation.PingViewModel
import com.plcoding.graphqlcountriesapp.presentation.SubsPingViewModel

@Composable
fun SubsPingScreen(
    viewModel: SubsPingViewModel
) {
    val pingState = viewModel.pingState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        if (pingState.value == "Loading...") {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            Text(text = pingState.value)
        }
    }
}
