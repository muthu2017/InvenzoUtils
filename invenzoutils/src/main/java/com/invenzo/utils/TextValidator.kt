package com.invenzo.utils

import android.text.TextUtils

object TextValidator {
    @JvmStatic
    fun toStr(str: Any?): String {
        var result = ""
        if (str == null) return result
        return if (str is String) {
            result = str
            result = if (TextUtils.isEmpty(result)) "" else if (result.equals(
                    "null",
                    ignoreCase = true
                )
            ) "" else result.replace("^\\s+".toRegex(), "")
            result
        } else {
            result
        }
    }

    @JvmStatic
    fun toInt(str: String?): Int {
        if (str!=null && toStr(str).isNotEmpty()) {
            var ss  = ""
            if(str.contains(".")){
                ss  = str.substring(0,str.indexOf("."))
            }
            else{
                ss = str
            }
           return Integer.valueOf(ss)
        }
        return 0
    }

    @JvmStatic
    fun toFloat(str: String?): Float {
        return if (toStr(str).isNotEmpty()) java.lang.Float.valueOf(str!!) else 0F
    }

    @JvmStatic
    fun toDouble(str: String?): Double {
        val ss = toStr(str).replace(",".toRegex(), "")
        return if (ss.length > 0) java.lang.Double.valueOf(ss) else 0.0
    }
}