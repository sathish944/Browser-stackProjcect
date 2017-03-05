$title = "Microsoft Outlook 2010 Startup"

$title1 = "Warranty Questions - Message (HTML)"

$title2 = "Wholesale Accounts Information Request - Message (HTML)"

$title3 = "Fleet/National Account Information Request - Message (HTML)"

$title4 = "Technical Website Issue - Message (HTML)"

$title5 = "About my store experience - Message (HTML)"

$title6 = "About my store experience - Message (HTML)"

$title7 = "Web Request - Message (HTML)"

If WinActivate($title) Then

   WinClose($title)
   ; ControlClick("Microsoft Outlook 2010 Startup","","Button4")
   Sleep(900)
   ControlClick("Microsoft Outlook 2010 Startup","","Button1")

ElseIf WinActivate($title1) Then
   WinClose($title1)
   Sleep(900)
   ControlClick("Microsoft Outlook","","Button2")

ElseIf WinActivate($title2) Then
   WinClose($title2)
   Sleep(900)
   ControlClick("Microsoft Outlook","","Button2")

ElseIf WinActivate($title3) Then
	  WinClose($title3)
	  Sleep(900)
	  ControlClick("Microsoft Outlook","","Button2")

ElseIf WinActivate($title4) Then
	  WinClose($title4)
	  Sleep(900)
	  ControlClick("Microsoft Outlook","","Button2")

ElseIf WinActivate($title5) Then
	  WinClose($title5)
	  Sleep(900)
	  ControlClick("Microsoft Outlook","","Button2")

ElseIf WinActivate($title6) Then
	  WinClose($title6)
	  Sleep(900)
	  ControlClick("Microsoft Outlook","","Button2")

ElseIf WinActivate($title7) Then
	  WinClose($title7)
	  Sleep(900)
	  ControlClick("Microsoft Outlook","","Button2")
	  EndIf