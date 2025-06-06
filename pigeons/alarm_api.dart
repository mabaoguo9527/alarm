import 'package:pigeon/pigeon.dart';

// After modifying this file run:
// dart run pigeon --input pigeons/alarm_api.dart && dart format .

@ConfigurePigeon(
  PigeonOptions(
    dartOut: 'lib/src/generated/platform_bindings.g.dart',
    dartPackageName: 'alarm',
    swiftOut: 'ios/Classes/generated/FlutterBindings.g.swift',
    kotlinOut:
        'android/src/main/kotlin/com/gdelataillade/alarm/generated/FlutterBindings.g.kt',
    kotlinOptions: KotlinOptions(
      package: 'com.gdelataillade.alarm.generated',
    ),
  ),
)
class AlarmSettingsWire {
  const AlarmSettingsWire({
    required this.id,
    required this.millisecondsSinceEpoch,
    required this.assetAudioPath,
    required this.volumeSettings,
    required this.notificationSettings,
    required this.loopAudio,
    required this.vibrate,
    required this.warningNotificationOnKill,
    required this.androidFullScreenIntent,
    required this.allowAlarmOverlap,
    required this.iOSBackgroundAudio,
    required this.voiceTagSettings,
    required this.flashlight,
  });

  final int id;
  final int millisecondsSinceEpoch;
  final String assetAudioPath;
  final VolumeSettingsWire volumeSettings;
  final NotificationSettingsWire notificationSettings;
  final bool loopAudio;
  final bool vibrate;
  final bool warningNotificationOnKill;
  final bool androidFullScreenIntent;
  final bool allowAlarmOverlap;
  final bool iOSBackgroundAudio;
  final VoiceTagSettingsWire voiceTagSettings;
  final bool flashlight;
}

class VolumeSettingsWire {
  const VolumeSettingsWire({
    required this.volume,
    required this.fadeDurationMillis,
    required this.fadeSteps,
    required this.volumeEnforced,
  });

  final double? volume;
  final int? fadeDurationMillis;
  final List<VolumeFadeStepWire> fadeSteps;
  final bool volumeEnforced;
}

class VolumeFadeStepWire {
  const VolumeFadeStepWire({
    required this.timeMillis,
    required this.volume,
  });

  final int timeMillis;
  final double volume;
}

class VoiceTagSettingsWire {
  const VoiceTagSettingsWire({
    required this.enable,
    required this.text,
    required this.volume,
    required this.speechRate,
    required this.pitch,
  });

  final bool enable;
  final String text;
  final double volume;
  final double speechRate;
  final double pitch;
}

class NotificationSettingsWire {
  const NotificationSettingsWire({
    required this.title,
    required this.body,
    required this.stopButton,
    required this.icon,
  });

  final String title;
  final String body;
  final String? stopButton;
  final String? icon;
}

/// Errors that can occur when interacting with the Alarm API.
enum AlarmErrorCode {
  unknown,

  /// A plugin internal error. Please report these as bugs on GitHub.
  pluginInternal,

  /// The arguments passed to the method are invalid.
  invalidArguments,

  /// An error occurred while communicating with the native platform.
  channelError,

  /// The required notification permission was not granted.
  ///
  /// Please use an external permission manager such as "permission_handler" to
  /// request the permission from the user.
  missingNotificationPermission,

  /// not support
  notSupport,
}

class EditRingingAlarmSettingsWire {
  const EditRingingAlarmSettingsWire({
    required this.id,

    /// 铃声相关
    required this.volumeSettings,
    required this.loopAudio,
    required this.assetAudioPath,

    /// 震动
    required this.vibrate,

    /// 手电筒
    required this.flashlight,

    /// 语音标签
    required this.voiceTagSettings,
  });

  final int id;
  final VolumeSettingsWire? volumeSettings;
  final bool? loopAudio;
  final String? assetAudioPath;
  final bool? vibrate;
  final bool? flashlight;
  final VoiceTagSettingsWire? voiceTagSettings;
}

@HostApi()
abstract class AlarmApi {
  void setAlarm({required AlarmSettingsWire alarmSettings});

  void stopAlarm({required int alarmId});

  void stopAll();

  bool isRinging({required int? alarmId});

  void setWarningNotificationOnKill({
    required String title,
    required String body,
  });

  void disableWarningNotificationOnKill();

  /// 修改响铃中的闹钟表现（开关：震动/响铃/手电筒等）
  void editRingingAlarm(
      {required EditRingingAlarmSettingsWire editRingingAlarmSettingsWire});
}

@FlutterApi()
abstract class AlarmTriggerApi {
  @async
  void alarmRang(int alarmId);

  @async
  void alarmStopped(int alarmId);
}
