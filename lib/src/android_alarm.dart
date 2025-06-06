import 'dart:async';

import 'package:alarm/alarm.dart';
import 'package:alarm/model/edit_ringing_alarm_settings.dart';
import 'package:alarm/src/generated/platform_bindings.g.dart';
import 'package:alarm/utils/alarm_exception.dart';
import 'package:alarm/utils/alarm_handler.dart';
import 'package:logging/logging.dart';

/// Uses method channel to interact with the native platform.
class AndroidAlarm {
  static final _log = Logger('AndroidAlarm');

  static final AlarmApi _api = AlarmApi();

  /// Whether there are other alarms set.
  static Future<bool> get hasOtherAlarms =>
      Alarm.getAlarms().then((alarms) => alarms.length > 1);

  /// Schedules a native alarm with given [settings] with its notification.
  static Future<bool> set(AlarmSettings settings) async {
    await _api
        .setAlarm(alarmSettings: settings.toWire())
        .catchError(AlarmExceptionHandlers.catchError<void>);

    _log.info(
      'Alarm with id ${settings.id} scheduled at ${settings.dateTime}.',
    );

    return true;
  }

  /// Sends the message `stop` to the isolate so the audio player
  /// can stop playing and dispose.
  static Future<bool> stop(int id) async {
    try {
      await _api
          .stopAlarm(alarmId: id)
          .catchError(AlarmExceptionHandlers.catchError<void>);
      if (!(await hasOtherAlarms)) await disableWarningNotificationOnKill();
      return true;
    } on AlarmException catch (e) {
      _log.severe('Failed to stop alarm: $e');
      return false;
    }
  }

  /// Calls the native `stopAll` function.
  static Future<void> stopAll() async {
    return _api.stopAll().catchError(AlarmExceptionHandlers.catchError<void>);
  }

  /// Checks whether an alarm or any alarm (if id is null) is ringing.
  static Future<bool> isRinging([int? id]) async {
    try {
      final res = await _api
          .isRinging(alarmId: id)
          .catchError(AlarmExceptionHandlers.catchError<bool>);
      return res;
    } on AlarmException catch (e) {
      _log.severe('Failed to check if alarm is ringing: $e');
      return false;
    }
  }

  /// Sets the native notification on app kill title and body.
  static Future<void> setWarningNotificationOnKill(String title, String body) =>
      _api
          .setWarningNotificationOnKill(
            title: title,
            body: body,
          )
          .catchError(AlarmExceptionHandlers.catchError<void>);

  /// Disable the notification on kill service.
  static Future<void> disableWarningNotificationOnKill() => _api
      .disableWarningNotificationOnKill()
      .catchError(AlarmExceptionHandlers.catchError<void>);

  /// 修改响铃中的闹钟表现（开关：震动/响铃/手电筒等）
  static Future<void> editRingingAlarm(EditRingingAlarmSettings settings) =>
      _api
          .editRingingAlarm(editRingingAlarmSettingsWire: settings.toWire())
          .catchError(AlarmExceptionHandlers.catchError<void>);
}
