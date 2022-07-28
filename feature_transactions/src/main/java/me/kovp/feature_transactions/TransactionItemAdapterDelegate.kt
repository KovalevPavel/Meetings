package me.kovp.feature_transactions

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import me.kovp.core_design.delegate_adapter.ItemViewStates
import me.kovp.feature_transactions.databinding.ItemTransactionBinding

fun transactionItemAdapterDelegate() =
    adapterDelegateViewBinding<TransactionItemAdapterData, ItemViewStates, ItemTransactionBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemTransactionBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            binding.apply {
                tvTransactionPersonName.text = item.personName
                tvTransactionPartyTitle.text = item.partyTitle
                tvTransactionSum.text = item.sum
            }
        }
    }

data class TransactionItemAdapterData(
    override val id: String,
    val personName: String,
    val partyTitle: String,
    val sum: String
) : ItemViewStates()