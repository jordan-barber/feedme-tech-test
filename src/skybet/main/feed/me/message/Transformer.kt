package skybet.main.feed.me.message

import java.util.*
import java.util.stream.Collectors

class Transformer {
  fun transform(msg: String): Event? {
    var event: Event? = null;

    val cleanStream = msg.replace(("\\\\" + "\\|").toRegex(), " ")
    val dataStream = cleanStream.split("\\|".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
    val messageData = deleteEmptyItems(dataStream)
    val feedMeDataHeader = FeedMeDataHeader(messageData[0].toInt(), messageData[1], messageData[2], messageData[3].toLong())

    println("MESSAGE DATA ${messageData.toString()}")

    return when(messageData.get(2)) {
      "event" -> Event(feedMeDataHeader, messageData.get(4), messageData.get(5), messageData.get(6), messageData.get(7), messageData.get(8).toLong(), messageData.get(9).toBoolean(), messageData.get(10).toBoolean());
      "market" -> Market(feedMeDataHeader, messageData.get(4), messageData.get(5), messageData.get(6), messageData.get(7).toBoolean(), messageData.get(8).toBoolean());
      "outcome" -> Outcome(feedMeDataHeader, messageData.get(4), messageData.get(5), messageData.get(6), messageData.get(7), messageData.get(8).toBoolean(), messageData.get(9).toBoolean());
      else -> null
    }
  }


  private fun deleteEmptyItems(dataStream: Array<String>): List<String> {
    val items: List<String> = dataStream.toList<String>();

    return items.filter { x -> !x.isEmpty() }
  }
}