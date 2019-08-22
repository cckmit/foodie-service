#!/bin/bash

Jar_Path=$1

usage()
{
    echo "Usage: $0 <Jar_Path> {start|stop|restart}  "
    exit 1
}

start()
{
    java -jar $Jar_Path >$Jar_Path.log &
}

stop()
{
    echo "stop $Jar_Path ........"
    ps -ef | grep java | grep -w $Jar_Path
    num=`ps -ef | grep java | grep -w $Jar_Path | wc -l`
    echo $num
    if [ $num -ne 0 ];then
        pid=`ps -ef | grep java | grep -w $Jar_Path | awk '{print $2}'`
        kill -9 $pid
        echo "$Jar_Path stoped"
    else
        echo "$Jar_Path not run"
    fi
}
case "$2" in
    start)
        start
        ;;
    stop)
        stop
        ;;
    restart)
        stop
        start
        ;;
    *)
        usage
esac