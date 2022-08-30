package com.example.miga.domain.models

data class SuggestionModel(val tag: String) {
    val id = tag.hashCode()
}
