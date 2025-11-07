B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=9.85
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	Public Mqtt As MqttClient
'	Private Server As String = "tcp://broker.hivemq.com:1883"
	Private Server As String = "tcp://broker.emqx.io:1883"
	Private TimerConnect As Timer
End Sub

Sub Service_Create
	TimerConnect.Initialize("TimerConnect", 1500)
	Mqtt.Initialize("MC", Server, DateTime.Now.As(String) & Rnd(1000, 9999))
	TimerConnect_Tick
End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground 'Starter service can start in the foreground state in some edge cases.
End Sub

Sub Service_TaskRemoved
	'This event will be raised when the user removes the app from the recent apps list.
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub

Private Sub MC_Connected (Success As Boolean)
	If Success = False Then
		Log(LastException)
		TimerConnect.Enabled = True
	Else
		Log("MQTT Connected")
		Mqtt.Subscribe("tracker-A1b2C3d4E5f6G7h8I9j0KlMnOpQrStUvWxYzABCD", Mqtt.QOS_2_EXACTLY_ONCE)
	End If
End Sub

Private Sub MC_Disconnected
	Log("MQTT Disconnected")
	TimerConnect.Enabled = True
End Sub

Private Sub MC_MessageArrived (SenderTopic As String, Payload() As Byte)
	Dim str As String = BytesToString(Payload, 0, Payload.Length, "UTF-8")
	Log(str)
	
	If B4XPages.GetManager.GetTopPage.Id <> "map" Then
		Return
	End If
	
	If str.StartsWith("$") And str.EndsWith("#") Then
	Else
		Return
	End If
	
	str = str.SubString2(1, str.Length -1)
	
	Dim pieces() As String = Regex.Split(",", str)
	
	If pieces.Length <> 4 Then
		Return
	End If
	
	Dim lat As Double = pieces(1)
	Dim lng As Double = pieces(2)
	
	Dim m As Map = CreateMap()
	m.Put("lat", lat)
	m.Put("lng", lng)
	
	B4XPages.GetManager.RaiseEvent(B4XPages.GetManager.GetTopPage, "UpdateLocation", Array(m))
End Sub

Private Sub TimerConnect_Tick
	TimerConnect.Enabled = False
	If Mqtt.Connected = False Then
		Mqtt.Connect
	End If
End Sub