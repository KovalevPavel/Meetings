package me.kovp.feature_auth.domain

class ValidateInputDataInteractor {
    operator fun invoke(inputtedData: Map<String, String>): Boolean {
        inputtedData.forEach { (_, value) ->
            if (value.isEmpty()) return false
        }
        return true
    }
}