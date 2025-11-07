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
	Private LB_ForgotPassword As Label
	Private LB_Signup As Label
	Private BT_Login As Button
End Sub

'You can add more parameters here.
Public Sub Initialize As Object
	Return Me
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("login")
	B4XPages.SetTitle(Me, Config.APP_TITLE)
	
	Dim CS_ForgotPassword As CSBuilder
	CS_ForgotPassword.Initialize
	CS_ForgotPassword.Typeface(Typeface.LoadFromAssets("Roboto-Regular.ttf"))
	CS_ForgotPassword.Size(20)
	CS_ForgotPassword.Append(" ")
	CS_ForgotPassword.Pop
	CS_ForgotPassword.Clickable("ForgotPassword", 1)
	CS_ForgotPassword.Size(20)
	CS_ForgotPassword.Alignment("ALIGN_OPPOSITE")
	CS_ForgotPassword.Color(Config.COLOR_MATERIAL_GRAY)
	CS_ForgotPassword.Append("Forgot Password")
	CS_ForgotPassword.EnableClickEvents(LB_ForgotPassword)
	CS_ForgotPassword.PopAll
	
	LB_ForgotPassword.Text = CS_ForgotPassword
	
	Dim CS_Signup As CSBuilder
	CS_Signup.Initialize
	CS_Signup.Typeface(Typeface.LoadFromAssets("Roboto-Regular.ttf"))
	CS_Signup.Size(20)
	CS_Signup.Color(Config.COLOR_MATERIAL_GRAY)
	CS_Signup.Append("Dont have an account? ")
	CS_Signup.Pop
	CS_Signup.Color(Config.COLOR_ACCENT)
	CS_Signup.Clickable("Signup", 1)
	CS_Signup.Append("Sign Up")
	CS_Signup.EnableClickEvents(LB_Signup)
	CS_Signup.PopAll
	
	LB_Signup.Text = CS_Signup
End Sub

Private Sub BT_Login_Click
	ClearFields
	B4XPages.ShowPageAndRemovePreviousPages("menu")
End Sub

Private Sub ForgotPassword_Click (Tag As Object)
	ClearFields
	B4XPages.ShowPageAndRemovePreviousPages("forgot_password")
End Sub

Private Sub SignUp_Click (Tag As Object)
	ClearFields
	B4XPages.ShowPageAndRemovePreviousPages("sign_up")
End Sub

Private Sub ClearFields
	ET_Email.Text = ""
	ET_Password.Text = ""
End Sub