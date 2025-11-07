package com.vehicle.tracker;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class menupage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.vehicle.tracker.menupage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.vehicle.tracker.menupage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public com.vehicle.tracker.b4xdrawer _drawer = null;
public com.vehicle.tracker.sidebarcls _sidebar = null;
public com.vehicle.tracker.asviewpager _pager = null;
public com.vehicle.tracker.dashboardpane _dashboard = null;
public com.vehicle.tracker.vehiclepane _vehicle = null;
public com.vehicle.tracker.customerpane _customer = null;
public com.vehicle.tracker.rentalpane _rental = null;
public com.vehicle.tracker.reportpane _report = null;
public com.vehicle.tracker.accountpane _account = null;
public b4a.example.dateutils _dateutils = null;
public com.vehicle.tracker.main _main = null;
public com.vehicle.tracker.starter _starter = null;
public com.vehicle.tracker.config _config = null;
public com.vehicle.tracker.xuiviewsutils _xuiviewsutils = null;
public com.vehicle.tracker.b4xpages _b4xpages = null;
public com.vehicle.tracker.b4xcollections _b4xcollections = null;
public String  _b4xpage_appear() throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Private Sub B4XPage_Appear";
 //BA.debugLineNum = 40;BA.debugLine="InitMenu";
_initmenu();
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _b4xpage_closerequest() throws Exception{
ResumableSub_B4XPage_CloseRequest rsub = new ResumableSub_B4XPage_CloseRequest(this);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_B4XPage_CloseRequest extends BA.ResumableSub {
public ResumableSub_B4XPage_CloseRequest(com.vehicle.tracker.menupage parent) {
this.parent = parent;
}
com.vehicle.tracker.menupage parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 48;BA.debugLine="If Main.ActionBarHomeClicked Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._main._actionbarhomeclicked /*boolean*/ ) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 49;BA.debugLine="Drawer.LeftOpen = Not(Drawer.LeftOpen)";
parent._drawer._setleftopen /*boolean*/ (parent.__c.Not(parent._drawer._getleftopen /*boolean*/ ()));
 //BA.debugLineNum = 50;BA.debugLine="Return False";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
 if (true) break;
;
 //BA.debugLineNum = 52;BA.debugLine="If Drawer.LeftOpen Then";

case 4:
//if
this.state = 7;
if (parent._drawer._getleftopen /*boolean*/ ()) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 53;BA.debugLine="Drawer.LeftOpen = False";
parent._drawer._setleftopen /*boolean*/ (parent.__c.False);
 //BA.debugLineNum = 54;BA.debugLine="Return False";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
 if (true) break;

case 7:
//C
this.state = -1;
;
 //BA.debugLineNum = 56;BA.debugLine="Return True";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.True));return;};
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 22;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 24;BA.debugLine="Drawer.Initialize(Me, \"Drawer\", Root, 200dip)";
_drawer._initialize /*String*/ (ba,this,"Drawer",_root,__c.DipToCurrent((int) (200)));
 //BA.debugLineNum = 25;BA.debugLine="Drawer.CenterPanel.LoadLayout(\"menu\")";
_drawer._getcenterpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().LoadLayout("menu",ba);
 //BA.debugLineNum = 27;BA.debugLine="Sidebar.Initialize(Drawer.LeftPanel, Me)";
_sidebar._initialize /*String*/ (ba,_drawer._getleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ (),(com.vehicle.tracker.menupage)(this));
 //BA.debugLineNum = 29;BA.debugLine="Dashboard.Initialize(Pager)";
_dashboard._initialize /*String*/ (ba,_pager);
 //BA.debugLineNum = 30;BA.debugLine="Vehicle.Initialize(Pager)";
_vehicle._initialize /*String*/ (ba,_pager);
 //BA.debugLineNum = 31;BA.debugLine="Customer.Initialize(Pager)";
_customer._initialize /*String*/ (ba,_pager);
 //BA.debugLineNum = 32;BA.debugLine="Rental.Initialize(Pager)";
_rental._initialize /*String*/ (ba,_pager);
 //BA.debugLineNum = 33;BA.debugLine="Report.Initialize(Pager)";
_report._initialize /*String*/ (ba,_pager);
 //BA.debugLineNum = 34;BA.debugLine="Account.Initialize(Pager)";
_account._initialize /*String*/ (ba,_pager);
 //BA.debugLineNum = 36;BA.debugLine="B4XPages.SetTitle(Me, Config.APP_TITLE)";
_b4xpages._settitle /*String*/ (ba,this,(Object)(_config._app_title /*String*/ ));
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public String  _b4xpage_disappear() throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Private Sub B4XPage_Disappear";
 //BA.debugLineNum = 44;BA.debugLine="RemoveMenu";
_removemenu();
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private Root As B4XView 'ignore";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 3;BA.debugLine="Private XUI As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 4;BA.debugLine="Private Drawer As B4XDrawer";
_drawer = new com.vehicle.tracker.b4xdrawer();
 //BA.debugLineNum = 5;BA.debugLine="Private Sidebar As SidebarCls";
_sidebar = new com.vehicle.tracker.sidebarcls();
 //BA.debugLineNum = 6;BA.debugLine="Private Pager As ASViewPager";
_pager = new com.vehicle.tracker.asviewpager();
 //BA.debugLineNum = 7;BA.debugLine="Private Dashboard As DashboardPane";
_dashboard = new com.vehicle.tracker.dashboardpane();
 //BA.debugLineNum = 8;BA.debugLine="Private Vehicle As VehiclePane";
_vehicle = new com.vehicle.tracker.vehiclepane();
 //BA.debugLineNum = 9;BA.debugLine="Private Customer As CustomerPane";
_customer = new com.vehicle.tracker.customerpane();
 //BA.debugLineNum = 10;BA.debugLine="Private Rental As RentalPane";
_rental = new com.vehicle.tracker.rentalpane();
 //BA.debugLineNum = 11;BA.debugLine="Private Report As ReportPane";
_report = new com.vehicle.tracker.reportpane();
 //BA.debugLineNum = 12;BA.debugLine="Private Account As AccountPane";
_account = new com.vehicle.tracker.accountpane();
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public Object  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 16;BA.debugLine="Public Sub Initialize As Object";
 //BA.debugLineNum = 17;BA.debugLine="Return Me";
if (true) return this;
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return null;
}
public String  _initmenu() throws Exception{
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bd = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _icon = null;
 //BA.debugLineNum = 59;BA.debugLine="Private Sub InitMenu";
 //BA.debugLineNum = 60;BA.debugLine="B4XPages.GetManager.ActionBar.RunMethod(\"setDispl";
_b4xpages._getmanager /*com.vehicle.tracker.b4xpagesmanager*/ (ba)._actionbar /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("setDisplayHomeAsUpEnabled",new Object[]{(Object)(__c.True)});
 //BA.debugLineNum = 61;BA.debugLine="Dim bd As BitmapDrawable";
_bd = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 62;BA.debugLine="Dim icon As B4XBitmap = XUI.LoadBitmapResize(File";
_icon = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_icon = _xui.LoadBitmapResize(__c.File.getDirAssets(),"menu36.png",__c.DipToCurrent((int) (32)),__c.DipToCurrent((int) (32)),__c.True);
 //BA.debugLineNum = 63;BA.debugLine="bd.Initialize(icon)";
_bd.Initialize((android.graphics.Bitmap)(_icon.getObject()));
 //BA.debugLineNum = 64;BA.debugLine="B4XPages.GetManager.ActionBar.RunMethod(\"setHomeA";
_b4xpages._getmanager /*com.vehicle.tracker.b4xpagesmanager*/ (ba)._actionbar /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("setHomeAsUpIndicator",new Object[]{(Object)(_bd.getObject())});
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public void  _logout() throws Exception{
ResumableSub_Logout rsub = new ResumableSub_Logout(this);
rsub.resume(ba, null);
}
public static class ResumableSub_Logout extends BA.ResumableSub {
public ResumableSub_Logout(com.vehicle.tracker.menupage parent) {
this.parent = parent;
}
com.vehicle.tracker.menupage parent;
anywheresoftware.b4a.objects.CSBuilder _cs_title = null;
anywheresoftware.b4a.objects.CSBuilder _cs_msg = null;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 83;BA.debugLine="Dim cs_title As CSBuilder";
_cs_title = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 84;BA.debugLine="cs_title.Initialize";
_cs_title.Initialize();
 //BA.debugLineNum = 85;BA.debugLine="cs_title.Size(20)";
_cs_title.Size((int) (20));
 //BA.debugLineNum = 86;BA.debugLine="cs_title.Bold";
_cs_title.Bold();
 //BA.debugLineNum = 87;BA.debugLine="cs_title.Typeface(Typeface.LoadFromAssets(\"Roboto";
_cs_title.Typeface(parent.__c.Typeface.LoadFromAssets("Roboto-Regular.ttf"));
 //BA.debugLineNum = 88;BA.debugLine="cs_title.Color(Config.COLOR_MATERIAL_BLACK)";
_cs_title.Color(parent._config._color_material_black /*int*/ );
 //BA.debugLineNum = 89;BA.debugLine="cs_title.Append(Config.APP_TITLE)";
_cs_title.Append(BA.ObjectToCharSequence(parent._config._app_title /*String*/ ));
 //BA.debugLineNum = 90;BA.debugLine="cs_title.PopAll";
_cs_title.PopAll();
 //BA.debugLineNum = 92;BA.debugLine="Dim cs_msg As CSBuilder";
_cs_msg = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 93;BA.debugLine="cs_msg.Initialize";
_cs_msg.Initialize();
 //BA.debugLineNum = 94;BA.debugLine="cs_msg.Size(18)";
_cs_msg.Size((int) (18));
 //BA.debugLineNum = 95;BA.debugLine="cs_msg.Typeface(Typeface.LoadFromAssets(\"Roboto-R";
_cs_msg.Typeface(parent.__c.Typeface.LoadFromAssets("Roboto-Regular.ttf"));
 //BA.debugLineNum = 96;BA.debugLine="cs_msg.Color(Config.COLOR_MATERIAL_BLACK)";
_cs_msg.Color(parent._config._color_material_black /*int*/ );
 //BA.debugLineNum = 97;BA.debugLine="cs_msg.Append(\"Are you sure you want to log out?\"";
_cs_msg.Append(BA.ObjectToCharSequence("Are you sure you want to log out?"));
 //BA.debugLineNum = 98;BA.debugLine="cs_msg.PopAll";
_cs_msg.PopAll();
 //BA.debugLineNum = 100;BA.debugLine="Msgbox2Async(cs_msg, cs_title, \"Yes\", \"Cancel\", \"";
parent.__c.Msgbox2Async(BA.ObjectToCharSequence(_cs_msg.getObject()),BA.ObjectToCharSequence(_cs_title.getObject()),"Yes","Cancel","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(parent.__c.Null)),ba,parent.__c.True);
 //BA.debugLineNum = 101;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
parent.__c.WaitFor("msgbox_result", ba, this, null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 102;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==parent.__c.DialogResponse.POSITIVE) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 103;BA.debugLine="B4XPages.ShowPageAndRemovePreviousPages(\"login\")";
parent._b4xpages._showpageandremovepreviouspages /*String*/ (ba,"login");
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _msgbox_result(int _result) throws Exception{
}
public String  _pager_pagechanged(int _index) throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Private Sub Pager_PageChanged(Index As Int)";
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public String  _removemenu() throws Exception{
 //BA.debugLineNum = 67;BA.debugLine="Private Sub RemoveMenu";
 //BA.debugLineNum = 68;BA.debugLine="B4XPages.GetManager.ActionBar.RunMethod(\"setHomeA";
_b4xpages._getmanager /*com.vehicle.tracker.b4xpagesmanager*/ (ba)._actionbar /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("setHomeAsUpIndicator",new Object[]{(Object)(0)});
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public String  _sidebar_selected(int _index,String _tag) throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Public Sub Sidebar_Selected(Index As Int, Tag As S";
 //BA.debugLineNum = 72;BA.debugLine="Drawer.LeftOpen = False";
_drawer._setleftopen /*boolean*/ (__c.False);
 //BA.debugLineNum = 74;BA.debugLine="If SubExists(Me, Tag) Then";
if (__c.SubExists(ba,this,_tag)) { 
 //BA.debugLineNum = 75;BA.debugLine="CallSub(Me, Tag)";
__c.CallSubNew(ba,this,_tag);
 //BA.debugLineNum = 76;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 79;BA.debugLine="Pager.CurrentIndex2 = Index";
_pager._setcurrentindex2(_index);
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
