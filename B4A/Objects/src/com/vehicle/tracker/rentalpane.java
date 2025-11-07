package com.vehicle.tracker;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class rentalpane extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.vehicle.tracker.rentalpane");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.vehicle.tracker.rentalpane.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.PanelWrapper _mparent = null;
public b4a.example.dateutils _dateutils = null;
public com.vehicle.tracker.main _main = null;
public com.vehicle.tracker.starter _starter = null;
public com.vehicle.tracker.config _config = null;
public com.vehicle.tracker.xuiviewsutils _xuiviewsutils = null;
public com.vehicle.tracker.b4xpages _b4xpages = null;
public com.vehicle.tracker.b4xcollections _b4xcollections = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private XUI As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 3;BA.debugLine="Private mParent As Panel";
_mparent = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,com.vehicle.tracker.asviewpager _pager) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 7;BA.debugLine="Public Sub Initialize (Pager As ASViewPager)";
 //BA.debugLineNum = 8;BA.debugLine="mParent = XUI.CreatePanel(\"\")";
_mparent = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_xui.CreatePanel(ba,"").getObject()));
 //BA.debugLineNum = 9;BA.debugLine="mParent.SetLayout(0, 0, Pager.Base.Width, Pager.B";
_mparent.SetLayout((int) (0),(int) (0),_pager._getbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().getWidth(),_pager._getbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().getHeight());
 //BA.debugLineNum = 11;BA.debugLine="Pager.AddPage(mParent, \"\")";
_pager._addpage /*String*/ ((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_mparent.getObject())),(Object)(""));
 //BA.debugLineNum = 13;BA.debugLine="mParent.LoadLayout(\"rentals\")";
_mparent.LoadLayout("rentals",ba);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
