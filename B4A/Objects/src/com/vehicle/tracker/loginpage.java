package com.vehicle.tracker;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class loginpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.vehicle.tracker.loginpage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.vehicle.tracker.loginpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_email = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et_password = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb_forgotpassword = null;
public anywheresoftware.b4a.objects.LabelWrapper _lb_signup = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bt_login = null;
public b4a.example.dateutils _dateutils = null;
public com.vehicle.tracker.main _main = null;
public com.vehicle.tracker.starter _starter = null;
public com.vehicle.tracker.config _config = null;
public com.vehicle.tracker.xuiviewsutils _xuiviewsutils = null;
public com.vehicle.tracker.b4xpages _b4xpages = null;
public com.vehicle.tracker.b4xcollections _b4xcollections = null;
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
anywheresoftware.b4a.objects.CSBuilder _cs_forgotpassword = null;
anywheresoftware.b4a.objects.CSBuilder _cs_signup = null;
 //BA.debugLineNum = 17;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 18;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 19;BA.debugLine="Root.LoadLayout(\"login\")";
_root.LoadLayout("login",ba);
 //BA.debugLineNum = 20;BA.debugLine="B4XPages.SetTitle(Me, Config.APP_TITLE)";
_b4xpages._settitle /*String*/ (ba,this,(Object)(_config._app_title /*String*/ ));
 //BA.debugLineNum = 22;BA.debugLine="Dim CS_ForgotPassword As CSBuilder";
_cs_forgotpassword = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 23;BA.debugLine="CS_ForgotPassword.Initialize";
_cs_forgotpassword.Initialize();
 //BA.debugLineNum = 24;BA.debugLine="CS_ForgotPassword.Typeface(Typeface.LoadFromAsset";
_cs_forgotpassword.Typeface(__c.Typeface.LoadFromAssets("Roboto-Regular.ttf"));
 //BA.debugLineNum = 25;BA.debugLine="CS_ForgotPassword.Size(20)";
_cs_forgotpassword.Size((int) (20));
 //BA.debugLineNum = 26;BA.debugLine="CS_ForgotPassword.Append(\" \")";
_cs_forgotpassword.Append(BA.ObjectToCharSequence(" "));
 //BA.debugLineNum = 27;BA.debugLine="CS_ForgotPassword.Pop";
_cs_forgotpassword.Pop();
 //BA.debugLineNum = 28;BA.debugLine="CS_ForgotPassword.Clickable(\"ForgotPassword\", 1)";
_cs_forgotpassword.Clickable(ba,"ForgotPassword",(Object)(1));
 //BA.debugLineNum = 29;BA.debugLine="CS_ForgotPassword.Size(20)";
_cs_forgotpassword.Size((int) (20));
 //BA.debugLineNum = 30;BA.debugLine="CS_ForgotPassword.Alignment(\"ALIGN_OPPOSITE\")";
_cs_forgotpassword.Alignment(BA.getEnumFromString(android.text.Layout.Alignment.class,"ALIGN_OPPOSITE"));
 //BA.debugLineNum = 31;BA.debugLine="CS_ForgotPassword.Color(Config.COLOR_MATERIAL_GRA";
_cs_forgotpassword.Color(_config._color_material_gray /*int*/ );
 //BA.debugLineNum = 32;BA.debugLine="CS_ForgotPassword.Append(\"Forgot Password\")";
_cs_forgotpassword.Append(BA.ObjectToCharSequence("Forgot Password"));
 //BA.debugLineNum = 33;BA.debugLine="CS_ForgotPassword.EnableClickEvents(LB_ForgotPass";
_cs_forgotpassword.EnableClickEvents((android.widget.TextView)(_lb_forgotpassword.getObject()));
 //BA.debugLineNum = 34;BA.debugLine="CS_ForgotPassword.PopAll";
_cs_forgotpassword.PopAll();
 //BA.debugLineNum = 36;BA.debugLine="LB_ForgotPassword.Text = CS_ForgotPassword";
_lb_forgotpassword.setText(BA.ObjectToCharSequence(_cs_forgotpassword.getObject()));
 //BA.debugLineNum = 38;BA.debugLine="Dim CS_Signup As CSBuilder";
