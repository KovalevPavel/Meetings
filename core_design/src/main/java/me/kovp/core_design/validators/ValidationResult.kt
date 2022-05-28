package me.kovp.core_design.validators

sealed class ValidationResult {
    object Success : ValidationResult()
    object Fail : ValidationResult()
}
