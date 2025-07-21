#!/bin/bash

# ------------------- 配置项 -------------------
REMOTE="root@ubuntu@orb"
REMOTE_DIR="~"
PACKAGE="target/cubo-rest-spring-boot-sample-servlet.tar.gz"
DEPLOY_DIR="cubo-rest-spring-boot-sample-servlet"
# ---------------------------------------------

# 0. 获取操作参数，默认为 start
ACTION=${1:-start}

if [[ ! "$ACTION" =~ ^(start|restart|stop|destroy)$ ]]; then
  echo "用法: $0 [start|restart|stop|destroy]"
  exit 1
fi

PACKAGE_BASENAME=$(basename "$PACKAGE")

# 定义远程执行命令
case "$ACTION" in
  start)
    START_CMD="cd $DEPLOY_DIR && bin/server.sh -s prod -t -i"
    ;;
  restart)
    START_CMD="cd $DEPLOY_DIR && bin/server.sh -r prod -t -i"
    ;;
  stop)
    START_CMD="cd $DEPLOY_DIR && bin/server.sh -S prod"
    ;;
  destroy)
    START_CMD="cd $DEPLOY_DIR && bin/server.sh -S prod && cd $REMOTE_DIR && rm -rf $DEPLOY_DIR $PACKAGE_BASENAME"
    ;;
esac

# start 时才执行构建、上传、解压
if [[ "$ACTION" == "start" ]]; then
  echo "🛠️ 正在执行 Maven 构建..."
  mvn clean package -Dcheckstyle.skip=true -Dpmd.skip=true -Dmaven.test.skip=true -e

  if [ $? -ne 0 ]; then
      echo "❌ 构建失败，终止部署。"
      exit 1
  fi

  echo "🚀 正在上传压缩包到远程服务器：$REMOTE:$REMOTE_DIR"
  orb pus "$PACKAGE"
  scp "$PACKAGE" "${REMOTE}:${REMOTE_DIR}/"

  if [ $? -ne 0 ]; then
      echo "❌ 上传失败，终止部署。"
      exit 1
  fi

  echo "📦 正在远程解压..."
  ssh "$REMOTE" "cd $REMOTE_DIR && tar -zxvf $PACKAGE_BASENAME"
fi

# 执行远程命令
echo "🚀 正在远程执行 $ACTION 操作..."
ssh "$REMOTE" "cd $REMOTE_DIR && $START_CMD"

echo "✅ $ACTION 操作完成！"
