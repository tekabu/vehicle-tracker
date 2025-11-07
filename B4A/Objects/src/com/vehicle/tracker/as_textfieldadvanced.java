package com.vehicle.tracker;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class as_textfieldadvanced extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.vehicle.tracker.as_textfieldadvanced");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.vehicle.tracker.as_textfieldadvanced.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_title _g_title = null;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_information _g_information = null;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_counter _g_counter = null;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_hint _g_hint = null;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_leadingicon _g_leadingicon = null;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_trailingicon _g_trailingicon = null;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_prefix _g_prefix = null;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_suffix _g_suffix = null;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_textfieldproperties _g_textfieldproperties = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_textfieldbackground = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xtf_textfield = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xtf_textfieldpassword = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xtf_multiline = null;
public com.vehicle.tracker.as_comboboxintern _xcb_combobox = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_hint = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_floatinghinttitle = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_clearbutton = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_revealbutton = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_passwordstrengthbackground = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_underline = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_internpreproperties = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_buttontext = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_title = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_titlereqiredfield = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_counter = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_info = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_leadingicon = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_trailingicon = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xiv_leadingicon = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xiv_trailingicon = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_prefix = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_suffix = null;
public float _m_customleadingwidth = 0f;
public float _m_customtrailingwidth = 0f;
public String _m_mode = "";
public int _m_backgroundcolor = 0;
public String _m_keyboardtype = "";
public boolean _m_passwordfield = false;
public boolean _m_showrevealbutton = false;
public boolean _m_showclearbutton = false;
public boolean _m_readonly = false;
public String _m_textalignment = "";
public boolean _m_ignoretextchangeevent = false;
public float _m_titlewidth = 0f;
public int _m_clearandrevealbuttoncolor = 0;
public int _m_textcolor = 0;
public String _m_strengthindicator = "";
public boolean _m_requiredfield = false;
public int _m_requiredfieldcolor = 0;
public boolean _m_underline = false;
public String _m_titlemode = "";
public String _m_oldtext = "";
public String _m_internoldtext = "";
public String _m_mask = "";
public String _m_masktext = "";
public float _m_bottomheight = 0f;
public anywheresoftware.b4a.objects.IME _ime = null;
public float _m_leftgap = 0f;
public float _m_topgap = 0f;
public boolean _m_hasfocus = false;
public boolean _m_ispasswordmode = false;
public boolean _m_isinrequiredmode = false;
public boolean _m_isviewready = false;
public anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
public boolean _m_lasttohint = false;
public b4a.example.dateutils _dateutils = null;
public com.vehicle.tracker.main _main = null;
public com.vehicle.tracker.starter _starter = null;
public com.vehicle.tracker.config _config = null;
public com.vehicle.tracker.xuiviewsutils _xuiviewsutils = null;
public com.vehicle.tracker.b4xpages _b4xpages = null;
public com.vehicle.tracker.b4xcollections _b4xcollections = null;
public static class _astextfieldadvanced_title{
public boolean IsInitialized;
public boolean Visible;
public String Text;
public float Height;
public boolean IgnoreProperties;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont xFont;
public int FocusedTextColor;
public int NonFocusedTextColor;
public String HorizontalAlignment;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtitle View;
public void Initialize() {
IsInitialized = true;
Visible = false;
Text = "";
Height = 0f;
IgnoreProperties = false;
xFont = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
FocusedTextColor = 0;
NonFocusedTextColor = 0;
HorizontalAlignment = "";
View = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtitle();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_information{
public boolean IsInitialized;
public boolean Visible;
public String Text;
public boolean IgnoreProperties;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont xFont;
public int TextColor;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewinformation View;
public void Initialize() {
IsInitialized = true;
Visible = false;
Text = "";
IgnoreProperties = false;
xFont = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
TextColor = 0;
View = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewinformation();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_counter{
public boolean IsInitialized;
public boolean Visible;
public int CounterMax;
public boolean IgnoreProperties;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont xFont;
public int TextColor;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewcounter View;
public void Initialize() {
IsInitialized = true;
Visible = false;
CounterMax = 0;
IgnoreProperties = false;
xFont = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
TextColor = 0;
View = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewcounter();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_hint{
public boolean IsInitialized;
public boolean Visible;
public String Text;
public boolean IgnoreProperties;
public int FocusedTextColor;
public int NonFocusedTextColor;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont xFont;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewhint View;
public void Initialize() {
IsInitialized = true;
Visible = false;
Text = "";
IgnoreProperties = false;
FocusedTextColor = 0;
NonFocusedTextColor = 0;
xFont = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
View = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewhint();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_leadingicon{
public boolean IsInitialized;
public boolean Visible;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper Icon;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewleadingicon View;
public void Initialize() {
IsInitialized = true;
Visible = false;
Icon = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
View = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewleadingicon();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_trailingicon{
public boolean IsInitialized;
public boolean Visible;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper Icon;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtrailingicon View;
public void Initialize() {
IsInitialized = true;
Visible = false;
Icon = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
View = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtrailingicon();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_prefix{
public boolean IsInitialized;
public boolean Visible;
public String Text;
public boolean IgnoreProperties;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont xFont;
public int TextColor;
public float Gap;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewprefixsuffix View;
public void Initialize() {
IsInitialized = true;
Visible = false;
Text = "";
IgnoreProperties = false;
xFont = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
TextColor = 0;
Gap = 0f;
View = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewprefixsuffix();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_suffix{
public boolean IsInitialized;
public boolean Visible;
public String Text;
public boolean IgnoreProperties;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont xFont;
public int TextColor;
public float Gap;
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewprefixsuffix View;
public void Initialize() {
IsInitialized = true;
Visible = false;
Text = "";
IgnoreProperties = false;
xFont = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
TextColor = 0;
Gap = 0f;
View = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewprefixsuffix();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_textfieldproperties{
public boolean IsInitialized;
public int FocusedShapeColor;
public int NonFocusedShapeColor;
public float BorderWidth;
public float CornerRadius;
public void Initialize() {
IsInitialized = true;
FocusedShapeColor = 0;
NonFocusedShapeColor = 0;
BorderWidth = 0f;
CornerRadius = 0f;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_viewhint{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.B4XViewWrapper xlbl_Hint;
public void Initialize() {
IsInitialized = true;
xlbl_Hint = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_viewcounter{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.B4XViewWrapper xlbl_Counter;
public void Initialize() {
IsInitialized = true;
xlbl_Counter = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_viewtitle{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.B4XViewWrapper xlbl_Title;
public void Initialize() {
IsInitialized = true;
xlbl_Title = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_viewinformation{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.B4XViewWrapper xlbl_Information;
public void Initialize() {
IsInitialized = true;
xlbl_Information = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_viewleadingicon{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.B4XViewWrapper xpnl_Background;
public anywheresoftware.b4a.objects.B4XViewWrapper xiv_Icon;
public void Initialize() {
IsInitialized = true;
xpnl_Background = new anywheresoftware.b4a.objects.B4XViewWrapper();
xiv_Icon = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_viewtrailingicon{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.B4XViewWrapper xpnl_Background;
public anywheresoftware.b4a.objects.B4XViewWrapper xiv_Icon;
public void Initialize() {
IsInitialized = true;
xpnl_Background = new anywheresoftware.b4a.objects.B4XViewWrapper();
xiv_Icon = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _astextfieldadvanced_viewprefixsuffix{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.B4XViewWrapper xlbl_PrefixSuffix;
public void Initialize() {
IsInitialized = true;
xlbl_PrefixSuffix = new anywheresoftware.b4a.objects.B4XViewWrapper();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _applymask(String _text,String _mask,String _start) throws Exception{
String _textclear = "";
anywheresoftware.b4a.keywords.StringBuilderWrapper _textmasked = null;
int _zeros = 0;
int _i = 0;
char _c = '\0';
char _t = '\0';
 //BA.debugLineNum = 2072;BA.debugLine="Private Sub applyMask(Text As String, Mask As Stri";
 //BA.debugLineNum = 2073;BA.debugLine="Dim textClear As String = lettersAndNumbers(Text)";
_textclear = _lettersandnumbers(_text);
 //BA.debugLineNum = 2074;BA.debugLine="Dim textMasked As StringBuilder";
_textmasked = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 2075;BA.debugLine="textMasked.Initialize";
_textmasked.Initialize();
 //BA.debugLineNum = 2077;BA.debugLine="Try";
try { //BA.debugLineNum = 2080;BA.debugLine="Dim zeros As Int = 0";
_zeros = (int) (0);
 //BA.debugLineNum = 2081;BA.debugLine="For i = 0 To (Mask.Length-1)";
{
final int step6 = 1;
final int limit6 = (int) ((_mask.length()-1));
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 2082;BA.debugLine="If Mask.CharAt(i)=\"0\" Then";
if (_mask.charAt(_i)==BA.ObjectToChar("0")) { 
 //BA.debugLineNum = 2083;BA.debugLine="zeros = zeros + 1";
_zeros = (int) (_zeros+1);
 };
 }
};
 //BA.debugLineNum = 2087;BA.debugLine="If zeros > 0 Then";
if (_zeros>0) { 
 //BA.debugLineNum = 2088;BA.debugLine="If IsNumber(textClear) Then";
if (__c.IsNumber(_textclear)) { 
 //BA.debugLineNum = 2089;BA.debugLine="textClear = textClear.As(Long)";
_textclear = BA.NumberToString(((long)(Double.parseDouble(_textclear))));
 };
 };
 //BA.debugLineNum = 2094;BA.debugLine="If zeros > textClear.Length Then";
if (_zeros>_textclear.length()) { 
 //BA.debugLineNum = 2095;BA.debugLine="textClear = \"0000000000000000000000000000000000";
_textclear = "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"+_textclear;
 //BA.debugLineNum = 2096;BA.debugLine="textClear = textClear.SubString(textClear.Lengt";
_textclear = _textclear.substring((int) (_textclear.length()-_zeros));
 };
 //BA.debugLineNum = 2099;BA.debugLine="If Start=\"Left\" Then";
if ((_start).equals("Left")) { 
 //BA.debugLineNum = 2100;BA.debugLine="For i = 1 To Mask.Length";
{
final int step21 = 1;
final int limit21 = _mask.length();
_i = (int) (1) ;
for (;_i <= limit21 ;_i = _i + step21 ) {
 //BA.debugLineNum = 2101;BA.debugLine="Dim c As Char = Mask.CharAt(i-1)";
_c = _mask.charAt((int) (_i-1));
 //BA.debugLineNum = 2102;BA.debugLine="If (c=\"X\" And textClear.Length>0) Or (c=\"0\" An";
if ((_c==BA.ObjectToChar("X") && _textclear.length()>0) || (_c==BA.ObjectToChar("0") && _textclear.length()>0)) { 
 //BA.debugLineNum = 2103;BA.debugLine="Dim t As Char = textClear.CharAt(0)'get the l";
_t = _textclear.charAt((int) (0));
 //BA.debugLineNum = 2104;BA.debugLine="textClear = textClear.SubString(1)'remove the";
_textclear = _textclear.substring((int) (1));
 //BA.debugLineNum = 2105;BA.debugLine="textMasked.Append(t)";
_textmasked.Append(BA.ObjectToString(_t));
 }else {
 //BA.debugLineNum = 2107;BA.debugLine="If c=\"X\" Or textClear.Length=0 Then";
if (_c==BA.ObjectToChar("X") || _textclear.length()==0) { 
 //BA.debugLineNum = 2108;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 2110;BA.debugLine="textMasked.Append(c)";
_textmasked.Append(BA.ObjectToString(_c));
 };
 }
};
 }else if((_start).equals("Right")) { 
 //BA.debugLineNum = 2115;BA.debugLine="For i = Mask.Length To 1 Step -1";
{
final int step35 = -1;
final int limit35 = (int) (1);
_i = _mask.length() ;
for (;_i >= limit35 ;_i = _i + step35 ) {
 //BA.debugLineNum = 2116;BA.debugLine="Dim c As Char = Mask.CharAt(i-1)";
_c = _mask.charAt((int) (_i-1));
 //BA.debugLineNum = 2117;BA.debugLine="If (c=\"X\" And textClear.Length>0) Or (c=\"0\" An";
if ((_c==BA.ObjectToChar("X") && _textclear.length()>0) || (_c==BA.ObjectToChar("0") && _textclear.length()>0)) { 
 //BA.debugLineNum = 2118;BA.debugLine="Dim t As Char = textClear.CharAt(textClear.Le";
_t = _textclear.charAt((int) (_textclear.length()-1));
 //BA.debugLineNum = 2119;BA.debugLine="textClear = textClear.SubString2(0,textClear.";
_textclear = _textclear.substring((int) (0),(int) (_textclear.length()-1));
 //BA.debugLineNum = 2120;BA.debugLine="textMasked.Insert(0, t)";
_textmasked.Insert((int) (0),BA.ObjectToString(_t));
 }else {
 //BA.debugLineNum = 2122;BA.debugLine="If c=\"X\" Or textClear.Length=0 Then";
if (_c==BA.ObjectToChar("X") || _textclear.length()==0) { 
 //BA.debugLineNum = 2123;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 2125;BA.debugLine="textMasked.Insert(0, c)";
_textmasked.Insert((int) (0),BA.ObjectToString(_c));
 };
 }
};
 };
 } 
       catch (Exception e50) {
			ba.setLastException(e50); //BA.debugLineNum = 2130;BA.debugLine="Log(LastException)";
__c.LogImpl("922151226",BA.ObjectToString(__c.LastException(ba)),0);
 };
 //BA.debugLineNum = 2133;BA.debugLine="Return textMasked.ToString";
if (true) return _textmasked.ToString();
 //BA.debugLineNum = 2134;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
float _textfieldheight = 0f;
float _actionbuttongap = 0f;
float _textfieldtop = 0f;
float _textfieldleft = 0f;
float _textfieldwidth = 0f;
float _actionbuttonswidth = 0f;
float _textfieldinputleft = 0f;
float _textfield_width = 0f;
float _iconwidthheight = 0f;
 //BA.debugLineNum = 649;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 651;BA.debugLine="xlbl_Title.Visible = g_Title.Visible";
_xlbl_title.setVisible(_g_title.Visible /*boolean*/ );
 //BA.debugLineNum = 652;BA.debugLine="xlbl_TitleReqiredField.Visible = m_RequiredField";
_xlbl_titlereqiredfield.setVisible(_m_requiredfield);
 //BA.debugLineNum = 653;BA.debugLine="xlbl_Counter.Visible = g_Counter.Visible";
_xlbl_counter.setVisible(_g_counter.Visible /*boolean*/ );
 //BA.debugLineNum = 654;BA.debugLine="xlbl_Info.Visible = g_Information.Visible";
_xlbl_info.setVisible(_g_information.Visible /*boolean*/ );
 //BA.debugLineNum = 655;BA.debugLine="xpnl_LeadingIcon.Visible = g_LeadingIcon.Visible";
_xpnl_leadingicon.setVisible(_g_leadingicon.Visible /*boolean*/ );
 //BA.debugLineNum = 656;BA.debugLine="xpnl_TrailingIcon.Visible = g_TrailingIcon.Visibl";
_xpnl_trailingicon.setVisible(_g_trailingicon.Visible /*boolean*/ );
 //BA.debugLineNum = 657;BA.debugLine="xlbl_Prefix.Visible = g_Prefix.Visible And m_Mode";
_xlbl_prefix.setVisible(_g_prefix.Visible /*boolean*/  && (_m_mode).equals("Multiline") == false);
 //BA.debugLineNum = 658;BA.debugLine="xlbl_Suffix.Visible = g_Suffix.Visible And m_Mode";
_xlbl_suffix.setVisible(_g_suffix.Visible /*boolean*/  && (_m_mode).equals("Multiline") == false);
 //BA.debugLineNum = 660;BA.debugLine="Dim TextFieldHeight As Float = Height";
_textfieldheight = (float) (_height);
 //BA.debugLineNum = 661;BA.debugLine="If g_Title.Visible And m_TitleMode <> \"BeforeText";
if (_g_title.Visible /*boolean*/  && (_m_titlemode).equals("BeforeTextField") == false) { 
 //BA.debugLineNum = 662;BA.debugLine="TextFieldHeight = Height - g_Title.Height";
_textfieldheight = (float) (_height-_g_title.Height /*float*/ );
 };
 //BA.debugLineNum = 665;BA.debugLine="If g_Counter.Visible Or g_Information.Visible The";
if (_g_counter.Visible /*boolean*/  || _g_information.Visible /*boolean*/ ) { 
 //BA.debugLineNum = 666;BA.debugLine="TextFieldHeight = TextFieldHeight - m_BottomHeig";
_textfieldheight = (float) (_textfieldheight-_m_bottomheight);
 };
 //BA.debugLineNum = 669;BA.debugLine="If m_PasswordField And m_StrengthIndicator <> \"No";
if (_m_passwordfield && (_m_strengthindicator).equals("None") == false) { 
 //BA.debugLineNum = 670;BA.debugLine="TextFieldHeight = TextFieldHeight - 20dip";
_textfieldheight = (float) (_textfieldheight-__c.DipToCurrent((int) (20)));
 };
 //BA.debugLineNum = 673;BA.debugLine="Dim ActionButtonGap As Float = 5dip";
_actionbuttongap = (float) (__c.DipToCurrent((int) (5)));
 //BA.debugLineNum = 675;BA.debugLine="Dim TextFieldTop As Float";
_textfieldtop = 0f;
 //BA.debugLineNum = 676;BA.debugLine="Dim TextFieldLeft As Float";
_textfieldleft = 0f;
 //BA.debugLineNum = 677;BA.debugLine="Dim TextFieldWidth As Float";
_textfieldwidth = 0f;
 //BA.debugLineNum = 678;BA.debugLine="If m_TitleMode = \"BeforeTextField\" Then";
if ((_m_titlemode).equals("BeforeTextField")) { 
 //BA.debugLineNum = 679;BA.debugLine="TextFieldTop = 0";
_textfieldtop = (float) (0);
 //BA.debugLineNum = 680;BA.debugLine="TextFieldLeft = m_TitleWidth";
_textfieldleft = _m_titlewidth;
 //BA.debugLineNum = 681;BA.debugLine="TextFieldWidth = Width - m_TitleWidth";
_textfieldwidth = (float) (_width-_m_titlewidth);
 }else {
 //BA.debugLineNum = 683;BA.debugLine="TextFieldTop = IIf(g_Title.Visible,g_Title.Heigh";
_textfieldtop = (float)(BA.ObjectToNumber(((_g_title.Visible /*boolean*/ ) ? ((Object)(_g_title.Height /*float*/ )) : ((Object)(0)))));
 //BA.debugLineNum = 684;BA.debugLine="TextFieldLeft = 0";
_textfieldleft = (float) (0);
 //BA.debugLineNum = 685;BA.debugLine="TextFieldWidth = Width";
_textfieldwidth = (float) (_width);
 };
 //BA.debugLineNum = 688;BA.debugLine="xpnl_LeadingIcon.SetLayoutAnimated(0,0,m_TopGap,I";
_xpnl_leadingicon.SetLayoutAnimated((int) (0),(int) (0),(int) (_m_topgap),(int)(BA.ObjectToNumber(((_m_customleadingwidth==0) ? ((Object)(_textfieldheight)) : ((Object)(_m_customleadingwidth))))),(int) (_textfieldheight-_m_topgap*2));
 //BA.debugLineNum = 689;BA.debugLine="xpnl_TrailingIcon.SetLayoutAnimated(0,TextFieldWi";
_xpnl_trailingicon.SetLayoutAnimated((int) (0),(int) (_textfieldwidth-_textfieldheight),(int) (_m_topgap),(int)(BA.ObjectToNumber(((_m_customtrailingwidth==0) ? ((Object)(_textfieldheight)) : ((Object)(_m_customtrailingwidth))))),(int) (_textfieldheight-_m_topgap*2));
 //BA.debugLineNum = 691;BA.debugLine="xpnl_TextFieldBackground.SetLayoutAnimated(0,Text";
_xpnl_textfieldbackground.SetLayoutAnimated((int) (0),(int) (_textfieldleft),(int) (_textfieldtop),(int) (_textfieldwidth),(int) (_textfieldheight));
 //BA.debugLineNum = 692;BA.debugLine="xlbl_Title.SetLayoutAnimated(0,0,0,IIf(m_TitleMod";
_xlbl_title.SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int)(BA.ObjectToNumber((((_m_titlemode).equals("BeforeTextField")) ? ((Object)(_m_titlewidth)) : ((Object)(_width))))),(int)(BA.ObjectToNumber((((_m_titlemode).equals("BeforeTextField")) ? ((Object)(_textfieldheight)) : ((Object)(_g_title.Height /*float*/ ))))));
 //BA.debugLineNum = 693;BA.debugLine="xlbl_TitleReqiredField.SetLayoutAnimated(0,Measur";
_xlbl_titlereqiredfield.SetLayoutAnimated((int) (0),_measuretextwidth(_xlbl_title.getText(),_xlbl_title.getFont()),(int) (0),_measuretextwidth(_xlbl_titlereqiredfield.getText(),_xlbl_titlereqiredfield.getFont()),(int) (_xlbl_title.getHeight()-_xlbl_titlereqiredfield.getFont().getSize()/(double)2));
 //BA.debugLineNum = 694;BA.debugLine="xlbl_Counter.SetLayoutAnimated(0,0,Height - m_Bot";
_xlbl_counter.SetLayoutAnimated((int) (0),(int) (0),(int) (_height-_m_bottomheight),(int) (_width),(int) (_m_bottomheight));
 //BA.debugLineNum = 695;BA.debugLine="xlbl_Info.SetLayoutAnimated(0,TextFieldLeft,Heigh";
_xlbl_info.SetLayoutAnimated((int) (0),(int) (_textfieldleft),(int) (_height-_m_bottomheight),(int) (_textfieldwidth),(int) (_m_bottomheight));
 //BA.debugLineNum = 696;BA.debugLine="xpnl_Underline.SetLayoutAnimated(0,TextFieldLeft,";
_xpnl_underline.SetLayoutAnimated((int) (0),(int) (_textfieldleft),(int) (_textfieldtop+_textfieldheight-__c.DipToCurrent((int) (2))),(int) (_textfieldwidth),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 698;BA.debugLine="If m_PasswordField And m_StrengthIndicator <> \"No";
if (_m_passwordfield && (_m_strengthindicator).equals("None") == false) { 
 //BA.debugLineNum = 699;BA.debugLine="xpnl_PasswordStrengthBackground.SetLayoutAnimate";
_xpnl_passwordstrengthbackground.SetLayoutAnimated((int) (0),(int) (_textfieldleft),(int) (_height-__c.DipToCurrent((int) (20))-(double)(BA.ObjectToNumber(((_xlbl_info.getVisible()) ? ((Object)(_xlbl_info.getHeight())) : ((Object)(0)))))),(int) (_textfieldwidth),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 700;BA.debugLine="DrawPasswordStrengthIndicator";
_drawpasswordstrengthindicator();
 };
 //BA.debugLineNum = 703;BA.debugLine="Dim ActionButtonsWidth As Float = 24dip'xpnl_Text";
_actionbuttonswidth = (float) (__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 705;BA.debugLine="xlbl_ClearButton.SetLayoutAnimated(0,TextFieldWid";
_xlbl_clearbutton.SetLayoutAnimated((int) (0),(int) (_textfieldwidth-(double)(BA.ObjectToNumber(((_g_trailingicon.Visible /*boolean*/ ) ? ((Object)(_textfieldheight)) : ((Object)(_actionbuttongap)))))-_actionbuttonswidth),(int) (_m_topgap),(int) (_actionbuttonswidth),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));
 //BA.debugLineNum = 706;BA.debugLine="xlbl_RevealButton.SetLayoutAnimated(0,TextFieldWi";
_xlbl_revealbutton.SetLayoutAnimated((int) (0),(int) (_textfieldwidth-(double)(BA.ObjectToNumber(((_g_trailingicon.Visible /*boolean*/ ) ? ((Object)(_textfieldheight)) : ((Object)(_actionbuttongap*(double)(BA.ObjectToNumber(((_m_showclearbutton) ? ((Object)(3)) : ((Object)(1))))))))))-_actionbuttonswidth*(double)(BA.ObjectToNumber(((_m_showclearbutton) ? ((Object)(2)) : ((Object)(1)))))),(int) (_m_topgap),(int) (_actionbuttonswidth),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));
 //BA.debugLineNum = 708;BA.debugLine="xlbl_Prefix.SetLayoutAnimated(0,0,m_TopGap,Measur";
_xlbl_prefix.SetLayoutAnimated((int) (0),(int) (0),(int) (_m_topgap),(int) (_measuretextwidth(_xlbl_prefix.getText(),_xlbl_prefix.getFont())+_g_prefix.Gap /*float*/ ),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));
 //BA.debugLineNum = 711;BA.debugLine="Dim TextFieldInputLeft As Float = m_LeftGap + IIf";
_textfieldinputleft = (float) (_m_leftgap+(double)(BA.ObjectToNumber(((_xlbl_prefix.getVisible()) ? ((Object)(_xlbl_prefix.getWidth())) : ((Object)(0))))));
 //BA.debugLineNum = 712;BA.debugLine="Dim TextField_Width As Float = TextFieldWidth - I";
_textfield_width = (float) (_textfieldwidth-(double)(BA.ObjectToNumber(((_m_showclearbutton) ? ((Object)(_actionbuttonswidth+(double)(BA.ObjectToNumber(((_g_trailingicon.Visible /*boolean*/ ) ? ((Object)(0)) : ((Object)(_actionbuttongap))))))) : ((Object)(0)))))-(double)(BA.ObjectToNumber(((_m_showrevealbutton && _m_passwordfield) ? ((Object)(_actionbuttonswidth+_actionbuttongap*(double)(BA.ObjectToNumber(((_m_showclearbutton) ? ((Object)(3)) : ((Object)(1))))))) : ((Object)(__c.DipToCurrent((int) (5)))))))-(double)(BA.ObjectToNumber(((_xlbl_prefix.getVisible()) ? ((Object)(_xlbl_prefix.getWidth())) : ((Object)(0)))))*(double)(BA.ObjectToNumber(((_m_showrevealbutton || _m_showclearbutton) ? ((Object)(1)) : ((Object)(2))))));
 //BA.debugLineNum = 714;BA.debugLine="If g_LeadingIcon.Visible Then TextField_Width = T";
if (_g_leadingicon.Visible /*boolean*/ ) { 
_textfield_width = (float) (_textfield_width-_xpnl_leadingicon.getWidth());};
 //BA.debugLineNum = 715;BA.debugLine="If g_TrailingIcon.Visible Then TextField_Width =";
if (_g_trailingicon.Visible /*boolean*/ ) { 
_textfield_width = (float) (_textfield_width-_xpnl_trailingicon.getWidth()-_actionbuttongap);};
 //BA.debugLineNum = 717;BA.debugLine="TextField_Width = TextField_Width - TextFieldInpu";
_textfield_width = (float) (_textfield_width-_textfieldinputleft);
 //BA.debugLineNum = 719;BA.debugLine="If g_LeadingIcon.Visible Then TextFieldInputLeft";
if (_g_leadingicon.Visible /*boolean*/ ) { 
_textfieldinputleft = (float) (_textfieldinputleft+_xpnl_leadingicon.getWidth());};
 //BA.debugLineNum = 721;BA.debugLine="xlbl_Prefix.Left = TextFieldInputLeft - xlbl_Pref";
_xlbl_prefix.setLeft((int) (_textfieldinputleft-_xlbl_prefix.getWidth()));
 //BA.debugLineNum = 723;BA.debugLine="Dim IconWidthHeight As Float = xpnl_LeadingIcon.H";
_iconwidthheight = (float) (_xpnl_leadingicon.getHeight()/(double)2);
 //BA.debugLineNum = 725;BA.debugLine="xiv_LeadingIcon.SetLayoutAnimated(0,xpnl_LeadingI";
_xiv_leadingicon.SetLayoutAnimated((int) (0),(int) (_xpnl_leadingicon.getWidth()/(double)2-_iconwidthheight/(double)2),(int) (_xpnl_leadingicon.getHeight()/(double)2-_iconwidthheight/(double)2),(int) (_iconwidthheight),(int) (_iconwidthheight));
 //BA.debugLineNum = 726;BA.debugLine="xiv_TrailingIcon.SetLayoutAnimated(0,xpnl_Trailin";
_xiv_trailingicon.SetLayoutAnimated((int) (0),(int) (_xpnl_trailingicon.getWidth()/(double)2-_iconwidthheight/(double)2),(int) (_xpnl_trailingicon.getHeight()/(double)2-_iconwidthheight/(double)2),(int) (_iconwidthheight),(int) (_iconwidthheight));
 //BA.debugLineNum = 728;BA.debugLine="If g_LeadingIcon.Icon <> Null And g_LeadingIcon.I";
if (_g_leadingicon.Icon /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ != null && _g_leadingicon.Icon /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ .IsInitialized()==__c.True) { 
_setleadingicon2(_g_leadingicon.Icon /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ );};
 //BA.debugLineNum = 729;BA.debugLine="If g_TrailingIcon.Icon <> Null And g_TrailingIcon";
if (_g_trailingicon.Icon /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ != null && _g_trailingicon.Icon /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ .IsInitialized()==__c.True) { 
_settrailingicon2(_g_trailingicon.Icon /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ );};
 //BA.debugLineNum = 732;BA.debugLine="If xtf_TextField.IsInitialized Then xtf_TextField";
if (_xtf_textfield.IsInitialized()) { 
_xtf_textfield.SetLayoutAnimated((int) (0),(int) (_textfieldinputleft),(int) (_m_topgap),(int) (_textfield_width),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));};
 //BA.debugLineNum = 734;BA.debugLine="xlbl_Suffix.SetLayoutAnimated(0,TextFieldInputLef";
_xlbl_suffix.SetLayoutAnimated((int) (0),(int) (_textfieldinputleft+_textfield_width-_measuretextwidth(_xlbl_suffix.getText(),_xlbl_suffix.getFont())-_g_suffix.Gap /*float*/ ),(int) (_m_topgap),(int) (_measuretextwidth(_xlbl_suffix.getText(),_xlbl_suffix.getFont())+_g_prefix.Gap /*float*/ ),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));
 //BA.debugLineNum = 735;BA.debugLine="If xlbl_Suffix.Visible Then";
if (_xlbl_suffix.getVisible()) { 
 //BA.debugLineNum = 736;BA.debugLine="TextField_Width = TextField_Width - xlbl_Suffix.";
_textfield_width = (float) (_textfield_width-_xlbl_suffix.getWidth());
 //BA.debugLineNum = 737;BA.debugLine="If xtf_TextField.IsInitialized Then xtf_TextFiel";
if (_xtf_textfield.IsInitialized()) { 
_xtf_textfield.setWidth((int) (_textfield_width));};
 };
 //BA.debugLineNum = 740;BA.debugLine="If xtf_TextFieldPassword.IsInitialized Then xtf_T";
if (_xtf_textfieldpassword.IsInitialized()) { 
_xtf_textfieldpassword.SetLayoutAnimated((int) (0),(int) (_textfieldinputleft),(int) (_m_topgap),(int) (_textfield_width),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));};
 //BA.debugLineNum = 741;BA.debugLine="xlbl_ButtonText.SetLayoutAnimated(0,TextFieldInpu";
_xlbl_buttontext.SetLayoutAnimated((int) (0),(int) (_textfieldinputleft),(int) (_m_topgap),(int) (_textfield_width),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));
 //BA.debugLineNum = 742;BA.debugLine="If m_Mode <> \"Multiline\" Then";
if ((_m_mode).equals("Multiline") == false) { 
 //BA.debugLineNum = 743;BA.debugLine="xlbl_Hint.SetLayoutAnimated(0,TextFieldInputLeft";
_xlbl_hint.SetLayoutAnimated((int) (0),(int) (_textfieldinputleft),(int) (_m_topgap),(int) (_textfield_width),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));
 }else {
 //BA.debugLineNum = 745;BA.debugLine="xlbl_Hint.SetLayoutAnimated(0,TextFieldInputLeft";
_xlbl_hint.SetLayoutAnimated((int) (0),(int) (_textfieldinputleft+_m_leftgap),(int) (__c.DipToCurrent((int) (5))+_m_topgap),(int) (_textfield_width-_textfieldinputleft-_m_leftgap*2),(int) (_textfieldheight-__c.DipToCurrent((int) (10))-_m_topgap*2));
 //BA.debugLineNum = 751;BA.debugLine="xlbl_Prefix.Visible = False";
_xlbl_prefix.setVisible(__c.False);
 //BA.debugLineNum = 752;BA.debugLine="xlbl_RevealButton.Visible = False";
_xlbl_revealbutton.setVisible(__c.False);
 //BA.debugLineNum = 753;BA.debugLine="xlbl_Suffix.Visible = False";
_xlbl_suffix.setVisible(__c.False);
 //BA.debugLineNum = 754;BA.debugLine="xpnl_LeadingIcon.Visible = False";
_xpnl_leadingicon.setVisible(__c.False);
 //BA.debugLineNum = 755;BA.debugLine="xpnl_TrailingIcon.Visible = False";
_xpnl_trailingicon.setVisible(__c.False);
 };
 //BA.debugLineNum = 757;BA.debugLine="MoveFloatingHint(getText.Length = 0,False)";
_movefloatinghint(_gettext().length()==0,__c.False);
 //BA.debugLineNum = 759;BA.debugLine="If xtf_Multiline.IsInitialized Then";
if (_xtf_multiline.IsInitialized()) { 
 //BA.debugLineNum = 765;BA.debugLine="xtf_Multiline.SetLayoutAnimated(0,xlbl_Hint.Left";
_xtf_multiline.SetLayoutAnimated((int) (0),_xlbl_hint.getLeft(),(int) (__c.DipToCurrent((int) (5))+_m_topgap),(int) (_textfield_width-(_xlbl_hint.getLeft()*2)),(int) (_textfieldheight-__c.DipToCurrent((int) (10))-_m_topgap*2));
 };
 //BA.debugLineNum = 769;BA.debugLine="If xcb_ComboBox.IsInitialized Then";
if (_xcb_combobox.IsInitialized /*boolean*/ ()) { 
 //BA.debugLineNum = 771;BA.debugLine="xlbl_ButtonText.Height = xlbl_ButtonText.Height";
_xlbl_buttontext.setHeight((int) (_xlbl_buttontext.getHeight()-__c.DipToCurrent((int) (5))));
 //BA.debugLineNum = 772;BA.debugLine="xlbl_ButtonText.Top = xlbl_ButtonText.Top + 5dip";
_xlbl_buttontext.setTop((int) (_xlbl_buttontext.getTop()+__c.DipToCurrent((int) (5))/(double)2));
 //BA.debugLineNum = 774;BA.debugLine="xcb_ComboBox.mBase.SetLayoutAnimated(0,xlbl_Hint";
_xcb_combobox._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),_xlbl_hint.getLeft(),_xlbl_hint.getTop(),(int) (_textfield_width),_xlbl_hint.getHeight());
 //BA.debugLineNum = 775;BA.debugLine="CallSub3(xcb_ComboBox, \"Base_Resize\", TextField_";
__c.CallSubNew3(ba,(Object)(_xcb_combobox),"Base_Resize",(Object)(_textfield_width),(Object)(_xcb_combobox._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight()));
 };
 //BA.debugLineNum = 778;BA.debugLine="End Sub";
return "";
}
public String  _buttonclick() throws Exception{
 //BA.debugLineNum = 1844;BA.debugLine="Private Sub ButtonClick";
 //BA.debugLineNum = 1846;BA.debugLine="If m_Mode = \"ComboBox\" Then";
if ((_m_mode).equals("ComboBox")) { 
 //BA.debugLineNum = 1847;BA.debugLine="OpenComboBoxIntern(xcb_ComboBox)";
_opencomboboxintern(_xcb_combobox);
 };
 //BA.debugLineNum = 1850;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_Button";
if (_xui.SubExists(ba,_mcallback,_meventname+"_ButtonClick",(int) (0))) { 
 //BA.debugLineNum = 1851;BA.debugLine="CallSub(mCallBack, mEventName & \"_ButtonClick\")";
__c.CallSubNew(ba,_mcallback,_meventname+"_ButtonClick");
 };
 //BA.debugLineNum = 1853;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 257;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 259;BA.debugLine="Type ASTextFieldAdvanced_Title(Visible As Boolean";
;
 //BA.debugLineNum = 260;BA.debugLine="Type ASTextFieldAdvanced_Information(Visible As B";
;
 //BA.debugLineNum = 261;BA.debugLine="Type ASTextFieldAdvanced_Counter(Visible As Boole";
;
 //BA.debugLineNum = 262;BA.debugLine="Type ASTextFieldAdvanced_Hint(Visible As Boolean,";
;
 //BA.debugLineNum = 263;BA.debugLine="Type ASTextFieldAdvanced_LeadingIcon(Visible As B";
;
 //BA.debugLineNum = 264;BA.debugLine="Type ASTextFieldAdvanced_TrailingIcon(Visible As";
;
 //BA.debugLineNum = 265;BA.debugLine="Type ASTextFieldAdvanced_Prefix(Visible As Boolea";
;
 //BA.debugLineNum = 266;BA.debugLine="Type ASTextFieldAdvanced_Suffix(Visible As Boolea";
;
 //BA.debugLineNum = 267;BA.debugLine="Type ASTextFieldAdvanced_TextFieldProperties(Focu";
;
 //BA.debugLineNum = 269;BA.debugLine="Type ASTextFieldAdvanced_ViewHint(xlbl_Hint As B4";
;
 //BA.debugLineNum = 270;BA.debugLine="Type ASTextFieldAdvanced_ViewCounter(xlbl_Counter";
;
 //BA.debugLineNum = 271;BA.debugLine="Type ASTextFieldAdvanced_ViewTitle(xlbl_Title As";
;
 //BA.debugLineNum = 272;BA.debugLine="Type ASTextFieldAdvanced_ViewInformation(xlbl_Inf";
;
 //BA.debugLineNum = 273;BA.debugLine="Type ASTextFieldAdvanced_ViewLeadingIcon(xpnl_Bac";
;
 //BA.debugLineNum = 274;BA.debugLine="Type ASTextFieldAdvanced_ViewTrailingIcon(xpnl_Ba";
;
 //BA.debugLineNum = 275;BA.debugLine="Type ASTextFieldAdvanced_ViewPrefixSuffix(xlbl_Pr";
;
 //BA.debugLineNum = 277;BA.debugLine="Private g_Title As ASTextFieldAdvanced_Title";
_g_title = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_title();
 //BA.debugLineNum = 278;BA.debugLine="Private g_Information As ASTextFieldAdvanced_Info";
_g_information = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_information();
 //BA.debugLineNum = 279;BA.debugLine="Private g_Counter As ASTextFieldAdvanced_Counter";
_g_counter = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_counter();
 //BA.debugLineNum = 280;BA.debugLine="Private g_Hint As ASTextFieldAdvanced_Hint";
_g_hint = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_hint();
 //BA.debugLineNum = 281;BA.debugLine="Private g_LeadingIcon As ASTextFieldAdvanced_Lead";
_g_leadingicon = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_leadingicon();
 //BA.debugLineNum = 282;BA.debugLine="Private g_TrailingIcon As ASTextFieldAdvanced_Tra";
_g_trailingicon = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_trailingicon();
 //BA.debugLineNum = 283;BA.debugLine="Private g_Prefix As ASTextFieldAdvanced_Prefix";
_g_prefix = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_prefix();
 //BA.debugLineNum = 284;BA.debugLine="Private g_Suffix As ASTextFieldAdvanced_Suffix";
_g_suffix = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_suffix();
 //BA.debugLineNum = 285;BA.debugLine="Private g_TextFieldProperties As ASTextFieldAdvan";
_g_textfieldproperties = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_textfieldproperties();
 //BA.debugLineNum = 287;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
 //BA.debugLineNum = 288;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
 //BA.debugLineNum = 289;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 290;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 291;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 293;BA.debugLine="Private xpnl_TextFieldBackground As B4XView";
_xpnl_textfieldbackground = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 294;BA.debugLine="Private xtf_TextField As B4XView";
_xtf_textfield = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 295;BA.debugLine="Private xtf_TextFieldPassword As B4XView";
_xtf_textfieldpassword = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 296;BA.debugLine="Private xtf_Multiline As B4XView";
_xtf_multiline = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 297;BA.debugLine="Private xcb_ComboBox As AS_ComboBoxIntern";
_xcb_combobox = new com.vehicle.tracker.as_comboboxintern();
 //BA.debugLineNum = 298;BA.debugLine="Private xlbl_Hint As B4XView";
_xlbl_hint = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 299;BA.debugLine="Private xlbl_FloatingHintTitle As B4XView";
_xlbl_floatinghinttitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 300;BA.debugLine="Private xlbl_ClearButton As B4XView";
_xlbl_clearbutton = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 301;BA.debugLine="Private xlbl_RevealButton As B4XView";
_xlbl_revealbutton = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 302;BA.debugLine="Private xpnl_PasswordStrengthBackground As B4XVie";
_xpnl_passwordstrengthbackground = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 303;BA.debugLine="Private xpnl_Underline As B4XView";
_xpnl_underline = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 305;BA.debugLine="Private xlbl_InternPreProperties As B4XView";
_xlbl_internpreproperties = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 307;BA.debugLine="Private xlbl_ButtonText As B4XView";
_xlbl_buttontext = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 309;BA.debugLine="Private xlbl_Title As B4XView";
_xlbl_title = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 310;BA.debugLine="Private xlbl_TitleReqiredField As B4XView";
_xlbl_titlereqiredfield = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 312;BA.debugLine="Private xlbl_Counter As B4XView";
_xlbl_counter = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 313;BA.debugLine="Private xlbl_Info As B4XView";
_xlbl_info = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 315;BA.debugLine="Private xpnl_LeadingIcon As B4XView";
_xpnl_leadingicon = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 316;BA.debugLine="Private xpnl_TrailingIcon As B4XView";
_xpnl_trailingicon = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 318;BA.debugLine="Private xiv_LeadingIcon As B4XView";
_xiv_leadingicon = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 319;BA.debugLine="Private xiv_TrailingIcon As B4XView";
_xiv_trailingicon = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 321;BA.debugLine="Private xlbl_Prefix As B4XView";
_xlbl_prefix = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 322;BA.debugLine="Private xlbl_Suffix As B4XView";
_xlbl_suffix = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 324;BA.debugLine="Private m_CustomLeadingWidth As Float";
_m_customleadingwidth = 0f;
 //BA.debugLineNum = 325;BA.debugLine="Private m_CustomTrailingWidth As Float";
_m_customtrailingwidth = 0f;
 //BA.debugLineNum = 327;BA.debugLine="Private m_Mode As String";
_m_mode = "";
 //BA.debugLineNum = 329;BA.debugLine="Private m_BackgroundColor As Int";
_m_backgroundcolor = 0;
 //BA.debugLineNum = 330;BA.debugLine="Private m_KeyboardType As String";
_m_keyboardtype = "";
 //BA.debugLineNum = 331;BA.debugLine="Private m_PasswordField As Boolean";
_m_passwordfield = false;
 //BA.debugLineNum = 332;BA.debugLine="Private m_ShowRevealButton As Boolean";
_m_showrevealbutton = false;
 //BA.debugLineNum = 333;BA.debugLine="Private m_ShowClearButton As Boolean";
_m_showclearbutton = false;
 //BA.debugLineNum = 334;BA.debugLine="Private m_ReadOnly As Boolean = False";
_m_readonly = __c.False;
 //BA.debugLineNum = 335;BA.debugLine="Private m_TextAlignment As String";
_m_textalignment = "";
 //BA.debugLineNum = 336;BA.debugLine="Private m_IgnoreTextChangeEvent As Boolean = Fals";
_m_ignoretextchangeevent = __c.False;
 //BA.debugLineNum = 337;BA.debugLine="Private m_TitleWidth As Float";
_m_titlewidth = 0f;
 //BA.debugLineNum = 339;BA.debugLine="Private m_ClearAndRevealButtonColor As Int";
_m_clearandrevealbuttoncolor = 0;
 //BA.debugLineNum = 340;BA.debugLine="Private m_TextColor As Int";
_m_textcolor = 0;
 //BA.debugLineNum = 341;BA.debugLine="Private m_StrengthIndicator As String";
_m_strengthindicator = "";
 //BA.debugLineNum = 342;BA.debugLine="Private m_RequiredField As Boolean";
_m_requiredfield = false;
 //BA.debugLineNum = 343;BA.debugLine="Private m_RequiredFieldColor As Int";
_m_requiredfieldcolor = 0;
 //BA.debugLineNum = 344;BA.debugLine="Private m_Underline As Boolean";
_m_underline = false;
 //BA.debugLineNum = 345;BA.debugLine="Private m_TitleMode As String";
_m_titlemode = "";
 //BA.debugLineNum = 346;BA.debugLine="Private m_OldText As String = \"\"";
_m_oldtext = "";
 //BA.debugLineNum = 347;BA.debugLine="Private m_InternOldText As String";
_m_internoldtext = "";
 //BA.debugLineNum = 350;BA.debugLine="Private m_Mask As String";
_m_mask = "";
 //BA.debugLineNum = 351;BA.debugLine="Private m_MaskText As String";
_m_masktext = "";
 //BA.debugLineNum = 353;BA.debugLine="Private m_BottomHeight As Float";
_m_bottomheight = 0f;
 //BA.debugLineNum = 360;BA.debugLine="Private IME As IME";
_ime = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 363;BA.debugLine="Private m_LeftGap As Float = 10dip";
_m_leftgap = (float) (__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 364;BA.debugLine="Private m_TopGap As Float = 0dip";
_m_topgap = (float) (__c.DipToCurrent((int) (0)));
 //BA.debugLineNum = 365;BA.debugLine="Private m_HasFocus As Boolean = False";
_m_hasfocus = __c.False;
 //BA.debugLineNum = 366;BA.debugLine="Private m_isPasswordMode As Boolean = False";
_m_ispasswordmode = __c.False;
 //BA.debugLineNum = 367;BA.debugLine="Private m_isInRequiredMode As Boolean = False";
_m_isinrequiredmode = __c.False;
 //BA.debugLineNum = 368;BA.debugLine="Private m_isViewReady As Boolean = False";
_m_isviewready = __c.False;
 //BA.debugLineNum = 369;BA.debugLine="Private bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 370;BA.debugLine="Private m_LastToHint As Boolean = False";
_m_lasttohint = __c.False;
 //BA.debugLineNum = 371;BA.debugLine="End Sub";
return "";
}
public String  _clearbutton_click() throws Exception{
 //BA.debugLineNum = 1581;BA.debugLine="Private Sub ClearButton_Click";
 //BA.debugLineNum = 1582;BA.debugLine="If m_ReadOnly Then Return";
if (_m_readonly) { 
if (true) return "";};
 //BA.debugLineNum = 1583;BA.debugLine="m_OldText = getText";
_m_oldtext = _gettext();
 //BA.debugLineNum = 1584;BA.debugLine="If xtf_TextField.IsInitialized Then xtf_TextField";
if (_xtf_textfield.IsInitialized()) { 
_xtf_textfield.setText(BA.ObjectToCharSequence(""));};
 //BA.debugLineNum = 1585;BA.debugLine="If xtf_TextFieldPassword.IsInitialized Then xtf_T";
if (_xtf_textfieldpassword.IsInitialized()) { 
_xtf_textfieldpassword.setText(BA.ObjectToCharSequence(""));};
 //BA.debugLineNum = 1586;BA.debugLine="If xtf_Multiline.IsInitialized Then xtf_Multiline";
if (_xtf_multiline.IsInitialized()) { 
_xtf_multiline.setText(BA.ObjectToCharSequence(""));};
 //BA.debugLineNum = 1587;BA.debugLine="xlbl_ButtonText.Text = \"\"";
_xlbl_buttontext.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 1588;BA.debugLine="TextChanged(\"\")";
_textchanged("");
 //BA.debugLineNum = 1589;BA.debugLine="ClearButtonClick";
_clearbuttonclick();
 //BA.debugLineNum = 1590;BA.debugLine="End Sub";
return "";
}
public String  _clearbuttonclick() throws Exception{
 //BA.debugLineNum = 1659;BA.debugLine="Private Sub ClearButtonClick";
 //BA.debugLineNum = 1660;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_ClearB";
if (_xui.SubExists(ba,_mcallback,_meventname+"_ClearButtonClick",(int) (0))) { 
 //BA.debugLineNum = 1661;BA.debugLine="CallSub(mCallBack, mEventName & \"_ClearButtonCli";
__c.CallSubNew(ba,_mcallback,_meventname+"_ClearButtonClick");
 };
 //BA.debugLineNum = 1663;BA.debugLine="End Sub";
return "";
}
public String  _comboboxselectedindexchanged(int _index) throws Exception{
 //BA.debugLineNum = 1822;BA.debugLine="Private Sub ComboBoxSelectedIndexChanged(Index As";
 //BA.debugLineNum = 1823;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_ComboB";
if (_xui.SubExists(ba,_mcallback,_meventname+"_ComboBoxSelectedIndexChanged",(int) (1))) { 
 //BA.debugLineNum = 1824;BA.debugLine="CallSub2(mCallBack, mEventName & \"_ComboBoxSelec";
__c.CallSubNew2(ba,_mcallback,_meventname+"_ComboBoxSelectedIndexChanged",(Object)(_index));
 };
 //BA.debugLineNum = 1826;BA.debugLine="End Sub";
return "";
}
public int  _countmatches(String _text,String _pattern) throws Exception{
int _tmp_count = 0;
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _matcher1 = null;
 //BA.debugLineNum = 1812;BA.debugLine="Private Sub CountMatches(text As String,pattern As";
 //BA.debugLineNum = 1813;BA.debugLine="Dim tmp_count As Int = 0";
_tmp_count = (int) (0);
 //BA.debugLineNum = 1814;BA.debugLine="Dim Matcher1 As Matcher";
_matcher1 = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
 //BA.debugLineNum = 1815;BA.debugLine="Matcher1 = Regex.Matcher(pattern, text)";
_matcher1 = __c.Regex.Matcher(_pattern,_text);
 //BA.debugLineNum = 1816;BA.debugLine="Do While Matcher1.Find";
while (_matcher1.Find()) {
 //BA.debugLineNum = 1817;BA.debugLine="tmp_count = tmp_count +1";
_tmp_count = (int) (_tmp_count+1);
 }
;
 //BA.debugLineNum = 1819;BA.debugLine="Return tmp_count";
if (true) return _tmp_count;
 //BA.debugLineNum = 1820;BA.debugLine="End Sub";
return 0;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_counter  _createastextfieldadvanced_counter(boolean _visible,int _countermax,boolean _ignoreproperties,anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _xfont,int _textcolor,com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewcounter _view) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_counter _t1 = null;
 //BA.debugLineNum = 2226;BA.debugLine="Private Sub CreateASTextFieldAdvanced_Counter (Vis";
 //BA.debugLineNum = 2227;BA.debugLine="Dim t1 As ASTextFieldAdvanced_Counter";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_counter();
 //BA.debugLineNum = 2228;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2229;BA.debugLine="t1.Visible = Visible";
_t1.Visible /*boolean*/  = _visible;
 //BA.debugLineNum = 2230;BA.debugLine="t1.CounterMax = CounterMax";
_t1.CounterMax /*int*/  = _countermax;
 //BA.debugLineNum = 2231;BA.debugLine="t1.IgnoreProperties = IgnoreProperties";
_t1.IgnoreProperties /*boolean*/  = _ignoreproperties;
 //BA.debugLineNum = 2232;BA.debugLine="t1.xFont = xFont";
_t1.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _xfont;
 //BA.debugLineNum = 2233;BA.debugLine="t1.TextColor = TextColor";
_t1.TextColor /*int*/  = _textcolor;
 //BA.debugLineNum = 2234;BA.debugLine="t1.View = View";
_t1.View /*com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewcounter*/  = _view;
 //BA.debugLineNum = 2235;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2236;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_hint  _createastextfieldadvanced_hint(boolean _visible,String _text,boolean _ignoreproperties,int _focusedtextcolor,int _nonfocusedtextcolor,anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _xfont,com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewhint _view) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_hint _t1 = null;
 //BA.debugLineNum = 2245;BA.debugLine="Private Sub CreateASTextFieldAdvanced_Hint (Visibl";
 //BA.debugLineNum = 2246;BA.debugLine="Dim t1 As ASTextFieldAdvanced_Hint";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_hint();
 //BA.debugLineNum = 2247;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2248;BA.debugLine="t1.Visible = Visible";
_t1.Visible /*boolean*/  = _visible;
 //BA.debugLineNum = 2249;BA.debugLine="t1.Text = Text";
_t1.Text /*String*/  = _text;
 //BA.debugLineNum = 2250;BA.debugLine="t1.IgnoreProperties = IgnoreProperties";
_t1.IgnoreProperties /*boolean*/  = _ignoreproperties;
 //BA.debugLineNum = 2251;BA.debugLine="t1.FocusedTextColor = FocusedTextColor";
_t1.FocusedTextColor /*int*/  = _focusedtextcolor;
 //BA.debugLineNum = 2252;BA.debugLine="t1.NonFocusedTextColor = NonFocusedTextColor";
_t1.NonFocusedTextColor /*int*/  = _nonfocusedtextcolor;
 //BA.debugLineNum = 2253;BA.debugLine="t1.xFont = xFont";
_t1.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _xfont;
 //BA.debugLineNum = 2254;BA.debugLine="t1.View = View";
_t1.View /*com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewhint*/  = _view;
 //BA.debugLineNum = 2255;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2256;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_information  _createastextfieldadvanced_information(boolean _visible,String _text,boolean _ignoreproperties,anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _xfont,int _textcolor,com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewinformation _view) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_information _t1 = null;
 //BA.debugLineNum = 2207;BA.debugLine="Private Sub CreateASTextFieldAdvanced_Information";
 //BA.debugLineNum = 2208;BA.debugLine="Dim t1 As ASTextFieldAdvanced_Information";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_information();
 //BA.debugLineNum = 2209;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2210;BA.debugLine="t1.Visible = Visible";
_t1.Visible /*boolean*/  = _visible;
 //BA.debugLineNum = 2211;BA.debugLine="t1.Text = Text";
_t1.Text /*String*/  = _text;
 //BA.debugLineNum = 2212;BA.debugLine="t1.IgnoreProperties = IgnoreProperties";
_t1.IgnoreProperties /*boolean*/  = _ignoreproperties;
 //BA.debugLineNum = 2213;BA.debugLine="t1.xFont = xFont";
_t1.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _xfont;
 //BA.debugLineNum = 2214;BA.debugLine="t1.TextColor = TextColor";
_t1.TextColor /*int*/  = _textcolor;
 //BA.debugLineNum = 2215;BA.debugLine="t1.View = View";
_t1.View /*com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewinformation*/  = _view;
 //BA.debugLineNum = 2216;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2217;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_leadingicon  _createastextfieldadvanced_leadingicon(boolean _visible,anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _icon,com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewleadingicon _view) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_leadingicon _t1 = null;
 //BA.debugLineNum = 2175;BA.debugLine="Private Sub CreateASTextFieldAdvanced_LeadingIcon";
 //BA.debugLineNum = 2176;BA.debugLine="Dim t1 As ASTextFieldAdvanced_LeadingIcon";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_leadingicon();
 //BA.debugLineNum = 2177;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2178;BA.debugLine="t1.Visible = Visible";
_t1.Visible /*boolean*/  = _visible;
 //BA.debugLineNum = 2179;BA.debugLine="t1.Icon = Icon";
_t1.Icon /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/  = _icon;
 //BA.debugLineNum = 2180;BA.debugLine="t1.View = View";
_t1.View /*com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewleadingicon*/  = _view;
 //BA.debugLineNum = 2181;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2182;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_prefix  _createastextfieldadvanced_prefix(boolean _visible,String _text,boolean _ignoreproperties,anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _xfont,int _textcolor,float _gap,com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewprefixsuffix _view) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_prefix _t1 = null;
 //BA.debugLineNum = 2279;BA.debugLine="Private Sub CreateASTextFieldAdvanced_Prefix (Visi";
 //BA.debugLineNum = 2280;BA.debugLine="Dim t1 As ASTextFieldAdvanced_Prefix";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_prefix();
 //BA.debugLineNum = 2281;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2282;BA.debugLine="t1.Visible = Visible";
_t1.Visible /*boolean*/  = _visible;
 //BA.debugLineNum = 2283;BA.debugLine="t1.Text = Text";
_t1.Text /*String*/  = _text;
 //BA.debugLineNum = 2284;BA.debugLine="t1.IgnoreProperties = IgnoreProperties";
_t1.IgnoreProperties /*boolean*/  = _ignoreproperties;
 //BA.debugLineNum = 2285;BA.debugLine="t1.xFont = xFont";
_t1.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _xfont;
 //BA.debugLineNum = 2286;BA.debugLine="t1.TextColor = TextColor";
_t1.TextColor /*int*/  = _textcolor;
 //BA.debugLineNum = 2287;BA.debugLine="t1.Gap = Gap";
_t1.Gap /*float*/  = _gap;
 //BA.debugLineNum = 2288;BA.debugLine="t1.View = View";
_t1.View /*com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewprefixsuffix*/  = _view;
 //BA.debugLineNum = 2289;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2290;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_suffix  _createastextfieldadvanced_suffix(boolean _visible,String _text,boolean _ignoreproperties,anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _xfont,int _textcolor,float _gap,com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewprefixsuffix _view) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_suffix _t1 = null;
 //BA.debugLineNum = 2266;BA.debugLine="Private Sub CreateASTextFieldAdvanced_Suffix (Visi";
 //BA.debugLineNum = 2267;BA.debugLine="Dim t1 As ASTextFieldAdvanced_Suffix";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_suffix();
 //BA.debugLineNum = 2268;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2269;BA.debugLine="t1.Visible = Visible";
_t1.Visible /*boolean*/  = _visible;
 //BA.debugLineNum = 2270;BA.debugLine="t1.Text = Text";
_t1.Text /*String*/  = _text;
 //BA.debugLineNum = 2271;BA.debugLine="t1.IgnoreProperties = IgnoreProperties";
_t1.IgnoreProperties /*boolean*/  = _ignoreproperties;
 //BA.debugLineNum = 2272;BA.debugLine="t1.xFont = xFont";
_t1.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _xfont;
 //BA.debugLineNum = 2273;BA.debugLine="t1.TextColor = TextColor";
_t1.TextColor /*int*/  = _textcolor;
 //BA.debugLineNum = 2274;BA.debugLine="t1.Gap = Gap";
_t1.Gap /*float*/  = _gap;
 //BA.debugLineNum = 2275;BA.debugLine="t1.View = View";
_t1.View /*com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewprefixsuffix*/  = _view;
 //BA.debugLineNum = 2276;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2277;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_textfieldproperties  _createastextfieldadvanced_textfieldproperties(int _focusedshapecolor,int _nonfocusedshapecolor,float _borderwidth,float _cornerradius) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_textfieldproperties _t1 = null;
 //BA.debugLineNum = 2292;BA.debugLine="Private Sub CreateASTextFieldAdvanced_TextFieldPro";
 //BA.debugLineNum = 2293;BA.debugLine="Dim t1 As ASTextFieldAdvanced_TextFieldProperties";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_textfieldproperties();
 //BA.debugLineNum = 2294;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2295;BA.debugLine="t1.FocusedShapeColor = FocusedShapeColor";
_t1.FocusedShapeColor /*int*/  = _focusedshapecolor;
 //BA.debugLineNum = 2296;BA.debugLine="t1.NonFocusedShapeColor = NonFocusedShapeColor";
_t1.NonFocusedShapeColor /*int*/  = _nonfocusedshapecolor;
 //BA.debugLineNum = 2297;BA.debugLine="t1.BorderWidth = BorderWidth";
_t1.BorderWidth /*float*/  = _borderwidth;
 //BA.debugLineNum = 2298;BA.debugLine="t1.CornerRadius = CornerRadius";
_t1.CornerRadius /*float*/  = _cornerradius;
 //BA.debugLineNum = 2299;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2300;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_title  _createastextfieldadvanced_title(boolean _visible,String _text,float _height,boolean _ignoreproperties,anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _xfont,int _focusedtextcolor,int _nonfocusedtextcolor,String _horizontalalignment,com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtitle _view) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_title _t1 = null;
 //BA.debugLineNum = 2302;BA.debugLine="Public Sub CreateASTextFieldAdvanced_Title (Visibl";
 //BA.debugLineNum = 2303;BA.debugLine="Dim t1 As ASTextFieldAdvanced_Title";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_title();
 //BA.debugLineNum = 2304;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2305;BA.debugLine="t1.Visible = Visible";
_t1.Visible /*boolean*/  = _visible;
 //BA.debugLineNum = 2306;BA.debugLine="t1.Text = Text";
_t1.Text /*String*/  = _text;
 //BA.debugLineNum = 2307;BA.debugLine="t1.Height = Height";
_t1.Height /*float*/  = _height;
 //BA.debugLineNum = 2308;BA.debugLine="t1.IgnoreProperties = IgnoreProperties";
_t1.IgnoreProperties /*boolean*/  = _ignoreproperties;
 //BA.debugLineNum = 2309;BA.debugLine="t1.xFont = xFont";
_t1.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _xfont;
 //BA.debugLineNum = 2310;BA.debugLine="t1.FocusedTextColor = FocusedTextColor";
_t1.FocusedTextColor /*int*/  = _focusedtextcolor;
 //BA.debugLineNum = 2311;BA.debugLine="t1.NonFocusedTextColor = NonFocusedTextColor";
_t1.NonFocusedTextColor /*int*/  = _nonfocusedtextcolor;
 //BA.debugLineNum = 2312;BA.debugLine="t1.HorizontalAlignment = HorizontalAlignment";
_t1.HorizontalAlignment /*String*/  = _horizontalalignment;
 //BA.debugLineNum = 2313;BA.debugLine="t1.View = View";
_t1.View /*com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtitle*/  = _view;
 //BA.debugLineNum = 2314;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2315;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_trailingicon  _createastextfieldadvanced_trailingicon(boolean _visible,anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _icon,com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtrailingicon _view) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_trailingicon _t1 = null;
 //BA.debugLineNum = 2184;BA.debugLine="Private Sub CreateASTextFieldAdvanced_TrailingIcon";
 //BA.debugLineNum = 2185;BA.debugLine="Dim t1 As ASTextFieldAdvanced_TrailingIcon";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_trailingicon();
 //BA.debugLineNum = 2186;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2187;BA.debugLine="t1.Visible = Visible";
_t1.Visible /*boolean*/  = _visible;
 //BA.debugLineNum = 2188;BA.debugLine="t1.Icon = Icon";
_t1.Icon /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/  = _icon;
 //BA.debugLineNum = 2189;BA.debugLine="t1.View = View";
_t1.View /*com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtrailingicon*/  = _view;
 //BA.debugLineNum = 2190;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2191;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewcounter  _createastextfieldadvanced_viewcounter(anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_counter2) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewcounter _t1 = null;
 //BA.debugLineNum = 2219;BA.debugLine="Private Sub CreateASTextFieldAdvanced_ViewCounter";
 //BA.debugLineNum = 2220;BA.debugLine="Dim t1 As ASTextFieldAdvanced_ViewCounter";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewcounter();
 //BA.debugLineNum = 2221;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2222;BA.debugLine="t1.xlbl_Counter = xlbl_Counter2";
_t1.xlbl_Counter /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = _xlbl_counter2;
 //BA.debugLineNum = 2223;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2224;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewhint  _createastextfieldadvanced_viewhint(anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_hint2) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewhint _t1 = null;
 //BA.debugLineNum = 2238;BA.debugLine="Private Sub CreateASTextFieldAdvanced_ViewHint (xl";
 //BA.debugLineNum = 2239;BA.debugLine="Dim t1 As ASTextFieldAdvanced_ViewHint";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewhint();
 //BA.debugLineNum = 2240;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2241;BA.debugLine="t1.xlbl_Hint = xlbl_Hint2";
_t1.xlbl_Hint /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = _xlbl_hint2;
 //BA.debugLineNum = 2242;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2243;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewinformation  _createastextfieldadvanced_viewinformation(anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_information) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewinformation _t1 = null;
 //BA.debugLineNum = 2200;BA.debugLine="Private Sub CreateASTextFieldAdvanced_ViewInformat";
 //BA.debugLineNum = 2201;BA.debugLine="Dim t1 As ASTextFieldAdvanced_ViewInformation";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewinformation();
 //BA.debugLineNum = 2202;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2203;BA.debugLine="t1.xlbl_Information = xlbl_Information";
_t1.xlbl_Information /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = _xlbl_information;
 //BA.debugLineNum = 2204;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2205;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewleadingicon  _createastextfieldadvanced_viewleadingicon(anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_background,anywheresoftware.b4a.objects.B4XViewWrapper _xiv_icon) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewleadingicon _t1 = null;
 //BA.debugLineNum = 2159;BA.debugLine="Private Sub CreateASTextFieldAdvanced_ViewLeadingI";
 //BA.debugLineNum = 2160;BA.debugLine="Dim t1 As ASTextFieldAdvanced_ViewLeadingIcon";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewleadingicon();
 //BA.debugLineNum = 2161;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2162;BA.debugLine="t1.xpnl_Background = xpnl_Background";
_t1.xpnl_Background /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = _xpnl_background;
 //BA.debugLineNum = 2163;BA.debugLine="t1.xiv_Icon = xiv_Icon";
_t1.xiv_Icon /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = _xiv_icon;
 //BA.debugLineNum = 2164;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2165;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewprefixsuffix  _createastextfieldadvanced_viewprefixsuffix(anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_prefixsuffix) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewprefixsuffix _t1 = null;
 //BA.debugLineNum = 2258;BA.debugLine="Private Sub CreateASTextFieldAdvanced_ViewPrefixSu";
 //BA.debugLineNum = 2259;BA.debugLine="Dim t1 As ASTextFieldAdvanced_ViewPrefixSuffix";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewprefixsuffix();
 //BA.debugLineNum = 2260;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2261;BA.debugLine="t1.xlbl_PrefixSuffix = xlbl_PrefixSuffix";
_t1.xlbl_PrefixSuffix /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = _xlbl_prefixsuffix;
 //BA.debugLineNum = 2262;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2263;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtitle  _createastextfieldadvanced_viewtitle(anywheresoftware.b4a.objects.B4XViewWrapper _xlbl_title2) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtitle _t1 = null;
 //BA.debugLineNum = 2193;BA.debugLine="Private Sub CreateASTextFieldAdvanced_ViewTitle (x";
 //BA.debugLineNum = 2194;BA.debugLine="Dim t1 As ASTextFieldAdvanced_ViewTitle";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtitle();
 //BA.debugLineNum = 2195;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2196;BA.debugLine="t1.xlbl_Title = xlbl_Title2";
_t1.xlbl_Title /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = _xlbl_title2;
 //BA.debugLineNum = 2197;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2198;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtrailingicon  _createastextfieldadvanced_viewtrailingicon(anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_background,anywheresoftware.b4a.objects.B4XViewWrapper _xiv_icon) throws Exception{
com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtrailingicon _t1 = null;
 //BA.debugLineNum = 2167;BA.debugLine="Private Sub CreateASTextFieldAdvanced_ViewTrailing";
 //BA.debugLineNum = 2168;BA.debugLine="Dim t1 As ASTextFieldAdvanced_ViewTrailingIcon";
_t1 = new com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_viewtrailingicon();
 //BA.debugLineNum = 2169;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 2170;BA.debugLine="t1.xpnl_Background = xpnl_Background";
_t1.xpnl_Background /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = _xpnl_background;
 //BA.debugLineNum = 2171;BA.debugLine="t1.xiv_Icon = xiv_Icon";
_t1.xiv_Icon /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = _xiv_icon;
 //BA.debugLineNum = 2172;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 2173;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createimageview(String _eventname) throws Exception{
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
 //BA.debugLineNum = 1929;BA.debugLine="Private Sub CreateImageView(EventName As String) A";
 //BA.debugLineNum = 1930;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 1931;BA.debugLine="iv.Initialize(EventName)";
_iv.Initialize(ba,_eventname);
 //BA.debugLineNum = 1932;BA.debugLine="Return iv";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_iv.getObject()));
 //BA.debugLineNum = 1933;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createlabel(String _eventname) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 1916;BA.debugLine="Private Sub CreateLabel(EventName As String) As B4";
 //BA.debugLineNum = 1917;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 1918;BA.debugLine="lbl.Initialize(EventName)";
_lbl.Initialize(ba,_eventname);
 //BA.debugLineNum = 1919;BA.debugLine="Return lbl";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 1920;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createmultinetextfield() throws Exception{
 //BA.debugLineNum = 1935;BA.debugLine="Private Sub CreateMultineTextField As B4XView 'Ign";
 //BA.debugLineNum = 1977;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createtextfield(boolean _password) throws Exception{
anywheresoftware.b4a.objects.EditTextWrapper _tf = null;
 //BA.debugLineNum = 1979;BA.debugLine="Private Sub CreateTextField (Password As Boolean)";
 //BA.debugLineNum = 1989;BA.debugLine="Dim tf As EditText";
_tf = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 1990;BA.debugLine="tf.Initialize(\"xtf_TextField\")";
_tf.Initialize(ba,"xtf_TextField");
 //BA.debugLineNum = 1991;BA.debugLine="tf.SingleLine = IIf(m_Mode = \"Multiline\",False,Tr";
_tf.setSingleLine(BA.ObjectToBoolean((((_m_mode).equals("Multiline")) ? ((Object)(__c.False)) : ((Object)(__c.True)))));
 //BA.debugLineNum = 1992;BA.debugLine="tf.Padding = Array As Int (0, 0, 0, 0)";
_tf.setPadding(new int[]{(int) (0),(int) (0),(int) (0),(int) (0)});
 //BA.debugLineNum = 1993;BA.debugLine="tf.PasswordMode = Password";
_tf.setPasswordMode(_password);
 //BA.debugLineNum = 1994;BA.debugLine="If Password Then";
if (_password) { 
 //BA.debugLineNum = 1995;BA.debugLine="If m_KeyboardType <> \"Text\" Then";
if ((_m_keyboardtype).equals("Text") == false) { 
 //BA.debugLineNum = 1996;BA.debugLine="tf.InputType = Bit.Or(tf.INPUT_TYPE_NUMBERS, 16";
_tf.setInputType(__c.Bit.Or(_tf.INPUT_TYPE_NUMBERS,(int) (16)));
 }else {
 //BA.debugLineNum = 1999;BA.debugLine="tf.PasswordMode = True";
_tf.setPasswordMode(__c.True);
 };
 }else {
 //BA.debugLineNum = 2002;BA.debugLine="Select m_KeyboardType";
switch (BA.switchObjectToInt(_m_keyboardtype,"Numbers","Decimal")) {
case 0: {
 //BA.debugLineNum = 2004;BA.debugLine="tf.InputType = tf.INPUT_TYPE_NUMBERS";
_tf.setInputType(_tf.INPUT_TYPE_NUMBERS);
 break; }
case 1: {
 //BA.debugLineNum = 2006;BA.debugLine="tf.InputType = tf.INPUT_TYPE_DECIMAL_NUMBERS";
_tf.setInputType(_tf.INPUT_TYPE_DECIMAL_NUMBERS);
 break; }
}
;
 };
 //BA.debugLineNum = 2009;BA.debugLine="Return tf";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_tf.getObject()));
 //BA.debugLineNum = 2026;BA.debugLine="End Sub";
return null;
}
public String  _createtextfields() throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_comboboxbackground = null;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl_combobox = null;
 //BA.debugLineNum = 498;BA.debugLine="Private Sub CreateTextFields";
 //BA.debugLineNum = 500;BA.debugLine="If m_Mode = \"TextField\" Then";
if ((_m_mode).equals("TextField")) { 
 //BA.debugLineNum = 501;BA.debugLine="xtf_TextField = CreateTextField(False)";
_xtf_textfield = _createtextfield(__c.False);
 //BA.debugLineNum = 502;BA.debugLine="xpnl_TextFieldBackground.AddView(xtf_TextField,m";
_xpnl_textfieldbackground.AddView((android.view.View)(_xtf_textfield.getObject()),(int) (_m_leftgap),(int) (_m_topgap),(int) (_xpnl_textfieldbackground.getWidth()-_xpnl_textfieldbackground.getHeight()),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));
 //BA.debugLineNum = 505;BA.debugLine="xtf_TextField.Color = xui.Color_Transparent";
_xtf_textfield.setColor(_xui.Color_Transparent);
 //BA.debugLineNum = 506;BA.debugLine="xtf_TextField.TextColor = xlbl_InternPreProperti";
_xtf_textfield.setTextColor(_xlbl_internpreproperties.getTextColor());
 //BA.debugLineNum = 507;BA.debugLine="xtf_TextField.Font = xlbl_InternPreProperties.Fo";
_xtf_textfield.setFont(_xlbl_internpreproperties.getFont());
 //BA.debugLineNum = 508;BA.debugLine="xtf_TextField.SetTextAlignment(\"CENTER\",m_TextAl";
_xtf_textfield.SetTextAlignment("CENTER",_m_textalignment);
 //BA.debugLineNum = 510;BA.debugLine="xlbl_ButtonText.Visible = False";
_xlbl_buttontext.setVisible(__c.False);
 };
 //BA.debugLineNum = 513;BA.debugLine="If m_Mode = \"TextField\" And m_isPasswordMode Then";
if ((_m_mode).equals("TextField") && _m_ispasswordmode) { 
 //BA.debugLineNum = 514;BA.debugLine="xtf_TextFieldPassword = CreateTextField(True)";
_xtf_textfieldpassword = _createtextfield(__c.True);
 //BA.debugLineNum = 515;BA.debugLine="xpnl_TextFieldBackground.AddView(xtf_TextFieldPa";
_xpnl_textfieldbackground.AddView((android.view.View)(_xtf_textfieldpassword.getObject()),(int) (_m_leftgap),(int) (_m_topgap),(int) (_xpnl_textfieldbackground.getWidth()-_xpnl_textfieldbackground.getHeight()),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));
 //BA.debugLineNum = 518;BA.debugLine="xtf_TextFieldPassword.Color = xui.Color_Transpar";
_xtf_textfieldpassword.setColor(_xui.Color_Transparent);
 //BA.debugLineNum = 519;BA.debugLine="xtf_TextFieldPassword.TextColor = xlbl_InternPre";
_xtf_textfieldpassword.setTextColor(_xlbl_internpreproperties.getTextColor());
 //BA.debugLineNum = 520;BA.debugLine="xtf_TextFieldPassword.Font = xlbl_InternPrePrope";
_xtf_textfieldpassword.setFont(_xlbl_internpreproperties.getFont());
 //BA.debugLineNum = 521;BA.debugLine="xtf_TextFieldPassword.SetTextAlignment(\"CENTER\",";
_xtf_textfieldpassword.SetTextAlignment("CENTER",_m_textalignment);
 //BA.debugLineNum = 523;BA.debugLine="If m_PasswordField Then";
if (_m_passwordfield) { 
 //BA.debugLineNum = 524;BA.debugLine="xtf_TextField.Visible = False";
_xtf_textfield.setVisible(__c.False);
 //BA.debugLineNum = 525;BA.debugLine="xtf_TextFieldPassword.Visible = True";
_xtf_textfieldpassword.setVisible(__c.True);
 //BA.debugLineNum = 526;BA.debugLine="xtf_TextFieldPassword.BringToFront";
_xtf_textfieldpassword.BringToFront();
 }else {
 //BA.debugLineNum = 528;BA.debugLine="xtf_TextField.Visible = True";
_xtf_textfield.setVisible(__c.True);
 //BA.debugLineNum = 529;BA.debugLine="xtf_TextFieldPassword.Visible = False";
_xtf_textfieldpassword.setVisible(__c.False);
 //BA.debugLineNum = 530;BA.debugLine="xtf_TextField.BringToFront";
_xtf_textfield.BringToFront();
 };
 };
 //BA.debugLineNum = 535;BA.debugLine="If m_Mode = \"Multiline\" Then";
if ((_m_mode).equals("Multiline")) { 
 //BA.debugLineNum = 536;BA.debugLine="xtf_Multiline = IIf(xui.IsB4A,CreateTextField(Fa";
_xtf_multiline = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(((_xui.getIsB4A()) ? ((Object)(_createtextfield(__c.False).getObject())) : ((Object)(_createmultinetextfield().getObject())))));
 //BA.debugLineNum = 537;BA.debugLine="xpnl_TextFieldBackground.AddView(xtf_Multiline,m";
_xpnl_textfieldbackground.AddView((android.view.View)(_xtf_multiline.getObject()),(int) (_m_leftgap),(int) (_m_topgap),(int) (_xpnl_textfieldbackground.getWidth()-_xpnl_textfieldbackground.getHeight()),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));
 //BA.debugLineNum = 540;BA.debugLine="xtf_Multiline.Color = xui.Color_Transparent";
_xtf_multiline.setColor(_xui.Color_Transparent);
 //BA.debugLineNum = 541;BA.debugLine="xtf_Multiline.TextColor = xlbl_InternPreProperti";
_xtf_multiline.setTextColor(_xlbl_internpreproperties.getTextColor());
 //BA.debugLineNum = 542;BA.debugLine="xtf_Multiline.Font = xlbl_InternPreProperties.Fo";
_xtf_multiline.setFont(_xlbl_internpreproperties.getFont());
 //BA.debugLineNum = 544;BA.debugLine="xtf_Multiline.SetTextAlignment(\"TOP\",m_TextAlign";
_xtf_multiline.SetTextAlignment("TOP",_m_textalignment);
 //BA.debugLineNum = 552;BA.debugLine="xtf_Multiline.BringToFront";
_xtf_multiline.BringToFront();
 //BA.debugLineNum = 554;BA.debugLine="xlbl_ButtonText.Visible = False";
_xlbl_buttontext.setVisible(__c.False);
 };
 //BA.debugLineNum = 557;BA.debugLine="If m_Mode = \"ComboBox\" Then";
if ((_m_mode).equals("ComboBox")) { 
 //BA.debugLineNum = 558;BA.debugLine="Dim xpnl_ComboBoxBackground As B4XView = xui.Cre";
_xpnl_comboboxbackground = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xpnl_comboboxbackground = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 559;BA.debugLine="xpnl_TextFieldBackground.AddView(xpnl_ComboBoxBa";
_xpnl_textfieldbackground.AddView((android.view.View)(_xpnl_comboboxbackground.getObject()),(int) (_m_leftgap),(int) (_m_topgap),(int) (_xpnl_textfieldbackground.getWidth()-_xpnl_textfieldbackground.getHeight()),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));
 //BA.debugLineNum = 560;BA.debugLine="Dim lbl_ComboBox As B4XView = CreateLabel(\"\")";
_lbl_combobox = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl_combobox = _createlabel("");
 //BA.debugLineNum = 561;BA.debugLine="xcb_ComboBox.Initialize(Me,\"xcb_ComboBox\")";
_xcb_combobox._initialize /*String*/ (ba,this,"xcb_ComboBox");
 //BA.debugLineNum = 562;BA.debugLine="xcb_ComboBox.DesignerCreateView(xpnl_ComboBoxBac";
_xcb_combobox._designercreateview /*String*/ ((Object)(_xpnl_comboboxbackground.getObject()),(anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_lbl_combobox.getObject())),__c.createMap(new Object[] {}));
 //BA.debugLineNum = 563;BA.debugLine="xcb_ComboBox.SetItems(Array As String(\"\"))";
_xcb_combobox._setitems /*String*/ (anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{""}));
 //BA.debugLineNum = 565;BA.debugLine="xcb_ComboBox.cmbBox.Visible = False";
_xcb_combobox._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .setVisible(__c.False);
 };
 //BA.debugLineNum = 572;BA.debugLine="xlbl_FloatingHintTitle = CreateLabel(\"\")";
_xlbl_floatinghinttitle = _createlabel("");
 //BA.debugLineNum = 574;BA.debugLine="If m_TitleMode = \"FloatText\" Then";
if ((_m_titlemode).equals("FloatText")) { 
 //BA.debugLineNum = 578;BA.debugLine="mBase.AddView(xlbl_FloatingHintTitle,m_LeftGap,m";
_mbase.AddView((android.view.View)(_xlbl_floatinghinttitle.getObject()),(int) (_m_leftgap),(int) (_m_topgap),_xpnl_textfieldbackground.getWidth(),(int) (_xpnl_textfieldbackground.getHeight()-_m_topgap*2));
 //BA.debugLineNum = 579;BA.debugLine="RefreshFloatingHint";
_refreshfloatinghint();
 };
 //BA.debugLineNum = 582;BA.debugLine="If m_ReadOnly Then setReadOnly(m_ReadOnly)";
if (_m_readonly) { 
_setreadonly(_m_readonly);};
 //BA.debugLineNum = 584;BA.debugLine="End Sub";
return "";
}
public void  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
ResumableSub_DesignerCreateView rsub = new ResumableSub_DesignerCreateView(this,_base,_lbl,_props);
rsub.resume(ba, null);
}
public static class ResumableSub_DesignerCreateView extends BA.ResumableSub {
public ResumableSub_DesignerCreateView(com.vehicle.tracker.as_textfieldadvanced parent,Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) {
this.parent = parent;
this._base = _base;
this._lbl = _lbl;
this._props = _props;
}
com.vehicle.tracker.as_textfieldadvanced parent;
Object _base;
anywheresoftware.b4a.objects.LabelWrapper _lbl;
anywheresoftware.b4a.objects.collections.Map _props;
int[] _clearandrevealbuttoncolor = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 383;BA.debugLine="xlbl_InternPreProperties = Lbl";
parent._xlbl_internpreproperties = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 384;BA.debugLine="mBase = Base";
parent._mbase = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 385;BA.debugLine="Tag = mBase.Tag";
parent._tag = parent._mbase.getTag();
 //BA.debugLineNum = 386;BA.debugLine="mBase.Tag = Me";
parent._mbase.setTag(parent);
 //BA.debugLineNum = 388;BA.debugLine="IniProps(Props)";
parent._iniprops(_props);
 //BA.debugLineNum = 390;BA.debugLine="xpnl_TextFieldBackground = xui.CreatePanel(\"xpnl_";
parent._xpnl_textfieldbackground = parent._xui.CreatePanel(ba,"xpnl_TextFieldBackground");
 //BA.debugLineNum = 391;BA.debugLine="mBase.AddView(xpnl_TextFieldBackground,0,0,mBase.";
parent._mbase.AddView((android.view.View)(parent._xpnl_textfieldbackground.getObject()),(int) (0),(int) (0),parent._mbase.getWidth(),parent._mbase.getHeight());
 //BA.debugLineNum = 393;BA.debugLine="If m_PasswordField And m_StrengthIndicator <> \"No";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._m_passwordfield && (parent._m_strengthindicator).equals("None") == false) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 394;BA.debugLine="xpnl_PasswordStrengthBackground = xui.CreatePane";
parent._xpnl_passwordstrengthbackground = parent._xui.CreatePanel(ba,"");
 //BA.debugLineNum = 395;BA.debugLine="mBase.AddView(xpnl_PasswordStrengthBackground,0,";
parent._mbase.AddView((android.view.View)(parent._xpnl_passwordstrengthbackground.getObject()),(int) (0),(int) (0),parent._mbase.getWidth(),parent.__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 396;BA.debugLine="xpnl_PasswordStrengthBackground.Color = xui.Colo";
parent._xpnl_passwordstrengthbackground.setColor(parent._xui.Color_Transparent);
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 399;BA.debugLine="CreateTextFields";
parent._createtextfields();
 //BA.debugLineNum = 401;BA.debugLine="xpnl_TextFieldBackground.AddView(xlbl_ButtonText,";
parent._xpnl_textfieldbackground.AddView((android.view.View)(parent._xlbl_buttontext.getObject()),(int) (parent._m_leftgap),(int) (parent._m_topgap),(int) (parent._xpnl_textfieldbackground.getWidth()-parent._xpnl_textfieldbackground.getHeight()),(int) (parent._xpnl_textfieldbackground.getHeight()-parent._m_topgap*2));
 //BA.debugLineNum = 403;BA.debugLine="xpnl_TextFieldBackground.AddView(xlbl_Hint,m_Left";
parent._xpnl_textfieldbackground.AddView((android.view.View)(parent._xlbl_hint.getObject()),(int) (parent._m_leftgap),(int) (parent._m_topgap),parent._xpnl_textfieldbackground.getWidth(),(int) (parent._xpnl_textfieldbackground.getHeight()-parent._m_topgap*2));
 //BA.debugLineNum = 405;BA.debugLine="xpnl_TextFieldBackground.AddView(xlbl_ClearButton";
parent._xpnl_textfieldbackground.AddView((android.view.View)(parent._xlbl_clearbutton.getObject()),(int) (parent._xpnl_textfieldbackground.getWidth()-parent._xpnl_textfieldbackground.getHeight()),(int) (0),parent._xpnl_textfieldbackground.getHeight(),parent._xpnl_textfieldbackground.getHeight());
 //BA.debugLineNum = 407;BA.debugLine="xpnl_TextFieldBackground.AddView(xlbl_RevealButto";
parent._xpnl_textfieldbackground.AddView((android.view.View)(parent._xlbl_revealbutton.getObject()),(int) (parent._xpnl_textfieldbackground.getWidth()-parent._xpnl_textfieldbackground.getHeight()*(double)(BA.ObjectToNumber(((parent._m_showclearbutton) ? ((Object)(2)) : ((Object)(1)))))),(int) (0),parent._xpnl_textfieldbackground.getHeight(),parent._xpnl_textfieldbackground.getHeight());
 //BA.debugLineNum = 409;BA.debugLine="mBase.AddView(xlbl_Title,0,0,mBase.Width,20dip)";
parent._mbase.AddView((android.view.View)(parent._xlbl_title.getObject()),(int) (0),(int) (0),parent._mbase.getWidth(),parent.__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 410;BA.debugLine="mBase.AddView(xlbl_TitleReqiredField,0,0,mBase.Wi";
parent._mbase.AddView((android.view.View)(parent._xlbl_titlereqiredfield.getObject()),(int) (0),(int) (0),parent._mbase.getWidth(),parent.__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 411;BA.debugLine="mBase.AddView(xpnl_Underline,0,mBase.Height,mBase";
parent._mbase.AddView((android.view.View)(parent._xpnl_underline.getObject()),(int) (0),parent._mbase.getHeight(),parent._mbase.getWidth(),parent.__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 412;BA.debugLine="xpnl_Underline.Visible = m_Underline";
parent._xpnl_underline.setVisible(parent._m_underline);
 //BA.debugLineNum = 414;BA.debugLine="mBase.AddView(xlbl_Counter,0,0,mBase.Width/2,20di";
parent._mbase.AddView((android.view.View)(parent._xlbl_counter.getObject()),(int) (0),(int) (0),(int) (parent._mbase.getWidth()/(double)2),parent.__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 416;BA.debugLine="mBase.AddView(xlbl_Info,0,0,mBase.Width/2,20dip)";
parent._mbase.AddView((android.view.View)(parent._xlbl_info.getObject()),(int) (0),(int) (0),(int) (parent._mbase.getWidth()/(double)2),parent.__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 418;BA.debugLine="UpdateTextFieldShape";
parent._updatetextfieldshape();
 //BA.debugLineNum = 421;BA.debugLine="If m_Mode = \"ComboBox\" Then";
if (true) break;

case 5:
//if
this.state = 10;
if ((parent._m_mode).equals("ComboBox")) { 
this.state = 7;
}else {
this.state = 9;
}if (true) break;

case 7:
//C
this.state = 10;
 //BA.debugLineNum = 422;BA.debugLine="xlbl_ButtonText.Color = xpnl_TextFieldBackground";
parent._xlbl_buttontext.setColor(parent._xpnl_textfieldbackground.getColor());
 if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 424;BA.debugLine="xlbl_ButtonText.Color = xui.Color_Transparent";
parent._xlbl_buttontext.setColor(parent._xui.Color_Transparent);
 if (true) break;

case 10:
//C
this.state = 11;
;
 //BA.debugLineNum = 426;BA.debugLine="xlbl_ButtonText.TextColor = Lbl.As(B4XView).TextC";
parent._xlbl_buttontext.setTextColor(((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()))).getTextColor());
 //BA.debugLineNum = 427;BA.debugLine="xlbl_ButtonText.Font = Lbl.As(B4XView).Font";
parent._xlbl_buttontext.setFont(((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()))).getFont());
 //BA.debugLineNum = 428;BA.debugLine="xlbl_ButtonText.SetTextAlignment(\"CENTER\",m_TextA";
parent._xlbl_buttontext.SetTextAlignment("CENTER",parent._m_textalignment);
 //BA.debugLineNum = 430;BA.debugLine="g_Hint.xFont = Lbl.As(B4XView).Font";
parent._g_hint.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = ((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()))).getFont();
 //BA.debugLineNum = 431;BA.debugLine="xlbl_Hint.Color = xui.Color_Transparent";
parent._xlbl_hint.setColor(parent._xui.Color_Transparent);
 //BA.debugLineNum = 432;BA.debugLine="xlbl_Hint.SetTextAlignment(\"CENTER\",m_TextAlignme";
parent._xlbl_hint.SetTextAlignment("CENTER",parent._m_textalignment);
 //BA.debugLineNum = 433;BA.debugLine="xlbl_Hint.Visible = g_Hint.Visible";
parent._xlbl_hint.setVisible(parent._g_hint.Visible /*boolean*/ );
 //BA.debugLineNum = 436;BA.debugLine="xlbl_ClearButton.Visible = False";
parent._xlbl_clearbutton.setVisible(parent.__c.False);
 //BA.debugLineNum = 437;BA.debugLine="xlbl_ClearButton.SetTextAlignment(\"CENTER\",\"CENTE";
parent._xlbl_clearbutton.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 439;BA.debugLine="Dim ClearAndRevealButtonColor() As Int = GetARGB(";
_clearandrevealbuttoncolor = parent._getargb(parent._m_clearandrevealbuttoncolor);
 //BA.debugLineNum = 441;BA.debugLine="xlbl_ClearButton.TextColor = IIf(ClearAndRevealBu";
parent._xlbl_clearbutton.setTextColor((int)(BA.ObjectToNumber(((_clearandrevealbuttoncolor[(int) (0)]>0) ? ((Object)(parent._m_clearandrevealbuttoncolor)) : (((parent._iscolordark(parent._m_backgroundcolor)) ? ((Object)(parent._xui.Color_ARGB((int) (152),(int) (255),(int) (255),(int) (255)))) : ((Object)(parent._xui.Color_ARGB((int) (152),(int) (0),(int) (0),(int) (0))))))))));
 //BA.debugLineNum = 442;BA.debugLine="xlbl_ClearButton.Font = xui.CreateMaterialIcons(2";
parent._xlbl_clearbutton.setFont(parent._xui.CreateMaterialIcons((float) (20)));
 //BA.debugLineNum = 443;BA.debugLine="xlbl_ClearButton.Text = Chr(0xE14C)";
parent._xlbl_clearbutton.setText(BA.ObjectToCharSequence(parent.__c.Chr(((int)0xe14c))));
 //BA.debugLineNum = 446;BA.debugLine="xlbl_RevealButton.Tag = \"reveal\"";
parent._xlbl_revealbutton.setTag((Object)("reveal"));
 //BA.debugLineNum = 447;BA.debugLine="xlbl_RevealButton.Visible = False";
parent._xlbl_revealbutton.setVisible(parent.__c.False);
 //BA.debugLineNum = 448;BA.debugLine="xlbl_RevealButton.SetTextAlignment(\"CENTER\",\"CENT";
parent._xlbl_revealbutton.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 449;BA.debugLine="xlbl_RevealButton.TextColor = xlbl_ClearButton.Te";
parent._xlbl_revealbutton.setTextColor(parent._xlbl_clearbutton.getTextColor());
 //BA.debugLineNum = 450;BA.debugLine="xlbl_RevealButton.Font = xui.CreateMaterialIcons(";
parent._xlbl_revealbutton.setFont(parent._xui.CreateMaterialIcons((float) (18)));
 //BA.debugLineNum = 451;BA.debugLine="xlbl_RevealButton.Text = Chr(0xE8F4)";
parent._xlbl_revealbutton.setText(BA.ObjectToCharSequence(parent.__c.Chr(((int)0xe8f4))));
 //BA.debugLineNum = 454;BA.debugLine="xlbl_Info.SetTextAlignment(\"CENTER\",\"LEFT\")";
parent._xlbl_info.SetTextAlignment("CENTER","LEFT");
 //BA.debugLineNum = 457;BA.debugLine="xpnl_TextFieldBackground.AddView(xpnl_LeadingIcon";
parent._xpnl_textfieldbackground.AddView((android.view.View)(parent._xpnl_leadingicon.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 459;BA.debugLine="xpnl_LeadingIcon.AddView(xiv_LeadingIcon,0,0,0,0)";
parent._xpnl_leadingicon.AddView((android.view.View)(parent._xiv_leadingicon.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 462;BA.debugLine="xpnl_TextFieldBackground.AddView(xpnl_TrailingIco";
parent._xpnl_textfieldbackground.AddView((android.view.View)(parent._xpnl_trailingicon.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 465;BA.debugLine="xpnl_TrailingIcon.AddView(xiv_TrailingIcon,0,0,0,";
parent._xpnl_trailingicon.AddView((android.view.View)(parent._xiv_trailingicon.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 467;BA.debugLine="xpnl_TextFieldBackground.AddView(xlbl_Prefix,0,0,";
parent._xpnl_textfieldbackground.AddView((android.view.View)(parent._xlbl_prefix.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 468;BA.debugLine="xpnl_TextFieldBackground.AddView(xlbl_Suffix,0,0,";
parent._xpnl_textfieldbackground.AddView((android.view.View)(parent._xlbl_suffix.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 470;BA.debugLine="Style";
parent._style();
 //BA.debugLineNum = 472;BA.debugLine="If xlbl_InternPreProperties.Text <> \"\" Then setTe";
if (true) break;

case 11:
//if
this.state = 16;
if ((parent._xlbl_internpreproperties.getText()).equals("") == false) { 
this.state = 13;
;}if (true) break;

case 13:
//C
this.state = 16;
parent._settext(parent._xlbl_internpreproperties.getText());
if (true) break;

case 16:
//C
this.state = -1;
;
 //BA.debugLineNum = 475;BA.debugLine="Base_Resize(mBase.Width,mBase.Height)";
parent._base_resize(parent._mbase.getWidth(),parent._mbase.getHeight());
 //BA.debugLineNum = 478;BA.debugLine="Sleep(0)";
parent.__c.Sleep(ba,this,(int) (0));
this.state = 17;
return;
case 17:
//C
this.state = -1;
;
 //BA.debugLineNum = 479;BA.debugLine="m_isViewReady = True";
parent._m_isviewready = parent.__c.True;
 //BA.debugLineNum = 481;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _drawpasswordstrengthindicator() throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_background = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_strengthline = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_segment1 = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_segment2 = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xpnl_segment3 = null;
float _gapbetween = 0f;
float _width = 0f;
String _passwordtext = "";
int _passwordscore2 = 0;
 //BA.debugLineNum = 1681;BA.debugLine="Private Sub DrawPasswordStrengthIndicator";
 //BA.debugLineNum = 1682;BA.debugLine="If m_PasswordField And m_StrengthIndicator <> \"No";
if (_m_passwordfield && (_m_strengthindicator).equals("None") == false) { 
 //BA.debugLineNum = 1684;BA.debugLine="If xpnl_PasswordStrengthBackground.NumberOfViews";
if (_xpnl_passwordstrengthbackground.getNumberOfViews()==0) { 
 //BA.debugLineNum = 1686;BA.debugLine="Dim xpnl_Background As B4XView = xui.CreatePane";
_xpnl_background = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xpnl_background = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 1687;BA.debugLine="xpnl_PasswordStrengthBackground.AddView(xpnl_Ba";
_xpnl_passwordstrengthbackground.AddView((android.view.View)(_xpnl_background.getObject()),(int) (0),(int) (_xpnl_passwordstrengthbackground.getHeight()/(double)2-(_xpnl_passwordstrengthbackground.getHeight()/(double)2)/(double)2),_xpnl_passwordstrengthbackground.getWidth(),(int) (_xpnl_passwordstrengthbackground.getHeight()/(double)2));
 //BA.debugLineNum = 1689;BA.debugLine="If m_StrengthIndicator = \"Line\" Then";
if ((_m_strengthindicator).equals("Line")) { 
 //BA.debugLineNum = 1690;BA.debugLine="Dim xpnl_StrengthLine As B4XView = xui.CreateP";
_xpnl_strengthline = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xpnl_strengthline = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 1691;BA.debugLine="xpnl_Background.AddView(xpnl_StrengthLine,0,0,";
_xpnl_background.AddView((android.view.View)(_xpnl_strengthline.getObject()),(int) (0),(int) (0),(int) (0),_xpnl_background.getHeight());
 //BA.debugLineNum = 1692;BA.debugLine="xpnl_Background.SetColorAndBorder(m_Background";
_xpnl_background.SetColorAndBorder(_m_backgroundcolor,(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 }else if((_m_strengthindicator).equals("Segmented")) { 
 //BA.debugLineNum = 1694;BA.debugLine="xpnl_Background.SetColorAndBorder(xui.Color_Tr";
_xpnl_background.SetColorAndBorder(_xui.Color_Transparent,(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 1695;BA.debugLine="Dim xpnl_Segment1 As B4XView = xui.CreatePanel";
_xpnl_segment1 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xpnl_segment1 = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 1696;BA.debugLine="Dim xpnl_Segment2 As B4XView = xui.CreatePanel";
_xpnl_segment2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xpnl_segment2 = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 1697;BA.debugLine="Dim xpnl_Segment3 As B4XView = xui.CreatePanel";
_xpnl_segment3 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xpnl_segment3 = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 1699;BA.debugLine="Dim GapBetween As Float = 5dip";
_gapbetween = (float) (__c.DipToCurrent((int) (5)));
 //BA.debugLineNum = 1700;BA.debugLine="Dim Width As Float = (xpnl_Background.Width/3)";
_width = (float) ((_xpnl_background.getWidth()/(double)3)-_gapbetween);
 //BA.debugLineNum = 1702;BA.debugLine="xpnl_Background.AddView(xpnl_Segment1,0,0,Widt";
_xpnl_background.AddView((android.view.View)(_xpnl_segment1.getObject()),(int) (0),(int) (0),(int) (_width),_xpnl_background.getHeight());
 //BA.debugLineNum = 1703;BA.debugLine="xpnl_Background.AddView(xpnl_Segment2,xpnl_Bac";
_xpnl_background.AddView((android.view.View)(_xpnl_segment2.getObject()),(int) (_xpnl_background.getWidth()/(double)2-_width/(double)2),(int) (0),(int) (_width),_xpnl_background.getHeight());
 //BA.debugLineNum = 1704;BA.debugLine="xpnl_Background.AddView(xpnl_Segment3,xpnl_Bac";
_xpnl_background.AddView((android.view.View)(_xpnl_segment3.getObject()),(int) (_xpnl_background.getWidth()-_width),(int) (0),(int) (_width),_xpnl_background.getHeight());
 };
 };
 //BA.debugLineNum = 1710;BA.debugLine="If m_StrengthIndicator = \"Line\" Then";
if ((_m_strengthindicator).equals("Line")) { 
 //BA.debugLineNum = 1711;BA.debugLine="Dim xpnl_StrengthLine As B4XView = xpnl_Passwor";
_xpnl_strengthline = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xpnl_strengthline = _xpnl_passwordstrengthbackground.GetView((int) (0)).GetView((int) (0));
 //BA.debugLineNum = 1713;BA.debugLine="Dim PasswordText As String = getText";
_passwordtext = _gettext();
 //BA.debugLineNum = 1714;BA.debugLine="Dim PasswordScore2 As Int = PasswordStrengthSco";
_passwordscore2 = _passwordstrengthscore(_passwordtext,(int) (8),(int) (1),(int) (1),(int) (1),(int) (1));
 //BA.debugLineNum = 1716;BA.debugLine="xpnl_StrengthLine.Parent.Width = xpnl_PasswordS";
_xpnl_strengthline.getParent().setWidth(_xpnl_passwordstrengthbackground.getWidth());
 //BA.debugLineNum = 1718;BA.debugLine="If PasswordText.Length = 0 Then";
if (_passwordtext.length()==0) { 
 //BA.debugLineNum = 1719;BA.debugLine="xpnl_StrengthLine.SetLayoutAnimated(250,0,0,2d";
_xpnl_strengthline.SetLayoutAnimated((int) (250),(int) (0),(int) (0),__c.DipToCurrent((int) (2)),_xpnl_strengthline.getParent().getHeight());
 }else if(_passwordscore2==1) { 
 //BA.debugLineNum = 1721;BA.debugLine="xpnl_StrengthLine.SetColorAndBorder(xui.Color_";
_xpnl_strengthline.SetColorAndBorder(_xui.Color_ARGB((int) (255),(int) (211),(int) (47),(int) (47)),(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 1722;BA.debugLine="xpnl_StrengthLine.SetLayoutAnimated(250,0,0,xp";
_xpnl_strengthline.SetLayoutAnimated((int) (250),(int) (0),(int) (0),(int) (_xpnl_strengthline.getParent().getWidth()/(double)3),_xpnl_strengthline.getParent().getHeight());
 }else if(_passwordscore2==2) { 
 //BA.debugLineNum = 1724;BA.debugLine="xpnl_StrengthLine.SetColorAndBorder(xui.Color_";
_xpnl_strengthline.SetColorAndBorder(_xui.Color_ARGB((int) (255),(int) (239),(int) (108),(int) (0)),(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 1725;BA.debugLine="xpnl_StrengthLine.SetLayoutAnimated(250,0,0,(x";
_xpnl_strengthline.SetLayoutAnimated((int) (250),(int) (0),(int) (0),(int) ((_xpnl_strengthline.getParent().getWidth()/(double)3)*2),_xpnl_strengthline.getParent().getHeight());
 }else if(_passwordscore2==3) { 
 //BA.debugLineNum = 1727;BA.debugLine="xpnl_StrengthLine.SetColorAndBorder(xui.Color_";
_xpnl_strengthline.SetColorAndBorder(_xui.Color_ARGB((int) (255),(int) (67),(int) (160),(int) (71)),(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 1728;BA.debugLine="xpnl_StrengthLine.SetLayoutAnimated(250,0,0,xp";
_xpnl_strengthline.SetLayoutAnimated((int) (250),(int) (0),(int) (0),_xpnl_strengthline.getParent().getWidth(),_xpnl_strengthline.getParent().getHeight());
 };
 }else if((_m_strengthindicator).equals("Segmented")) { 
 //BA.debugLineNum = 1733;BA.debugLine="Dim xpnl_Segment1 As B4XView = xpnl_PasswordStr";
_xpnl_segment1 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xpnl_segment1 = _xpnl_passwordstrengthbackground.GetView((int) (0)).GetView((int) (0));
 //BA.debugLineNum = 1734;BA.debugLine="Dim xpnl_Segment2 As B4XView = xpnl_PasswordStr";
_xpnl_segment2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xpnl_segment2 = _xpnl_passwordstrengthbackground.GetView((int) (0)).GetView((int) (1));
 //BA.debugLineNum = 1735;BA.debugLine="Dim xpnl_Segment3 As B4XView = xpnl_PasswordStr";
_xpnl_segment3 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xpnl_segment3 = _xpnl_passwordstrengthbackground.GetView((int) (0)).GetView((int) (2));
 //BA.debugLineNum = 1737;BA.debugLine="xpnl_Segment1.Parent.Width = xpnl_PasswordStren";
_xpnl_segment1.getParent().setWidth(_xpnl_passwordstrengthbackground.getWidth());
 //BA.debugLineNum = 1739;BA.debugLine="Dim GapBetween As Float = 5dip";
_gapbetween = (float) (__c.DipToCurrent((int) (5)));
 //BA.debugLineNum = 1740;BA.debugLine="Dim Width As Float = (xpnl_Segment1.Parent.Widt";
_width = (float) ((_xpnl_segment1.getParent().getWidth()/(double)3)-_gapbetween);
 //BA.debugLineNum = 1742;BA.debugLine="xpnl_Segment1.SetLayoutAnimated(0,0,0,Width,xpn";
_xpnl_segment1.SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),_xpnl_segment1.getParent().getHeight());
 //BA.debugLineNum = 1743;BA.debugLine="xpnl_Segment2.SetLayoutAnimated(0,xpnl_Segment1";
_xpnl_segment2.SetLayoutAnimated((int) (0),(int) (_xpnl_segment1.getParent().getWidth()/(double)2-_width/(double)2),(int) (0),(int) (_width),_xpnl_segment1.getParent().getHeight());
 //BA.debugLineNum = 1744;BA.debugLine="xpnl_Segment3.SetLayoutAnimated(0,xpnl_Segment1";
_xpnl_segment3.SetLayoutAnimated((int) (0),(int) (_xpnl_segment1.getParent().getWidth()-_width),(int) (0),(int) (_width),_xpnl_segment1.getParent().getHeight());
 //BA.debugLineNum = 1746;BA.debugLine="Dim PasswordText As String = getText";
_passwordtext = _gettext();
 //BA.debugLineNum = 1747;BA.debugLine="Dim PasswordScore2 As Int = PasswordStrengthSco";
_passwordscore2 = _passwordstrengthscore(_passwordtext,(int) (8),(int) (1),(int) (1),(int) (1),(int) (1));
 //BA.debugLineNum = 1749;BA.debugLine="If PasswordText.Length = 0 Then";
if (_passwordtext.length()==0) { 
 //BA.debugLineNum = 1750;BA.debugLine="xpnl_Segment1.SetColorAndBorder(m_BackgroundCo";
_xpnl_segment1.SetColorAndBorder(_m_backgroundcolor,(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 1751;BA.debugLine="xpnl_Segment2.SetColorAndBorder(m_BackgroundCo";
_xpnl_segment2.SetColorAndBorder(_m_backgroundcolor,(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 1752;BA.debugLine="xpnl_Segment3.SetColorAndBorder(m_BackgroundCo";
_xpnl_segment3.SetColorAndBorder(_m_backgroundcolor,(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 }else if(_passwordscore2==1) { 
 //BA.debugLineNum = 1754;BA.debugLine="xpnl_Segment1.SetColorAndBorder(xui.Color_ARGB";
_xpnl_segment1.SetColorAndBorder(_xui.Color_ARGB((int) (255),(int) (211),(int) (47),(int) (47)),(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 1755;BA.debugLine="xpnl_Segment2.SetColorAndBorder(m_BackgroundCo";
_xpnl_segment2.SetColorAndBorder(_m_backgroundcolor,(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 1756;BA.debugLine="xpnl_Segment3.SetColorAndBorder(m_BackgroundCo";
_xpnl_segment3.SetColorAndBorder(_m_backgroundcolor,(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 }else if(_passwordscore2==2) { 
 //BA.debugLineNum = 1758;BA.debugLine="xpnl_Segment1.SetColorAndBorder(xui.Color_ARGB";
_xpnl_segment1.SetColorAndBorder(_xui.Color_ARGB((int) (255),(int) (211),(int) (47),(int) (47)),(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 1759;BA.debugLine="xpnl_Segment2.SetColorAndBorder(xui.Color_ARGB";
_xpnl_segment2.SetColorAndBorder(_xui.Color_ARGB((int) (255),(int) (239),(int) (108),(int) (0)),(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 1760;BA.debugLine="xpnl_Segment3.SetColorAndBorder(m_BackgroundCo";
_xpnl_segment3.SetColorAndBorder(_m_backgroundcolor,(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 }else if(_passwordscore2==3) { 
 //BA.debugLineNum = 1762;BA.debugLine="xpnl_Segment1.SetColorAndBorder(xui.Color_ARGB";
_xpnl_segment1.SetColorAndBorder(_xui.Color_ARGB((int) (255),(int) (211),(int) (47),(int) (47)),(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 1763;BA.debugLine="xpnl_Segment2.SetColorAndBorder(xui.Color_ARGB";
_xpnl_segment2.SetColorAndBorder(_xui.Color_ARGB((int) (255),(int) (239),(int) (108),(int) (0)),(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 1764;BA.debugLine="xpnl_Segment3.SetColorAndBorder(xui.Color_ARGB";
_xpnl_segment3.SetColorAndBorder(_xui.Color_ARGB((int) (255),(int) (67),(int) (160),(int) (71)),(int) (0),(int) (0),__c.DipToCurrent((int) (2)));
 };
 };
 };
 //BA.debugLineNum = 1770;BA.debugLine="End Sub";
return "";
}
public String  _enterpressed() throws Exception{
 //BA.debugLineNum = 1865;BA.debugLine="Private Sub EnterPressed";
 //BA.debugLineNum = 1866;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_EnterP";
if (_xui.SubExists(ba,_mcallback,_meventname+"_EnterPressed",(int) (0))) { 
 //BA.debugLineNum = 1867;BA.debugLine="CallSub(mCallBack, mEventName & \"_EnterPressed\")";
__c.CallSubNew(ba,_mcallback,_meventname+"_EnterPressed");
 };
 //BA.debugLineNum = 1869;BA.debugLine="End Sub";
return "";
}
public boolean  _focus() throws Exception{
 //BA.debugLineNum = 908;BA.debugLine="Public Sub Focus As Boolean";
 //BA.debugLineNum = 910;BA.debugLine="Select m_Mode";
switch (BA.switchObjectToInt(_m_mode,"Multiline","Button","ComboBox")) {
case 0: {
 //BA.debugLineNum = 913;BA.debugLine="IME.ShowKeyboard(xtf_Multiline)";
_ime.ShowKeyboard((android.view.View)(_xtf_multiline.getObject()));
 //BA.debugLineNum = 915;BA.debugLine="Return xtf_Multiline.RequestFocus";
if (true) return _xtf_multiline.RequestFocus();
 break; }
case 1: 
case 2: {
 //BA.debugLineNum = 917;BA.debugLine="Return True";
if (true) return __c.True;
 break; }
default: {
 //BA.debugLineNum = 919;BA.debugLine="If xlbl_RevealButton.Tag = \"reveal\" And m_isPas";
if ((_xlbl_revealbutton.getTag()).equals((Object)("reveal")) && _m_ispasswordmode) { 
 //BA.debugLineNum = 921;BA.debugLine="IME.ShowKeyboard(xtf_TextFieldPassword)";
_ime.ShowKeyboard((android.view.View)(_xtf_textfieldpassword.getObject()));
 //BA.debugLineNum = 923;BA.debugLine="Return xtf_TextFieldPassword.RequestFocus";
if (true) return _xtf_textfieldpassword.RequestFocus();
 }else {
 //BA.debugLineNum = 926;BA.debugLine="IME.ShowKeyboard(xtf_TextField)";
_ime.ShowKeyboard((android.view.View)(_xtf_textfield.getObject()));
 //BA.debugLineNum = 928;BA.debugLine="Return xtf_TextField.RequestFocus";
if (true) return _xtf_textfield.RequestFocus();
 };
 break; }
}
;
 //BA.debugLineNum = 932;BA.debugLine="End Sub";
return false;
}
public String  _focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 1855;BA.debugLine="Private Sub FocusChanged(HasFocus As Boolean)";
 //BA.debugLineNum = 1856;BA.debugLine="m_HasFocus = HasFocus";
_m_hasfocus = _hasfocus;
 //BA.debugLineNum = 1857;BA.debugLine="If m_isInRequiredMode = False Then";
if (_m_isinrequiredmode==__c.False) { 
 //BA.debugLineNum = 1858;BA.debugLine="UpdateTextFieldShape";
_updatetextfieldshape();
 };
 //BA.debugLineNum = 1860;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_FocusC";
if (_xui.SubExists(ba,_mcallback,_meventname+"_FocusChanged",(int) (1))) { 
 //BA.debugLineNum = 1861;BA.debugLine="CallSub2(mCallBack, mEventName & \"_FocusChanged\"";
__c.CallSubNew2(ba,_mcallback,_meventname+"_FocusChanged",(Object)(_hasfocus));
 };
 //BA.debugLineNum = 1863;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper  _fonttobitmap(String _text,boolean _ismaterialicons,float _fontsize,int _color) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
anywheresoftware.b4a.objects.B4XCanvas _cvs1 = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _fnt = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _r = null;
int _baseline = 0;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _b = null;
 //BA.debugLineNum = 1900;BA.debugLine="Public Sub FontToBitmap (text As String, IsMateria";
 //BA.debugLineNum = 1901;BA.debugLine="Dim xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 1902;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 1903;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, 32dip, 32dip)";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),__c.DipToCurrent((int) (32)),__c.DipToCurrent((int) (32)));
 //BA.debugLineNum = 1904;BA.debugLine="Dim cvs1 As B4XCanvas";
_cvs1 = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 1905;BA.debugLine="cvs1.Initialize(p)";
_cvs1.Initialize(_p);
 //BA.debugLineNum = 1906;BA.debugLine="Dim fnt As B4XFont";
_fnt = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
 //BA.debugLineNum = 1907;BA.debugLine="If IsMaterialIcons Then fnt = xui.CreateMaterialI";
if (_ismaterialicons) { 
_fnt = _xui.CreateMaterialIcons(_fontsize);}
else {
_fnt = _xui.CreateFontAwesome(_fontsize);};
 //BA.debugLineNum = 1908;BA.debugLine="Dim r As B4XRect = cvs1.MeasureText(text, fnt)";
_r = _cvs1.MeasureText(_text,_fnt);
 //BA.debugLineNum = 1909;BA.debugLine="Dim BaseLine As Int = cvs1.TargetRect.CenterY - r";
_baseline = (int) (_cvs1.getTargetRect().getCenterY()-_r.getHeight()/(double)2-_r.getTop());
 //BA.debugLineNum = 1910;BA.debugLine="cvs1.DrawText(text, cvs1.TargetRect.CenterX, Base";
_cvs1.DrawText(ba,_text,_cvs1.getTargetRect().getCenterX(),(float) (_baseline),_fnt,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
 //BA.debugLineNum = 1911;BA.debugLine="Dim b As B4XBitmap = cvs1.CreateBitmap";
_b = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_b = _cvs1.CreateBitmap();
 //BA.debugLineNum = 1912;BA.debugLine="cvs1.Release";
_cvs1.Release();
 //BA.debugLineNum = 1913;BA.debugLine="Return b";
if (true) return _b;
 //BA.debugLineNum = 1914;BA.debugLine="End Sub";
return null;
}
public int[]  _getargb(int _color) throws Exception{
int[] _res = null;
 //BA.debugLineNum = 2029;BA.debugLine="Private Sub GetARGB(Color As Int) As Int()'ignore";
 //BA.debugLineNum = 2030;BA.debugLine="Private res(4) As Int";
_res = new int[(int) (4)];
;
 //BA.debugLineNum = 2031;BA.debugLine="res(0) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (0)] = __c.Bit.UnsignedShiftRight(__c.Bit.And(_color,((int)0xff000000)),(int) (24));
 //BA.debugLineNum = 2032;BA.debugLine="res(1) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (1)] = __c.Bit.UnsignedShiftRight(__c.Bit.And(_color,((int)0xff0000)),(int) (16));
 //BA.debugLineNum = 2033;BA.debugLine="res(2) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (2)] = __c.Bit.UnsignedShiftRight(__c.Bit.And(_color,((int)0xff00)),(int) (8));
 //BA.debugLineNum = 2034;BA.debugLine="res(3) = Bit.And(Color, 0xff)";
_res[(int) (3)] = __c.Bit.And(_color,((int)0xff));
 //BA.debugLineNum = 2035;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 2036;BA.debugLine="End Sub";
return null;
}
public int  _getbackgroundcolor() throws Exception{
 //BA.debugLineNum = 1243;BA.debugLine="Public Sub getBackgroundColor As Int";
 //BA.debugLineNum = 1244;BA.debugLine="Return m_BackgroundColor";
if (true) return _m_backgroundcolor;
 //BA.debugLineNum = 1245;BA.debugLine="End Sub";
return 0;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getbackgroundpanel() throws Exception{
 //BA.debugLineNum = 1227;BA.debugLine="Public Sub getBackgroundPanel As B4XView";
 //BA.debugLineNum = 1228;BA.debugLine="Return xpnl_TextFieldBackground";
if (true) return _xpnl_textfieldbackground;
 //BA.debugLineNum = 1229;BA.debugLine="End Sub";
return null;
}
public float  _getbottomheight() throws Exception{
 //BA.debugLineNum = 1298;BA.debugLine="Public Sub getBottomHeight As Float";
 //BA.debugLineNum = 1299;BA.debugLine="Return m_BottomHeight";
if (true) return _m_bottomheight;
 //BA.debugLineNum = 1300;BA.debugLine="End Sub";
return 0f;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getbuttontextlabel() throws Exception{
 //BA.debugLineNum = 1235;BA.debugLine="Public Sub getButtonTextLabel As B4XView";
 //BA.debugLineNum = 1236;BA.debugLine="Return xlbl_ButtonText";
if (true) return _xlbl_buttontext;
 //BA.debugLineNum = 1237;BA.debugLine="End Sub";
return null;
}
public int  _getclearandrevealbuttoncolor() throws Exception{
 //BA.debugLineNum = 1252;BA.debugLine="Public Sub getClearAndRevealButtonColor As Int";
 //BA.debugLineNum = 1253;BA.debugLine="Return m_ClearAndRevealButtonColor";
if (true) return _m_clearandrevealbuttoncolor;
 //BA.debugLineNum = 1254;BA.debugLine="End Sub";
return 0;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getclearbuttonlabel() throws Exception{
 //BA.debugLineNum = 1231;BA.debugLine="Public Sub getClearButtonLabel As B4XView";
 //BA.debugLineNum = 1232;BA.debugLine="Return xlbl_ClearButton";
if (true) return _xlbl_clearbutton;
 //BA.debugLineNum = 1233;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_comboboxintern  _getcombobox() throws Exception{
 //BA.debugLineNum = 1032;BA.debugLine="Public Sub getComboBox As AS_ComboBoxIntern";
 //BA.debugLineNum = 1033;BA.debugLine="Return xcb_ComboBox";
if (true) return _xcb_combobox;
 //BA.debugLineNum = 1034;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_counter  _getcounter() throws Exception{
 //BA.debugLineNum = 1132;BA.debugLine="Public Sub getCounter As ASTextFieldAdvanced_Count";
 //BA.debugLineNum = 1133;BA.debugLine="Return g_Counter";
if (true) return _g_counter;
 //BA.debugLineNum = 1134;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_hint  _gethint() throws Exception{
 //BA.debugLineNum = 1136;BA.debugLine="Public Sub getHint As ASTextFieldAdvanced_Hint";
 //BA.debugLineNum = 1137;BA.debugLine="Return g_Hint";
if (true) return _g_hint;
 //BA.debugLineNum = 1138;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_information  _getinformation() throws Exception{
 //BA.debugLineNum = 1128;BA.debugLine="Public Sub getInformation As ASTextFieldAdvanced_I";
 //BA.debugLineNum = 1129;BA.debugLine="Return g_Information";
if (true) return _g_information;
 //BA.debugLineNum = 1130;BA.debugLine="End Sub";
return null;
}
public boolean  _getispasswordmode() throws Exception{
 //BA.debugLineNum = 1264;BA.debugLine="Public Sub getisPasswordMode As Boolean";
 //BA.debugLineNum = 1265;BA.debugLine="Return m_PasswordField";
if (true) return _m_passwordfield;
 //BA.debugLineNum = 1266;BA.debugLine="End Sub";
return false;
}
public boolean  _getisrevealed() throws Exception{
 //BA.debugLineNum = 1268;BA.debugLine="Public Sub getisRevealed As Boolean";
 //BA.debugLineNum = 1269;BA.debugLine="Return IIf(xlbl_RevealButton.Tag = \"hide\",True,Fa";
if (true) return BA.ObjectToBoolean((((_xlbl_revealbutton.getTag()).equals((Object)("hide"))) ? ((Object)(__c.True)) : ((Object)(__c.False))));
 //BA.debugLineNum = 1270;BA.debugLine="End Sub";
return false;
}
public String  _getkeyboardtype() throws Exception{
 //BA.debugLineNum = 1260;BA.debugLine="Public Sub getKeyboardType As String";
 //BA.debugLineNum = 1261;BA.debugLine="Return m_KeyboardType";
if (true) return _m_keyboardtype;
 //BA.debugLineNum = 1262;BA.debugLine="End Sub";
return "";
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_leadingicon  _getleadingicon() throws Exception{
 //BA.debugLineNum = 1140;BA.debugLine="Public Sub getLeadingIcon As ASTextFieldAdvanced_L";
 //BA.debugLineNum = 1141;BA.debugLine="Return g_LeadingIcon";
if (true) return _g_leadingicon;
 //BA.debugLineNum = 1142;BA.debugLine="End Sub";
return null;
}
public float  _getleadingwidth() throws Exception{
 //BA.debugLineNum = 1058;BA.debugLine="Public Sub getLeadingWidth As Float";
 //BA.debugLineNum = 1059;BA.debugLine="Return m_CustomLeadingWidth";
if (true) return _m_customleadingwidth;
 //BA.debugLineNum = 1060;BA.debugLine="End Sub";
return 0f;
}
public float  _getleftgap() throws Exception{
 //BA.debugLineNum = 1308;BA.debugLine="Public Sub getLeftGap As Float";
 //BA.debugLineNum = 1309;BA.debugLine="Return m_LeftGap";
if (true) return _m_leftgap;
 //BA.debugLineNum = 1310;BA.debugLine="End Sub";
return 0f;
}
public String  _getmasktext() throws Exception{
 //BA.debugLineNum = 1070;BA.debugLine="Public Sub getMaskText As String";
 //BA.debugLineNum = 1071;BA.debugLine="Return m_MaskText";
if (true) return _m_masktext;
 //BA.debugLineNum = 1072;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.EditTextWrapper  _getnativetextfield() throws Exception{
 //BA.debugLineNum = 1185;BA.debugLine="Public Sub getNativeTextField As EditText";
 //BA.debugLineNum = 1190;BA.debugLine="Return xtf_TextField";
if (true) return (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_xtf_textfield.getObject()));
 //BA.debugLineNum = 1191;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.EditTextWrapper  _getnativetextfieldmultiline() throws Exception{
 //BA.debugLineNum = 1205;BA.debugLine="Public Sub getNativeTextFieldMultiline As EditText";
 //BA.debugLineNum = 1212;BA.debugLine="Return xtf_Multiline";
if (true) return (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_xtf_multiline.getObject()));
 //BA.debugLineNum = 1213;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.EditTextWrapper  _getnativetextfieldpassword() throws Exception{
 //BA.debugLineNum = 1195;BA.debugLine="Public Sub getNativeTextFieldPassword As EditText";
 //BA.debugLineNum = 1200;BA.debugLine="Return xtf_TextFieldPassword";
if (true) return (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_xtf_textfieldpassword.getObject()));
 //BA.debugLineNum = 1201;BA.debugLine="End Sub";
return null;
}
public String  _getoldtext() throws Exception{
 //BA.debugLineNum = 1335;BA.debugLine="Public Sub getOldText As String";
 //BA.debugLineNum = 1336;BA.debugLine="Return m_OldText";
if (true) return _m_oldtext;
 //BA.debugLineNum = 1337;BA.debugLine="End Sub";
return "";
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_prefix  _getprefix() throws Exception{
 //BA.debugLineNum = 1148;BA.debugLine="Public Sub getPrefix As ASTextFieldAdvanced_Prefix";
 //BA.debugLineNum = 1149;BA.debugLine="Return g_Prefix";
if (true) return _g_prefix;
 //BA.debugLineNum = 1150;BA.debugLine="End Sub";
return null;
}
public boolean  _getreadonly() throws Exception{
 //BA.debugLineNum = 1091;BA.debugLine="Public Sub getReadOnly As Boolean";
 //BA.debugLineNum = 1092;BA.debugLine="Return m_ReadOnly";
if (true) return _m_readonly;
 //BA.debugLineNum = 1093;BA.debugLine="End Sub";
return false;
}
public int  _getrealtextlength(String _text) throws Exception{
int[] _result = null;
 //BA.debugLineNum = 1457;BA.debugLine="Private Sub GetRealTextLength(Text As String) As I";
 //BA.debugLineNum = 1458;BA.debugLine="Dim Result() As Int = bc.IntsFromBytes(Text.GetBy";
_result = _bc.IntsFromBytes(_text.getBytes("UTF-32BE"));
 //BA.debugLineNum = 1459;BA.debugLine="Return Result.Length";
if (true) return _result.length;
 //BA.debugLineNum = 1460;BA.debugLine="End Sub";
return 0;
}
public boolean  _getrequiredfield() throws Exception{
 //BA.debugLineNum = 1087;BA.debugLine="Public Sub getRequiredField As Boolean";
 //BA.debugLineNum = 1088;BA.debugLine="Return m_RequiredField";
if (true) return _m_requiredfield;
 //BA.debugLineNum = 1089;BA.debugLine="End Sub";
return false;
}
public int  _getrequiredfieldcolor() throws Exception{
 //BA.debugLineNum = 1079;BA.debugLine="Public Sub getRequiredFieldColor As Int";
 //BA.debugLineNum = 1080;BA.debugLine="Return m_RequiredFieldColor";
if (true) return _m_requiredfieldcolor;
 //BA.debugLineNum = 1081;BA.debugLine="End Sub";
return 0;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getrevealbuttonlabel() throws Exception{
 //BA.debugLineNum = 1239;BA.debugLine="Public Sub getRevealButtonLabel As B4XView";
 //BA.debugLineNum = 1240;BA.debugLine="Return xlbl_RevealButton";
if (true) return _xlbl_revealbutton;
 //BA.debugLineNum = 1241;BA.debugLine="End Sub";
return null;
}
public int  _getselectedindex() throws Exception{
 //BA.debugLineNum = 1021;BA.debugLine="Public Sub getSelectedIndex As Int";
 //BA.debugLineNum = 1022;BA.debugLine="Return xcb_ComboBox.SelectedIndex";
if (true) return _xcb_combobox._getselectedindex /*int*/ ();
 //BA.debugLineNum = 1023;BA.debugLine="End Sub";
return 0;
}
public boolean  _getshowclearbutton() throws Exception{
 //BA.debugLineNum = 1289;BA.debugLine="Public Sub getShowClearButton As Boolean";
 //BA.debugLineNum = 1290;BA.debugLine="Return m_ShowClearButton";
if (true) return _m_showclearbutton;
 //BA.debugLineNum = 1291;BA.debugLine="End Sub";
return false;
}
public boolean  _getshowrevealbutton() throws Exception{
 //BA.debugLineNum = 1281;BA.debugLine="Public Sub getShowRevealButton As Boolean";
 //BA.debugLineNum = 1282;BA.debugLine="Return m_ShowRevealButton";
if (true) return _m_showrevealbutton;
 //BA.debugLineNum = 1283;BA.debugLine="End Sub";
return false;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_suffix  _getsuffix() throws Exception{
 //BA.debugLineNum = 1152;BA.debugLine="Public Sub getSuffix As ASTextFieldAdvanced_Suffix";
 //BA.debugLineNum = 1153;BA.debugLine="Return g_Suffix";
if (true) return _g_suffix;
 //BA.debugLineNum = 1154;BA.debugLine="End Sub";
return null;
}
public String  _gettext() throws Exception{
 //BA.debugLineNum = 1339;BA.debugLine="Public Sub getText As String";
 //BA.debugLineNum = 1340;BA.debugLine="If m_Mode = \"TextField\" Then";
if ((_m_mode).equals("TextField")) { 
 //BA.debugLineNum = 1341;BA.debugLine="If getisPasswordMode And getisRevealed = False T";
if (_getispasswordmode() && _getisrevealed()==__c.False) { 
 //BA.debugLineNum = 1342;BA.debugLine="Return xtf_TextFieldPassword.Text";
if (true) return _xtf_textfieldpassword.getText();
 }else {
 //BA.debugLineNum = 1344;BA.debugLine="Return xtf_TextField.Text";
if (true) return _xtf_textfield.getText();
 };
 }else if((_m_mode).equals("Multiline")) { 
 //BA.debugLineNum = 1348;BA.debugLine="Return xtf_Multiline.Text";
if (true) return _xtf_multiline.getText();
 }else {
 //BA.debugLineNum = 1350;BA.debugLine="Return xlbl_ButtonText.Text";
if (true) return _xlbl_buttontext.getText();
 };
 //BA.debugLineNum = 1352;BA.debugLine="End Sub";
return "";
}
public String  _gettextalignment() throws Exception{
 //BA.debugLineNum = 975;BA.debugLine="Public Sub getTextAlignment As String";
 //BA.debugLineNum = 976;BA.debugLine="Return m_TextAlignment";
if (true) return _m_textalignment;
 //BA.debugLineNum = 977;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _gettextfield() throws Exception{
 //BA.debugLineNum = 1215;BA.debugLine="Public Sub getTextField As B4XView";
 //BA.debugLineNum = 1216;BA.debugLine="Return xtf_TextField";
if (true) return _xtf_textfield;
 //BA.debugLineNum = 1217;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _gettextfieldmultiline() throws Exception{
 //BA.debugLineNum = 1223;BA.debugLine="Public Sub getTextFieldMultiline As B4XView";
 //BA.debugLineNum = 1224;BA.debugLine="Return xtf_Multiline";
if (true) return _xtf_multiline;
 //BA.debugLineNum = 1225;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _gettextfieldpassword() throws Exception{
 //BA.debugLineNum = 1219;BA.debugLine="Public Sub getTextFieldPassword As B4XView";
 //BA.debugLineNum = 1220;BA.debugLine="Return xtf_TextFieldPassword";
if (true) return _xtf_textfieldpassword;
 //BA.debugLineNum = 1221;BA.debugLine="End Sub";
return null;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_textfieldproperties  _gettextfieldproperties() throws Exception{
 //BA.debugLineNum = 1156;BA.debugLine="Public Sub getTextFieldProperties As ASTextFieldAd";
 //BA.debugLineNum = 1157;BA.debugLine="Return g_TextFieldProperties";
if (true) return _g_textfieldproperties;
 //BA.debugLineNum = 1158;BA.debugLine="End Sub";
return null;
}
public String  _gettextfull() throws Exception{
String _text = "";
 //BA.debugLineNum = 1384;BA.debugLine="Public Sub getTextFull As String";
 //BA.debugLineNum = 1385;BA.debugLine="If m_Mode = \"Multiline\" Then";
if ((_m_mode).equals("Multiline")) { 
 //BA.debugLineNum = 1386;BA.debugLine="Return xtf_Multiline.Text";
if (true) return _xtf_multiline.getText();
 }else {
 //BA.debugLineNum = 1388;BA.debugLine="Dim Text As String = \"\"";
_text = "";
 //BA.debugLineNum = 1389;BA.debugLine="If xlbl_Prefix.Visible Then";
if (_xlbl_prefix.getVisible()) { 
 //BA.debugLineNum = 1390;BA.debugLine="Text = Text & xlbl_Prefix.Text";
_text = _text+_xlbl_prefix.getText();
 };
 //BA.debugLineNum = 1393;BA.debugLine="Text = Text & xtf_TextField.Text";
_text = _text+_xtf_textfield.getText();
 //BA.debugLineNum = 1395;BA.debugLine="If xlbl_Suffix.Visible Then";
if (_xlbl_suffix.getVisible()) { 
 //BA.debugLineNum = 1396;BA.debugLine="Text = Text & xlbl_Suffix.Text";
_text = _text+_xlbl_suffix.getText();
 };
 //BA.debugLineNum = 1398;BA.debugLine="Return Text";
if (true) return _text;
 };
 //BA.debugLineNum = 1400;BA.debugLine="End Sub";
return "";
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_title  _gettitle() throws Exception{
 //BA.debugLineNum = 1124;BA.debugLine="Public Sub getTitle As ASTextFieldAdvanced_Title";
 //BA.debugLineNum = 1125;BA.debugLine="Return g_Title";
if (true) return _g_title;
 //BA.debugLineNum = 1126;BA.debugLine="End Sub";
return null;
}
public float  _gettitlewidth() throws Exception{
 //BA.debugLineNum = 1001;BA.debugLine="Public Sub getTitleWidth As Float";
 //BA.debugLineNum = 1002;BA.debugLine="Return m_TitleWidth";
if (true) return _m_titlewidth;
 //BA.debugLineNum = 1003;BA.debugLine="End Sub";
return 0f;
}
public float  _gettopgap() throws Exception{
 //BA.debugLineNum = 1318;BA.debugLine="Public Sub getTopGap As Float";
 //BA.debugLineNum = 1319;BA.debugLine="Return m_TopGap";
if (true) return _m_topgap;
 //BA.debugLineNum = 1320;BA.debugLine="End Sub";
return 0f;
}
public com.vehicle.tracker.as_textfieldadvanced._astextfieldadvanced_trailingicon  _gettrailingicon() throws Exception{
 //BA.debugLineNum = 1144;BA.debugLine="Public Sub getTrailingIcon As ASTextFieldAdvanced_";
 //BA.debugLineNum = 1145;BA.debugLine="Return g_TrailingIcon";
if (true) return _g_trailingicon;
 //BA.debugLineNum = 1146;BA.debugLine="End Sub";
return null;
}
public float  _gettrailingwidth() throws Exception{
 //BA.debugLineNum = 1049;BA.debugLine="Public Sub getTrailingWidth As Float";
 //BA.debugLineNum = 1050;BA.debugLine="Return m_CustomTrailingWidth";
if (true) return _m_customtrailingwidth;
 //BA.debugLineNum = 1051;BA.debugLine="End Sub";
return 0f;
}
public boolean  _getunderline() throws Exception{
 //BA.debugLineNum = 980;BA.debugLine="Public Sub getUnderline As Boolean";
 //BA.debugLineNum = 981;BA.debugLine="Return m_Underline";
if (true) return _m_underline;
 //BA.debugLineNum = 982;BA.debugLine="End Sub";
return false;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getunderlinepanel() throws Exception{
 //BA.debugLineNum = 1044;BA.debugLine="Public Sub getUnderlinePanel As B4XView";
 //BA.debugLineNum = 1045;BA.debugLine="Return xpnl_Underline";
if (true) return _xpnl_underline;
 //BA.debugLineNum = 1046;BA.debugLine="End Sub";
return null;
}
public String  _hidedisplaymissingfield() throws Exception{
 //BA.debugLineNum = 944;BA.debugLine="Public Sub HideDisplayMissingField";
 //BA.debugLineNum = 945;BA.debugLine="If m_isInRequiredMode Then";
if (_m_isinrequiredmode) { 
 //BA.debugLineNum = 946;BA.debugLine="UpdateTextFieldShape";
_updatetextfieldshape();
 //BA.debugLineNum = 947;BA.debugLine="xlbl_Info.Text = g_Information.Text";
_xlbl_info.setText(BA.ObjectToCharSequence(_g_information.Text /*String*/ ));
 //BA.debugLineNum = 948;BA.debugLine="m_isInRequiredMode = False";
_m_isinrequiredmode = __c.False;
 };
 //BA.debugLineNum = 950;BA.debugLine="End Sub";
return "";
}
public int  _indexof(String _item) throws Exception{
 //BA.debugLineNum = 1027;BA.debugLine="Public Sub IndexOf(Item As String) As Int";
 //BA.debugLineNum = 1028;BA.debugLine="Return xcb_ComboBox.IndexOf(Item)";
if (true) return _xcb_combobox._indexof /*int*/ (_item);
 //BA.debugLineNum = 1029;BA.debugLine="End Sub";
return 0;
}
public String  _iniprops(anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 586;BA.debugLine="Private Sub IniProps(Props As Map)";
 //BA.debugLineNum = 588;BA.debugLine="xlbl_Hint = CreateLabel(\"\")";
_xlbl_hint = _createlabel("");
 //BA.debugLineNum = 589;BA.debugLine="xlbl_Info = CreateLabel(\"\")";
_xlbl_info = _createlabel("");
 //BA.debugLineNum = 590;BA.debugLine="xlbl_Counter = CreateLabel(\"\")";
_xlbl_counter = _createlabel("");
 //BA.debugLineNum = 591;BA.debugLine="xlbl_Title = CreateLabel(\"xlbl_Title\")";
_xlbl_title = _createlabel("xlbl_Title");
 //BA.debugLineNum = 592;BA.debugLine="xlbl_TitleReqiredField = CreateLabel(\"\")";
_xlbl_titlereqiredfield = _createlabel("");
 //BA.debugLineNum = 593;BA.debugLine="xpnl_LeadingIcon = xui.CreatePanel(\"xpnl_LeadingI";
_xpnl_leadingicon = _xui.CreatePanel(ba,"xpnl_LeadingIcon");
 //BA.debugLineNum = 594;BA.debugLine="xiv_LeadingIcon = CreateImageView(\"\")";
_xiv_leadingicon = _createimageview("");
 //BA.debugLineNum = 595;BA.debugLine="xpnl_TrailingIcon = xui.CreatePanel(\"xpnl_Trailin";
_xpnl_trailingicon = _xui.CreatePanel(ba,"xpnl_TrailingIcon");
 //BA.debugLineNum = 596;BA.debugLine="xiv_TrailingIcon = CreateImageView(\"\")";
_xiv_trailingicon = _createimageview("");
 //BA.debugLineNum = 597;BA.debugLine="xlbl_Prefix = CreateLabel(\"\")";
_xlbl_prefix = _createlabel("");
 //BA.debugLineNum = 598;BA.debugLine="xlbl_Suffix = CreateLabel(\"\")";
_xlbl_suffix = _createlabel("");
 //BA.debugLineNum = 599;BA.debugLine="xlbl_ClearButton = CreateLabel(\"xlbl_ClearButton\"";
_xlbl_clearbutton = _createlabel("xlbl_ClearButton");
 //BA.debugLineNum = 600;BA.debugLine="xlbl_RevealButton = CreateLabel(\"xlbl_RevealButto";
_xlbl_revealbutton = _createlabel("xlbl_RevealButton");
 //BA.debugLineNum = 601;BA.debugLine="xlbl_ButtonText = CreateLabel(\"xlbl_ButtonText\")";
_xlbl_buttontext = _createlabel("xlbl_ButtonText");
 //BA.debugLineNum = 602;BA.debugLine="xpnl_Underline = xui.CreatePanel(\"\")";
_xpnl_underline = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 604;BA.debugLine="m_Mode = Props.Get(\"Mode\")";
_m_mode = BA.ObjectToString(_props.Get((Object)("Mode")));
 //BA.debugLineNum = 605;BA.debugLine="m_ReadOnly = Props.GetDefault(\"ReadOnly\",False)";
_m_readonly = BA.ObjectToBoolean(_props.GetDefault((Object)("ReadOnly"),(Object)(__c.False)));
 //BA.debugLineNum = 606;BA.debugLine="m_BackgroundColor = xui.PaintOrColorToColor(Props";
_m_backgroundcolor = _xui.PaintOrColorToColor(_props.Get((Object)("BackgroundColor")));
 //BA.debugLineNum = 607;BA.debugLine="m_TextAlignment = Props.GetDefault(\"TextAlignment";
_m_textalignment = (BA.ObjectToString(_props.GetDefault((Object)("TextAlignment"),(Object)("Left")))).toUpperCase();
 //BA.debugLineNum = 608;BA.debugLine="m_KeyboardType = Props.Get(\"KeyboardType\")";
_m_keyboardtype = BA.ObjectToString(_props.Get((Object)("KeyboardType")));
 //BA.debugLineNum = 609;BA.debugLine="m_PasswordField = IIf(m_Mode = \"TextField\",Props.";
_m_passwordfield = BA.ObjectToBoolean((((_m_mode).equals("TextField")) ? (_props.Get((Object)("PasswordField"))) : ((Object)(__c.False))));
 //BA.debugLineNum = 610;BA.debugLine="m_ShowRevealButton = IIf(m_Mode = \"TextField\",Pro";
_m_showrevealbutton = BA.ObjectToBoolean((((_m_mode).equals("TextField")) ? (_props.Get((Object)("ShowRevealButton"))) : ((Object)(__c.False))));
 //BA.debugLineNum = 611;BA.debugLine="m_ShowClearButton = Props.Get(\"ShowClearButton\")";
_m_showclearbutton = BA.ObjectToBoolean(_props.Get((Object)("ShowClearButton")));
 //BA.debugLineNum = 612;BA.debugLine="m_Underline = Props.GetDefault(\"Underline\",False)";
_m_underline = BA.ObjectToBoolean(_props.GetDefault((Object)("Underline"),(Object)(__c.False)));
 //BA.debugLineNum = 613;BA.debugLine="m_TitleMode = Props.GetDefault(\"TitleMode\",\"Defau";
_m_titlemode = BA.ObjectToString(_props.GetDefault((Object)("TitleMode"),(Object)("Default")));
 //BA.debugLineNum = 616;BA.debugLine="m_ClearAndRevealButtonColor = xui.PaintOrColorToC";
_m_clearandrevealbuttoncolor = _xui.PaintOrColorToColor(_props.GetDefault((Object)("ClearAndRevealButtonColor"),(Object)(((int)0x00ffffff))));
 //BA.debugLineNum = 618;BA.debugLine="m_StrengthIndicator = Props.GetDefault(\"StrengthI";
_m_strengthindicator = BA.ObjectToString(_props.GetDefault((Object)("StrengthIndicator"),(Object)("None")));
 //BA.debugLineNum = 619;BA.debugLine="m_RequiredField = Props.GetDefault(\"RequiredField";
_m_requiredfield = BA.ObjectToBoolean(_props.GetDefault((Object)("RequiredField"),(Object)(__c.False)));
 //BA.debugLineNum = 620;BA.debugLine="m_RequiredFieldColor = xui.PaintOrColorToColor(Pr";
_m_requiredfieldcolor = _xui.PaintOrColorToColor(_props.GetDefault((Object)("RequiredFieldColor"),(Object)(_xui.Color_ARGB((int) (255),(int) (221),(int) (95),(int) (96)))));
 //BA.debugLineNum = 622;BA.debugLine="m_Mask = Props.GetDefault(\"Mask\",\"None\")";
_m_mask = BA.ObjectToString(_props.GetDefault((Object)("Mask"),(Object)("None")));
 //BA.debugLineNum = 623;BA.debugLine="m_MaskText = Props.GetDefault(\"MaskText\",\"\")";
_m_masktext = BA.ObjectToString(_props.GetDefault((Object)("MaskText"),(Object)("")));
 //BA.debugLineNum = 625;BA.debugLine="m_BottomHeight = DipToCurrent(Props.Get(\"BottomHe";
_m_bottomheight = (float) (__c.DipToCurrent((int)(BA.ObjectToNumber(_props.Get((Object)("BottomHeight"))))));
 //BA.debugLineNum = 627;BA.debugLine="m_TextColor = xlbl_InternPreProperties.TextColor";
_m_textcolor = _xlbl_internpreproperties.getTextColor();
 //BA.debugLineNum = 629;BA.debugLine="If m_PasswordField Then m_isPasswordMode = True";
if (_m_passwordfield) { 
_m_ispasswordmode = __c.True;};
 //BA.debugLineNum = 635;BA.debugLine="m_TitleWidth = IIf(Props.ContainsKey(\"TitleWidth\"";
_m_titlewidth = (float)(BA.ObjectToNumber(((_props.ContainsKey((Object)("TitleWidth"))) ? ((Object)(__c.DipToCurrent((int)(BA.ObjectToNumber(_props.Get((Object)("TitleWidth"))))))) : ((Object)(__c.DipToCurrent((int) (100)))))));
 //BA.debugLineNum = 637;BA.debugLine="g_Title = CreateASTextFieldAdvanced_Title(Props.G";
_g_title = _createastextfieldadvanced_title(BA.ObjectToBoolean(_props.Get((Object)("Title"))),BA.ObjectToString(_props.Get((Object)("TitleText"))),(float) (__c.DipToCurrent((int)(BA.ObjectToNumber(_props.Get((Object)("TitleHeight")))))),__c.False,_xui.CreateDefaultBoldFont((float) (15)),_xui.PaintOrColorToColor(_props.GetDefault((Object)("FocusedTitleTextColor"),(Object)(_xui.Color_White))),_xui.PaintOrColorToColor(_props.GetDefault((Object)("NonFocusedTitleTextColor"),(Object)(_xui.Color_White))),"LEFT",_createastextfieldadvanced_viewtitle(_xlbl_title));
 //BA.debugLineNum = 638;BA.debugLine="g_Hint = CreateASTextFieldAdvanced_Hint(Props.Get";
_g_hint = _createastextfieldadvanced_hint(BA.ObjectToBoolean(_props.Get((Object)("Hint"))) && (_m_mode).equals("ComboBox") == false,BA.ObjectToString(_props.Get((Object)("HintText"))),__c.False,_xui.PaintOrColorToColor(_props.Get((Object)("FocusedHintTextColor"))),_xui.PaintOrColorToColor(_props.Get((Object)("NonFocusedHintTextColor"))),_xui.CreateDefaultFont((float) (12)),_createastextfieldadvanced_viewhint(_xlbl_hint));
 //BA.debugLineNum = 639;BA.debugLine="g_Information = CreateASTextFieldAdvanced_Informa";
_g_information = _createastextfieldadvanced_information(BA.ObjectToBoolean(_props.Get((Object)("Info"))),BA.ObjectToString(_props.Get((Object)("InfoText"))),__c.False,_xui.CreateDefaultFont((float) (13)),_xui.PaintOrColorToColor(_props.GetDefault((Object)("InfoTextColor"),(Object)(_xui.Color_White))),_createastextfieldadvanced_viewinformation(_xlbl_info));
 //BA.debugLineNum = 640;BA.debugLine="g_Counter = CreateASTextFieldAdvanced_Counter(Pro";
_g_counter = _createastextfieldadvanced_counter(BA.ObjectToBoolean(_props.Get((Object)("Counter"))),(int)(BA.ObjectToNumber(_props.Get((Object)("CounterMax")))),__c.False,_xui.CreateDefaultFont((float) (13)),_xui.PaintOrColorToColor(_props.GetDefault((Object)("CounterTextColor"),(Object)(_xui.Color_White))),_createastextfieldadvanced_viewcounter(_xlbl_counter));
 //BA.debugLineNum = 641;BA.debugLine="g_LeadingIcon = CreateASTextFieldAdvanced_Leading";
_g_leadingicon = _createastextfieldadvanced_leadingicon(BA.ObjectToBoolean(_props.GetDefault((Object)("LeadingIcon"),(Object)(__c.False))),(anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(__c.Null)),_createastextfieldadvanced_viewleadingicon(_xpnl_leadingicon,_xiv_leadingicon));
 //BA.debugLineNum = 642;BA.debugLine="g_TrailingIcon = CreateASTextFieldAdvanced_Traili";
_g_trailingicon = _createastextfieldadvanced_trailingicon(BA.ObjectToBoolean(_props.GetDefault((Object)("TrailingIcon"),(Object)(__c.False))),(anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(__c.Null)),_createastextfieldadvanced_viewtrailingicon(_xpnl_trailingicon,_xiv_trailingicon));
 //BA.debugLineNum = 643;BA.debugLine="g_Prefix = CreateASTextFieldAdvanced_Prefix(Props";
_g_prefix = _createastextfieldadvanced_prefix(BA.ObjectToBoolean(_props.GetDefault((Object)("Prefix"),(Object)(__c.False))),BA.ObjectToString(_props.GetDefault((Object)("PrefixText"),(Object)("$"))),__c.False,_xui.CreateDefaultFont((float) (20)),_xui.Color_ARGB((int) (100),(int) (255),(int) (255),(int) (255)),(float) (__c.DipToCurrent((int) (5))),_createastextfieldadvanced_viewprefixsuffix(_xlbl_prefix));
 //BA.debugLineNum = 644;BA.debugLine="g_Suffix = CreateASTextFieldAdvanced_Suffix(Props";
_g_suffix = _createastextfieldadvanced_suffix(BA.ObjectToBoolean(_props.GetDefault((Object)("Suffix"),(Object)(__c.False))),BA.ObjectToString(_props.GetDefault((Object)("SuffixText"),(Object)("@gmail.com"))),__c.False,_xui.CreateDefaultFont((float) (20)),_xui.Color_ARGB((int) (100),(int) (255),(int) (255),(int) (255)),(float) (__c.DipToCurrent((int) (5))),_createastextfieldadvanced_viewprefixsuffix(_xlbl_suffix));
 //BA.debugLineNum = 645;BA.debugLine="g_TextFieldProperties = CreateASTextFieldAdvanced";
_g_textfieldproperties = _createastextfieldadvanced_textfieldproperties(_xui.PaintOrColorToColor(_props.GetDefault((Object)("FocusedShapeColor"),(Object)(((int)0xffffffff)))),_xui.PaintOrColorToColor(_props.GetDefault((Object)("NonFocusedShapeColor"),(Object)(((int)0xffffffff)))),(float) (__c.DipToCurrent((int) (2))),(float) (__c.DipToCurrent((int)(BA.ObjectToNumber(_props.GetDefault((Object)("TextFieldCornerRadius"),(Object)(__c.DipToCurrent((int) (5)))))))));
 //BA.debugLineNum = 647;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 373;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 374;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 375;BA.debugLine="mCallBack = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 377;BA.debugLine="IME.Initialize(\"ime\")";
_ime.Initialize("ime");
 //BA.debugLineNum = 379;BA.debugLine="End Sub";
return "";
}
public boolean  _iscolordark(int _color) throws Exception{
double _darkness = 0;
 //BA.debugLineNum = 2136;BA.debugLine="Private Sub isColorDark(color As Int) As Boolean";
 //BA.debugLineNum = 2138;BA.debugLine="Dim darkness As Double = 1 - (0.299 * GetARGB(col";
_darkness = 1-(0.299*_getargb(_color)[(int) (1)]+0.587*_getargb(_color)[(int) (2)]+0.114*_getargb(_color)[(int) (3)])/(double)255;
 //BA.debugLineNum = 2140;BA.debugLine="If darkness <= 0.5 Then";
if (_darkness<=0.5) { 
 //BA.debugLineNum = 2141;BA.debugLine="Return    False 'It's a light color";
if (true) return __c.False;
 }else {
 //BA.debugLineNum = 2143;BA.debugLine="Return    True 'It's a dark color";
if (true) return __c.True;
 };
 //BA.debugLineNum = 2146;BA.debugLine="End Sub";
return false;
}
public String  _leadingiconclick() throws Exception{
 //BA.debugLineNum = 1877;BA.debugLine="Private Sub LeadingIconClick";
 //BA.debugLineNum = 1878;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_Leadin";
if (_xui.SubExists(ba,_mcallback,_meventname+"_LeadingIconClick",(int) (0))) { 
 //BA.debugLineNum = 1879;BA.debugLine="CallSub(mCallBack, mEventName & \"_LeadingIconCli";
__c.CallSubNew(ba,_mcallback,_meventname+"_LeadingIconClick");
 };
 //BA.debugLineNum = 1881;BA.debugLine="End Sub";
return "";
}
public String  _lettersandnumbers(String _text) throws Exception{
String _enable = "";
anywheresoftware.b4a.keywords.StringBuilderWrapper _textclear = null;
int _i = 0;
String _c = "";
 //BA.debugLineNum = 2058;BA.debugLine="Private Sub lettersAndNumbers(Text As String) As S";
 //BA.debugLineNum = 2059;BA.debugLine="Dim enable As String = \"abcdefghijklmnopqrstuvwxy";
_enable = "abcdefghijklmnopqrstuvwxyzçáãàâäéèêëíìîïóòôõöúùûüçABCDEFGHIJKLMNOPQRSTUVWXYZÁÃÀÂÄÉÈÊËÍÌÎÏÓÒÔÕÖÚÙÛÜÜÇ0123456789";
 //BA.debugLineNum = 2061;BA.debugLine="Dim textClear As StringBuilder";
_textclear = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 2062;BA.debugLine="textClear.Initialize";
_textclear.Initialize();
 //BA.debugLineNum = 2063;BA.debugLine="For i = 0 To Text.Length-1";
{
final int step4 = 1;
final int limit4 = (int) (_text.length()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 2064;BA.debugLine="Dim c As String = Text.CharAt(i)";
_c = BA.ObjectToString(_text.charAt(_i));
 //BA.debugLineNum = 2065;BA.debugLine="If enable.Contains(c) Then";
if (_enable.contains(_c)) { 
 //BA.debugLineNum = 2066;BA.debugLine="textClear.Append(c)";
_textclear.Append(_c);
 };
 }
};
 //BA.debugLineNum = 2069;BA.debugLine="Return textClear.ToString";
if (true) return _textclear.ToString();
 //BA.debugLineNum = 2070;BA.debugLine="End Sub";
return "";
}
public int  _measuretextwidth(String _text,anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _font1) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
 //BA.debugLineNum = 2038;BA.debugLine="Private Sub MeasureTextWidth(Text As String, Font1";
 //BA.debugLineNum = 2040;BA.debugLine="Private bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 2041;BA.debugLine="bmp.InitializeMutable(2dip, 2dip)";
_bmp.InitializeMutable(__c.DipToCurrent((int) (2)),__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 2042;BA.debugLine="Private cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 2043;BA.debugLine="cvs.Initialize2(bmp)";
_cvs.Initialize2((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 2044;BA.debugLine="Return cvs.MeasureStringWidth(Text, Font1.ToNa";
if (true) return (int) (_cvs.MeasureStringWidth(_text,(android.graphics.Typeface)(_font1.ToNativeFont().getObject()),_font1.getSize())+__c.DipToCurrent((int) (4)));
 //BA.debugLineNum = 2056;BA.debugLine="End Sub";
return 0;
}
public void  _movefloatinghint(boolean _tohint,boolean _animated) throws Exception{
ResumableSub_MoveFloatingHint rsub = new ResumableSub_MoveFloatingHint(this,_tohint,_animated);
rsub.resume(ba, null);
}
public static class ResumableSub_MoveFloatingHint extends BA.ResumableSub {
public ResumableSub_MoveFloatingHint(com.vehicle.tracker.as_textfieldadvanced parent,boolean _tohint,boolean _animated) {
this.parent = parent;
this._tohint = _tohint;
this._animated = _animated;
}
com.vehicle.tracker.as_textfieldadvanced parent;
boolean _tohint;
boolean _animated;
int _duration = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 880;BA.debugLine="If m_TitleMode <> \"FloatText\" Or (m_LastToHint =";
if (true) break;

case 1:
//if
this.state = 6;
if ((parent._m_titlemode).equals("FloatText") == false || (parent._m_lasttohint==_tohint && _animated==parent.__c.True)) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) return ;
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 882;BA.debugLine="m_LastToHint = ToHint";
parent._m_lasttohint = _tohint;
 //BA.debugLineNum = 884;BA.debugLine="Dim Duration As Int = IIf(Animated,250,0)";
_duration = (int)(BA.ObjectToNumber(((_animated) ? ((Object)(250)) : ((Object)(0)))));
 //BA.debugLineNum = 886;BA.debugLine="If ToHint Then";
if (true) break;

case 7:
//if
this.state = 12;
if (_tohint) { 
this.state = 9;
}else {
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
 //BA.debugLineNum = 887;BA.debugLine="xlbl_FloatingHintTitle.SetLayoutAnimated(Duratio";
parent._xlbl_floatinghinttitle.SetLayoutAnimated(_duration,(int) (parent._xpnl_textfieldbackground.getLeft()+parent._xlbl_hint.getLeft()),(int) (parent._xpnl_textfieldbackground.getTop()+parent._xlbl_hint.getTop()),parent._xlbl_hint.getWidth(),parent._xlbl_hint.getHeight());
 //BA.debugLineNum = 888;BA.debugLine="xlbl_FloatingHintTitle.SetTextSizeAnimated(Durat";
parent._xlbl_floatinghinttitle.SetTextSizeAnimated(_duration,parent._xlbl_hint.getTextSize());
 //BA.debugLineNum = 889;BA.debugLine="xlbl_FloatingHintTitle.TextColor = xlbl_Hint.Tex";
parent._xlbl_floatinghinttitle.setTextColor(parent._xlbl_hint.getTextColor());
 //BA.debugLineNum = 890;BA.debugLine="Sleep(Duration)";
parent.__c.Sleep(ba,this,_duration);
this.state = 13;
return;
case 13:
//C
this.state = 12;
;
 //BA.debugLineNum = 891;BA.debugLine="xlbl_FloatingHintTitle.Font = xlbl_Hint.Font";
parent._xlbl_floatinghinttitle.setFont(parent._xlbl_hint.getFont());
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 893;BA.debugLine="xlbl_FloatingHintTitle.SetLayoutAnimated(Duratio";
parent._xlbl_floatinghinttitle.SetLayoutAnimated(_duration,parent._xlbl_title.getLeft(),parent._xlbl_title.getTop(),parent._xlbl_title.getWidth(),parent._xlbl_title.getHeight());
 //BA.debugLineNum = 894;BA.debugLine="xlbl_FloatingHintTitle.SetTextSizeAnimated(Durat";
parent._xlbl_floatinghinttitle.SetTextSizeAnimated(_duration,parent._xlbl_title.getFont().getSize());
 //BA.debugLineNum = 895;BA.debugLine="xlbl_FloatingHintTitle.TextColor = xlbl_Title.Te";
parent._xlbl_floatinghinttitle.setTextColor(parent._xlbl_title.getTextColor());
 //BA.debugLineNum = 896;BA.debugLine="Sleep(Duration)";
parent.__c.Sleep(ba,this,_duration);
this.state = 14;
return;
case 14:
//C
this.state = 12;
;
 //BA.debugLineNum = 897;BA.debugLine="xlbl_FloatingHintTitle.Font = xlbl_Title.Font";
parent._xlbl_floatinghinttitle.setFont(parent._xlbl_title.getFont());
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 899;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _opencombobox() throws Exception{
 //BA.debugLineNum = 1036;BA.debugLine="Public Sub OpenComboBox";
 //BA.debugLineNum = 1037;BA.debugLine="If m_Mode = \"ComboBox\" Then";
if ((_m_mode).equals("ComboBox")) { 
 //BA.debugLineNum = 1038;BA.debugLine="OpenComboBoxIntern(xcb_ComboBox)";
_opencomboboxintern(_xcb_combobox);
 }else {
 //BA.debugLineNum = 1040;BA.debugLine="LogColor(\"Textfield mode is not ComboBox!\",xui.C";
__c.LogImpl("915663108","Textfield mode is not ComboBox!",_xui.Color_Red);
 };
 //BA.debugLineNum = 1042;BA.debugLine="End Sub";
return "";
}
public String  _opencomboboxintern(com.vehicle.tracker.as_comboboxintern _x) throws Exception{
 //BA.debugLineNum = 1828;BA.debugLine="Private Sub OpenComboBoxIntern(x As AS_ComboBoxInt";
 //BA.debugLineNum = 1830;BA.debugLine="x.cmbBox.As(JavaObject).RunMethod(\"performClic";
((anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_x._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ .getObject()))).RunMethod("performClick",(Object[])(__c.Null));
 //BA.debugLineNum = 1836;BA.debugLine="End Sub";
return "";
}
public String  _passwordrevealchanged(boolean _revealed) throws Exception{
 //BA.debugLineNum = 1871;BA.debugLine="Private Sub PasswordRevealChanged(Revealed As Bool";
 //BA.debugLineNum = 1872;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_Passwo";
if (_xui.SubExists(ba,_mcallback,_meventname+"_PasswordRevealChanged",(int) (1))) { 
 //BA.debugLineNum = 1873;BA.debugLine="CallSub2(mCallBack, mEventName & \"_PasswordRevea";
__c.CallSubNew2(ba,_mcallback,_meventname+"_PasswordRevealChanged",(Object)(_revealed));
 };
 //BA.debugLineNum = 1875;BA.debugLine="End Sub";
return "";
}
public int  _passwordscore() throws Exception{
 //BA.debugLineNum = 1798;BA.debugLine="Public Sub PasswordScore As Int";
 //BA.debugLineNum = 1799;BA.debugLine="Return PasswordStrengthScore(getText,8,1,1,1,1)";
if (true) return _passwordstrengthscore(_gettext(),(int) (8),(int) (1),(int) (1),(int) (1),(int) (1));
 //BA.debugLineNum = 1800;BA.debugLine="End Sub";
return 0;
}
public int  _passwordstrengthscore(String _pwd,int _minlength,int _numupper,int _numlower,int _numnumbers,int _numspecial) throws Exception{
int _score = 0;
 //BA.debugLineNum = 1772;BA.debugLine="Private Sub PasswordStrengthScore(pwd As String,mi";
 //BA.debugLineNum = 1775;BA.debugLine="Dim Score As Int";
_score = 0;
 //BA.debugLineNum = 1776;BA.debugLine="If pwd.Length >= minLength Then Score = Score +1";
if (_pwd.length()>=_minlength) { 
_score = (int) (_score+1);};
 //BA.debugLineNum = 1777;BA.debugLine="If CountMatches(pwd,\"[A-Z]\") >= numUpper Then Sco";
if (_countmatches(_pwd,"[A-Z]")>=_numupper) { 
_score = (int) (_score+1);};
 //BA.debugLineNum = 1778;BA.debugLine="If CountMatches(pwd,\"[a-z]\") >= numLower Then Sco";
if (_countmatches(_pwd,"[a-z]")>=_numlower) { 
_score = (int) (_score+1);};
 //BA.debugLineNum = 1779;BA.debugLine="If CountMatches(pwd,\"[a-z]\") >= numLower Then Sco";
if (_countmatches(_pwd,"[a-z]")>=_numlower) { 
_score = (int) (_score+1);};
 //BA.debugLineNum = 1780;BA.debugLine="If CountMatches(pwd,\"[0-9]\") >= numNumbers Then S";
if (_countmatches(_pwd,"[0-9]")>=_numnumbers) { 
_score = (int) (_score+1);};
 //BA.debugLineNum = 1781;BA.debugLine="If CountMatches(pwd,\"[^a-zA-Z0-9]\") >= numSpecial";
if (_countmatches(_pwd,"[^a-zA-Z0-9]")>=_numspecial) { 
_score = (int) (_score+1);};
 //BA.debugLineNum = 1782;BA.debugLine="If pwd.Length <= minLength/2 And pwd.Length > 0 T";
if (_pwd.length()<=_minlength/(double)2 && _pwd.length()>0) { 
_score = (int) (2);};
 //BA.debugLineNum = 1784;BA.debugLine="If Score <= 2 Then";
if (_score<=2) { 
 //BA.debugLineNum = 1785;BA.debugLine="Return 1 'Weak";
if (true) return (int) (1);
 }else if(_score==3 || _score==4) { 
 //BA.debugLineNum = 1787;BA.debugLine="Return 2 'Medium";
if (true) return (int) (2);
 }else if(_score==5 || _score==6) { 
 //BA.debugLineNum = 1789;BA.debugLine="Return 3 'Strong";
if (true) return (int) (3);
 }else {
 //BA.debugLineNum = 1791;BA.debugLine="Return 1";
if (true) return (int) (1);
 };
 //BA.debugLineNum = 1794;BA.debugLine="End Sub";
return 0;
}
public String  _refresh() throws Exception{
 //BA.debugLineNum = 901;BA.debugLine="Public Sub Refresh";
 //BA.debugLineNum = 902;BA.debugLine="Style";
_style();
 //BA.debugLineNum = 903;BA.debugLine="Base_Resize(mBase.Width,mBase.Height)";
_base_resize(_mbase.getWidth(),_mbase.getHeight());
 //BA.debugLineNum = 904;BA.debugLine="End Sub";
return "";
}
public String  _refreshfloatinghint() throws Exception{
 //BA.debugLineNum = 855;BA.debugLine="Private Sub RefreshFloatingHint";
 //BA.debugLineNum = 857;BA.debugLine="If getText.Length = 0 Then";
if (_gettext().length()==0) { 
 //BA.debugLineNum = 859;BA.debugLine="xlbl_FloatingHintTitle.TextColor = xlbl_Hint.Tex";
_xlbl_floatinghinttitle.setTextColor(_xlbl_hint.getTextColor());
 //BA.debugLineNum = 860;BA.debugLine="xlbl_FloatingHintTitle.Font = xlbl_Hint.Font";
_xlbl_floatinghinttitle.setFont(_xlbl_hint.getFont());
 //BA.debugLineNum = 862;BA.debugLine="xlbl_FloatingHintTitle.Color = xui.Color_Transpa";
_xlbl_floatinghinttitle.setColor(_xui.Color_Transparent);
 //BA.debugLineNum = 863;BA.debugLine="xlbl_FloatingHintTitle.SetTextAlignment(\"CENTER\"";
_xlbl_floatinghinttitle.SetTextAlignment("CENTER",_m_textalignment);
 //BA.debugLineNum = 865;BA.debugLine="If m_Mode = \"Multiline\" Then";
if ((_m_mode).equals("Multiline")) { 
 //BA.debugLineNum = 866;BA.debugLine="xlbl_FloatingHintTitle.SetTextAlignment(\"TOP\",m";
_xlbl_floatinghinttitle.SetTextAlignment("TOP",_m_textalignment);
 };
 }else {
 //BA.debugLineNum = 871;BA.debugLine="xlbl_FloatingHintTitle.TextColor = xlbl_Title.Te";
_xlbl_floatinghinttitle.setTextColor(_xlbl_title.getTextColor());
 //BA.debugLineNum = 872;BA.debugLine="xlbl_FloatingHintTitle.Font = xlbl_Title.Font";
_xlbl_floatinghinttitle.setFont(_xlbl_title.getFont());
 };
 //BA.debugLineNum = 876;BA.debugLine="End Sub";
return "";
}
public String  _revealbutton_click() throws Exception{
 //BA.debugLineNum = 1592;BA.debugLine="Private Sub RevealButton_Click";
 //BA.debugLineNum = 1593;BA.debugLine="If m_ReadOnly Then Return";
if (_m_readonly) { 
if (true) return "";};
 //BA.debugLineNum = 1594;BA.debugLine="If xlbl_RevealButton.Tag = \"reveal\" Then";
if ((_xlbl_revealbutton.getTag()).equals((Object)("reveal"))) { 
 //BA.debugLineNum = 1595;BA.debugLine="xlbl_RevealButton.Text = Chr(0xE8F5)";
_xlbl_revealbutton.setText(BA.ObjectToCharSequence(__c.Chr(((int)0xe8f5))));
 //BA.debugLineNum = 1596;BA.debugLine="xlbl_RevealButton.Tag = \"hide\"";
_xlbl_revealbutton.setTag((Object)("hide"));
 //BA.debugLineNum = 1598;BA.debugLine="xtf_TextField.Text = xtf_TextFieldPassword.Text";
_xtf_textfield.setText(BA.ObjectToCharSequence(_xtf_textfieldpassword.getText()));
 //BA.debugLineNum = 1600;BA.debugLine="xtf_TextField.Visible = True";
_xtf_textfield.setVisible(__c.True);
 //BA.debugLineNum = 1601;BA.debugLine="xtf_TextFieldPassword.Visible = False";
_xtf_textfieldpassword.setVisible(__c.False);
 //BA.debugLineNum = 1603;BA.debugLine="xtf_TextField.RequestFocus";
_xtf_textfield.RequestFocus();
 //BA.debugLineNum = 1607;BA.debugLine="xtf_TextField.As(EditText).SelectionStart = xtf_";
((anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_xtf_textfield.getObject()))).setSelectionStart(_xtf_textfield.getText().length());
 //BA.debugLineNum = 1611;BA.debugLine="PasswordRevealChanged(True)";
_passwordrevealchanged(__c.True);
 }else {
 //BA.debugLineNum = 1613;BA.debugLine="xlbl_RevealButton.Text = Chr(0xE8F4)";
_xlbl_revealbutton.setText(BA.ObjectToCharSequence(__c.Chr(((int)0xe8f4))));
 //BA.debugLineNum = 1614;BA.debugLine="xlbl_RevealButton.Tag = \"reveal\"";
_xlbl_revealbutton.setTag((Object)("reveal"));
 //BA.debugLineNum = 1616;BA.debugLine="xtf_TextFieldPassword.Text = xtf_TextField.Text";
_xtf_textfieldpassword.setText(BA.ObjectToCharSequence(_xtf_textfield.getText()));
 //BA.debugLineNum = 1618;BA.debugLine="xtf_TextField.Visible = False";
_xtf_textfield.setVisible(__c.False);
 //BA.debugLineNum = 1619;BA.debugLine="xtf_TextFieldPassword.Visible = True";
_xtf_textfieldpassword.setVisible(__c.True);
 //BA.debugLineNum = 1621;BA.debugLine="xtf_TextFieldPassword.RequestFocus";
_xtf_textfieldpassword.RequestFocus();
 //BA.debugLineNum = 1625;BA.debugLine="xtf_TextFieldPassword.As(EditText).SelectionStar";
((anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_xtf_textfieldpassword.getObject()))).setSelectionStart(_xtf_textfieldpassword.getText().length());
 //BA.debugLineNum = 1629;BA.debugLine="PasswordRevealChanged(False)";
_passwordrevealchanged(__c.False);
 };
 //BA.debugLineNum = 1631;BA.debugLine="End Sub";
return "";
}
public String  _setbackgroundcolor(int _color) throws Exception{
 //BA.debugLineNum = 1247;BA.debugLine="Public Sub setBackgroundColor(Color As Int)";
 //BA.debugLineNum = 1248;BA.debugLine="m_BackgroundColor = Color";
_m_backgroundcolor = _color;
 //BA.debugLineNum = 1249;BA.debugLine="End Sub";
return "";
}
public String  _setbottomheight(float _height) throws Exception{
 //BA.debugLineNum = 1302;BA.debugLine="Public Sub setBottomHeight(Height As Float)";
 //BA.debugLineNum = 1303;BA.debugLine="m_BottomHeight = Height";
_m_bottomheight = _height;
 //BA.debugLineNum = 1304;BA.debugLine="End Sub";
return "";
}
public String  _setbuttontext(String _text) throws Exception{
 //BA.debugLineNum = 1162;BA.debugLine="Private Sub setButtonText(Text As String)";
 //BA.debugLineNum = 1163;BA.debugLine="m_OldText = getText";
_m_oldtext = _gettext();
 //BA.debugLineNum = 1164;BA.debugLine="xlbl_ButtonText.Text = Text";
_xlbl_buttontext.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 1165;BA.debugLine="If Text.Length > 0 Then";
if (_text.length()>0) { 
 //BA.debugLineNum = 1166;BA.debugLine="xlbl_Hint.Visible = False";
_xlbl_hint.setVisible(__c.False);
 //BA.debugLineNum = 1167;BA.debugLine="MoveFloatingHint(False,True)";
_movefloatinghint(__c.False,__c.True);
 }else {
 //BA.debugLineNum = 1169;BA.debugLine="xlbl_Hint.Visible = g_Hint.Visible";
_xlbl_hint.setVisible(_g_hint.Visible /*boolean*/ );
 //BA.debugLineNum = 1170;BA.debugLine="MoveFloatingHint(True,True)";
_movefloatinghint(__c.True,__c.True);
 };
 //BA.debugLineNum = 1172;BA.debugLine="TextChanged(Text)";
_textchanged(_text);
 //BA.debugLineNum = 1173;BA.debugLine="End Sub";
return "";
}
public void  _setbuttontext2(String _text) throws Exception{
ResumableSub_setButtonText2 rsub = new ResumableSub_setButtonText2(this,_text);
rsub.resume(ba, null);
}
public static class ResumableSub_setButtonText2 extends BA.ResumableSub {
public ResumableSub_setButtonText2(com.vehicle.tracker.as_textfieldadvanced parent,String _text) {
this.parent = parent;
this._text = _text;
}
com.vehicle.tracker.as_textfieldadvanced parent;
String _text;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 1176;BA.debugLine="m_IgnoreTextChangeEvent = True";
parent._m_ignoretextchangeevent = parent.__c.True;
 //BA.debugLineNum = 1177;BA.debugLine="setButtonText(Text)";
parent._setbuttontext(_text);
 //BA.debugLineNum = 1178;BA.debugLine="Sleep(250)";
parent.__c.Sleep(ba,this,(int) (250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 1179;BA.debugLine="m_IgnoreTextChangeEvent = False";
parent._m_ignoretextchangeevent = parent.__c.False;
 //BA.debugLineNum = 1180;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _setclearandrevealbuttoncolor(int _color) throws Exception{
 //BA.debugLineNum = 1256;BA.debugLine="Public Sub setClearAndRevealButtonColor(Color As I";
 //BA.debugLineNum = 1257;BA.debugLine="m_ClearAndRevealButtonColor = Color";
_m_clearandrevealbuttoncolor = _color;
 //BA.debugLineNum = 1258;BA.debugLine="End Sub";
return "";
}
public String  _setitems(anywheresoftware.b4a.objects.collections.List _items) throws Exception{
 //BA.debugLineNum = 1010;BA.debugLine="Public Sub SetItems(Items As List)";
 //BA.debugLineNum = 1011;BA.debugLine="xcb_ComboBox.SetItems(Items)";
_xcb_combobox._setitems /*String*/ (_items);
 //BA.debugLineNum = 1012;BA.debugLine="xlbl_ButtonText.Text = xcb_ComboBox.SelectedItem";
_xlbl_buttontext.setText(BA.ObjectToCharSequence(_xcb_combobox._getselecteditem /*String*/ ()));
 //BA.debugLineNum = 1013;BA.debugLine="End Sub";
return "";
}
public String  _setleadingicon2(anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _icon) throws Exception{
float _scale = 0f;
 //BA.debugLineNum = 1402;BA.debugLine="Private Sub setLeadingIcon2(Icon As B4XBitmap)";
 //BA.debugLineNum = 1403;BA.debugLine="g_LeadingIcon.Icon = Icon";
_g_leadingicon.Icon /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/  = _icon;
 //BA.debugLineNum = 1404;BA.debugLine="Dim scale As Float = 1";
_scale = (float) (1);
 //BA.debugLineNum = 1408;BA.debugLine="xiv_LeadingIcon.SetBitmap(Icon.Resize(xiv_Leading";
_xiv_leadingicon.SetBitmap((android.graphics.Bitmap)(_icon.Resize((int) (_xiv_leadingicon.getWidth()*_scale),(int) (_xiv_leadingicon.getHeight()*_scale),__c.True).getObject()));
 //BA.debugLineNum = 1409;BA.debugLine="End Sub";
return "";
}
public String  _setleadingwidth(float _width) throws Exception{
 //BA.debugLineNum = 1062;BA.debugLine="Public Sub setLeadingWidth(Width As Float)";
 //BA.debugLineNum = 1063;BA.debugLine="m_CustomLeadingWidth = Width";
_m_customleadingwidth = _width;
 //BA.debugLineNum = 1064;BA.debugLine="End Sub";
return "";
}
public String  _setleftgap(float _gap) throws Exception{
 //BA.debugLineNum = 1312;BA.debugLine="Public Sub setLeftGap(Gap As Float)";
 //BA.debugLineNum = 1313;BA.debugLine="m_LeftGap = Gap";
_m_leftgap = _gap;
 //BA.debugLineNum = 1314;BA.debugLine="End Sub";
return "";
}
public String  _setmasktext(String _mask) throws Exception{
 //BA.debugLineNum = 1066;BA.debugLine="Public Sub setMaskText(Mask As String)";
 //BA.debugLineNum = 1067;BA.debugLine="m_MaskText = Mask";
_m_masktext = _mask;
 //BA.debugLineNum = 1068;BA.debugLine="End Sub";
return "";
}
public String  _setreadonly(boolean _readonly) throws Exception{
 //BA.debugLineNum = 1094;BA.debugLine="Public Sub setReadOnly(ReadOnly As Boolean)";
 //BA.debugLineNum = 1095;BA.debugLine="m_ReadOnly = ReadOnly";
_m_readonly = _readonly;
 //BA.debugLineNum = 1096;BA.debugLine="If ReadOnly = True Then";
if (_readonly==__c.True) { 
 //BA.debugLineNum = 1097;BA.debugLine="If xtf_TextField.IsInitialized Then xtf_TextFiel";
if (_xtf_textfield.IsInitialized()) { 
_xtf_textfield.setEnabled(__c.False);};
 //BA.debugLineNum = 1098;BA.debugLine="If xtf_TextFieldPassword.IsInitialized Then xtf_";
if (_xtf_textfieldpassword.IsInitialized()) { 
_xtf_textfieldpassword.setEnabled(__c.False);};
 //BA.debugLineNum = 1099;BA.debugLine="If xtf_Multiline.IsInitialized Then";
if (_xtf_multiline.IsInitialized()) { 
 //BA.debugLineNum = 1103;BA.debugLine="xtf_Multiline.As(EditText).InputType = xtf_Mult";
((anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_xtf_multiline.getObject()))).setInputType(((anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_xtf_multiline.getObject()))).INPUT_TYPE_NONE);
 //BA.debugLineNum = 1104;BA.debugLine="xtf_Multiline.As(EditText).SingleLine = False";
((anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_xtf_multiline.getObject()))).setSingleLine(__c.False);
 };
 }else {
 //BA.debugLineNum = 1110;BA.debugLine="If xtf_TextField.IsInitialized Then xtf_TextFiel";
if (_xtf_textfield.IsInitialized()) { 
_xtf_textfield.setEnabled(__c.True);};
 //BA.debugLineNum = 1111;BA.debugLine="If xtf_TextFieldPassword.IsInitialized Then xtf_";
if (_xtf_textfieldpassword.IsInitialized()) { 
_xtf_textfieldpassword.setEnabled(__c.True);};
 //BA.debugLineNum = 1112;BA.debugLine="If xtf_Multiline.IsInitialized Then";
if (_xtf_multiline.IsInitialized()) { 
 //BA.debugLineNum = 1113;BA.debugLine="xtf_Multiline.Enabled = True";
_xtf_multiline.setEnabled(__c.True);
 //BA.debugLineNum = 1117;BA.debugLine="xtf_Multiline.As(EditText).InputType = xtf_Mult";
((anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_xtf_multiline.getObject()))).setInputType(((anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_xtf_multiline.getObject()))).INPUT_TYPE_TEXT);
 //BA.debugLineNum = 1118;BA.debugLine="xtf_Multiline.As(EditText).SingleLine = False";
((anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_xtf_multiline.getObject()))).setSingleLine(__c.False);
 };
 };
 //BA.debugLineNum = 1122;BA.debugLine="End Sub";
return "";
}
public String  _setrequiredfield(boolean _required) throws Exception{
 //BA.debugLineNum = 1083;BA.debugLine="Public Sub setRequiredField(Required As Boolean)";
 //BA.debugLineNum = 1084;BA.debugLine="m_RequiredField = Required";
_m_requiredfield = _required;
 //BA.debugLineNum = 1085;BA.debugLine="End Sub";
return "";
}
public String  _setrequiredfieldcolor(int _color) throws Exception{
 //BA.debugLineNum = 1075;BA.debugLine="Public Sub setRequiredFieldColor(Color As Int)";
 //BA.debugLineNum = 1076;BA.debugLine="m_RequiredFieldColor = Color";
_m_requiredfieldcolor = _color;
 //BA.debugLineNum = 1077;BA.debugLine="End Sub";
return "";
}
public String  _setreveale(boolean _revealed) throws Exception{
 //BA.debugLineNum = 1272;BA.debugLine="Public Sub setReveale(Revealed As Boolean)";
 //BA.debugLineNum = 1273;BA.debugLine="If Revealed Then";
if (_revealed) { 
 //BA.debugLineNum = 1274;BA.debugLine="xlbl_RevealButton.Tag = \"reveal\"";
_xlbl_revealbutton.setTag((Object)("reveal"));
 }else {
 //BA.debugLineNum = 1276;BA.debugLine="xlbl_RevealButton.Tag = \"hide\"";
_xlbl_revealbutton.setTag((Object)("hide"));
 };
 //BA.debugLineNum = 1278;BA.debugLine="RevealButton_Click";
_revealbutton_click();
 //BA.debugLineNum = 1279;BA.debugLine="End Sub";
return "";
}
public String  _setselectedindex(int _index) throws Exception{
 //BA.debugLineNum = 1016;BA.debugLine="Public Sub setSelectedIndex(Index As Int)";
 //BA.debugLineNum = 1017;BA.debugLine="xcb_ComboBox.SelectedIndex = Index";
_xcb_combobox._setselectedindex /*int*/ (_index);
 //BA.debugLineNum = 1018;BA.debugLine="xlbl_ButtonText.Text = xcb_ComboBox.SelectedItem";
_xlbl_buttontext.setText(BA.ObjectToCharSequence(_xcb_combobox._getselecteditem /*String*/ ()));
 //BA.debugLineNum = 1019;BA.debugLine="End Sub";
return "";
}
public String  _setshowclearbutton(boolean _show) throws Exception{
 //BA.debugLineNum = 1293;BA.debugLine="Public Sub setShowClearButton(Show As Boolean)";
 //BA.debugLineNum = 1294;BA.debugLine="m_ShowClearButton = Show";
_m_showclearbutton = _show;
 //BA.debugLineNum = 1295;BA.debugLine="End Sub";
return "";
}
public String  _setshowrevealbutton(boolean _show) throws Exception{
 //BA.debugLineNum = 1285;BA.debugLine="Public Sub setShowRevealButton(Show As Boolean)";
 //BA.debugLineNum = 1286;BA.debugLine="m_ShowRevealButton = Show";
_m_showrevealbutton = _show;
 //BA.debugLineNum = 1287;BA.debugLine="End Sub";
return "";
}
public String  _settext(String _text) throws Exception{
 //BA.debugLineNum = 1366;BA.debugLine="Public Sub setText(Text As String)";
 //BA.debugLineNum = 1367;BA.debugLine="m_OldText = getText";
_m_oldtext = _gettext();
 //BA.debugLineNum = 1368;BA.debugLine="If m_Mode = \"Button\" Then";
if ((_m_mode).equals("Button")) { 
 //BA.debugLineNum = 1369;BA.debugLine="setButtonText(Text)";
_setbuttontext(_text);
 }else {
 //BA.debugLineNum = 1371;BA.debugLine="If xtf_TextField.IsInitialized Then xtf_TextFiel";
if (_xtf_textfield.IsInitialized()) { 
_xtf_textfield.setText(BA.ObjectToCharSequence(_text));};
 //BA.debugLineNum = 1372;BA.debugLine="If xtf_TextFieldPassword.IsInitialized Then xtf_";
if (_xtf_textfieldpassword.IsInitialized()) { 
_xtf_textfieldpassword.setText(BA.ObjectToCharSequence(_text));};
 //BA.debugLineNum = 1373;BA.debugLine="If xtf_Multiline.IsInitialized Then xtf_Multilin";
if (_xtf_multiline.IsInitialized()) { 
_xtf_multiline.setText(BA.ObjectToCharSequence(_text));};
 //BA.debugLineNum = 1374;BA.debugLine="If Text.Length > 0 Then";
if (_text.length()>0) { 
 //BA.debugLineNum = 1375;BA.debugLine="xlbl_Hint.Visible = False";
_xlbl_hint.setVisible(__c.False);
 }else {
 //BA.debugLineNum = 1377;BA.debugLine="xlbl_Hint.Visible = g_Hint.Visible";
_xlbl_hint.setVisible(_g_hint.Visible /*boolean*/ );
 //BA.debugLineNum = 1378;BA.debugLine="MoveFloatingHint(True,False)";
_movefloatinghint(__c.True,__c.False);
 };
 //BA.debugLineNum = 1380;BA.debugLine="TextChanged(Text)";
_textchanged(_text);
 };
 //BA.debugLineNum = 1382;BA.debugLine="End Sub";
return "";
}
public void  _settext2(String _text) throws Exception{
ResumableSub_setText2 rsub = new ResumableSub_setText2(this,_text);
rsub.resume(ba, null);
}
public static class ResumableSub_setText2 extends BA.ResumableSub {
public ResumableSub_setText2(com.vehicle.tracker.as_textfieldadvanced parent,String _text) {
this.parent = parent;
this._text = _text;
}
com.vehicle.tracker.as_textfieldadvanced parent;
String _text;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 1355;BA.debugLine="m_OldText = getText";
parent._m_oldtext = parent._gettext();
 //BA.debugLineNum = 1356;BA.debugLine="If m_Mode = \"Button\" Then";
if (true) break;

case 1:
//if
this.state = 6;
if ((parent._m_mode).equals("Button")) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 1357;BA.debugLine="setButtonText2(Text)";
parent._setbuttontext2(_text);
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 1359;BA.debugLine="m_IgnoreTextChangeEvent = True";
parent._m_ignoretextchangeevent = parent.__c.True;
 //BA.debugLineNum = 1360;BA.debugLine="setText(Text)";
parent._settext(_text);
 //BA.debugLineNum = 1361;BA.debugLine="Sleep(250)";
parent.__c.Sleep(ba,this,(int) (250));
this.state = 7;
return;
case 7:
//C
this.state = 6;
;
 //BA.debugLineNum = 1362;BA.debugLine="m_IgnoreTextChangeEvent = False";
parent._m_ignoretextchangeevent = parent.__c.False;
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 1364;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _settextalignment(String _textalignment) throws Exception{
 //BA.debugLineNum = 954;BA.debugLine="Public Sub setTextAlignment(TextAlignment As Strin";
 //BA.debugLineNum = 955;BA.debugLine="m_TextAlignment = TextAlignment";
_m_textalignment = _textalignment;
 //BA.debugLineNum = 956;BA.debugLine="If xtf_TextField.IsInitialized Then xtf_TextField";
if (_xtf_textfield.IsInitialized()) { 
_xtf_textfield.SetTextAlignment("CENTER",_m_textalignment);};
 //BA.debugLineNum = 957;BA.debugLine="If xtf_TextFieldPassword.IsInitialized Then xtf_T";
if (_xtf_textfieldpassword.IsInitialized()) { 
_xtf_textfieldpassword.SetTextAlignment("CENTER",_m_textalignment);};
 //BA.debugLineNum = 958;BA.debugLine="If xlbl_ButtonText.IsInitialized Then xlbl_Button";
if (_xlbl_buttontext.IsInitialized()) { 
_xlbl_buttontext.SetTextAlignment("CENTER",_m_textalignment);};
 //BA.debugLineNum = 959;BA.debugLine="If xlbl_Hint.IsInitialized Then xlbl_Hint.SetText";
if (_xlbl_hint.IsInitialized()) { 
_xlbl_hint.SetTextAlignment("CENTER",_m_textalignment);};
 //BA.debugLineNum = 962;BA.debugLine="If xtf_Multiline.IsInitialized Then";
if (_xtf_multiline.IsInitialized()) { 
 //BA.debugLineNum = 964;BA.debugLine="xtf_Multiline.SetTextAlignment(\"TOP\",m_TextAlignm";
_xtf_multiline.SetTextAlignment("TOP",_m_textalignment);
 };
 //BA.debugLineNum = 973;BA.debugLine="End Sub";
return "";
}
public String  _settextcolor(int _color) throws Exception{
 //BA.debugLineNum = 1326;BA.debugLine="Public Sub setTextColor(Color As Int)";
 //BA.debugLineNum = 1327;BA.debugLine="m_TextColor = Color";
_m_textcolor = _color;
 //BA.debugLineNum = 1328;BA.debugLine="If xtf_TextField.IsInitialized Then xtf_TextField";
if (_xtf_textfield.IsInitialized()) { 
_xtf_textfield.setTextColor(_m_textcolor);};
 //BA.debugLineNum = 1329;BA.debugLine="If xtf_TextFieldPassword.IsInitialized Then xtf_T";
if (_xtf_textfieldpassword.IsInitialized()) { 
_xtf_textfieldpassword.setTextColor(_m_textcolor);};
 //BA.debugLineNum = 1330;BA.debugLine="If xtf_Multiline.IsInitialized Then xtf_Multiline";
if (_xtf_multiline.IsInitialized()) { 
_xtf_multiline.setTextColor(_m_textcolor);};
 //BA.debugLineNum = 1331;BA.debugLine="If xlbl_ButtonText.IsInitialized Then xlbl_Button";
if (_xlbl_buttontext.IsInitialized()) { 
_xlbl_buttontext.setTextColor(_m_textcolor);};
 //BA.debugLineNum = 1332;BA.debugLine="End Sub";
return "";
}
public String  _settitlewidth(float _width) throws Exception{
 //BA.debugLineNum = 1005;BA.debugLine="Public Sub setTitleWidth(Width As Float)";
 //BA.debugLineNum = 1006;BA.debugLine="m_TitleWidth = Width";
_m_titlewidth = _width;
 //BA.debugLineNum = 1007;BA.debugLine="End Sub";
return "";
}
public String  _settopgap(float _gap) throws Exception{
 //BA.debugLineNum = 1322;BA.debugLine="Public Sub setTopGap(Gap As Float)";
 //BA.debugLineNum = 1323;BA.debugLine="m_TopGap = Gap";
_m_topgap = _gap;
 //BA.debugLineNum = 1324;BA.debugLine="End Sub";
return "";
}
public String  _settrailingicon2(anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _icon) throws Exception{
float _scale = 0f;
 //BA.debugLineNum = 1411;BA.debugLine="Private Sub setTrailingIcon2(Icon As B4XBitmap)";
 //BA.debugLineNum = 1412;BA.debugLine="g_TrailingIcon.Icon = Icon";
_g_trailingicon.Icon /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/  = _icon;
 //BA.debugLineNum = 1413;BA.debugLine="Dim scale As Float = 1";
_scale = (float) (1);
 //BA.debugLineNum = 1417;BA.debugLine="xiv_TrailingIcon.SetBitmap(Icon.Resize(xiv_Traili";
_xiv_trailingicon.SetBitmap((android.graphics.Bitmap)(_icon.Resize((int) (_xiv_trailingicon.getWidth()*_scale),(int) (_xiv_trailingicon.getHeight()*_scale),__c.True).getObject()));
 //BA.debugLineNum = 1418;BA.debugLine="End Sub";
return "";
}
public String  _settrailingwidth(float _width) throws Exception{
 //BA.debugLineNum = 1053;BA.debugLine="Public Sub setTrailingWidth(Width As Float)";
 //BA.debugLineNum = 1054;BA.debugLine="m_CustomTrailingWidth = Width";
_m_customtrailingwidth = _width;
 //BA.debugLineNum = 1055;BA.debugLine="End Sub";
return "";
}
public String  _setunderline(boolean _underline) throws Exception{
 //BA.debugLineNum = 984;BA.debugLine="Public Sub setUnderline(Underline As Boolean)";
 //BA.debugLineNum = 985;BA.debugLine="m_Underline = Underline";
_m_underline = _underline;
 //BA.debugLineNum = 986;BA.debugLine="UpdateTextFieldShape";
_updatetextfieldshape();
 //BA.debugLineNum = 987;BA.debugLine="End Sub";
return "";
}
public String  _showdisplaymissingfield(String _informationtext) throws Exception{
int[] _color = null;
 //BA.debugLineNum = 936;BA.debugLine="Public Sub ShowDisplayMissingField(InformationText";
 //BA.debugLineNum = 937;BA.debugLine="m_isInRequiredMode = True";
_m_isinrequiredmode = __c.True;
 //BA.debugLineNum = 938;BA.debugLine="Dim Color() As Int = GetARGB(m_RequiredFieldColor";
_color = _getargb(_m_requiredfieldcolor);
 //BA.debugLineNum = 939;BA.debugLine="xpnl_TextFieldBackground.SetColorAndBorder(xui.Co";
_xpnl_textfieldbackground.SetColorAndBorder(_xui.Color_ARGB((int) (80),_color[(int) (1)],_color[(int) (2)],_color[(int) (3)]),(int) (_g_textfieldproperties.BorderWidth /*float*/ ),_m_requiredfieldcolor,(int) (_g_textfieldproperties.CornerRadius /*float*/ ));
 //BA.debugLineNum = 940;BA.debugLine="xlbl_Info.Text = InformationText";
_xlbl_info.setText(BA.ObjectToCharSequence(_informationtext));
 //BA.debugLineNum = 941;BA.debugLine="End Sub";
return "";
}
public String  _style() throws Exception{
int[] _clearandrevealbuttoncolor = null;
 //BA.debugLineNum = 780;BA.debugLine="Private Sub Style";
 //BA.debugLineNum = 783;BA.debugLine="If g_Title.IgnoreProperties = False Then";
if (_g_title.IgnoreProperties /*boolean*/ ==__c.False) { 
 //BA.debugLineNum = 784;BA.debugLine="If m_TitleMode <> \"FloatText\" Then xlbl_Title.Te";
if ((_m_titlemode).equals("FloatText") == false) { 
_xlbl_title.setText(BA.ObjectToCharSequence(_g_title.Text /*String*/ ));};
 //BA.debugLineNum = 785;BA.debugLine="If m_TitleMode = \"FloatText\" Then xlbl_FloatingH";
if ((_m_titlemode).equals("FloatText")) { 
_xlbl_floatinghinttitle.setText(BA.ObjectToCharSequence(_g_title.Text /*String*/ ));};
 //BA.debugLineNum = 786;BA.debugLine="If m_HasFocus Then";
if (_m_hasfocus) { 
 //BA.debugLineNum = 787;BA.debugLine="xlbl_Title.TextColor = g_Title.FocusedTextColor";
_xlbl_title.setTextColor(_g_title.FocusedTextColor /*int*/ );
 }else {
 //BA.debugLineNum = 790;BA.debugLine="xlbl_Title.TextColor = g_Title.NonFocusedTextCo";
_xlbl_title.setTextColor(_g_title.NonFocusedTextColor /*int*/ );
 };
 //BA.debugLineNum = 793;BA.debugLine="xlbl_Title.Font = g_Title.xFont";
_xlbl_title.setFont(_g_title.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/ );
 //BA.debugLineNum = 794;BA.debugLine="xlbl_Title.SetTextAlignment(\"CENTER\",g_Title.Hor";
_xlbl_title.SetTextAlignment("CENTER",_g_title.HorizontalAlignment /*String*/ );
 //BA.debugLineNum = 796;BA.debugLine="xlbl_TitleReqiredField.Text = \"*\"";
_xlbl_titlereqiredfield.setText(BA.ObjectToCharSequence("*"));
 //BA.debugLineNum = 797;BA.debugLine="xlbl_TitleReqiredField.Textcolor = m_RequiredFie";
_xlbl_titlereqiredfield.setTextColor(_m_requiredfieldcolor);
 //BA.debugLineNum = 798;BA.debugLine="xlbl_TitleReqiredField.Font = g_Title.xFont";
_xlbl_titlereqiredfield.setFont(_g_title.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/ );
 //BA.debugLineNum = 799;BA.debugLine="xlbl_TitleReqiredField.SetTextAlignment(\"CENTER\"";
_xlbl_titlereqiredfield.SetTextAlignment("CENTER",_g_title.HorizontalAlignment /*String*/ );
 };
 //BA.debugLineNum = 804;BA.debugLine="If g_Hint.IgnoreProperties = False Then";
if (_g_hint.IgnoreProperties /*boolean*/ ==__c.False) { 
 //BA.debugLineNum = 805;BA.debugLine="If m_HasFocus Then";
if (_m_hasfocus) { 
 //BA.debugLineNum = 806;BA.debugLine="xlbl_Hint.TextColor = g_Hint.FocusedTextColor";
_xlbl_hint.setTextColor(_g_hint.FocusedTextColor /*int*/ );
 }else {
 //BA.debugLineNum = 808;BA.debugLine="xlbl_Hint.TextColor = g_Hint.NonFocusedTextColo";
_xlbl_hint.setTextColor(_g_hint.NonFocusedTextColor /*int*/ );
 };
 //BA.debugLineNum = 810;BA.debugLine="xlbl_Hint.Font = g_Hint.xFont";
_xlbl_hint.setFont(_g_hint.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/ );
 //BA.debugLineNum = 811;BA.debugLine="If m_TitleMode <> \"FloatText\" Then xlbl_Hint.Tex";
if ((_m_titlemode).equals("FloatText") == false) { 
_xlbl_hint.setText(BA.ObjectToCharSequence(_g_hint.Text /*String*/ ));};
 //BA.debugLineNum = 812;BA.debugLine="If m_Mode = \"Multiline\" Then";
if ((_m_mode).equals("Multiline")) { 
 //BA.debugLineNum = 813;BA.debugLine="xlbl_Hint.SetTextAlignment(\"TOP\",m_TextAlignmen";
_xlbl_hint.SetTextAlignment("TOP",_m_textalignment);
 };
 };
 //BA.debugLineNum = 818;BA.debugLine="If g_Information.IgnoreProperties = False Then";
if (_g_information.IgnoreProperties /*boolean*/ ==__c.False) { 
 //BA.debugLineNum = 819;BA.debugLine="xlbl_Info.Text = g_Information.Text";
_xlbl_info.setText(BA.ObjectToCharSequence(_g_information.Text /*String*/ ));
 //BA.debugLineNum = 820;BA.debugLine="xlbl_Info.TextColor = g_Information.TextColor";
_xlbl_info.setTextColor(_g_information.TextColor /*int*/ );
 //BA.debugLineNum = 821;BA.debugLine="xlbl_Info.Font = g_Information.xFont";
_xlbl_info.setFont(_g_information.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/ );
 };
 //BA.debugLineNum = 825;BA.debugLine="If g_Counter.IgnoreProperties = False Then";
if (_g_counter.IgnoreProperties /*boolean*/ ==__c.False) { 
 //BA.debugLineNum = 826;BA.debugLine="xlbl_Counter.Text = getText.Length & \"/\" & g_Cou";
_xlbl_counter.setText(BA.ObjectToCharSequence(BA.NumberToString(_gettext().length())+"/"+BA.NumberToString(_g_counter.CounterMax /*int*/ )));
 //BA.debugLineNum = 827;BA.debugLine="xlbl_Counter.TextColor = g_Counter.TextColor";
_xlbl_counter.setTextColor(_g_counter.TextColor /*int*/ );
 //BA.debugLineNum = 828;BA.debugLine="xlbl_Counter.Font = g_Counter.xFont";
_xlbl_counter.setFont(_g_counter.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/ );
 //BA.debugLineNum = 829;BA.debugLine="xlbl_Counter.SetTextAlignment(\"CENTER\",\"RIGHT\")";
_xlbl_counter.SetTextAlignment("CENTER","RIGHT");
 };
 //BA.debugLineNum = 833;BA.debugLine="If g_Prefix.IgnoreProperties = False Then";
if (_g_prefix.IgnoreProperties /*boolean*/ ==__c.False) { 
 //BA.debugLineNum = 834;BA.debugLine="xlbl_Prefix.Text = g_Prefix.Text";
_xlbl_prefix.setText(BA.ObjectToCharSequence(_g_prefix.Text /*String*/ ));
 //BA.debugLineNum = 835;BA.debugLine="xlbl_Prefix.TextColor = g_Prefix.TextColor";
_xlbl_prefix.setTextColor(_g_prefix.TextColor /*int*/ );
 //BA.debugLineNum = 836;BA.debugLine="xlbl_Prefix.Font = g_Prefix.xFont";
_xlbl_prefix.setFont(_g_prefix.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/ );
 //BA.debugLineNum = 837;BA.debugLine="xlbl_Prefix.SetTextAlignment(\"CENTER\",\"CENTER\")";
_xlbl_prefix.SetTextAlignment("CENTER","CENTER");
 };
 //BA.debugLineNum = 841;BA.debugLine="If g_Suffix.IgnoreProperties = False Then";
if (_g_suffix.IgnoreProperties /*boolean*/ ==__c.False) { 
 //BA.debugLineNum = 842;BA.debugLine="xlbl_Suffix.Text = g_Suffix.Text";
_xlbl_suffix.setText(BA.ObjectToCharSequence(_g_suffix.Text /*String*/ ));
 //BA.debugLineNum = 843;BA.debugLine="xlbl_Suffix.TextColor = g_Suffix.TextColor";
_xlbl_suffix.setTextColor(_g_suffix.TextColor /*int*/ );
 //BA.debugLineNum = 844;BA.debugLine="xlbl_Suffix.Font = g_Suffix.xFont";
_xlbl_suffix.setFont(_g_suffix.xFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/ );
 //BA.debugLineNum = 845;BA.debugLine="xlbl_Suffix.SetTextAlignment(\"CENTER\",\"CENTER\")";
_xlbl_suffix.SetTextAlignment("CENTER","CENTER");
 };
 //BA.debugLineNum = 848;BA.debugLine="Dim ClearAndRevealButtonColor() As Int = GetARGB(";
_clearandrevealbuttoncolor = _getargb(_m_clearandrevealbuttoncolor);
 //BA.debugLineNum = 849;BA.debugLine="xlbl_ClearButton.TextColor = IIf(ClearAndRevealBu";
_xlbl_clearbutton.setTextColor((int)(BA.ObjectToNumber(((_clearandrevealbuttoncolor[(int) (0)]>0) ? ((Object)(_m_clearandrevealbuttoncolor)) : (((_iscolordark(_m_backgroundcolor)) ? ((Object)(_xui.Color_ARGB((int) (152),(int) (255),(int) (255),(int) (255)))) : ((Object)(_xui.Color_ARGB((int) (152),(int) (0),(int) (0),(int) (0))))))))));
 //BA.debugLineNum = 850;BA.debugLine="xlbl_RevealButton.TextColor = xlbl_ClearButton.Te";
_xlbl_revealbutton.setTextColor(_xlbl_clearbutton.getTextColor());
 //BA.debugLineNum = 852;BA.debugLine="UpdateTextFieldShape";
_updatetextfieldshape();
 //BA.debugLineNum = 853;BA.debugLine="End Sub";
return "";
}
public String  _textchanged(String _text) throws Exception{
String _textmasked = "";
int _selectionstart = 0;
 //BA.debugLineNum = 1462;BA.debugLine="Private Sub TextChanged(Text As String)";
 //BA.debugLineNum = 1463;BA.debugLine="If m_isViewReady = False Then Return";
if (_m_isviewready==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 1464;BA.debugLine="If m_Mask<>\"None\" And (m_MaskText.Contains(\"X\") O";
if ((_m_mask).equals("None") == false && (_m_masktext.contains("X") || _m_masktext.contains("0"))) { 
 //BA.debugLineNum = 1465;BA.debugLine="Dim textMasked As String = applyMask(Text, m_Mas";
_textmasked = _applymask(_text,_m_masktext,_m_mask);
 //BA.debugLineNum = 1466;BA.debugLine="If Text <> textMasked Then";
if ((_text).equals(_textmasked) == false) { 
 //BA.debugLineNum = 1467;BA.debugLine="xtf_TextField.Text = textMasked";
_xtf_textfield.setText(BA.ObjectToCharSequence(_textmasked));
 //BA.debugLineNum = 1468;BA.debugLine="xtf_TextField.SelectionStart = xtf_TextField.Te";
_xtf_textfield.setSelectionStart(_xtf_textfield.getText().length());
 };
 };
 //BA.debugLineNum = 1472;BA.debugLine="If g_Counter.Visible Then";
if (_g_counter.Visible /*boolean*/ ) { 
 //BA.debugLineNum = 1473;BA.debugLine="If GetRealTextLength(Text) > g_Counter.CounterMa";
if (_getrealtextlength(_text)>_g_counter.CounterMax /*int*/ ) { 
 //BA.debugLineNum = 1475;BA.debugLine="If xtf_TextField .IsInitialized Then";
if (_xtf_textfield.IsInitialized()) { 
 //BA.debugLineNum = 1476;BA.debugLine="Dim SelectionStart As Int = xtf_TextField.Sele";
_selectionstart = _xtf_textfield.getSelectionStart();
 //BA.debugLineNum = 1477;BA.debugLine="xtf_TextField.Text = m_InternOldText'Text.SubS";
_xtf_textfield.setText(BA.ObjectToCharSequence(_m_internoldtext));
 //BA.debugLineNum = 1478;BA.debugLine="xtf_TextField.SelectionStart = Min(SelectionSt";
_xtf_textfield.setSelectionStart((int) (__c.Min(_selectionstart,_xtf_textfield.getText().length())));
 };
 //BA.debugLineNum = 1480;BA.debugLine="If xtf_TextFieldPassword .IsInitialized Then";
if (_xtf_textfieldpassword.IsInitialized()) { 
 //BA.debugLineNum = 1481;BA.debugLine="Dim SelectionStart As Int = xtf_TextFieldPassw";
_selectionstart = _xtf_textfieldpassword.getSelectionStart();
 //BA.debugLineNum = 1482;BA.debugLine="xtf_TextFieldPassword.Text = m_InternOldText'T";
_xtf_textfieldpassword.setText(BA.ObjectToCharSequence(_m_internoldtext));
 //BA.debugLineNum = 1483;BA.debugLine="xtf_TextFieldPassword.SelectionStart = Min(Sel";
_xtf_textfieldpassword.setSelectionStart((int) (__c.Min(_selectionstart,_xtf_textfieldpassword.getText().length())));
 };
 //BA.debugLineNum = 1485;BA.debugLine="If xtf_Multiline.IsInitialized Then";
if (_xtf_multiline.IsInitialized()) { 
 //BA.debugLineNum = 1486;BA.debugLine="Dim SelectionStart As Int = xtf_Multiline.Sele";
_selectionstart = _xtf_multiline.getSelectionStart();
 //BA.debugLineNum = 1487;BA.debugLine="xtf_Multiline.Text = m_InternOldText'Text.SubS";
_xtf_multiline.setText(BA.ObjectToCharSequence(_m_internoldtext));
 //BA.debugLineNum = 1488;BA.debugLine="xtf_Multiline.SelectionStart = Min(SelectionSt";
_xtf_multiline.setSelectionStart((int) (__c.Min(_selectionstart,_xtf_multiline.getText().length())));
 };
 //BA.debugLineNum = 1490;BA.debugLine="Text = m_InternOldText'Text.SubString2(0,g_Coun";
_text = _m_internoldtext;
 };
 };
 //BA.debugLineNum = 1494;BA.debugLine="If Text.Length = 0 Then";
if (_text.length()==0) { 
 //BA.debugLineNum = 1495;BA.debugLine="xlbl_ClearButton.Visible = False";
_xlbl_clearbutton.setVisible(__c.False);
 //BA.debugLineNum = 1496;BA.debugLine="xlbl_RevealButton.Visible = False";
_xlbl_revealbutton.setVisible(__c.False);
 //BA.debugLineNum = 1497;BA.debugLine="xlbl_Hint.Visible = g_Hint.Visible";
_xlbl_hint.setVisible(_g_hint.Visible /*boolean*/ );
 //BA.debugLineNum = 1498;BA.debugLine="MoveFloatingHint(True,True)";
_movefloatinghint(__c.True,__c.True);
 }else {
 //BA.debugLineNum = 1500;BA.debugLine="xlbl_ClearButton.Visible = m_ShowClearButton";
_xlbl_clearbutton.setVisible(_m_showclearbutton);
 //BA.debugLineNum = 1501;BA.debugLine="xlbl_RevealButton.Visible = m_PasswordField And";
_xlbl_revealbutton.setVisible(_m_passwordfield && _m_showrevealbutton);
 //BA.debugLineNum = 1502;BA.debugLine="xlbl_Hint.Visible = False";
_xlbl_hint.setVisible(__c.False);
 //BA.debugLineNum = 1503;BA.debugLine="MoveFloatingHint(False,True)";
_movefloatinghint(__c.False,__c.True);
 };
 //BA.debugLineNum = 1506;BA.debugLine="xlbl_Counter.Text = GetRealTextLength(Text) & \"/\"";
_xlbl_counter.setText(BA.ObjectToCharSequence(BA.NumberToString(_getrealtextlength(_text))+"/"+BA.NumberToString(_g_counter.CounterMax /*int*/ )));
 //BA.debugLineNum = 1507;BA.debugLine="TextChanged_Event(Text)";
_textchanged_event(_text);
 //BA.debugLineNum = 1508;BA.debugLine="m_InternOldText = Text";
_m_internoldtext = _text;
 //BA.debugLineNum = 1509;BA.debugLine="End Sub";
return "";
}
public String  _textchanged_event(String _text) throws Exception{
 //BA.debugLineNum = 1665;BA.debugLine="Private Sub TextChanged_Event(Text As String)";
 //BA.debugLineNum = 1666;BA.debugLine="If m_IgnoreTextChangeEvent = False And xui.SubExi";
if (_m_ignoretextchangeevent==__c.False && _xui.SubExists(ba,_mcallback,_meventname+"_TextChanged",(int) (1))) { 
 //BA.debugLineNum = 1667;BA.debugLine="CallSub2(mCallBack, mEventName & \"_TextChanged\",";
__c.CallSubNew2(ba,_mcallback,_meventname+"_TextChanged",(Object)(_text));
 };
 //BA.debugLineNum = 1678;BA.debugLine="DrawPasswordStrengthIndicator";
_drawpasswordstrengthindicator();
 //BA.debugLineNum = 1679;BA.debugLine="End Sub";
return "";
}
public String  _titleclick() throws Exception{
 //BA.debugLineNum = 1838;BA.debugLine="Private Sub TitleClick";
 //BA.debugLineNum = 1839;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_TitleC";
if (_xui.SubExists(ba,_mcallback,_meventname+"_TitleClick",(int) (0))) { 
 //BA.debugLineNum = 1840;BA.debugLine="CallSub(mCallBack, mEventName & \"_TitleClick\")";
__c.CallSubNew(ba,_mcallback,_meventname+"_TitleClick");
 };
 //BA.debugLineNum = 1842;BA.debugLine="End Sub";
return "";
}
public String  _titlewidthall(anywheresoftware.b4a.objects.B4XViewWrapper _parent,float _width) throws Exception{
int _i = 0;
 //BA.debugLineNum = 991;BA.debugLine="Public Sub TitleWidthAll(Parent As B4XView,Width A";
 //BA.debugLineNum = 992;BA.debugLine="For i = 0 To Parent.NumberOfViews -1";
{
final int step1 = 1;
final int limit1 = (int) (_parent.getNumberOfViews()-1);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 993;BA.debugLine="If Parent.GetView(i).Tag Is AS_TextFieldAdvanced";
if (_parent.GetView(_i).getTag() instanceof com.vehicle.tracker.as_textfieldadvanced) { 
 //BA.debugLineNum = 994;BA.debugLine="Parent.GetView(i).Tag.As(AS_TextFieldAdvanced).";
((com.vehicle.tracker.as_textfieldadvanced)(_parent.GetView(_i).getTag()))._settitlewidth /*float*/ (_width);
 //BA.debugLineNum = 995;BA.debugLine="Parent.GetView(i).Tag.As(AS_TextFieldAdvanced).";
((com.vehicle.tracker.as_textfieldadvanced)(_parent.GetView(_i).getTag()))._refresh /*String*/ ();
 };
 }
};
 //BA.debugLineNum = 998;BA.debugLine="End Sub";
return "";
}
public String  _trailingiconclick() throws Exception{
 //BA.debugLineNum = 1883;BA.debugLine="Private Sub TrailingIconClick";
 //BA.debugLineNum = 1884;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_Traili";
if (_xui.SubExists(ba,_mcallback,_meventname+"_TrailingIconClick",(int) (0))) { 
 //BA.debugLineNum = 1885;BA.debugLine="CallSub(mCallBack, mEventName & \"_TrailingIconCl";
__c.CallSubNew(ba,_mcallback,_meventname+"_TrailingIconClick");
 };
 //BA.debugLineNum = 1887;BA.debugLine="End Sub";
return "";
}
public String  _updatetextfieldshape() throws Exception{
 //BA.debugLineNum = 483;BA.debugLine="Private Sub UpdateTextFieldShape";
 //BA.debugLineNum = 484;BA.debugLine="xpnl_Underline.Visible = m_Underline";
_xpnl_underline.setVisible(_m_underline);
 //BA.debugLineNum = 485;BA.debugLine="If m_Underline Then";
if (_m_underline) { 
 //BA.debugLineNum = 486;BA.debugLine="xpnl_Underline.Color = IIf(m_HasFocus,g_TextFiel";
_xpnl_underline.setColor((int)(BA.ObjectToNumber(((_m_hasfocus) ? ((Object)(_g_textfieldproperties.FocusedShapeColor /*int*/ )) : ((Object)(_g_textfieldproperties.NonFocusedShapeColor /*int*/ ))))));
 //BA.debugLineNum = 487;BA.debugLine="xpnl_TextFieldBackground.SetColorAndBorder(m_Bac";
_xpnl_textfieldbackground.SetColorAndBorder(_m_backgroundcolor,(int) (0),(int) (0),(int) (_g_textfieldproperties.CornerRadius /*float*/ ));
 }else {
 //BA.debugLineNum = 489;BA.debugLine="xpnl_TextFieldBackground.SetColorAndBorder(m_Bac";
_xpnl_textfieldbackground.SetColorAndBorder(_m_backgroundcolor,(int) (_g_textfieldproperties.BorderWidth /*float*/ ),(int)(BA.ObjectToNumber(((_m_hasfocus) ? ((Object)(_g_textfieldproperties.FocusedShapeColor /*int*/ )) : ((Object)(_g_textfieldproperties.NonFocusedShapeColor /*int*/ ))))),(int) (_g_textfieldproperties.CornerRadius /*float*/ ));
 };
 //BA.debugLineNum = 492;BA.debugLine="If m_Mode = \"ComboBox\" Then";
if ((_m_mode).equals("ComboBox")) { 
 //BA.debugLineNum = 493;BA.debugLine="xlbl_ButtonText.Color = xpnl_TextFieldBackground";
_xlbl_buttontext.setColor(_xpnl_textfieldbackground.getColor());
 };
 //BA.debugLineNum = 496;BA.debugLine="End Sub";
return "";
}
public boolean  _validatepassword(String _pwd,int _minlength,int _numupper,int _numlower,int _numnumbers,int _numspecial) throws Exception{
 //BA.debugLineNum = 1802;BA.debugLine="Private Sub ValidatePassword(pwd As String,minLeng";
 //BA.debugLineNum = 1803;BA.debugLine="If pwd.Length < minLength Then Return False";
if (_pwd.length()<_minlength) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1804;BA.debugLine="If CountMatches(pwd,\"[A-Z]\") < numUpper Then Retu";
if (_countmatches(_pwd,"[A-Z]")<_numupper) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1805;BA.debugLine="If CountMatches(pwd,\"[a-z]\") < numLower Then Retu";
if (_countmatches(_pwd,"[a-z]")<_numlower) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1806;BA.debugLine="If CountMatches(pwd,\"[0-9]\") < numNumbers Then Re";
if (_countmatches(_pwd,"[0-9]")<_numnumbers) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1807;BA.debugLine="If CountMatches(pwd,\"[^a-zA-Z0-9]\") < numSpecial";
if (_countmatches(_pwd,"[^a-zA-Z0-9]")<_numspecial) { 
if (true) return __c.False;};
 //BA.debugLineNum = 1809;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 1810;BA.debugLine="End Sub";
return false;
}
public String  _xcb_combobox_selectedindexchanged(int _index) throws Exception{
 //BA.debugLineNum = 1576;BA.debugLine="Private Sub xcb_ComboBox_SelectedIndexChanged (Ind";
 //BA.debugLineNum = 1577;BA.debugLine="xlbl_ButtonText.Text = xcb_ComboBox.SelectedItem";
_xlbl_buttontext.setText(BA.ObjectToCharSequence(_xcb_combobox._getselecteditem /*String*/ ()));
 //BA.debugLineNum = 1578;BA.debugLine="ComboBoxSelectedIndexChanged(Index)";
_comboboxselectedindexchanged(_index);
 //BA.debugLineNum = 1579;BA.debugLine="End Sub";
return "";
}
public String  _xlbl_buttontext_click() throws Exception{
 //BA.debugLineNum = 1642;BA.debugLine="Private Sub xlbl_ButtonText_Click";
 //BA.debugLineNum = 1644;BA.debugLine="If m_ReadOnly = False Then ButtonClick";
if (_m_readonly==__c.False) { 
_buttonclick();};
 //BA.debugLineNum = 1645;BA.debugLine="End Sub";
return "";
}
public String  _xlbl_clearbutton_click() throws Exception{
 //BA.debugLineNum = 1571;BA.debugLine="Private Sub xlbl_ClearButton_Click";
 //BA.debugLineNum = 1573;BA.debugLine="ClearButton_Click";
_clearbutton_click();
 //BA.debugLineNum = 1574;BA.debugLine="End Sub";
return "";
}
public String  _xlbl_revealbutton_click() throws Exception{
 //BA.debugLineNum = 1635;BA.debugLine="Private Sub xlbl_RevealButton_Click";
 //BA.debugLineNum = 1637;BA.debugLine="RevealButton_Click";
_revealbutton_click();
 //BA.debugLineNum = 1638;BA.debugLine="End Sub";
return "";
}
public String  _xlbl_title_click() throws Exception{
 //BA.debugLineNum = 1650;BA.debugLine="Private Sub xlbl_Title_Click";
 //BA.debugLineNum = 1652;BA.debugLine="TitleClick";
_titleclick();
 //BA.debugLineNum = 1653;BA.debugLine="End Sub";
return "";
}
public String  _xpnl_leadingicon_click() throws Exception{
 //BA.debugLineNum = 1426;BA.debugLine="Private Sub xpnl_LeadingIcon_Click";
 //BA.debugLineNum = 1428;BA.debugLine="LeadingIconClick";
_leadingiconclick();
 //BA.debugLineNum = 1429;BA.debugLine="End Sub";
return "";
}
public String  _xpnl_trailingicon_click() throws Exception{
 //BA.debugLineNum = 1433;BA.debugLine="Private Sub xpnl_TrailingIcon_Click";
 //BA.debugLineNum = 1435;BA.debugLine="TrailingIconClick";
_trailingiconclick();
 //BA.debugLineNum = 1436;BA.debugLine="End Sub";
return "";
}
public String  _xtf_textfield_enterpressed() throws Exception{
 //BA.debugLineNum = 1514;BA.debugLine="Private Sub xtf_TextField_EnterPressed";
 //BA.debugLineNum = 1516;BA.debugLine="EnterPressed";
_enterpressed();
 //BA.debugLineNum = 1521;BA.debugLine="End Sub";
return "";
}
public String  _xtf_textfield_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 1538;BA.debugLine="Private Sub xtf_TextField_FocusChanged (HasFocus A";
 //BA.debugLineNum = 1539;BA.debugLine="If HasFocus Then";
if (_hasfocus) { 
 //BA.debugLineNum = 1540;BA.debugLine="xlbl_Hint.TextColor = g_Hint.FocusedTextColor";
_xlbl_hint.setTextColor(_g_hint.FocusedTextColor /*int*/ );
 //BA.debugLineNum = 1541;BA.debugLine="xlbl_Title.TextColor = g_Title.FocusedTextColor";
_xlbl_title.setTextColor(_g_title.FocusedTextColor /*int*/ );
 }else {
 //BA.debugLineNum = 1543;BA.debugLine="xlbl_Hint.TextColor = g_Hint.NonFocusedTextColor";
_xlbl_hint.setTextColor(_g_hint.NonFocusedTextColor /*int*/ );
 //BA.debugLineNum = 1544;BA.debugLine="xlbl_Title.TextColor = g_Title.NonFocusedTextCol";
_xlbl_title.setTextColor(_g_title.NonFocusedTextColor /*int*/ );
 };
 //BA.debugLineNum = 1546;BA.debugLine="FocusChanged(HasFocus)";
_focuschanged(_hasfocus);
 //BA.debugLineNum = 1547;BA.debugLine="End Sub";
return "";
}
public String  _xtf_textfield_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 1446;BA.debugLine="Private Sub xtf_TextField_TextChanged (Old As Stri";
 //BA.debugLineNum = 1447;BA.debugLine="m_OldText = Old";
_m_oldtext = _old;
 //BA.debugLineNum = 1448;BA.debugLine="TextChanged(New)";
_textchanged(_new);
 //BA.debugLineNum = 1449;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "BASE_RESIZE"))
	return _base_resize(((Number)args[0]).doubleValue(), ((Number)args[1]).doubleValue());
return BA.SubDelegator.SubNotFound;
}
}
