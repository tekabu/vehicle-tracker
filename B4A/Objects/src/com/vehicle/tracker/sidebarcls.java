package com.vehicle.tracker;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class sidebarcls extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.vehicle.tracker.sidebarcls");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.vehicle.tracker.sidebarcls.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mparent = null;
public com.vehicle.tracker.menupage _mpage = null;
public b4a.example3.customlistview _clv = null;
public b4a.example.dateutils _dateutils = null;
public com.vehicle.tracker.main _main = null;
public com.vehicle.tracker.starter _starter = null;
public com.vehicle.tracker.config _config = null;
public com.vehicle.tracker.xuiviewsutils _xuiviewsutils = null;
public com.vehicle.tracker.b4xpages _b4xpages = null;
public com.vehicle.tracker.b4xcollections _b4xcollections = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private mParent As B4XView";
_mparent = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 3;BA.debugLine="Private mPage As MenuPage";
_mpage = new com.vehicle.tracker.menupage();
 //BA.debugLineNum = 4;BA.debugLine="Private CLV As CustomListView";
_clv = new b4a.example3.customlistview();
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return "";
}
public String  _clv_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Private Sub CLV_ItemClick (Index As Int, Value As";
 //BA.debugLineNum = 23;BA.debugLine="mPage.Sidebar_Selected(Index, Value)";
_mpage._sidebar_selected /*String*/ (_index,BA.ObjectToString(_value));
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.CSBuilder  _createitem(String _name) throws Exception{
anywheresoftware.b4a.objects.CSBuilder _cs = null;
 //BA.debugLineNum = 26;BA.debugLine="Private Sub CreateItem (Name As String) As CSBuild";
 //BA.debugLineNum = 27;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 28;BA.debugLine="cs.Initialize";
_cs.Initialize();
 //BA.debugLineNum = 29;BA.debugLine="cs.Size(18)";
_cs.Size((int) (18));
 //BA.debugLineNum = 30;BA.debugLine="cs.Color(Config.COLOR_MATERIAL_GRAY)";
_cs.Color(_config._color_material_gray /*int*/ );
 //BA.debugLineNum = 31;BA.debugLine="cs.Typeface(Typeface.LoadFromAssets(\"Roboto-Regul";
_cs.Typeface(__c.Typeface.LoadFromAssets("Roboto-Regular.ttf"));
 //BA.debugLineNum = 32;BA.debugLine="cs.Append(\"     \")";
_cs.Append(BA.ObjectToCharSequence("     "));
 //BA.debugLineNum = 33;BA.debugLine="cs.Append(Name)";
_cs.Append(BA.ObjectToCharSequence(_name));
 //BA.debugLineNum = 34;BA.debugLine="cs.PopAll";
_cs.PopAll();
 //BA.debugLineNum = 35;BA.debugLine="Return cs";
if (true) return _cs;
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _parent,com.vehicle.tracker.menupage _page) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 8;BA.debugLine="Public Sub Initialize (Parent As B4XView, Page As";
 //BA.debugLineNum = 9;BA.debugLine="mParent = Parent";
_mparent = _parent;
 //BA.debugLineNum = 10;BA.debugLine="mPage = Page";
_mpage = _page;
 //BA.debugLineNum = 11;BA.debugLine="mParent.LoadLayout(\"sidebar\")";
_mparent.LoadLayout("sidebar",ba);
 //BA.debugLineNum = 13;BA.debugLine="CLV.AddTextItem(CreateItem(\"Dashboard\"), \"Dashboa";
_clv._addtextitem((Object)(_createitem("Dashboard").getObject()),(Object)("Dashboard"));
 //BA.debugLineNum = 14;BA.debugLine="CLV.AddTextItem(CreateItem(\"Vehicles\"), \"Vehicles";
_clv._addtextitem((Object)(_createitem("Vehicles").getObject()),(Object)("Vehicles"));
 //BA.debugLineNum = 15;BA.debugLine="CLV.AddTextItem(CreateItem(\"Customers\"), \"Custome";
_clv._addtextitem((Object)(_createitem("Customers").getObject()),(Object)("Customers"));
 //BA.debugLineNum = 16;BA.debugLine="CLV.AddTextItem(CreateItem(\"Rentals\"), \"Rentals\")";
_clv._addtextitem((Object)(_createitem("Rentals").getObject()),(Object)("Rentals"));
 //BA.debugLineNum = 17;BA.debugLine="CLV.AddTextItem(CreateItem(\"Reports\"), \"Reports\")";
_clv._addtextitem((Object)(_createitem("Reports").getObject()),(Object)("Reports"));
 //BA.debugLineNum = 18;BA.debugLine="CLV.AddTextItem(CreateItem(\"Account\"), \"Accounts\"";
_clv._addtextitem((Object)(_createitem("Account").getObject()),(Object)("Accounts"));
 //BA.debugLineNum = 19;BA.debugLine="CLV.AddTextItem(CreateItem(\"Logout\"), \"Logout\")";
_clv._addtextitem((Object)(_createitem("Logout").getObject()),(Object)("Logout"));
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
