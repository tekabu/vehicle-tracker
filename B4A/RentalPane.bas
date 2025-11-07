B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.4
@EndOfDesignText@
Sub Class_Globals
	Private XUI As XUI
	Private mParent As Panel
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize (Pager As ASViewPager)
	mParent = XUI.CreatePanel("")
	mParent.SetLayout(0, 0, Pager.Base.Width, Pager.Base.Height)
	
	Pager.AddPage(mParent, "")
	
	mParent.LoadLayout("rentals")
End Sub