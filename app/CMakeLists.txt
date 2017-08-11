# Sets the minimum version of CMake required to build the native
# library. You should either keep the default value or only pass a
# value of 3.4.0 or lower.

#配置CMake的最低版本
cmake_minimum_required(VERSION 3.4.1)

#配置工程路径
set(distribution_DIR ${CMAKE_SOURCE_DIR}/../../../../libs)


#配置工程路径
#set(path_project /home/wuhuannan/AndroidPrj/FFmpeg)
#set(path_project D:/AndroidStudio/FFmpeg)

#配置头文件的包含路径
include_directories(src/main/cpp/include)
#include_directories(${path_project}/app/src/main/cpp/include)

#添加自己写的库
add_library(ffmpegdemo
            SHARED
            src/main/cpp/com_example_l1_ffmpegdemo_MainActivity.c
            )

#添加FFmpeg预编译的so库
add_library( avutil
             SHARED
             IMPORTED
            )

#设置两个预编译的库的路径
set_target_properties(
                       avutil
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/${ANDROID_ABI}/libavutil-55.so
                    )

add_library( swresample
             SHARED
             IMPORTED
            )

set_target_properties(
                       swresample
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/${ANDROID_ABI}/libswresample-2.so
                    )

add_library( avcodec
             SHARED
             IMPORTED
            )

set_target_properties(
                       avcodec
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/${ANDROID_ABI}/libavcodec-57.so
                    )

add_library( avformat
             SHARED
             IMPORTED
            )

set_target_properties(
                       avformat
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/${ANDROID_ABI}/libavformat-57.so
                    )

add_library( swscale
             SHARED
             IMPORTED
            )

set_target_properties(
                       swscale
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/${ANDROID_ABI}/libswscale-4.so
                    )

add_library( postproc
             SHARED
             IMPORTED
            )

set_target_properties(
                       postproc
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/${ANDROID_ABI}/libpostproc-54.so
                    )

add_library( avfilter
             SHARED
             IMPORTED
            )

set_target_properties(
                       avfilter
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/${ANDROID_ABI}/libavfilter-6.so
                    )

add_library( avdevice
             SHARED
             IMPORTED
            )

set_target_properties(
                       avdevice
                       PROPERTIES IMPORTED_LOCATION
                       ../../../../libs/${ANDROID_ABI}/libavdevice-57.so
                    )

#找到Android的log库（这个库已经在Android平台中了）
find_library(
            log-lib
            log
            )

#把需要的库链接到自己的库中
target_link_libraries(
            ffmpegdemo
            ${log-lib}
            avutil
            swresample
            avcodec
            avformat
            swscale
            postproc
            avfilter
            avdevice
            )
