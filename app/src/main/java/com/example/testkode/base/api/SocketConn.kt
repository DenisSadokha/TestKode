package com.example.testkode.base.api

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.Socket

class SocketConn {


    fun getResponse(): String {
        try {
            val request = "mock/request"
            val socket = Socket("127.0.0.1", 4000)
            val response = BufferedReader(InputStreamReader(socket.getInputStream()))
            val qwe = BufferedWriter(OutputStreamWriter(socket.getOutputStream()))

            qwe.write(
                "" + request
            )

            val serverResponse = response.readLine()

            socket.close()


            return if (serverResponse.isNullOrEmpty())
                "error"
            else
                serverResponse
        } catch (e: Exception) {
            e.printStackTrace()
            return "error1"
        }

    }
}