package org.isel.pdm

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Line (val x: Float, val y: Float) :  Serializable , Parcelable {

    constructor(parcel: Parcel): this(
        parcel.readFloat(),
        parcel.readFloat()
    ){
        add(x, y)
        //parcel.readTypedList(points, XyPair.CREATOR)
    }

    private val points : MutableList<XyPair> = mutableListOf()


    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeFloat(x)
        dest?.writeFloat(y)
        //dest?.writeTypedList(points)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Line> {
        override fun createFromParcel(parcel: Parcel): Line {
            return Line(parcel)
        }

        override fun newArray(size: Int): Array<Line?> {
            return arrayOfNulls(size)
        }
    }

    fun add(x: Float, y: Float) {
        points.add(XyPair(x, y))
    }

    fun draw(canvas: Canvas) {
        val paint = Paint()
        paint.setColor(Color.BLUE)
        paint.strokeWidth = 20f
        if(points.size>0)
            points.reduce { prev, curr ->
                canvas.drawLine(prev.x, prev.y, curr.x, curr.y, paint)
                curr
            }
    }


}
