package me.kovp.core_design.validators

class EmailValidator : TextValidator() {
    override val validation: (String) -> Boolean
        get() = {
            true
        }
}