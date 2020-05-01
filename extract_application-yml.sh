#!/bin/bash

FILE="application.yml"
FILE_ZIP="application-yml.zip"

if [ -e $FILE_ZIP ]
then
    echo ">>>>> file found"
    7z x $FILE_ZIP
    echo ">>>>> file extracted"
    mv $FILE src/main/resources/
    echo ">>>>> file ($FILE) moved to 'resources'"
else
    echo ">>>>> file not found; continue"
fi