package com.vehicle.tracker;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class config {
private static config mostCurrent = new config();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static String _app_title = "";
public static int _color_material_black = 0;
public static int _color_action_bar = 0;
public static int _color_status_bar = 0;
public static int _color_material_gray = 0;
public static int _color_material_light_gray = 0;
public static int _color_light_action_bar = 0;
public static int _color_accent = 0;
public static int _color_white = 0;
public b4a.example.dateutils _dateutils = null;
public com.vehicle.tracker.main _main = null;
public com.vehicle.tracker.starter _starter = null;
public com.vehicle.tracker.xuiviewsutils _xuiviewsutils = null;
public com.vehicle.tracker.b4xpages _b4xpages = null;
public com.vehicle.tracker.b4xcollections _b4xcollections = null;
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Public APP_TITLE As String = \"Tracker\"";
_app_title = "Tracker";
 //BA.debugLineNum = 5;BA.debugLine="Public COLOR_MATERIAL_BLACK As Int = 0xFF212121";
_color_material_black = ((int)0xff212121);
 //BA.debugLineNum = 6;BA.debugLine="Public COLOR_ACTION_BAR As Int = 0xFF2196F3";
_color_action_bar = ((int)0xff2196f3);
 //BA.debugLineNum = 7;BA.debugLine="Public COLOR_STATUS_BAR As Int = 0xFF1976D2";
_color_status_bar = ((int)0xff1976d2);
 //BA.debugLineNum = 8;BA.debugLine="Public COLOR_MATERIAL_GRAY As Int = 0xFF757575";
_color_material_gray = ((int)0xff757575);
 //BA.debugLineNum = 9;BA.debugLine="Public COLOR_MATERIAL_LIGHT_GRAY As Int = 0xFFBDB";
_color_material_light_gray = ((int)0xffbdbdbd);
 //BA.debugLineNum = 10;BA.debugLine="Public COLOR_LIGHT_ACTION_BAR As Int = 0xFFBBDEFB";
_color_light_action_bar = ((int)0xffbbdefb);
 //BA.debugLineNum = 11;BA.debugLine="Public COLOR_ACCENT As Int = 0xFF03A9F4";
_color_accent = ((int)0xff03a9f4);
 //BA.debugLineNum = 12;BA.debugLine="Public COLOR_WHITE As Int = 0xFFFFFFFF";
_color_white = ((int)0xffffffff);
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
}
