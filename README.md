# hadoopHelloWord
Hadoop计数文本单词数
最小安装版初始设置

===1.配置linux网络
设置vm nat网络模式
查看网卡命令 ip addr
修改ifcfg-ens33文件（thmod 777 文件名 修改文件权限）
ping 通网络
===2.安装缺失的工具
yum install -y net-tools

===3.配置java环境变量
安装jdk到usr/java目录
tar -zxvf 解压
配置etc/profile
export JAVA_HOME=/usr/java/jdk8
export PATH=$PATH$:JAVA_HOME/bin
source /etc/profile

===4.安装hadoop
mkdir usr/local/source
mkdir usr/local/hadoop
tar -zxvf .....

===设置环境变量(不能设置两个PATH)
export HADOOP_HOME=/usr/local/hadoop/hadoop-2.7.3
eport PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HADOOP_HOME/sbin

source /etc/profile
hadoop version

---设置hadoop-env.sh

---设置core-site.xml 
---默认HDFS存储，运行在本机
---设置储存位置

---设置hdfs-site.xml 设置副本数量

---设置mapred-site.xml.template 改名字为mappred-site.xml


===关闭防火墙
关闭：systemctl stop firewalld.service
	禁止开机自启：systemctl disable firewalld.service
查看：systemctl status firewalld

===初始化nameNode
 	hadoop namenode -format
  
错误：
原因：

错误：
原因：未设置etc/hosts

错误：
原因：未设置yarn-site.xml


===运行mapreduce案例
hadoop jar   /hadoop-2.7.3/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.3.jar wordcount /Test /output





