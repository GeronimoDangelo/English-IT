package com.study.englishit.util

object Constants {

    const val INFO_NOT_SET = "info_not_set"
    const val USER_COLLECTIONS = "users"
    private const val USER_NOT_LOGGED = "user_not_logged"
    const val USER_NOT_EXIST = "There is no user record corresponding to this identifier. The user may have been deleted."
    const val WRONG_PASSWORD = "The password is invalid or the user does not have a password."
    const val VALUE_REQUIRED = "Value required"
    const val EMAIL_ALREADY_EXISTS : String = "com.google.firebase.auth.FirebaseAuthUserCollisionException: The email address is already in use by another account."

    var USER_LOGGED_IN_ID = USER_NOT_LOGGED
    var USER_EMAIL_GET = "user_email"
    const val SHARED_PREFERENCES_NAME = "shared_preferences_name"

    const val SHARED_EMAIL = "shared_email"
    const val SHARED_PASSWORD = "password_email"

}