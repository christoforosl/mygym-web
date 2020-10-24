

export PROJECT_NAME=mygym-web
export PROJECT_GITHUB_URL=https://github.com/christoforosl/mygym-web.git
cd $HOME/GitProjects

rm -rf $PROJECT_NAME.testrun

git clone $PROJECT_GITHUB_URL $PROJECT_NAME.testrun
cd $PROJECT_NAME.testrun

mvn -B -DskipTests clean dependency:list install -s/Users/christoforosl/.m2/settings.plain.xml -Dmaven.repo.local=$HOME/.m2.$PROJECT_NAME.testrun

rm -rf $HOME/.m2.$PROJECT_NAME.testrun



