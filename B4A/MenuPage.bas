B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.4
@EndOfDesignText@
Sub Class_Globals
	Private Root As B4XView 'ignore
	Private XUI As XUI 'ignore
	Private Drawer As B4XDrawer
	Private Sidebar As SidebarCls
	Private Pager As ASViewPager
	Private Dashboard As DashboardPane
	Private Vehicle As VehiclePane
	Private Customer As CustomerPane
	Private Rental As RentalPane
	Private Report As ReportPane
	Private Account As AccountPane
End Sub

'You can add more parameters here.
Public Sub Initialize As Object
	Return Me
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	
	Drawer.Initialize(Me, "Drawer", Root, 200dip)
	Drawer.CenterPanel.LoadLayout("menu")
	
	Sidebar.Initialize(Drawer.LeftPanel, Me)
	
	Dashboard.Initialize(Pager)
	Vehicle.Initialize(Pager)
	Customer.Initialize(Pager)
	Rental.Initialize(Pager)
	Report.Initialize(Pager)
	Account.Initialize(Pager)
	
	B4XPages.SetTitle(Me, Config.APP_TITLE)
End Sub

Private Sub B4XPage_Appear
	InitMenu
End Sub

Private Sub B4XPage_Disappear
	RemoveMenu
End Sub

Private Sub B4XPage_CloseRequest As ResumableSub
	If Main.ActionBarHomeClicked Then
		Drawer.LeftOpen = Not(Drawer.LeftOpen)
		Return False
	End If
	If Drawer.LeftOpen Then
		Drawer.LeftOpen = False
		Return False
	End If
	Return True
End Sub

Private Sub InitMenu
	B4XPages.GetManager.ActionBar.RunMethod("setDisplayHomeAsUpEnabled", Array(True))
	Dim bd As BitmapDrawable
	Dim icon As B4XBitmap = XUI.LoadBitmapResize(File.DirAssets, "menu36.png", 32dip, 32dip, True)
	bd.Initialize(icon)
	B4XPages.GetManager.ActionBar.RunMethod("setHomeAsUpIndicator", Array(bd))
End Sub

Private Sub RemoveMenu
	B4XPages.GetManager.ActionBar.RunMethod("setHomeAsUpIndicator", Array(0))
End Sub

Public Sub Sidebar_Selected(Index As Int, Tag As String)
	Drawer.LeftOpen = False
	
	If SubExists(Me, Tag) Then
		CallSub(Me, Tag)
		Return
	End If

	Pager.CurrentIndex2 = Index
End Sub

Private Sub Logout 'ignore
	Dim cs_title As CSBuilder
	cs_title.Initialize
	cs_title.Size(20)
	cs_title.Bold
	cs_title.Typeface(Typeface.LoadFromAssets("Roboto-Regular.ttf"))
	cs_title.Color(Config.COLOR_MATERIAL_BLACK)
	cs_title.Append(Config.APP_TITLE)
	cs_title.PopAll
	
	Dim cs_msg As CSBuilder
	cs_msg.Initialize
	cs_msg.Size(18)
	cs_msg.Typeface(Typeface.LoadFromAssets("Roboto-Regular.ttf"))
	cs_msg.Color(Config.COLOR_MATERIAL_BLACK)
	cs_msg.Append("Are you sure you want to log out?")
	cs_msg.PopAll
	
	Msgbox2Async(cs_msg, cs_title, "Yes", "Cancel", "", Null, True)
	Wait For Msgbox_Result (Result As Int)
	If Result = DialogResponse.POSITIVE Then
		B4XPages.ShowPageAndRemovePreviousPages("login")
	End If
End Sub

Private Sub Pager_PageChanged(Index As Int)
	
End Sub