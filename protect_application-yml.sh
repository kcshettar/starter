#!/bin/bash

FILE="application.yml"
FILE_ZIP="application-yml.zip"

cd src/main/resources
echo ">>>>> navigated to 'resources'"

if [ -e $FILE ]
then
    echo ">>>>> file found"
    7z a $FILE_ZIP $FILE -p
    echo ">>>>> file ($FILE) protected"
    mv $FILE_ZIP ../../../
    echo ">>>>> file ($FILE_ZIP) moved to root"
    rm $FILE
    echo ">>>> file ($FILE) removed"
else
    echo ">>>>> file ($FILE) not found; continue"
fi