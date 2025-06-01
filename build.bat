@echo off
setlocal enabledelayedexpansion
set files=
for /r %%f in (*.java) do (
    set files=!files! "%%f"
)
javac -cp ".;lib/*" -d . !files!
echo Build selesai.