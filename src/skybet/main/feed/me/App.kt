package skybet.main.feed.me

import skybet.main.feed.me.message.Event
import skybet.main.feed.me.message.FeedMeDataHeader
import skybet.main.feed.me.message.Transformer
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

fun main(args : Array<String>) {
  try {
    val client: Socket = SocketClient("localhost", 8282).connect();
    client.keepAlive = true;

    val inFromServer: BufferedReader = BufferedReader(InputStreamReader(client.getInputStream()));

    while(client.isConnected) {
      val transformedMessage: Event? = Transformer().transform(inFromServer.readLine());
      println("POST TRANSFORMED MESSAGE ${transformedMessage}")
    }
  } catch(e: Exception) {
    println("EXCEPTION THROWN " + e)
  }
}

fun splitString(str: String): List<String> {
  return str.split("|") + str;
}
