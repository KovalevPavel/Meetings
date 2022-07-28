package me.kovp.domain_auth

class ValidateInputDataInteractor {
    operator fun invoke(inputtedData: Map<String, String>): Boolean {
        inputtedData.forEach { (_, value) ->
            if (value.isEmpty()) return false
        }
        return true
    }
}