// Autogenerated from Pigeon (v22.7.4), do not edit directly.
// See also: https://pub.dev/packages/pigeon
@file:Suppress("UNCHECKED_CAST", "ArrayInDataClass")

package com.gdelataillade.alarm.generated

import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMethodCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

private fun wrapResult(result: Any?): List<Any?> {
  return listOf(result)
}

private fun wrapError(exception: Throwable): List<Any?> {
  return if (exception is FlutterError) {
    listOf(
      exception.code,
      exception.message,
      exception.details
    )
  } else {
    listOf(
      exception.javaClass.simpleName,
      exception.toString(),
      "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
    )
  }
}

private fun createConnectionError(channelName: String): FlutterError {
  return FlutterError("channel-error",  "Unable to establish connection on channel: '$channelName'.", "")}

/**
 * Error class for passing custom error details to Flutter via a thrown PlatformException.
 * @property code The error code.
 * @property message The error message.
 * @property details The error details. Must be a datatype supported by the api codec.
 */
class FlutterError (
  val code: String,
  override val message: String? = null,
  val details: Any? = null
) : Throwable()

/** Errors that can occur when interacting with the Alarm API. */
enum class AlarmErrorCode(val raw: Int) {
  UNKNOWN(0),
  /** A plugin internal error. Please report these as bugs on GitHub. */
  PLUGIN_INTERNAL(1),
  /** The arguments passed to the method are invalid. */
  INVALID_ARGUMENTS(2),
  /** An error occurred while communicating with the native platform. */
  CHANNEL_ERROR(3),
  /**
   * The required notification permission was not granted.
   *
   * Please use an external permission manager such as "permission_handler" to
   * request the permission from the user.
   */
  MISSING_NOTIFICATION_PERMISSION(4);

