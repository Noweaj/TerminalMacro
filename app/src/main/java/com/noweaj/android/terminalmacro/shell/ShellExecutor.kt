package com.noweaj.android.terminalmacro.shell

import android.R.attr.process
import java.io.BufferedReader
import java.io.InputStreamReader


object ShellExecutor {
    
    fun execute(command: String): String {
//        var output = listOf<String>()
        var output = StringBuffer()
        
        val runtime = Runtime.getRuntime()
        var p: Process? = null
        try{
            p = runtime.exec(command)
            p.waitFor()
//            output = p.inputStream.bufferedReader().use(BufferedReader::readLines)

            val reader = BufferedReader(
                InputStreamReader(p.inputStream)
            )
            var read: Int
            val buffer = CharArray(4096)
            while (reader.read(buffer).also { read = it } > 0) {
                output.append(buffer, 0, read)
            }
            reader.close()

        } catch (e: Exception){
//            output = p!!.errorStream.bufferedReader().use(BufferedReader::readLines)
        }
        return output.toString()
    }
}