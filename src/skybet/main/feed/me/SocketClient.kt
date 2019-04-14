package skybet.main.feed.me

import java.net.Socket

class SocketClient (address: String, port: Int) {
  var address: String = address
  var port: Int = port

  fun connect(): Socket {
    val client: Socket = Socket(address, port);

    return client;
  }
}

