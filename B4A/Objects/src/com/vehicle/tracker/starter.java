package com.vehicle.tracker;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, BA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "com.vehicle.tracker", "com.vehicle.tracker.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "com.vehicle.tracker.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			if (ServiceHelper.StarterHelper.runWaitForLayouts() == false) {
                BA.LogInfo("stopping spontaneous created service");
                stopSelf();
            }
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }

	public void onTimeout(int startId) {
        BA.LogInfo("** Service (starter) Timeout **");
        anywheresoftware.b4a.objects.collections.Map params = new anywheresoftware.b4a.objects.collections.Map();
        params.Initialize();
        params.Put("StartId", startId);
        processBA.raiseEvent(null, "service_timeout", params);
            
    }
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (true) {
            BA.LogInfo("** Service (starter) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (starter) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.objects.MqttAsyncClientWrapper _mqtt = null;
public static String _server = "";
public static anywheresoftware.b4a.objects.Timer _timerconnect = null;
public b4a.example.dateutils _dateutils = null;
public com.vehicle.tracker.main _main = null;
public com.vehicle.tracker.config _config = null;
public com.vehicle.tracker.xuiviewsutils _xuiviewsutils = null;
public com.vehicle.tracker.b4xpages _b4xpages = null;
public com.vehicle.tracker.b4xcollections _b4xcollections = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 29;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return false;
}
public static String  _mc_connected(boolean _success) throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Private Sub MC_Connected (Success As Boolean)";
 //BA.debugLineNum = 37;BA.debugLine="If Success = False Then";
if (_success==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 38;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("71245186",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)),0);
 //BA.debugLineNum = 39;BA.debugLine="TimerConnect.Enabled = True";
_timerconnect.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 41;BA.debugLine="Log(\"MQTT Connected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("71245189","MQTT Connected",0);
 //BA.debugLineNum = 42;BA.debugLine="Mqtt.Subscribe(\"tracker-A1b2C3d4E5f6G7h8I9j0KlMn";
_mqtt.Subscribe("tracker-A1b2C3d4E5f6G7h8I9j0KlMnOpQrStUvWxYzABCD",_mqtt.QOS_2_EXACTLY_ONCE);
 };
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static String  _mc_disconnected() throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Private Sub MC_Disconnected";
 //BA.debugLineNum = 47;BA.debugLine="Log(\"MQTT Disconnected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("71310721","MQTT Disconnected",0);
 //BA.debugLineNum = 48;BA.debugLine="TimerConnect.Enabled = True";
_timerconnect.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public static String  _mc_messagearrived(String _sendertopic,byte[] _payload) throws Exception{
String _str = "";
String[] _pieces = null;
double _lat = 0;
double _lng = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 51;BA.debugLine="Private Sub MC_MessageArrived (SenderTopic As Stri";
 //BA.debugLineNum = 52;BA.debugLine="Dim str As String = BytesToString(Payload, 0, Pay";
_str = anywheresoftware.b4a.keywords.Common.BytesToString(_payload,(int) (0),_payload.length,"UTF-8");
 //BA.debugLineNum = 53;BA.debugLine="Log(str)";
anywheresoftware.b4a.keywords.Common.LogImpl("71376258",_str,0);
 //BA.debugLineNum = 55;BA.debugLine="If B4XPages.GetManager.GetTopPage.Id <> \"map\" The";
if ((mostCurrent._b4xpages._getmanager /*com.vehicle.tracker.b4xpagesmanager*/ (processBA)._gettoppage /*com.vehicle.tracker.b4xpagesmanager._b4xpageinfo*/ ().Id /*String*/ ).equals("map") == false) { 
 //BA.debugLineNum = 56;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 59;BA.debugLine="If str.StartsWith(\"$\") And str.EndsWith(\"#\") Then";
if (_str.startsWith("$") && _str.endsWith("#")) { 
 }else {
 //BA.debugLineNum = 61;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 64;BA.debugLine="str = str.SubString2(1, str.Length -1)";
_str = _str.substring((int) (1),(int) (_str.length()-1));
 //BA.debugLineNum = 66;BA.debugLine="Dim pieces() As String = Regex.Split(\",\", str)";
_pieces = anywheresoftware.b4a.keywords.Common.Regex.Split(",",_str);
 //BA.debugLineNum = 68;BA.debugLine="If pieces.Length <> 4 Then";
if (_pieces.length!=4) { 
 //BA.debugLineNum = 69;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 72;BA.debugLine="Dim lat As Double = pieces(1)";
_lat = (double)(Double.parseDouble(_pieces[(int) (1)]));
 //BA.debugLineNum = 73;BA.debugLine="Dim lng As Double = pieces(2)";
_lng = (double)(Double.parseDouble(_pieces[(int) (2)]));
 //BA.debugLineNum = 75;BA.debugLine="Dim m As Map = CreateMap()";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = anywheresoftware.b4a.keywords.Common.createMap(new Object[] {});
 //BA.debugLineNum = 76;BA.debugLine="m.Put(\"lat\", lat)";
_m.Put((Object)("lat"),(Object)(_lat));
 //BA.debugLineNum = 77;BA.debugLine="m.Put(\"lng\", lng)";
_m.Put((Object)("lng"),(Object)(_lng));
 //BA.debugLineNum = 79;BA.debugLine="B4XPages.GetManager.RaiseEvent(B4XPages.GetManage";
mostCurrent._b4xpages._getmanager /*com.vehicle.tracker.b4xpagesmanager*/ (processBA)._raiseevent /*String*/ (mostCurrent._b4xpages._getmanager /*com.vehicle.tracker.b4xpagesmanager*/ (processBA)._gettoppage /*com.vehicle.tracker.b4xpagesmanager._b4xpageinfo*/ (),"UpdateLocation",new Object[]{(Object)(_m.getObject())});
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Public Mqtt As MqttClient";
_mqtt = new anywheresoftware.b4j.objects.MqttAsyncClientWrapper();
 //BA.debugLineNum = 9;BA.debugLine="Private Server As String = \"tcp://broker.emqx.io:";
_server = "tcp://broker.emqx.io:1883";
 //BA.debugLineNum = 10;BA.debugLine="Private TimerConnect As Timer";
_timerconnect = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 14;BA.debugLine="TimerConnect.Initialize(\"TimerConnect\", 1500)";
_timerconnect.Initialize(processBA,"TimerConnect",(long) (1500));
 //BA.debugLineNum = 15;BA.debugLine="Mqtt.Initialize(\"MC\", Server, DateTime.Now.As(Str";
_mqtt.Initialize(processBA,"MC",_server,(BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow()))+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Rnd((int) (1000),(int) (9999))));
 //BA.debugLineNum = 16;BA.debugLine="TimerConnect_Tick";
_timerconnect_tick();
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 20;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
mostCurrent._service.StopAutomaticForeground();
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Service_TaskRemoved";
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _timerconnect_tick() throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Private Sub TimerConnect_Tick";
 //BA.debugLineNum = 83;BA.debugLine="TimerConnect.Enabled = False";
_timerconnect.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 84;BA.debugLine="If Mqtt.Connected = False Then";
if (_mqtt.getConnected()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 85;BA.debugLine="Mqtt.Connect";
_mqtt.Connect();
 };
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
}
