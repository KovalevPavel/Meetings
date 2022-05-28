package me.kovp.feature_profile.presentation.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.load
import me.kovp.core_design.setOnClick
import me.kovp.core_design.R
import me.kovp.feature_profile.databinding.ItemProfileHeaderBinding

fun profileHeaderDelegate(onPhotoClick: () -> Unit) =
    adapterDelegateViewBinding<ProfileHeaderAdapterData, ItemViewState, ItemProfileHeaderBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemProfileHeaderBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        binding.ivProfileHeaderAvatar.setOnClick { onPhotoClick() }
        val cornerRadius = context.resources.getDimensionPixelSize(R.dimen.max_corner_radius)

        bind {
            binding.ivProfileHeaderAvatar.load(url = item.avatarUrl, radius = cornerRadius)
            binding.tvProfileHeaderUserName.text = item.userName
            binding.tvProfileHeaderUserContact.text = item.userContact
        }
    }

data class ProfileHeaderAdapterData(
    override val id: String,
    val avatarUrl: String,
    val userName: String,
    val userContact: String
) : ItemViewState()