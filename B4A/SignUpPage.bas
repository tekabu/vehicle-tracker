B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.4
@EndOfDesignText@
Sub Class_Globals
	Private Root As B4XView 'ignore
	Private XUI  As XUI 'ignore
	Private ET_Email As EditText
	Private ET_Password As EditText
	Private ET_Name As EditText
	Private ET_PasswordConfirm As EditText
	Private BT_SignUp As Button
	Private LB_Login As Label
End Sub

'You can add more parameters here.
Public Sub Initialize As Object
	Return Me
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("sign_up")
	B4XPages.SetTitle(Me, Config.APP_TITLE)
	
	Dim CS_Login As CSBuilder
	CS_Login.Initialize
	CS_Login.Typeface(Typeface.LoadFromAssets("Roboto-Regular.ttf"))
	CS_Login.Size(20)
	CS_Login.Color(Config.COLOR_MATERIAL_GRAY)
	CS_Login.Append("Already have an account? ")
	CS_Login.Pop
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

Private Sub BT_SignUp_Click
	Log("sign up")
End Sub

Private Sub Login_Click (Tag As Object)
	ClearFields
	B4XPages.ShowPageAndRemovePreviousPages("login")
End Sub

Private Sub ClearFields
	ET_Name.Text = ""
	ET_Email.Text = ""
	ET_Password.Text = ""
	ET_PasswordConfirm.Text = ""
End Sub