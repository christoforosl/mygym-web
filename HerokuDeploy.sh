#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
export DIR
echo DIR: $DIR

export APPNAME=iic-services
echo Heroku appname is: $APPNAME

export COMMIT_MESSAGE=$1
if [ "$COMMIT_MESSAGE" = "" ]; then
	export COMMIT_MESSAGE='heroku deploy' 
fi

if [ ! -d  $HOME/herocu/$APPNAME ]; then
	echo will clone to $HOME/herocu/$APPNAME 
	git clone https://git.heroku.com/$APPNAME.git $HOME/herocu/$APPNAME
fi

echo get latest version of code in $DIR
cd $DIR
git pull -X theirs

rm -rf $HOME/herocu/$APPNAME/iic-model/  $HOME/herocu/$APPNAME/iic-parentPom/  $HOME/herocu/$APPNAME/iic-services/

# before copy from $DIR, change to heroku dir and pull resolving with theirs
cd $HOME/herocu/$APPNAME
git reset --hard 
echo git pull on $HOME/herocu/$APPNAME 
git pull -X theirs
echo "I am at heroku dir:" 
pwd
echo "---------------------------------"

copyDir() {
	echo remove and re-copy dir $DIR/$appdir/target recursively
	if [ -d  $HOME/herocu/$APPNAME/$appdir ]; then
		rm -rf $HOME/herocu/$APPNAME/$appdir
	fi
	cp -rf $DIR/$appdir $HOME/herocu/$APPNAME/
	if [ -d  $HOME/herocu/$APPNAME/$appdir/target ]; then
		rm -rf $HOME/herocu/$APPNAME/$appdir/target
	fi
} 

cd $DIR
pwd

export appdir=repo
copyDir
export appdir=iic-services
copyDir
export appdir=iic-model
copyDir

echo "change to directory $HOME/herocu/$APPNAME/"
cd $HOME/herocu/$APPNAME/

echo "now copy everything from iic-admin-web/src. This makes iic-admin-web part of the project"
if [ -d  $HOME/herocu/$APPNAME/iic-services/src/main/webapp/iic-admin-web ]; then
	rm -rf $HOME/herocu/$APPNAME/iic-services/src/main/webapp/iic-admin-web
fi
mkdir $HOME/herocu/$APPNAME/iic-services/src/main/webapp/iic-admin-web
cp -rf $DIR/iic-admin-web/src/* $HOME/herocu/$APPNAME/iic-services/src/main/webapp/iic-admin-web

#
# echo "//file produced by herokyDeploy.sh\nvar GLOBALS={};GLOBALS.apiServicesRoot=\"https://$APPNAME.herokuapp.com\";" > $HOME/herocu/$APPNAME/iic-services/src/main/webapp/iic-admin-web/globals.js
#

cp -rf $DIR/Procfile $HOME/herocu/$APPNAME
cp -rf $DIR/system.properties $HOME/herocu/$APPNAME
cp -rf $DIR/pom.xml $HOME/herocu/$APPNAME

#rm -rf $HOME/herocu/$APPNAME/repo
#cp -rf $DIR/repo/ $HOME/herocu/$APPNAME/repo/

rm -rf $HOME/herocu/$APPNAME/iic-services/target
rm -rf $HOME/herocu/$APPNAME/iic-model/target
find $HOME/herocu/$APPNAME/ -name '*.tmp' -delete
find $HOME/herocu/$APPNAME/ -name '.DS_Store' -delete

cd $HOME/herocu/$APPNAME
git add .;git commit -m "$COMMIT_MESSAGE";git push

cd $DIR

echo deployment completed, open http://$APPNAME.herokuapp.com/

exit
