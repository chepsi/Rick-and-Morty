package kmm.rickandmorty.app.android.presentation.components.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kmm.rickandmorty.app.android.presentation.theme.PrimaryTeal

@Composable
fun TopBar() {
    TopAppBar(
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Icon(
                imageVector = Outlined.Search,
                contentDescription = "Search",
                modifier = Modifier
                    .size(50.dp)
                    .height(50.dp)
                    .width(50.dp)
                    .padding(10.dp)
                    .align(Alignment.CenterEnd)
                    .background(shape = RoundedCornerShape(50.dp), color = PrimaryTeal),
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}