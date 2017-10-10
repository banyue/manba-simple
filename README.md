环境要求：
jdk 1.8
maven 3.0.5

数据库文件
mb_db_dat.sql  目前只用到3个表：man_simple_user、man_simple_zone、man_simple_guild

环境部署之后，可直接启动ManBaApplicationLauncher  类来启动服务
http://localhost:8080/   输入此地址验证服务是否可用
http://localhost:8080/user/1  输入此地址验证数据库是否可用（注意：数据库中必须有数据）
http://localhost:8080/swagger-ui.html   在接口上添加相关API，可通过此页面验证接口的正确性（swagger)

启动ManBaUploadApplicationLauncher类  可启动文件上传服务，然后使用工具ImgUploadUtil   或者直接调uploadFile

打包：可直接用idea中自带的命令打包，如果部署在linux服务器上，可使用mvn package

运行：输入命令  java -jar manba-simple-web.jar  启动对外接口服务
                java -jar manba-simple-inner-web.jar  启动后台服务
                java -jar manba-simple-upload.jar  启动文件上传服务