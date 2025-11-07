package com.vehicle.tracker;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class newpasswordpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.vehicle.tracker.newpasswordpage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.vehicle.tracker.newpasswordpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb_login = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_newpassword = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_confirmnewpassword = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bt_newpassword = null;
public b4a.example.dateutils _dateutils = null;
public com.vehicle.tracker.main _main = null;
public com.vehicle.tracker.starter _starter = null;
public com.vehicle.tracker.config _config = null;
public com.vehicle.tracker.xuiviewsutils _xuiviewsutils = null;
public com.vehicle.tracker.b4xpages _b4xpages = null;
public com.vehicle.tracker.b4xcollections _b4xcollections = null;
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _b4xpage_closerequest() throws Exception{
ResumableSub_B4XPage_CloseRequest rsub = new ResumableSub_B4XPage_CloseRequest(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_B4XPage_CloseRequest extends BA.ResumableSub {
public ResumableSub_B4XPage_CloseRequest(com.vehicle.tracker.newpasswordpage parent) {
this.parent = parent;
}
com.vehicle.tracker.newpasswordpage parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = -1;
 //BA.debugLineNum = 35;BA.debugLine="Login_Click(1)";
parent._login_click((Object)(1));
 //BA.debugLineNum = 36;BA.debugLine="Return True";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.True));return;};
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
anywheresoftware.b4a.objects.CSBuilder _cs_login = null;
 //BA.debugLineNum = 16;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 17;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 18;BA.debugLine="Root.LoadLayout(\"new_password\")";
_root.LoadLayout("new_password",ba);
 //BA.debugLineNum = 19;BA.debugLine="B4XPages.SetTitle(Me, Config.APP_TITLE)";
_b4xpages._settitle /*String*/ (ba,this,(Object)(_config._app_title /*String*/ ));
 //BA.debugLineNum = 21;BA.debugLine="Dim CS_Login As CSBuilder";
_cs_login = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 22;BA.debugLine="CS_Login.Initialize";
_cs_login.Initialize();
 //BA.debugLineNum = 23;BA.debugLine="CS_Login.Typeface(Typeface.LoadFromAssets(\"Roboto";
_cs_login.Typeface(__c.Typeface.LoadFromAssets("Roboto-Regular.ttf"));
 //BA.debugLineNum = 24;BA.debugLine="CS_Login.Size(20)";
_cs_login.Size((int) (20));
 //BA.debugLineNum = 25;BA.debugLine="CS_Login.Color(Config.COLOR_ACCENT)";
_cs_login.Color(_config._color_accent /*int*/ );
 //BA.debugLineNum = 26;BA.debugLine="CS_Login.Clickable(\"Login\", 1)";
_cs_login.Clickable(ba,"Login",(Object)(1));
 //BA.debugLineNum = 27;BA.debugLine="CS_Login.Append(\"Login\")";
_cs_login.Append(BA.ObjectToCharSequence("Login"));
 //BA.debugLineNum = 28;BA.debugLine="CS_Login.EnableClickEvents(LB_Login)";
_cs_login.EnableClickEvents((android.widget.TextView)(_lb_login.getObject()));
 //BA.debugLineNum = 29;BA.debugLine="CS_Login.PopAll";
_cs_login.PopAll();
 //BA.debugLineNum = 31;BA.debugLine="LB_Login.Text = CS_Login";
_lb_login.setText(BA.ObjectToCharSequence(_cs_login.getObject()));
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public String  _bt_newpassword_click() throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Private Sub BT_NewPassword_Click";
 //BA.debugLineNum = 50;BA.debugLine="Log(\"new passwordl\")";
__c.LogImpl("753542913","new passwordl",0);
 //BA.debugLineNum = 51;BA.debugLine="Login_Click(1)";
_login_click((Object)(1));
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private Root As B4XView 'ignore";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 3;BA.debugLine="Private XUI  As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 4;BA.debugLine="Private LB_Login As Label";
_lb_login = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 5;BA.debugLine="Private ET_NewPassword As EditText";
_et_newpassword = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private ET_ConfirmNewPassword As EditText";
_et_confirmnewpassword = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Private BT_NewPassword As Button";
_bt_newpassword = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public String  _clearfields() throws Exception{
 //BA.debugLineNum = 44;BA.debugLine="Private Sub ClearFields";
 //BA.debugLineNum = 45;BA.debugLine="ET_NewPassword.Text = \"\"";
_et_newpassword.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 46;BA.debugLine="ET_ConfirmNewPassword.Text = \"\"";
_et_confirmnewpassword.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public Object  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 11;BA.debugLine="Public Sub Initialize As Object";
 //BA.debugLineNum = 12;BA.debugLine="Return Me";
if (true) return this;
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return null;
}
public String  _login_click(Object _tag) throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Private Sub Login_Click (Tag As Object)";
 //BA.debugLineNum = 40;BA.debugLine="ClearFields";
_clearfields();
 //BA.debugLineNum = 41;BA.debugLine="B4XPages.ShowPageAndRemovePreviousPages(\"login\")";
_b4xpages._showpageandremovepreviouspages /*String*/ (ba,"login");
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
