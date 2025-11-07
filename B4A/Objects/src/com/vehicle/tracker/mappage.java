package com.vehicle.tracker;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class mappage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.vehicle.tracker.mappage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.vehicle.tracker.mappage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.MapFragmentWrapper _fragment = null;
public anywheresoftware.b4a.objects.MapFragmentWrapper.GoogleMapWrapper _gmap = null;
public uk.co.martinpearman.b4a.googlemapsextras.GoogleMapsExtras _gextra = null;
public b4a.example.dateutils _dateutils = null;
public com.vehicle.tracker.main _main = null;
public com.vehicle.tracker.starter _starter = null;
public com.vehicle.tracker.config _config = null;
public com.vehicle.tracker.xuiviewsutils _xuiviewsutils = null;
public com.vehicle.tracker.b4xpages _b4xpages = null;
public com.vehicle.tracker.b4xcollections _b4xcollections = null;
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 16;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 17;BA.debugLine="Root.LoadLayout(\"map\")";
_root.LoadLayout("map",ba);
 //BA.debugLineNum = 18;BA.debugLine="B4XPages.SetTitle(Me, Config.APP_TITLE)";
_b4xpages._settitle /*String*/ (ba,this,(Object)(_config._app_title /*String*/ ));
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private Root As B4XView 'ignore";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 3;BA.debugLine="Private XUI As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 4;BA.debugLine="Private Fragment As MapFragment";
_fragment = new anywheresoftware.b4a.objects.MapFragmentWrapper();
 //BA.debugLineNum = 5;BA.debugLine="Private Gmap As GoogleMap";
_gmap = new anywheresoftware.b4a.objects.MapFragmentWrapper.GoogleMapWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private	GExtra As GoogleMapsExtras";
_gextra = new uk.co.martinpearman.b4a.googlemapsextras.GoogleMapsExtras();
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public String  _fragment_ready() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Private Sub Fragment_Ready";
 //BA.debugLineNum = 22;BA.debugLine="Gmap = Fragment.GetMap";
_gmap = _fragment.GetMap();
 //BA.debugLineNum = 23;BA.debugLine="Gmap.Clear";
_gmap.Clear();
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public Object  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 10;BA.debugLine="Public Sub Initialize As Object";
 //BA.debugLineNum = 11;BA.debugLine="Return Me";
if (true) return this;
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return null;
}
public String  _updatelocation(Object _args) throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
anywheresoftware.b4a.objects.MapFragmentWrapper.CameraPositionWrapper _c = null;
uk.co.martinpearman.b4a.com.google.android.gms.maps.model.CircleOptions _circle = null;
 //BA.debugLineNum = 26;BA.debugLine="Private Sub UpdateLocation(Args As Object) 'ignore";
 //BA.debugLineNum = 27;BA.debugLine="Dim Data As Map = Args";
_data = new anywheresoftware.b4a.objects.collections.Map();
_data = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_args));
 //BA.debugLineNum = 29;BA.debugLine="If Data.ContainsKey(\"lat\") And Data.ContainsKey(\"";
if (_data.ContainsKey((Object)("lat")) && _data.ContainsKey((Object)("lng"))) { 
 }else {
 //BA.debugLineNum = 31;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 34;BA.debugLine="Dim c As CameraPosition";
_c = new anywheresoftware.b4a.objects.MapFragmentWrapper.CameraPositionWrapper();
 //BA.debugLineNum = 35;BA.debugLine="c.Initialize(Data.Get(\"lat\"), Data.Get(\"lng\"), 17";
_c.Initialize((double)(BA.ObjectToNumber(_data.Get((Object)("lat")))),(double)(BA.ObjectToNumber(_data.Get((Object)("lng")))),(float) (17));
 //BA.debugLineNum = 37;BA.debugLine="Gmap.Clear";
_gmap.Clear();
 //BA.debugLineNum = 38;BA.debugLine="Gmap.AddMarker(Data.Get(\"lat\"), Data.Get(\"lng\"),";
_gmap.AddMarker((double)(BA.ObjectToNumber(_data.Get((Object)("lat")))),(double)(BA.ObjectToNumber(_data.Get((Object)("lng")))),"Tracker");
 //BA.debugLineNum = 40;BA.debugLine="Dim circle As CircleOptions";
_circle = new uk.co.martinpearman.b4a.com.google.android.gms.maps.model.CircleOptions();
 //BA.debugLineNum = 41;BA.debugLine="circle.Initialize";
_circle.Initialize();
 //BA.debugLineNum = 42;BA.debugLine="circle.Radius(100)";
_circle.Radius(100);
 //BA.debugLineNum = 43;BA.debugLine="circle.Center2(Data.Get(\"lat\"), Data.Get(\"lng\"))";
_circle.Center2((double)(BA.ObjectToNumber(_data.Get((Object)("lat")))),(double)(BA.ObjectToNumber(_data.Get((Object)("lng")))));
 //BA.debugLineNum = 44;BA.debugLine="circle.FillColor(0x320048FF)";
_circle.FillColor(((int)0x320048ff));
 //BA.debugLineNum = 45;BA.debugLine="circle.StrokeWidth(1dip)";
_circle.StrokeWidth((float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 46;BA.debugLine="circle.StrokeColor(0xFF0048FF)";
_circle.StrokeColor(((int)0xff0048ff));
 //BA.debugLineNum = 48;BA.debugLine="GExtra.AddCircle(Gmap, circle)";
_gextra.AddCircle((com.google.android.gms.maps.GoogleMap)(_gmap.getObject()),(com.google.android.gms.maps.model.CircleOptions)(_circle.getObject()));
 //BA.debugLineNum = 50;BA.debugLine="Gmap.AnimateCamera(c)";
_gmap.AnimateCamera((com.google.android.gms.maps.model.CameraPosition)(_c.getObject()));
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
