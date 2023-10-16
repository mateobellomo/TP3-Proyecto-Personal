package com.proyecto.personal.mb.entities

import android.os.Parcel
import android.os.Parcelable

class Contacto(nombre: String?, edad: Int?, curso: String?): Parcelable {
    var nombre: String = "Sin completar"

    var curso: String = "Sin completar"

    var edad: Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    class Constants {
        companion object{
            val cursoA = "A"
            val cursoB = "B"
            val cursoC = "C"

        }
    }

    init {
        this.nombre = nombre!!
        this.curso = curso!!
        this.edad = edad!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(curso)
        parcel.writeInt(edad)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contacto> {
        override fun createFromParcel(parcel: Parcel): Contacto {
            return Contacto(parcel)
        }

        override fun newArray(size: Int): Array<Contacto?> {
            return arrayOfNulls(size)
        }
    }

}