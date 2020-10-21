#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
echo "will change to dir $DIR"

cd $DIR


if [ "$1" = "" ]; then
	echo "Must supply message for commit ! "
	exit 1
fi

git pull
git add .
git commit -m "$1"
git push

if [ "$2" = "" ]; then
  echo "Do you wish to run heroku deploy?"
  select yn in "Yes" "No"; do
    case $yn in
        Yes ) ./web/herokuDeploy.sh "$1"; break;;
        No  ) exit;;
    esac
  done
else
    if [ "$2" = "1" ]; then
       ./web/herokuDeploy.sh "$1";
    fi
fi
