package kmm.rickandmorty.app.android.presentation.components.locations.mappers

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class StringResMapper {
    data class DynamicString(val value: String) : StringResMapper()
    class StringResource(
        @StringRes
        val resID: Int,
        vararg val args: Any
    ) : StringResMapper()

    @Composable
    fun getString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> stringResource(id = resID, formatArgs = args)
        }
    }
}