_cs_signup = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 39;BA.debugLine="CS_Signup.Initialize";
_cs_signup.Initialize();
 //BA.debugLineNum = 40;BA.debugLine="CS_Signup.Typeface(Typeface.LoadFromAssets(\"Robot";
_cs_signup.Typeface(__c.Typeface.LoadFromAssets("Roboto-Regular.ttf"));
 //BA.debugLineNum = 41;BA.debugLine="CS_Signup.Size(20)";
_cs_signup.Size((int) (20));
 //BA.debugLineNum = 42;BA.debugLine="CS_Signup.Color(Config.COLOR_MATERIAL_GRAY)";
_cs_signup.Color(_config._color_material_gray /*int*/ );
 //BA.debugLineNum = 43;BA.debugLine="CS_Signup.Append(\"Dont have an account? \")";
_cs_signup.Append(BA.ObjectToCharSequence("Dont have an account? "));
 //BA.debugLineNum = 44;BA.debugLine="CS_Signup.Pop";
_cs_signup.Pop();
 //BA.debugLineNum = 45;BA.debugLine="CS_Signup.Color(Config.COLOR_ACCENT)";
_cs_signup.Color(_config._color_accent /*int*/ );
 //BA.debugLineNum = 46;BA.debugLine="CS_Signup.Clickable(\"Signup\", 1)";
_cs_signup.Clickable(ba,"Signup",(Object)(1));
 //BA.debugLineNum = 47;BA.debugLine="CS_Signup.Append(\"Sign Up\")";
_cs_signup.Append(BA.ObjectToCharSequence("Sign Up"));
 //BA.debugLineNum = 48;BA.debugLine="CS_Signup.EnableClickEvents(LB_Signup)";
_cs_signup.EnableClickEvents((android.widget.TextView)(_lb_signup.getObject()));
 //BA.debugLineNum = 49;BA.debugLine="CS_Signup.PopAll";
_cs_signup.PopAll();
 //BA.debugLineNum = 51;BA.debugLine="LB_Signup.Text = CS_Signup";
_lb_signup.setText(BA.ObjectToCharSequence(_cs_signup.getObject()));
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public String  _bt_login_click() throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Private Sub BT_Login_Click";
 //BA.debugLineNum = 55;BA.debugLine="ClearFields";
_clearfields();
 //BA.debugLineNum = 56;BA.debugLine="B4XPages.ShowPageAndRemovePreviousPages(\"menu\")";
_b4xpages._showpageandremovepreviouspages /*String*/ (ba,"menu");
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private Root As B4XView 'ignore";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 3;BA.debugLine="Private XUI  As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 4;BA.debugLine="Private ET_Email As EditText";
_et_email = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 5;BA.debugLine="Private ET_Password As EditText";
_et_password = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private LB_ForgotPassword As Label";
_lb_forgotpassword = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 7;BA.debugLine="Private LB_Signup As Label";
_lb_signup = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 8;BA.debugLine="Private BT_Login As Button";
_bt_login = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public String  _clearfields() throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Private Sub ClearFields";
 //BA.debugLineNum = 70;BA.debugLine="ET_Email.Text = \"\"";
_et_email.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 71;BA.debugLine="ET_Password.Text = \"\"";
_et_password.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public String  _forgotpassword_click(Object _tag) throws Exception{
 //BA.debugLineNum = 59;BA.debugLine="Private Sub ForgotPassword_Click (Tag As Object)";
 //BA.debugLineNum = 60;BA.debugLine="ClearFields";
_clearfields();
 //BA.debugLineNum = 61;BA.debugLine="B4XPages.ShowPageAndRemovePreviousPages(\"forgot_p";
_b4xpages._showpageandremovepreviouspages /*String*/ (ba,"forgot_password");
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public Object  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 12;BA.debugLine="Public Sub Initialize As Object";
 //BA.debugLineNum = 13;BA.debugLine="Return Me";
if (true) return this;
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return null;
}
public String  _signup_click(Object _tag) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Private Sub SignUp_Click (Tag As Object)";
 //BA.debugLineNum = 65;BA.debugLine="ClearFields";
_clearfields();
 //BA.debugLineNum = 66;BA.debugLine="B4XPages.ShowPageAndRemovePreviousPages(\"sign_up\"";
_b4xpages._showpageandremovepreviouspages /*String*/ (ba,"sign_up");
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
