package me.kovp.core_design.validators

class PhoneValidator : TextValidator() {
    override val validation: (String) -> Boolean
        get() = {
            true
        }
}