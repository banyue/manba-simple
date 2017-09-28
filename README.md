环境要求：
jdk 1.8
maven 3.0.5

数据库文件
mb_db_dat.sql  目前只用到3个表：man_simple_user、man_simple_zone、man_simple_guild

环境部署之后，可直接启动ManBaApplicationLauncher  类来启动服务
http://localhost:8080/   输入此地址验证服务是否可用
http://localhost:8080/user/1  输入此地址验证数据库是否可用（注意：数据库中必须有数据）