# 一.概念  
JNI: Java Native Interface，是Java和Native代码互通的接口  
NDK: Native Develop Kit，是一组允许你将C或C++(原生代码)嵌入到Android应用中的工具  
NDK使用场景：  
1.平台之间移植应用
2.重用现有库
3.在某些情况下提高性能，特别是计算密集型应用  
联想：在使用高德SDK时发现，高德SDK包含一些.jar文件和一些.so文件，所以在进行NDK相关开发时，最终目的是生成.so文件并打包进apk  
FFmpeg: A complete, cross-platform solution to record, convert and stream audio and video.

# 二.场景  
假设我们要开发一个基于FFmpeg的视频播放库SDK,简单起见，本Demo只是简单的调用FFmpeg库中的const char *avcodec_license(void)  
和const char *avcodec_configuration(void)方法，所以该"SDK"不包含.jar文件，只需生成.so文件。  

# 三.实现
1.生成FFmpeg库：  
下载FFmpeg代码[FFmpeg](https://ffmpeg.org/);生成FFmpeg库  
![FFmpeg](https://github.com/SDonGit/JniPractice/blob/master/FFmpeg%E5%BA%93.png)  
2.声明native函数：  
//在hello-jni中实现(调用avcodec-57中的const char *avcodec_license(void))  
public native String  avcodecLicense();  
//在hello-jni中实现(调用avcodec-57中的const char *avcodec_configuration(void))  
public native String  avcodecConfiguration();  
3.实现native函数：  
[hello-jni.c](https://github.com/SDonGit/JniPractice/blob/master/jni/hello-jni.c)  
4.编写Android.mk文件  
[Android.mk](https://github.com/SDonGit/JniPractice/blob/master/jni/Android.mk)  
5.ndk-build生成libhello-jni.so  
将生成的FFmpeg库和头文件、hello-jni.c、Android.mk放到一个文件夹内，利用ndk-build命令生成libjni-lib.so  

# 四.效果  
截图展示了Jni调用const char *avcodec_license(void)和const char *avcodec_configuration(void)的输出：  
！[输出](https://github.com/SDonGit/JniPractice/blob/master/ScreenShot.png)
