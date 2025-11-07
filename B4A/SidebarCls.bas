B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.4
@EndOfDesignText@
Sub Class_Globals
	Private mParent As B4XView
	Private mPage As MenuPage
	Private CLV As CustomListView
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize (Parent As B4XView, Page As MenuPage)
	mParent = Parent
	mPage = Page
	mParent.LoadLayout("sidebar")
	
	CLV.AddTextItem(CreateItem("Dashboard"), "Dashboard")
	CLV.AddTextItem(CreateItem("Vehicles"), "Vehicles")
	CLV.AddTextItem(CreateItem("Customers"), "Customers")
	CLV.AddTextItem(CreateItem("Rentals"), "Rentals")
	CLV.AddTextItem(CreateItem("Reports"), "Reports")
	CLV.AddTextItem(CreateItem("Account"), "Accounts")
	CLV.AddTextItem(CreateItem("Logout"), "Logout")
End Sub

Private Sub CLV_ItemClick (Index As Int, Value As Object)
	mPage.Sidebar_Selected(Index, Value)
End Sub

Private Sub CreateItem (Name As String) As CSBuilder
	Dim cs As CSBuilder
	cs.Initialize
	cs.Size(18)
	cs.Color(Config.COLOR_MATERIAL_GRAY)
	cs.Typeface(Typeface.LoadFromAssets("Roboto-Regular.ttf"))
	cs.Append("     ")
	cs.Append(Name)
	cs.PopAll
	Return cs
End Sub