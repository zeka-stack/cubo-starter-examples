#!/bin/bash

# 用于生成跨平台的创建测试模块的工具
# 支持在任意目录执行, 最后在 ../build.sh 生成 create

echo "🚀 开始编译 Cubo 测试模块生成工具..."

# 获取脚本目录
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$SCRIPT_DIR/.."

# 检查 Go 是否安装
if ! command -v go &> /dev/null; then
    echo "❌ 错误: 未找到 Go 编译器，请先安装 Go"
    exit 1
fi

echo "📦 编译测试模块生成工具..."
cd "$SCRIPT_DIR"
go build -o create create.go
if [ $? -eq 0 ]; then
    echo "✅ 测试模块生成工具编译成功: create"
    mv -f create "$ROOT_DIR/create"
else
    echo "❌ 测试模块生成工具编译失败"
    exit 1
fi


echo ""
echo "🎉 编译完成！"
echo "📋 可用的工具:"
echo "   🏷️  create      - 测试模块生成工具"
echo ""
echo "💡 使用方法:"
echo "   ./create        # 启动交互式选择界面"
echo ""
