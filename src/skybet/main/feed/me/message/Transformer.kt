package skybet.main.feed.me.message

import java.util.ArrayList



class Transformer {
  fun transform(msg: String): FeedMeDataHeader {
    val cleanStream = msg.replace(("\\\\" + "\\|").toRegex(), " ")
    val dataStream = cleanStream.split("\\|".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
    val itemsList = deleteEmptyItems(dataStream)
    val feedMeDataHeader = FeedMeDataHeader(itemsList[0].toInt(), itemsList[1], itemsList[2], itemsList[3].toLong())

    println("WHAT IS INSIDE ME!!!! $feedMeDataHeader")

    return feedMeDataHeader
  }

  private fun deleteEmptyItems(dataStream: Array<String>): ArrayList<String> {
    val streamItems = ArrayList<String>()
    for (i in dataStream.indices) {
      if (!dataStream[i].isEmpty()) {
        streamItems.add(dataStream[i])
      }
    }
    return streamItems
  }
}