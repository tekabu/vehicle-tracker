B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
#Region Shared Files
#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
'Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
#End Region

'Ctrl + click to export as zip: ide://run?File=%B4X%\Zipper.jar&Args=%PROJECT_NAME%.zip

Sub Class_Globals
	Private Map_ As MapPage
	Private Login_ As LoginPage
	Private SignUp_ As SignUpPage
	Private ForgotPassword_ As ForgotPasswordPage
	Private Verification_ As VerificationPage
	Private NewPassword_ As NewPasswordPage
	Private Menu_ As MenuPage
End Sub

Public Sub Initialize
	B4XPages.GetManager.LogEvents = True
	B4XPages.GetManager.TransitionAnimationDuration = 0
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Login_.Initialize
	SignUp_.Initialize
	ForgotPassword_.Initialize
	Verification_.Initialize
	NewPassword_.Initialize
	Menu_.Initialize
	Map_.Initialize
	
	B4XPages.AddPage("login", Login_)
	B4XPages.AddPage("sign_up", SignUp_)
	B4XPages.AddPage("forgot_password", ForgotPassword_)
	B4XPages.AddPage("verification", Verification_)
	B4XPages.AddPage("new_password", NewPassword_)
	B4XPages.AddPage("menu", Menu_)
	B4XPages.AddPage("map", Map_)
End Sub

Private Sub B4XPage_Appear
	B4XPages.ShowPageAndRemovePreviousPages("login")
End Sub