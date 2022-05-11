package kmm.rickandmorty.app.android.presentation.components.locations.mappers

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class StringResMapper {
    data class DynamicString(val stringValue:String) : StringResMapper()
    class StringResource(
        @StringRes
        val resID: Int,
        vararg val args: Any
    ) : StringResMapper()

    @Composable
    fun stringAble() : String {
        return when(this){
            is DynamicString -> stringValue
            is StringResource -> stringResource(id = resID, formatArgs = args)
        }
    }
    
}