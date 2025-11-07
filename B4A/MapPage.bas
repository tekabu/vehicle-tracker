B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.4
@EndOfDesignText@
Sub Class_Globals
	Private Root As B4XView 'ignore
	Private XUI As XUI 'ignore
	Private Fragment As MapFragment
	Private Gmap As GoogleMap
	Private	GExtra As GoogleMapsExtras
End Sub

'You can add more parameters here.
Public Sub Initialize As Object
	Return Me
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("map")
	B4XPages.SetTitle(Me, Config.APP_TITLE)
End Sub

Private Sub Fragment_Ready
	Gmap = Fragment.GetMap
	Gmap.Clear
End Sub

Private Sub UpdateLocation(Args As Object) 'ignore
	Dim Data As Map = Args
	
	If Data.ContainsKey("lat") And Data.ContainsKey("lng") Then
	Else
		Return
	End If
	
	Dim c As CameraPosition
	c.Initialize(Data.Get("lat"), Data.Get("lng"), 17)
	
	Gmap.Clear
	Gmap.AddMarker(Data.Get("lat"), Data.Get("lng"), "Tracker")
	
	Dim circle As CircleOptions
	circle.Initialize
	circle.Radius(100)
	circle.Center2(Data.Get("lat"), Data.Get("lng"))
	circle.FillColor(0x320048FF)
	circle.StrokeWidth(1dip)
	circle.StrokeColor(0xFF0048FF)
		
	GExtra.AddCircle(Gmap, circle)
	
	Gmap.AnimateCamera(c)
End Sub