package com.proyecto.personal.mb.models

import android.os.Parcel
import android.os.Parcelable

class Cliente (email: String , password: String) : Parcelable {
    var email: String = "Sin completar"
    var password: String = "Sin completar"

    constructor(parcel: Parcel) : this(
        TODO("email"),
        TODO("password")
    ) {
        email = parcel.readString().toString()
        password = parcel.readString().toString()
    }

    init {
        this.email = email
        this.password = password
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cliente> {
        override fun createFromParcel(parcel: Parcel): Cliente {
            return Cliente(parcel)
        }

        override fun newArray(size: Int): Array<Cliente?> {
            return arrayOfNulls(size)
        }
    }

}