Dim objOutl

Set objOutl = CreateObject("Outlook.Application")
Set objMailItem = objOutl.CreateItem(olMailItem)
objMailItem.Display

strEmailAddress = WScript.Arguments(0)
astrEmailAddress = Split(strEmailAddress, "$")

For i = 0 to UBound(astrEmailAddress)
	objMailItem.Recipients.Add astrEmailAddress(i)
Next


objMailItem.Subject = "Automation Test Results"

set fso = CreateObject("Scripting.FileSystemObject")
set f = fso.GetFolder(Wscript.Arguments(1))
Set ResultFiles = f.files
For Each rFiles in ResultFiles

objMailItem.Attachments.add rFile.Path
if ucase(rFiles.Name) = "SUMMARYREPORT.HTML" then
Set oTextStream = rFile.OpenAsTextStream(1,-2)
strText = oTextStream.ReadAll
oTextStream.Close
End If
Next

objMailItem.HTMLBody = strText & "</table><br><br><FONT COLOR=" & chr(34) & "#000066" & chr(34) & " FACE=" & chr(34) & "Arial" & chr(34) & "SIZE=2.75><b>Thanks<br> LTI Automation Team</b><br></br></br>"
objMailItem.send

set objMailItem = nothing
set objOutl = nothing

