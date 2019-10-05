package org.isel.pdm

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Line : Serializable /*, Parcelable*/ {

    private val points : MutableList<XyPair> = mutableListOf()

    /*constructor(parcel: Parcel) : this() {

    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {

    }

    override fun describeContents(): Int = 0*/

    constructor(x:Float, y:Float){
        add(x,y)
    }

    fun draw(canvas: Canvas) {
        val paint = Paint()
        paint.setColor(Color.BLUE)
        paint.strokeWidth = 20f

        points.reduce { prev, curr ->
            canvas.drawLine(prev.x, prev.y, curr.x, curr.y, paint)
            curr
        }
    }

    fun add(x: Float, y: Float) {
        points.add(XyPair(x, y))
    }

    /*
    companion object CREATOR : Parcelable.Creator<Line> {
        override fun createFromParcel(parcel: Parcel): Line {
            return Line(parcel)
        }

        override fun newArray(size: Int): Array<Line?> {
            return arrayOfNulls(size)
        }
    }
     */

}
