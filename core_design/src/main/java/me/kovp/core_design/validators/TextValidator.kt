package me.kovp.core_design.validators

abstract class TextValidator() {
    abstract val validation: (String) -> Boolean

    fun validate(stringToValidate: String): ValidationResult = when (validation(stringToValidate)) {
        true -> ValidationResult.Success
        false -> ValidationResult.Fail
    }
}