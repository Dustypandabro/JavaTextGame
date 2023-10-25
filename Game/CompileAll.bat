@echo off
setlocal enabledelayedexpansion

set "source_directory=C:\Users\User\Desktop\Game"

for %%f in (Barbarian BaseCharacter Book Deathwalker Hunter Location Main Quests Reputation RunGameBoi Viking Wizard Items) do (
	javac -d  "%source_directory%" "%source_directory%\%%f.java"
	if !errorlevel! neq 0 (
		echo Compilation failed for %%f
		exit /b 1	
	)
	echo Compilation %%f succesful.
)

echo Compilation succesful.
exit /b 0