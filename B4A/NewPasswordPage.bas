B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.4
@EndOfDesignText@
Sub Class_Globals
	Private Root As B4XView 'ignore
	Private XUI  As XUI 'ignore
	Private LB_Login As Label
	Private ET_NewPassword As EditText
	Private ET_ConfirmNewPassword As EditText
	Private BT_NewPassword As Button
End Sub

'You can add more parameters here.
Public Sub Initialize As Object
	Return Me
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("new_password")
	B4XPages.SetTitle(Me, Config.APP_TITLE)
	
	Dim CS_Login As CSBuilder
	CS_Login.Initialize
	CS_Login.Typeface(Typeface.LoadFromAssets("Roboto-Regular.ttf"))
	CS_Login.Size(20)
	CS_Login.Color(Config.COLOR_ACCENT)
	CS_Login.Clickable("Login", 1)
	CS_Login.Append("Login")
	CS_Login.EnableClickEvents(LB_Login)
	CS_Login.PopAll
	
	LB_Login.Text = CS_Login
End Sub

Private Sub B4XPage_CloseRequest As ResumableSub
	Login_Click(1)
	Return True
End Sub

Private Sub Login_Click (Tag As Object)
	ClearFields
	B4XPages.ShowPageAndRemovePreviousPages("login")
End Sub

Private Sub ClearFields
	ET_NewPassword.Text = ""
	ET_ConfirmNewPassword.Text = ""
End Sub

Private Sub BT_NewPassword_Click
	Log("new passwordl")
	Login_Click(1)
End Sub