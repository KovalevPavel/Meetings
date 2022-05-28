package me.kovp.core_design

import androidx.core.widget.doAfterTextChanged
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import me.kovp.core_design.databinding.ItemTextInputBinding
import me.kovp.core_design.delegate_adapter.Decorator
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.delegate_adapter.SpaceDecorator
import me.kovp.core_design.validators.TextValidator

fun textInputAdapterDelegate(onTextChange: (TextInputAdapterData) -> Unit) =
    adapterDelegateViewBinding<TextInputAdapterData, ItemViewState, ItemTextInputBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemTextInputBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        binding.root.doAfterTextChanged {
            item.text = it.toString()
            onTextChange(item)
        }

        bind {
            binding.root.hint = item.hint
        }
    }

data class TextInputAdapterData(
    override val id: String,
    override val decorator: Decorator? = SpaceDecorator(),
    val hint: String,
    var text: String = "",
    val validator: TextValidator? = null
) : ItemViewState()
