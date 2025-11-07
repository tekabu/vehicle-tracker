package com.vehicle.tracker;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.vehicle.tracker.b4xmainpage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.vehicle.tracker.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public com.vehicle.tracker.mappage _map_ = null;
public com.vehicle.tracker.loginpage _login_ = null;
public com.vehicle.tracker.signuppage _signup_ = null;
public com.vehicle.tracker.forgotpasswordpage _forgotpassword_ = null;
public com.vehicle.tracker.verificationpage _verification_ = null;
public com.vehicle.tracker.newpasswordpage _newpassword_ = null;
public com.vehicle.tracker.menupage _menu_ = null;
public b4a.example.dateutils _dateutils = null;
public com.vehicle.tracker.main _main = null;
public com.vehicle.tracker.starter _starter = null;
public com.vehicle.tracker.config _config = null;
public com.vehicle.tracker.xuiviewsutils _xuiviewsutils = null;
public com.vehicle.tracker.b4xpages _b4xpages = null;
public com.vehicle.tracker.b4xcollections _b4xcollections = null;
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 42;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 43;BA.debugLine="B4XPages.ShowPageAndRemovePreviousPages(\"login\")";
_b4xpages._showpageandremovepreviouspages /*String*/ (ba,"login");
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 25;BA.debugLine="Login_.Initialize";
_login_._initialize /*Object*/ (ba);
 //BA.debugLineNum = 26;BA.debugLine="SignUp_.Initialize";
_signup_._initialize /*Object*/ (ba);
 //BA.debugLineNum = 27;BA.debugLine="ForgotPassword_.Initialize";
_forgotpassword_._initialize /*Object*/ (ba);
 //BA.debugLineNum = 28;BA.debugLine="Verification_.Initialize";
_verification_._initialize /*Object*/ (ba);
 //BA.debugLineNum = 29;BA.debugLine="NewPassword_.Initialize";
_newpassword_._initialize /*Object*/ (ba);
 //BA.debugLineNum = 30;BA.debugLine="Menu_.Initialize";
_menu_._initialize /*Object*/ (ba);
 //BA.debugLineNum = 31;BA.debugLine="Map_.Initialize";
_map_._initialize /*Object*/ (ba);
 //BA.debugLineNum = 33;BA.debugLine="B4XPages.AddPage(\"login\", Login_)";
_b4xpages._addpage /*String*/ (ba,"login",(Object)(_login_));
 //BA.debugLineNum = 34;BA.debugLine="B4XPages.AddPage(\"sign_up\", SignUp_)";
_b4xpages._addpage /*String*/ (ba,"sign_up",(Object)(_signup_));
 //BA.debugLineNum = 35;BA.debugLine="B4XPages.AddPage(\"forgot_password\", ForgotPasswor";
_b4xpages._addpage /*String*/ (ba,"forgot_password",(Object)(_forgotpassword_));
 //BA.debugLineNum = 36;BA.debugLine="B4XPages.AddPage(\"verification\", Verification_)";
_b4xpages._addpage /*String*/ (ba,"verification",(Object)(_verification_));
 //BA.debugLineNum = 37;BA.debugLine="B4XPages.AddPage(\"new_password\", NewPassword_)";
_b4xpages._addpage /*String*/ (ba,"new_password",(Object)(_newpassword_));
 //BA.debugLineNum = 38;BA.debugLine="B4XPages.AddPage(\"menu\", Menu_)";
_b4xpages._addpage /*String*/ (ba,"menu",(Object)(_menu_));
 //BA.debugLineNum = 39;BA.debugLine="B4XPages.AddPage(\"map\", Map_)";
_b4xpages._addpage /*String*/ (ba,"map",(Object)(_map_));
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private Map_ As MapPage";
_map_ = new com.vehicle.tracker.mappage();
 //BA.debugLineNum = 10;BA.debugLine="Private Login_ As LoginPage";
_login_ = new com.vehicle.tracker.loginpage();
 //BA.debugLineNum = 11;BA.debugLine="Private SignUp_ As SignUpPage";
_signup_ = new com.vehicle.tracker.signuppage();
 //BA.debugLineNum = 12;BA.debugLine="Private ForgotPassword_ As ForgotPasswordPage";
_forgotpassword_ = new com.vehicle.tracker.forgotpasswordpage();
 //BA.debugLineNum = 13;BA.debugLine="Private Verification_ As VerificationPage";
_verification_ = new com.vehicle.tracker.verificationpage();
 //BA.debugLineNum = 14;BA.debugLine="Private NewPassword_ As NewPasswordPage";
_newpassword_ = new com.vehicle.tracker.newpasswordpage();
 //BA.debugLineNum = 15;BA.debugLine="Private Menu_ As MenuPage";
_menu_ = new com.vehicle.tracker.menupage();
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 18;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 19;BA.debugLine="B4XPages.GetManager.LogEvents = True";
_b4xpages._getmanager /*com.vehicle.tracker.b4xpagesmanager*/ (ba)._logevents /*boolean*/  = __c.True;
 //BA.debugLineNum = 20;BA.debugLine="B4XPages.GetManager.TransitionAnimationDuration =";
_b4xpages._getmanager /*com.vehicle.tracker.b4xpagesmanager*/ (ba)._transitionanimationduration /*int*/  = (int) (0);
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