  companion object {
    fun ofRaw(raw: Int): AlarmErrorCode? {
      return values().firstOrNull { it.raw == raw }
    }
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class AlarmSettingsWire (
  val id: Long,
  val millisecondsSinceEpoch: Long,
  val assetAudioPath: String,
  val volumeSettings: VolumeSettingsWire,
  val notificationSettings: NotificationSettingsWire,
  val loopAudio: Boolean,
  val vibrate: Boolean,
  val warningNotificationOnKill: Boolean,
  val androidFullScreenIntent: Boolean,
  val allowAlarmOverlap: Boolean,
  val iOSBackgroundAudio: Boolean,
  val voiceTagSettings: VoiceTagSettingsWire
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): AlarmSettingsWire {
      val id = pigeonVar_list[0] as Long
      val millisecondsSinceEpoch = pigeonVar_list[1] as Long
      val assetAudioPath = pigeonVar_list[2] as String
      val volumeSettings = pigeonVar_list[3] as VolumeSettingsWire
      val notificationSettings = pigeonVar_list[4] as NotificationSettingsWire
      val loopAudio = pigeonVar_list[5] as Boolean
      val vibrate = pigeonVar_list[6] as Boolean
      val warningNotificationOnKill = pigeonVar_list[7] as Boolean
      val androidFullScreenIntent = pigeonVar_list[8] as Boolean
      val allowAlarmOverlap = pigeonVar_list[9] as Boolean
      val iOSBackgroundAudio = pigeonVar_list[10] as Boolean
      val voiceTagSettings = pigeonVar_list[11] as VoiceTagSettingsWire
      return AlarmSettingsWire(id, millisecondsSinceEpoch, assetAudioPath, volumeSettings, notificationSettings, loopAudio, vibrate, warningNotificationOnKill, androidFullScreenIntent, allowAlarmOverlap, iOSBackgroundAudio, voiceTagSettings)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      id,
      millisecondsSinceEpoch,
      assetAudioPath,
      volumeSettings,
      notificationSettings,
      loopAudio,
      vibrate,
      warningNotificationOnKill,
      androidFullScreenIntent,
      allowAlarmOverlap,
      iOSBackgroundAudio,
      voiceTagSettings,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class VolumeSettingsWire (
  val volume: Double? = null,
  val fadeDurationMillis: Long? = null,
  val fadeSteps: List<VolumeFadeStepWire>,
  val volumeEnforced: Boolean
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): VolumeSettingsWire {
      val volume = pigeonVar_list[0] as Double?
      val fadeDurationMillis = pigeonVar_list[1] as Long?
      val fadeSteps = pigeonVar_list[2] as List<VolumeFadeStepWire>
      val volumeEnforced = pigeonVar_list[3] as Boolean
      return VolumeSettingsWire(volume, fadeDurationMillis, fadeSteps, volumeEnforced)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      volume,
      fadeDurationMillis,
      fadeSteps,
      volumeEnforced,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class VolumeFadeStepWire (
  val timeMillis: Long,
  val volume: Double
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): VolumeFadeStepWire {
      val timeMillis = pigeonVar_list[0] as Long
      val volume = pigeonVar_list[1] as Double
      return VolumeFadeStepWire(timeMillis, volume)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      timeMillis,
      volume,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class VoiceTagSettingsWire (
  val enable: Boolean,
  val text: String,
  val volume: Double,
  val speechRate: Double,
  val pitch: Double
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): VoiceTagSettingsWire {
      val enable = pigeonVar_list[0] as Boolean
      val text = pigeonVar_list[1] as String
      val volume = pigeonVar_list[2] as Double
      val speechRate = pigeonVar_list[3] as Double
      val pitch = pigeonVar_list[4] as Double
      return VoiceTagSettingsWire(enable, text, volume, speechRate, pitch)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      enable,
      text,
      volume,
      speechRate,
      pitch,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class NotificationSettingsWire (
  val title: String,
  val body: String,
  val stopButton: String? = null,
  val icon: String? = null
)
 {
  companion object {
    fun fromList(pigeonVar_list: List<Any?>): NotificationSettingsWire {
      val title = pigeonVar_list[0] as String
      val body = pigeonVar_list[1] as String
      val stopButton = pigeonVar_list[2] as String?
      val icon = pigeonVar_list[3] as String?
      return NotificationSettingsWire(title, body, stopButton, icon)
    }
  }
  fun toList(): List<Any?> {
    return listOf(
      title,
      body,
      stopButton,
      icon,
    )
  }
}
private open class FlutterBindingsPigeonCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      129.toByte() -> {
        return (readValue(buffer) as Long?)?.let {
          AlarmErrorCode.ofRaw(it.toInt())
        }
      }
      130.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          AlarmSettingsWire.fromList(it)
        }
      }
      131.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          VolumeSettingsWire.fromList(it)
        }
      }
      132.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          VolumeFadeStepWire.fromList(it)
        }
      }
      133.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          VoiceTagSettingsWire.fromList(it)
        }
      }
      134.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          NotificationSettingsWire.fromList(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is AlarmErrorCode -> {
        stream.write(129)
        writeValue(stream, value.raw)
      }
      is AlarmSettingsWire -> {
        stream.write(130)
        writeValue(stream, value.toList())
      }
      is VolumeSettingsWire -> {
        stream.write(131)
        writeValue(stream, value.toList())
      }
      is VolumeFadeStepWire -> {
        stream.write(132)
        writeValue(stream, value.toList())
      }
      is VoiceTagSettingsWire -> {
        stream.write(133)
        writeValue(stream, value.toList())
      }
      is NotificationSettingsWire -> {
        stream.write(134)
        writeValue(stream, value.toList())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface AlarmApi {
  fun setAlarm(alarmSettings: AlarmSettingsWire)
  fun stopAlarm(alarmId: Long)
  fun stopAll()
  fun isRinging(alarmId: Long?): Boolean
  fun setWarningNotificationOnKill(title: String, body: String)
  fun disableWarningNotificationOnKill()

  companion object {
    /** The codec used by AlarmApi. */
    val codec: MessageCodec<Any?> by lazy {
      FlutterBindingsPigeonCodec()
    }
    /** Sets up an instance of `AlarmApi` to handle messages through the `binaryMessenger`. */
    @JvmOverloads
    fun setUp(binaryMessenger: BinaryMessenger, api: AlarmApi?, messageChannelSuffix: String = "") {
      val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.alarm.AlarmApi.setAlarm$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val alarmSettingsArg = args[0] as AlarmSettingsWire
            val wrapped: List<Any?> = try {
              api.setAlarm(alarmSettingsArg)
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.alarm.AlarmApi.stopAlarm$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val alarmIdArg = args[0] as Long
            val wrapped: List<Any?> = try {
              api.stopAlarm(alarmIdArg)
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.alarm.AlarmApi.stopAll$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              api.stopAll()
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.alarm.AlarmApi.isRinging$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val alarmIdArg = args[0] as Long?
            val wrapped: List<Any?> = try {
              listOf(api.isRinging(alarmIdArg))
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.alarm.AlarmApi.setWarningNotificationOnKill$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val titleArg = args[0] as String
            val bodyArg = args[1] as String
            val wrapped: List<Any?> = try {
              api.setWarningNotificationOnKill(titleArg, bodyArg)
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.alarm.AlarmApi.disableWarningNotificationOnKill$separatedMessageChannelSuffix", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            val wrapped: List<Any?> = try {
              api.disableWarningNotificationOnKill()
              listOf(null)
            } catch (exception: Throwable) {
              wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}
/** Generated class from Pigeon that represents Flutter messages that can be called from Kotlin. */
class AlarmTriggerApi(private val binaryMessenger: BinaryMessenger, private val messageChannelSuffix: String = "") {
  companion object {
    /** The codec used by AlarmTriggerApi. */
    val codec: MessageCodec<Any?> by lazy {
      FlutterBindingsPigeonCodec()
    }
  }
  fun alarmRang(alarmIdArg: Long, callback: (Result<Unit>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.alarm.AlarmTriggerApi.alarmRang$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(alarmIdArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          callback(Result.success(Unit))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
  fun alarmStopped(alarmIdArg: Long, callback: (Result<Unit>) -> Unit)
{
    val separatedMessageChannelSuffix = if (messageChannelSuffix.isNotEmpty()) ".$messageChannelSuffix" else ""
    val channelName = "dev.flutter.pigeon.alarm.AlarmTriggerApi.alarmStopped$separatedMessageChannelSuffix"
    val channel = BasicMessageChannel<Any?>(binaryMessenger, channelName, codec)
    channel.send(listOf(alarmIdArg)) {
      if (it is List<*>) {
        if (it.size > 1) {
          callback(Result.failure(FlutterError(it[0] as String, it[1] as String, it[2] as String?)))
        } else {
          callback(Result.success(Unit))
        }
      } else {
        callback(Result.failure(createConnectionError(channelName)))
      } 
    }
  }
}
