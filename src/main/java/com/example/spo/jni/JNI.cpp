// JNI.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//
#include "com_example_spo_jni_JNI.h"
#include <iostream>
#include <jni.h>


JNIEXPORT jint JNICALL Java_com_example_spo_jni_JNI_OR
(JNIEnv* env, jobject obj, jint a, jint b) {
	return a | b;
}

JNIEXPORT jint JNICALL Java_com_example_spo_jni_JNI_MULTIPLY
(JNIEnv* env, jobject obj, jint a, jint b) {
	return a * b;
}