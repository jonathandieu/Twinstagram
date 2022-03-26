package com.example.lintstagram

import com.parse.*

@ParseClassName("Post")
class Post : ParseObject() {
    // Description : String
    fun getDescription(): String? {
        return getString(KEY_DESCRIPTION)
    }
    fun setDescription(description: String) {
        put(KEY_DESCRIPTION, description)
    }

    // Image : File
    fun getImage(): ParseFile? {
        return getParseFile(KEY_IMAGE)
    }
    fun setImage(parsefile: ParseFile) {
            put(KEY_IMAGE, parsefile)
    }

    // User : User
    fun getUser(): ParseUser? {
        return getParseUser(KEY_USER)
    }
    fun setUser(user: ParseUser) {
        return put(KEY_USER, user)
    }


    companion object {
        const val KEY_DESCRIPTION = "description"
        const val KEY_IMAGE = "image"
        const val KEY_USER = "user"
    }
}